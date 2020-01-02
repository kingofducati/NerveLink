package org.nervelinkin.core;

import org.nervelinkin.core.exception.NeuronAddressException;

import java.io.Serializable;

public class NeuronAddress implements Serializable {
    private int brainID;
    private int neuronAreaID;
    private int neuronLayerID;
    private int neuronGroupID;
    private int neuronID;

    private NeuronAddress() {}

    private NeuronAddress(int brainID, int neuronAreaID, int neuronLayerID, int neuronGroupID, int neuronID) {
        this.brainID = brainID;
        this.neuronAreaID = neuronAreaID;
        this.neuronLayerID = neuronLayerID;
        this.neuronGroupID = neuronGroupID;
        this.neuronID = neuronID;
    }

    public static final NeuronAddress createNeuronID(int brainID,int neuronAreaID,int neuronLayerID,int neuronGroupID,int neuronID){
        return new NeuronAddress(brainID,neuronAreaID,neuronLayerID,neuronGroupID,neuronID);
    }

    //从id格式化的字符串中还原出NeuronAddress对象
    public static final NeuronAddress formString(String neuronID) throws NeuronAddressException {
        NeuronAddress id=new NeuronAddress();
        String[] ids=neuronID.split(".");
        if(ids.length==5){
            try {
                int v = Integer.valueOf(ids[0]);
                id.brainID = v;

                v = Integer.valueOf(ids[1]);
                id.neuronAreaID = v;

                v = Integer.valueOf(ids[2]);
                id.neuronLayerID = v;

                v = Integer.valueOf(ids[3]);
                id.neuronGroupID = v;

                v = Integer.valueOf(ids[4]);
                id.neuronID = v;
            }catch (NumberFormatException e){
                throw new NeuronAddressException("The input string is (" + neuronID + ")not a neural network address string conforming to the specification.",e);
            }
        }else{
            throw new NeuronAddressException("The input string (" + neuronID + ")is not a neural network address string conforming to the specification.");
        }

        return id;
    }

    public int getBrainID() {
        return brainID;
    }

    public int getNeuronAreaID() {
        return neuronAreaID;
    }

    public int getNeuronLayerID() {
        return neuronLayerID;
    }

    public int getNeuronGroupID() {
        return neuronGroupID;
    }

    public int getNeuronID() {
        return neuronID;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(brainID).append(".").append(neuronAreaID).append(".").append(neuronLayerID).append(".").append(neuronGroupID).append(".").append(neuronID).toString();
    }
}
