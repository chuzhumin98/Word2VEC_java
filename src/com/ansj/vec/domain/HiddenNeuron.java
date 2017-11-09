package com.ansj.vec.domain;

public class HiddenNeuron extends Neuron{
    
    public double[] syn1 ; //hidden->out
    public double [] syn1_window; 
    
    public HiddenNeuron(int layerSize, int window){
        syn1 = new double[layerSize] ;
        //syn1_window = new double[2*layerSize*window];
    }
    
}
