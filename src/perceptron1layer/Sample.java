/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron1layer;

/**
 *
 * @author hadi
 */
public class Sample {

    private double[] p;
    private final int target;
    private boolean valid = false;

    public Sample(double[] p, int target, int depth) {
        this.p = new double[depth]; //it's an array with length of 2 for now.
        this.p = p;
        this.target = target;
    }

    public double[] getP() {
        return this.p;
    }

    public boolean getValidation() {
        return this.valid;
    }

    public void setValidation(boolean v) {
        this.valid = v;
    }

    public int getTarget() {
        return target;
    }
}
