package com.halconbit.computing.neuralnetwork.java.memory;

public class MemoryRAMSimulation {
    private double[] memory;
    private double[][] weightsInputHidden;
    private double[] weightsHiddenOutput;

    public MemoryRAMSimulation(int size) {
        memory = new double[size];
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

    public void allocateMemory(int address, double data) {
        memory[address] = data;
        System.out.println("Data '" + data + "' allocated at address " + address);
    }

    public double readMemory(int address) {
        double data = memory[address];
        System.out.println("Data read from address " + address + ": " + data);
        return data;
    }

    public double feedForward(int address) {
        // Calculate output of the neural network based on memory address
        double[] inputs = new double[memory.length];
        inputs[address] = 1.0; // Set the input corresponding to the memory address to 1

        // Calculate hidden layer outputs
        double[] hiddenLayerOutputs = new double[weightsHiddenOutput.length];
        
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

    public static void main(String[] args) {
        MemoryRAMSimulation memoryRAM = new MemoryRAMSimulation(100); // Creating a simulated RAM with 100 memory locations

        memoryRAM.allocateMemory(0, 5.5); // Allocating data to memory address 0
        memoryRAM.readMemory(0); // Reading data from memory address 0

        int readAddress = 0; // Address to read from neural network
        double neuralNetworkOutput = memoryRAM.feedForward(readAddress); // Feedforward through the neural network based on the address
        System.out.println("Neural Network Output: " + neuralNetworkOutput);
    }
}