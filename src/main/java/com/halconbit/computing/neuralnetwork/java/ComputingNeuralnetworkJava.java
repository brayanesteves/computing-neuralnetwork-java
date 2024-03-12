package com.halconbit.computing.neuralnetwork.java;

import com.halconbit.computing.neuralnetwork.java.disk.HardDiskSimulation;
import com.halconbit.computing.neuralnetwork.java.memory.MemoryRAMSimulation;

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
    
        MemoryRAMSimulation memoryRAM = new MemoryRAMSimulation(100); // Creating a simulated RAM with 100 memory locations

        memoryRAM.allocateMemory(0, 5.5); // Allocating data to memory address 0
        memoryRAM.readMemory(0); // Reading data from memory address 0

        int readAddress = 0; // Address to read from neural network
        double outputs = memoryRAM.feedForward(readAddress); // Feedforward through the neural network based on the address
        System.out.println("Neural Network Output: " + outputs);
    }
}
