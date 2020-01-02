package org.nervelinkin.core;

public interface NeuronConnection {
    public boolean isClosed();

    public ConnectionWeight getWeight();
    public ConnectionWeight addWeight();
    public ConnectionWeight subWeight();
    public NeuronAddress sourceNeuron();
    public NeuronAddress targetNeuron();

    public Semaphore createSemaphone();
    public boolean sendSemaphone(Semaphore semaphore);
}
