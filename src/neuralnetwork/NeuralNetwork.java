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
public class NeuralNetwork 
{
    public static double[][] numbers;
    public static double[][] targetValues;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        createInputsAndTargetValues5();
        Network numberRecognition = new Network(10, 10, 25);
        for(int i = 0; i < 20000; i++)
        {
            for(int j = 0; j < numbers.length; j++)
            {
                numberRecognition.predict(numbers[j]);
                double[] outputDeltas = numberRecognition.trainOutputNeurons(targetValues[j]);
                numberRecognition.calculateHiddenDeltas(numbers[j], outputDeltas);
                numberRecognition.backpropogateAndTrainHiddenNeurons();
            }
        }
        double[] numberToPredict = {0, 0, 1, 0, 0,
                                    0, 0, 1, 0, 0,
                                    0, 0, 1, 0, 0,
                                    0, 0, 1, 0, 0,
                                    0, 0, 1, 0, 0};
        
        double[] prediction = numberRecognition.predict(numberToPredict);
        int predictionValue = 0;
        double winner = 0.0;
        for(int i = 0; i < prediction.length; i++)
        {
            System.out.printf("%.5f " ,prediction[i]);
             if(prediction[i] > winner)
            {
                winner = prediction[i];
                predictionValue = i;
            }
        }
        System.out.println();
        System.out.println("Prediction: " + predictionValue);
        System.out.println();
        
        
        double[] numberToPredict2 = {1, 1, 1, 1, 1,
                                     0, 0, 0, 1, 0,
                                     0, 0, 1, 0, 0,
                                     0, 1, 0, 0, 0,
                                     1, 0, 0, 0, 0};
        
        double[] prediction2 = numberRecognition.predict(numberToPredict2);
        winner = 0.0;
        for(int i = 0; i < prediction2.length; i++)
        {
            System.out.printf("%.5f " ,prediction2[i]);
            if(prediction2[i] > winner)
            {
                winner = prediction2[i];
                predictionValue = i;
            }
        }
        System.out.println();
        System.out.println("Prediction: " + predictionValue);
        System.out.println();
        
        
        double[] numberToPredict3 = {0, 0, 1, 1, 0,
                                     0, 0, 0, 1, 1,
                                     0, 0, 1, 1, 0,
                                     0, 0, 0, 1, 1,
                                     0, 0, 1, 1, 0};
        
        double[] prediction3 = numberRecognition.predict(numberToPredict3);
        winner = 0.0;
        
        for(int i = 0; i < prediction3.length; i++)
        {
            System.out.printf("%.5f " ,prediction3[i]);
            if(prediction3[i] > winner)
            {
                winner = prediction3[i];
                predictionValue = i;
            }            
        }
        System.out.println();
        System.out.println("Prediction: " + predictionValue);
        System.out.println();
        
        double[] numberToPredict4 = {0, 0, 0, 0, 1,
                                     0, 0, 0, 1, 1,
                                     0, 0, 1, 1, 1,
                                     0, 0, 0, 0, 1,
                                     0, 0, 0, 0, 1};
        
