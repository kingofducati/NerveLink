package org.nervelinkin.core;

import java.io.Serializable;
import java.util.List;

/**
 * 一般神经元模拟
 * 实现多路矩阵信号输入，多路矩阵信号输出。
 * 1、神经元天赋：激活阈值、激活延时、冷却时间、刺激常数、不应期时长、是否在不应期
 * 2、对于输入信号量的加工由神经元本身特性决定
 * 3、对于输出信号量和输出目标由Action操作决定
 * 4、输入信号量强度增强，输出信号量频率增强而值不变。
 * 5、神经元都有自己的坐标地址，地址的表达方式类似IP，脑.区域.层.组.神经元，如：1.1.1.1.1代表神经元处于编号为1的脑区，编号为1的脑内区域，编号为1的神经网络层级，编号为1的神经元
 * 6、神经元知晓自己在整个神经网络中的功能地位，知晓自己的上下级，并会主动连接。
 * 7、神经元允许大脑控制层指挥自己连接一个未知的神经元，不可拒绝
 * 8、神经元允许大脑控制层指挥自己改变或增加计算功能，不可拒绝
 * 9、神经元根据上下级或大脑指令输出信号，轴突中的每个突触传输的信号并不相同
 * 10、神经元根据功能需要，会主动记忆输入的信号，并缓存一段时间，一般是1分钟。
 * 11、神经元间如果有信号传输，神经连接的权重自动增加。
 * 12、带记忆的神经元可以接受查询信号，激活记忆，传递索引
 */
public interface Neuron extends Serializable {
    public NeuronAddress getId();

    //轴突连接的神经元地址集合
    public List<NeuronAddress> getAxonNeurons();

    //判断是否和一个神经元地址有链接
    public boolean hasBehindNeuron(NeuronAddress behindNeuron);

    /**
     * --------------------------------------------------------------------------
     * 神经元天赋
     */
    //天赋：类型，类型对应不同信号处理操作
    public void setType(NeuronType type);
    public NeuronType getType();
    //天赋：激活阈值，当输入信号量大于阈值时才被接受
    public double getThreshold();
    public void setThreshold(double threshold);

    //天赋：激活延时，一般超过阈值的输入信号量要持续一段时间才能真正激活
    public long getActivationDelay();
    public void setActivationDelay(long activationDelay);

    //天赋：冷却时间，又叫不应期，在此期间神经元拒绝输入.放弃，改由神经网络统一控制，是生物系统节约能量、减少刺激的一种方式，目前暂不使用
    //public long getRefractoryPeriod();
    //public void setRefractoryPeriod(long refractoryPeriod);
    //天赋：神经元状态，是否处在不应期。
    //public boolean isRefractoryPeriod();
    //public void setIsRefractoryPeriod(boolean isRefractoryPeriod);
    //天赋：正常脉冲频率，神经元输出信号量的频率阈值
    public double getFrequency();
    public void setFrequency(double frequency);
    //天赋：刺激常数，用于控制因输入强度提高而转化的频率高低
    public double getStimulusConstant();
    public void setStimulusConstant(double stimulusConstant);

    //输入信号量，根据信号量的类型处理
    public void input(Semaphore input);
    //All semaphores have arrived
    public boolean isAllSemaphoreArrived();
    //All semaphores have been sent
    public boolean isAllSemaphoreSent();

    //做工函数，由外部指令控制做工。不采用线程或Actor方式，以减少资源占用和对硬件依赖。
    public void doActivation() throws Throwable;
    //添加一个突触连接（神经元链接）,一个连接确定以后，两个神经元的连接信道就确定了，相互间的信息传递就基于固定类型的神经递质
    public NeuronConnection doConnectionNeuron(NeuronAddress behindNeuron) throws Throwable;
    public void doSearch(Semaphore semaphore) throws Throwable;
    public void doAction(Semaphore semaphore) throws Throwable;

    public void clean();


}
