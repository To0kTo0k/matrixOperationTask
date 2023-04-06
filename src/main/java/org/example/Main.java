package org.example;

import org.example.handling.MatrixOperations;

public class Main {
    public static void main(String[] args) {
        MatrixOperations firstMatrix = new MatrixOperations();
        System.out.println("First matrix:");
        firstMatrix.outputMatrix();
        MatrixOperations secondMatrix = new MatrixOperations();
        System.out.println("Second matrix:");
        secondMatrix.outputMatrix();
        firstMatrix.multiplyMatrix(secondMatrix.getMatrix(), secondMatrix.getWidth(), secondMatrix.getLength());
        System.out.println("Result of first and second matrix multiplication:");
        firstMatrix.outputMatrix();
    }
}