        double[] prediction4 = numberRecognition.predict(numberToPredict4);
        winner = 0.0;
        for(int i = 0; i < prediction4.length; i++)
        {
            System.out.printf("%.5f " ,prediction4[i]);
            if(prediction4[i] > winner)
            {
                winner = prediction4[i];
                predictionValue = i;
            }
        }
        System.out.println();
        System.out.println("Prediction: " + predictionValue);
        System.out.println();
        
    }
    
    public static void createInputsAndTargetValues()
    {
        numbers = new double[8][2];
        targetValues = new double[8][2];
        double[] target0 = {1.0, 0.0};
        double[] target1 = {0.0, 1.0};
        
        double[] numbers1 = {0.0, 0.0};
        double[] numbers2 = {0.0, 1.0};
        double[] numbers3 = {1.0, 0.0};
        double[] numbers4 = {1.0, 1.0};
        double[] numbers5 = {0.0, 0.0};
        double[] numbers6 = {0.0, 1.0};
        double[] numbers7 = {1.0, 0.0};
        double[] numbers8 = {1.0, 1.0};
       
        
        
        
        System.arraycopy(numbers1, 0, numbers[0], 0, 2);
        System.arraycopy(target0, 0, targetValues[0], 0, 2);
        
        System.arraycopy(numbers2, 0, numbers[1], 0, 2);
        System.arraycopy(target1, 0, targetValues[1], 0, 2);
        
        System.arraycopy(numbers3, 0, numbers[2], 0, 2);
        System.arraycopy(target1, 0, targetValues[2], 0, 2);
        
        System.arraycopy(numbers4, 0, numbers[3], 0, 2);
        System.arraycopy(target0, 0, targetValues[3], 0, 2);
        
        System.arraycopy(numbers5, 0, numbers[4], 0, 2);
        System.arraycopy(target0, 0, targetValues[4], 0, 2);
        
        System.arraycopy(numbers6, 0, numbers[5], 0, 2);
        System.arraycopy(target1, 0, targetValues[5], 0, 2);
        
        System.arraycopy(numbers7, 0, numbers[6], 0, 2);
        System.arraycopy(target1, 0, targetValues[6], 0, 2);
        
        System.arraycopy(numbers8, 0, numbers[7], 0, 2);
        System.arraycopy(target0, 0, targetValues[7], 0, 2);
        
    }
    
    public static void createInputsAndTargetValues2()
    {
     numbers = new double[9][2];
        targetValues = new double[9][2];
        double[] target0 = {1.0, 0.0};
        double[] target1 = {0.0, 1.0};
        
        double[] numbers1 = {0.0, 0.0};
        double[] numbers2 = {0.0, 1.0};
        double[] numbers3 = {1.0, 0.0};
        double[] numbers4 = {1.0, 1.0};
        double[] numbers5 = {0.0, 0.0};
        double[] numbers6 = {0.0, 1.0};
        double[] numbers7 = {1.0, 0.0};
        double[] numbers8 = {1.0, 1.0};
        double[] numbers9 = {1.0, 1.0};
        
        
        
        System.arraycopy(numbers1, 0, numbers[0], 0, 2);
        System.arraycopy(target0, 0, targetValues[0], 0, 2);
        
        System.arraycopy(numbers2, 0, numbers[1], 0, 2);
        System.arraycopy(target0, 0, targetValues[1], 0, 2);
        
        System.arraycopy(numbers3, 0, numbers[2], 0, 2);
        System.arraycopy(target0, 0, targetValues[2], 0, 2);
        
        System.arraycopy(numbers4, 0, numbers[3], 0, 2);
        System.arraycopy(target1, 0, targetValues[3], 0, 2);
        
        System.arraycopy(numbers5, 0, numbers[4], 0, 2);
        System.arraycopy(target0, 0, targetValues[4], 0, 2);
        
        System.arraycopy(numbers6, 0, numbers[5], 0, 2);
        System.arraycopy(target0, 0, targetValues[5], 0, 2);
        
        System.arraycopy(numbers7, 0, numbers[6], 0, 2);
        System.arraycopy(target0, 0, targetValues[6], 0, 2);
        
        System.arraycopy(numbers8, 0, numbers[7], 0, 2);
        System.arraycopy(target1, 0, targetValues[7], 0, 2);
        
        System.arraycopy(numbers9, 0, numbers[8], 0, 2);
        System.arraycopy(target1, 0, targetValues[8], 0, 2);
    }
    
    public static void createInputsAndTargetValues3()
    {
     numbers = new double[8][3];
        targetValues = new double[8][2];
        double[] target0 = {1.0, 0.0};
        double[] target1 = {0.0, 1.0};
        
        double[] numbers1 = {0.0, 0.0};
        double[] numbers2 = {0.0, 1.0};
        double[] numbers3 = {1.0, 0.0};
        double[] numbers4 = {1.0, 1.0};
        double[] numbers5 = {0.0, 0.0};
        double[] numbers6 = {0.0, 1.0};
        double[] numbers7 = {1.0, 0.0};
        double[] numbers8 = {1.0, 1.0};
        
        
        
        System.arraycopy(numbers1, 0, numbers[0], 0, 2);
        System.arraycopy(target0, 0, targetValues[0], 0, 2);
        
        System.arraycopy(numbers2, 0, numbers[1], 0, 2);
        System.arraycopy(target1, 0, targetValues[1], 0, 2);
        
        System.arraycopy(numbers3, 0, numbers[2], 0, 2);
        System.arraycopy(target1, 0, targetValues[2], 0, 2);
        
        System.arraycopy(numbers4, 0, numbers[3], 0, 2);
        System.arraycopy(target1, 0, targetValues[3], 0, 2);
        
        System.arraycopy(numbers5, 0, numbers[4], 0, 2);
        System.arraycopy(target0, 0, targetValues[4], 0, 2);
        
        System.arraycopy(numbers6, 0, numbers[5], 0, 2);
        System.arraycopy(target1, 0, targetValues[5], 0, 2);
        
        System.arraycopy(numbers7, 0, numbers[6], 0, 2);
        System.arraycopy(target1, 0, targetValues[6], 0, 2);
        
        System.arraycopy(numbers8, 0, numbers[7], 0, 2);
        System.arraycopy(target1, 0, targetValues[7], 0, 2);   
    }
    
    public static void createInputsAndTargetValues4()
    {
     numbers = new double[8][2];
        targetValues = new double[8][2];
        double[] target0 = {1.0, 0.0};
        double[] target1 = {0.0, 1.0};
        
        double[] numbers1 = {0.0, 0.0, 0.0};
        double[] numbers2 = {0.0, 0.0, 1.0};
        double[] numbers3 = {0.0, 1.0, 0.0};
        double[] numbers4 = {0.0, 1.0, 1.0};
        double[] numbers5 = {1.0, 0.0, 0.0};
        double[] numbers6 = {1.0, 0.0, 1.0};
        double[] numbers7 = {1.0, 1.0, 0.0};
        double[] numbers8 = {1.0, 1.0, 1.0};
        
        
        
        System.arraycopy(numbers1, 0, numbers[0], 0, 2);
        System.arraycopy(target0, 0, targetValues[0], 0, 2);
        
        System.arraycopy(numbers2, 0, numbers[1], 0, 2);
        System.arraycopy(target0, 0, targetValues[1], 0, 2);
        
        System.arraycopy(numbers3, 0, numbers[2], 0, 2);
        System.arraycopy(target0, 0, targetValues[2], 0, 2);
        
        System.arraycopy(numbers4, 0, numbers[3], 0, 2);
        System.arraycopy(target1, 0, targetValues[3], 0, 2);
        
        System.arraycopy(numbers5, 0, numbers[4], 0, 2);
        System.arraycopy(target0, 0, targetValues[4], 0, 2);
        
        System.arraycopy(numbers6, 0, numbers[5], 0, 2);
        System.arraycopy(target1, 0, targetValues[5], 0, 2);
        
        System.arraycopy(numbers7, 0, numbers[6], 0, 2);
        System.arraycopy(target1, 0, targetValues[6], 0, 2);
        
        System.arraycopy(numbers8, 0, numbers[7], 0, 2);
        System.arraycopy(target1, 0, targetValues[7], 0, 2);   
    }
        
        public static void createInputsAndTargetValues5()
    {
        numbers = new double[16][25];
        targetValues = new double[16][10];
        double[] one =  {0, 0, 1, 0, 0,
                         0, 0, 1, 0, 0,
                         0, 0, 1, 0, 0,
                         0, 0, 1, 0, 0,
                         0, 0, 1, 0, 0};
        
        System.arraycopy(one, 0, numbers[0], 0, 25);
        
        double[] target1 = {0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        System.arraycopy(target1, 0, targetValues[0], 0, 10);
        
        
        double[] one2 = {0, 0, 0, 0, 1,
                         0, 0, 0, 0, 1,
                         0, 0, 0, 0, 1,
                         0, 0, 0, 0, 1,
                         0, 0, 0, 0, 1};
        
        System.arraycopy(one2, 0, numbers[1], 0, 25);
        System.arraycopy(target1, 0, targetValues[1], 0, 10);
        
        double[] one3 = {1, 0, 0, 0, 0,
                         1, 0, 0, 0, 0,
                         1, 0, 0, 0, 0,
                         1, 0, 0, 0, 0,
                         1, 0, 0, 0, 0};
        
        System.arraycopy(one3, 0, numbers[2], 0, 25);
        System.arraycopy(target1, 0, targetValues[2], 0, 10);
        
        double[] two =  {1, 1, 1, 1, 1,
                         0, 0, 0, 0, 1,
                         1, 1, 1, 1, 1, 
                         1, 0, 0, 0, 0, 
                         1, 1, 1, 1, 1};
        
        System.arraycopy(two, 0, numbers[3], 0, 25);
        double[] target2 = {0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        System.arraycopy(target2, 0, targetValues[3], 0, 10);
        
        double[] two2 = {1, 1, 1, 1, 1,
                         0, 0, 0, 0, 1,
                         0, 0, 0, 0, 1,
                         1, 1, 1, 1, 1,
                         1, 1, 1, 1, 1};
        
        System.arraycopy(two2, 0, numbers[4], 0, 25);
        System.arraycopy(target2, 0, targetValues[4], 0, 10);
        
        double[] three = {1, 1, 1, 1, 1, 
                          0, 0, 0, 0, 1,
                          1, 1, 1, 1, 1,
                          0, 0, 0, 0, 1,
                          1, 1, 1, 1, 1};
        
        System.arraycopy(three, 0, numbers[5], 0, 25);
        double[] target3 = {0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        System.arraycopy(target3, 0, targetValues[5], 0, 10);
        
        double[] three2 = {1, 1, 1, 1, 1,
                           0, 0, 0, 0, 1,
                           0, 0, 1, 1, 1,
                           0, 0, 0, 0, 1,
                           1, 1, 1, 1, 1};
        
        System.arraycopy(three2, 0, numbers[6], 0, 25);
        System.arraycopy(target3, 0, targetValues[6], 0, 10);
        
        double[] four = {1, 0, 0, 0, 1,
                         1, 0, 0, 0, 1,
                         1, 1, 1, 1, 1,
                         0, 0, 0, 0, 1,
                         0, 0, 0, 0, 1};
        
        System.arraycopy(four, 0, numbers[7], 0, 25);
        double[] target4 = {0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        System.arraycopy(target4, 0, targetValues[7], 0, 10);
        
        double[] four2 = {0, 0, 1, 0, 1,
                          0, 0, 1, 0, 1,
                          0, 0, 1, 1, 1,
                          0, 0, 0, 0, 1,
                          0, 0, 0, 0, 1};
        
        System.arraycopy(four2, 0, numbers[8], 0, 25);
        System.arraycopy(target4, 0, targetValues[8], 0, 10);
        
        double[] five = {1, 1, 1, 1, 1,
                         1, 0, 0, 0, 0,
                         1, 1, 1, 1, 1,
                         0, 0, 0, 0, 1,
                         1, 1, 1, 1, 1};
        
        System.arraycopy(five, 0, numbers[9], 0, 25);
        double[] target5 = {0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0};
        System.arraycopy(target5, 0, targetValues[9], 0, 10);
        
        double[] six = {1, 1, 1, 1, 1,
                        1, 0, 0, 0, 0,
                        1, 1, 1, 1, 1,
                        1, 0, 0, 0, 1,
                        1, 1, 1, 1, 1};
        
        System.arraycopy(six, 0, numbers[10], 0, 25);
        double[] target6 = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0};
        System.arraycopy(target6, 0, targetValues[10], 0, 10);
        
        double[] six2 = {1, 0, 0, 0, 0,
                         1, 0, 0, 0, 0,
                         1, 1, 1, 1, 1,
                         1, 0, 0, 0, 1,
                         1, 1, 1, 1, 1};
        
        System.arraycopy(six2, 0, numbers[11], 0, 25);
        System.arraycopy(target6, 0, targetValues[11], 0, 10);
        
//        double[] seven = {1, 1, 1, 1, 1,
//                          0, 0, 0, 0, 1,
//                          0, 0, 0, 0, 1,
//                          0, 0, 0, 0, 1,
//                          0, 0, 0, 0, 1};
//        
//        System.arraycopy(seven, 0, numbers[6], 0, 25);
        double[] target7 = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0};
//        System.arraycopy(target7, 0, targetValues[6], 0, 10);
        
        double[] seven2 = {1, 1, 1, 1, 1,
                           0, 0, 0, 1, 0,
                           0, 0, 1, 0, 0,
                           0, 1, 0, 0, 0,
                           1, 0, 0, 0, 0};
        
        System.arraycopy(seven2, 0, numbers[12], 0, 25);
        System.arraycopy(target7, 0, targetValues[12], 0, 10);
        
        double[] eight = {1, 1, 1, 1, 1,
                          1, 0, 0, 0, 1,
                          1, 1, 1, 1, 1,
                          1, 0, 0, 0, 1,
                          1, 1, 1, 1, 1};
        
        System.arraycopy(eight, 0, numbers[13], 0, 25);
        double[] target8 = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
        System.arraycopy(target8, 0, targetValues[13], 0, 10);
        
        
        double[] nine = {1, 1, 1, 1, 1, 
                         1, 0, 0, 0, 1,
                         1, 1, 1, 1, 1,
                         0, 0, 0, 0, 1,
                         0, 0, 0, 0, 1};
        
        System.arraycopy(nine, 0, numbers[14], 0, 25);
        double[] target9 = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
        System.arraycopy(target9, 0, targetValues[14], 0, 10);
        
        double[] zero = {1, 1, 1, 1, 1,
                         1, 0, 0, 0, 1,
                         1, 0, 0, 0, 1,
                         1, 0, 0, 0, 1,
                         1, 1, 1, 1, 1};
        
        System.arraycopy(zero, 0, numbers[15], 0, 25);
        double[] target0 = {1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        System.arraycopy(target0, 0, targetValues[15], 0, 10);
        
    }
}

