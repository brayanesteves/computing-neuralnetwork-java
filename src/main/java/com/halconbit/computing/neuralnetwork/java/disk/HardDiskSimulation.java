package com.halconbit.computing.neuralnetwork.java.disk;

import java.util.HashMap;

public class HardDiskSimulation {
    private HashMap<Integer, String> diskBlocks;
    private double[][] weightsInputHidden;
    private double[] weightsHiddenOutput;

    public HardDiskSimulation(int size) {
        diskBlocks = new HashMap<>(size);
        weightsInputHidden = new double[size][size]; // Weights between input and hidden layer
        weightsHiddenOutput = new double[size]; // Weights between hidden and output layer
        initializeWeights();
    }

    private void initializeWeights() {
        // Initialize weights with random values
        for (int i = 0; i < weightsInputHidden.length; i++) {
            for (int j = 0; j < weightsInputHidden[i].length; j++) {
                weightsInputHidden[i][j] = Math.random();
            }
        }
        for (int i = 0; i < weightsHiddenOutput.length; i++) {
            weightsHiddenOutput[i] = Math.random();
        }
    }

    public void writeBlock(int blockNumber, String data) {
        diskBlocks.put(blockNumber, data);
        System.out.println("Data '" + data + "' written to block " + blockNumber);
    }

    public String readBlock(int blockNumber) {
        String data = diskBlocks.getOrDefault(blockNumber, "Empty");
        System.out.println("Data read from block " + blockNumber + ": " + data);
        return data;
    }

    public double feedForward(double[] inputs) {
        // Calculate output of the neural network
        double[] hiddenLayerOutputs = new double[weightsHiddenOutput.length];
        
        // Calculate hidden layer outputs
        for (int i = 0; i < weightsHiddenOutput.length; i++) {
            double sum = 0;
            for (int j = 0; j < inputs.length; j++) {
                sum += inputs[j] * weightsInputHidden[j][i];
            }
            hiddenLayerOutputs[i] = sigmoid(sum);
        }

        // Calculate output layer output
        double output = 0;
        for (int i = 0; i < hiddenLayerOutputs.length; i++) {
            output += hiddenLayerOutputs[i] * weightsHiddenOutput[i];
        }
        
        return sigmoid(output);
    }

    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }
}
