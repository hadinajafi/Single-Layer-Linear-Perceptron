/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron1layer;

import java.util.ArrayList;

/**
 *
 * @author hadi
 */
public class Training {

    private double[] weights;
    private double bias;
    private double alpha = 1;
    private ArrayList<Sample> samples = new ArrayList<>();

    public Training(int depth) {
        weights = new double[depth];
        initValues();   //set weights and bias to zero
    }

    public void trainingAlgorithm(){
        while(!checkTrainingCondition()){ // while all the validations aren't true
            trainOnSamples();
        }
        printLineFormula();
    }
    
    // train algorithm on samples
    private void trainOnSamples() {
        for (Sample sample : samples) {
            double sum = 0;
            
            for (int i = 0; i < weights.length; i++) { //calculating    w1.x1 + w2.x2 + ... 
                sum += weights[i] * sample.getP()[i];
            }
            sum += bias; //adding bias to the sum

            if (!compareOutput(sum, sample)) {  //compare network & target output
                //updating the weights
                for (int i = 0; i < weights.length; i++) {
                    weights[i] += sample.getTarget() * sample.getP()[i];
                }
                //updating the bias
                bias += sample.getTarget();
                sample.setValidation(false);
            } else {
                sample.setValidation(true);
            }
        }
    }
    
    // check the all sample validations.
    private boolean checkTrainingCondition(){
        //if one sample validation was negative, so trainingCondition will be false.
        for(Sample s: samples){
            if(!s.getValidation())
                return false;
        }
        return true;
    }
    
    // print the weights and bias
    private void printLineFormula(){
        for(int i = 0; i < weights.length; i++){
            System.out.println("Weight[" + (i+1) + "] = " + weights[i]);
        }
        System.out.println("Bias : " + bias);
    }
    
//  comparing network output and target output
    private boolean compareOutput(double sum, Sample sample) {
        switch (sample.getTarget()) {
            case 1:
                if (sum > 0) {
                    return true;
                }
                break;
            case -1:
                if (sum <= 0) {
                    return true;
                }
                break;
        }
        return false;
    }

    /**
     * 
     * @param sample Add a sample object to Samples Array for running algorithm on them
     */
    public void addSample(Sample sample) {
        this.samples.add(sample);
    }

    private void initValues() {
        //init weights
        for (int i = 0; i < weights.length; i++) {
            weights[i] = 0;
        }

        //init bias
        bias = 0;
    }

}
