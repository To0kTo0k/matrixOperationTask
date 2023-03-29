package org.example;

import org.example.handling.MatrixOperations;

public class Main {
    public static void main(String[] args) {
        MatrixOperations firstMatrix = new MatrixOperations();
        System.out.println("First matrix:");
        firstMatrix.initMatrix();
        firstMatrix.outMatrix();
        MatrixOperations secondMatrix = new MatrixOperations();
        System.out.println("Second matrix:");
        secondMatrix.initMatrix();
        secondMatrix.outMatrix();
        System.out.println("Result of first and second matrix multiplication:");
        firstMatrix.multiplyMatrix(secondMatrix.getDto());
        firstMatrix.outMatrix();
    }
}