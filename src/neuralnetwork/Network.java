/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetwork;

public class Network 
{
    double[] inputs;
    double[] outputs;
    HiddenNeuron[] hiddenNeurons;
    OutputNeuron[] outputNeurons;
    double[] outputDeltaValues;
    double[] hiddenDeltas;
    double[] hiddenStrengths;
    double[] outputStrengths;
    
    public Network(int hiddenLayerSize, int outputLayerSize, int numInputs)
    {
        hiddenNeurons = new HiddenNeuron[hiddenLayerSize];
        for(int i = 0; i < hiddenLayerSize; i++)
        {
            hiddenNeurons[i] = new HiddenNeuron(numInputs);
        }
        outputNeurons = new OutputNeuron[outputLayerSize];
        for(int i = 0; i < outputNeurons.length; i++)
        {
            outputNeurons[i] = new OutputNeuron(hiddenNeurons.length);
        }
    }
    
    public double[] predict(double[] inputs)
    {
        this.inputs = inputs;
        hiddenStrengths = new double[hiddenNeurons.length];
        outputStrengths = new double[outputNeurons.length];
        for(int i = 0; i < hiddenStrengths.length; i++)
        {
            hiddenStrengths[i] = hiddenNeurons[i].activate(inputs);
        }
        for(int i = 0; i < outputNeurons.length; i++)
        {
            outputStrengths[i] = outputNeurons[i].activate(hiddenStrengths);
        }
        return outputStrengths;
    }
    
    public double[] trainOutputNeurons(double[] targets)
    {
        outputDeltaValues = new double[outputNeurons.length];
        
        for(int i = 0; i < outputNeurons.length; i++)
        {
            double outputDelta = outputNeurons[i].Train(targets[i]);
            outputDeltaValues[i] = outputDelta;
        }
        return outputDeltaValues;
    }
    
    public void backpropogateAndTrainHiddenNeurons()
    {
        for(int i = 0; i < hiddenNeurons.length; i++)
        {
            hiddenNeurons[i].Train(hiddenDeltas[i]);
        }
    }
    
    public double[] calculateHiddenDeltas(double[] inputs, double[] outputDeltas)
    {
        hiddenDeltas = new double[hiddenNeurons.length];
        for(int j = 0; j < hiddenStrengths.length; j++)
        {
            double hiddenDelta;
            double sum = 0.0;
            for(int k = 0; k < outputDeltas.length; k++)
            {
                sum += outputDeltas[k] * outputNeurons[k].weights[j];
            }
            hiddenDelta = (1 - hiddenStrengths[j])*hiddenStrengths[j] * sum;
            hiddenDeltas[j] = hiddenDelta;
        }
        
        return hiddenDeltas;
    }
    
}
