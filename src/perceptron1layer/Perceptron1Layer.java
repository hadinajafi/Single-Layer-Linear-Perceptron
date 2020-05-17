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
public class Perceptron1Layer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int depth = 4;  //depth of samples, 2d, 3d, etc.
        double[] p1 = {1, 1, 1, 1};
        double[] p2 = {-1, 1, -1, -1};
        double[] p3 = {1, 1, 1, -1};
        double[] p4 = {1, -1, -1, 1};
        Sample s1 = new Sample(p1, 1, depth);
        Sample s2 = new Sample(p2, 1, depth);
        Sample s3 = new Sample(p3, -1, depth);
        Sample s4 = new Sample(p4, -1, depth);

        Training tr = new Training(depth);
        tr.addSample(s1);
        tr.addSample(s2);
        tr.addSample(s3);
        tr.addSample(s4);
        tr.trainingAlgorithm();
    }
}
