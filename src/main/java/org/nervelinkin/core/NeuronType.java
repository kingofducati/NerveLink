package org.nervelinkin.core;

public enum NeuronType{
    VISION_BIPOLAR_NEURON("VISION_BIPOLAR_NEURON",10000),
    VISION_GANGLION_NEURON("VISION_GANGLION_NEURON",10001),
    VISION_VISUALCORTEX_NEURON("VISION_VISUALCORTEX_NEURON",10002);

    private String name;
    private int value;

    NeuronType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
