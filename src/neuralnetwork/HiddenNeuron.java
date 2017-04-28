/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetwork;

/**
 *
 * @author nicol
 */
public class HiddenNeuron {
    double bias = -1.0;
    double net;
    double[] inputs;
    double[] weights;
    double firingStrength;
    double stepSize = 1.0;
    
    public HiddenNeuron(int numInputs)
    {
        weights = new double[numInputs+1];
        for(int i = 0; i < numInputs+1; i++)
        {
            weights[i] = Math.random();
        }
    }
    
    public double activate(double[] inputs)
    {
        net = 0;
        this.inputs = inputs;
        for(int i = 0; i < inputs.length; i++)
        {
            net = net + (inputs[i] * weights[i]);         
        }
        net = net + bias*weights[weights.length-1];
        firingStrength = (1.0/(1.0 + Math.pow(Math.E, -1.0*net)));
        return firingStrength;
    }
    
    public void Train(double hiddenDelta)
    {
        for(int i = 0; i < inputs.length; i++)
        {
            double changeInWeight = -1 * stepSize * hiddenDelta * inputs[i];
            weights[i] += changeInWeight;
        }
        double changeInWeight = -1 * stepSize * hiddenDelta * bias;
        weights[weights.length-1] += changeInWeight;
    }
}
