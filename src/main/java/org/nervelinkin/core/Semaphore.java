package org.nervelinkin.core;

import java.io.Serializable;

/**
 * 信号量的抽象定义
 * 一个信号量必然是一个矩阵，矩阵的大小为一个功能区的大小
 */
public interface Semaphore extends Serializable {
    public SemaphoreType getSemaphoreType();
    //信号量产生的神经元ID
    public String getProducerID();
    //信号量消费的神经元ID
    public String getConsumerID();
    //信号量发送的时间
    public long getSendTimestemp();
    //信号量接收的时间
    public long getReceiveTimestemp();
    //信号量的值
    public SemaphoreValue getValue();
    //信号量强度
    public double getIntensity();
    //信号量的持续时间
    public long getDuration();
    //信号量的频率
    public double getFrequency();
}
