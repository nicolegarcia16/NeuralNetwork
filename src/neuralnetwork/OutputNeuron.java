
package neuralnetwork;

public class OutputNeuron 
{
    double bias = -1.0;
    double net;
    double[] inputs;
    double[] weights;
    double firingStrength;
    double stepSize = 1.0;
    
    public OutputNeuron(int numInputs)
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
        net = net + (bias * weights[weights.length-1]);
        firingStrength = (1.0/(1.0 + Math.pow(Math.E, -1.0*net)));
        return firingStrength;
    }
    
    public double Train(double target)
    {
        double delta = ((-1*(target-firingStrength))*((1 - firingStrength)*firingStrength));
        for(int i = 0; i < inputs.length; i++)
        {
            
            double changeInWeight = -1 * stepSize * delta * inputs[i];
            weights[i] += changeInWeight;
        }
        double changeInWeight = stepSize * delta * bias;
        weights[weights.length-1] += changeInWeight;
        return delta;
    }
}