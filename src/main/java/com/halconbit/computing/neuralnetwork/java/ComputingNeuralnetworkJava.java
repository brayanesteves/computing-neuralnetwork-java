package com.halconbit.computing.neuralnetwork.java;

import com.halconbit.computing.neuralnetwork.java.disk.HardDiskSimulation;

/**
 * @author Brayan Esteves
 */
public class ComputingNeuralnetworkJava {

    public static void main(String[] args) {
        HardDiskSimulation hardDisk = new HardDiskSimulation(100); // Creating a hard disk with 100 blocks

        hardDisk.writeBlock(0, "Hello, World!"); // Writing data to block 0
        hardDisk.readBlock(0); // Reading data from block 0

        double[] inputs = {1.0, 0.5}; // Example input values
        double output = hardDisk.feedForward(inputs); // Feedforward through the neural network
        System.out.println("Neural Network Output: " + output);
    }
}
