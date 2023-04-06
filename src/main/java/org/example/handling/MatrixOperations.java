package org.example.handling;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class MatrixOperations {
    private int width;
    private int length;
    private int[][] matrix;

    public MatrixOperations() {
        inputMatrixLength();
        inputMatrixWidth();
        inputMatrix(getLength(), getWidth());
    }

    private void inputMatrixLength() {
        System.out.println("Input matrix length:");
        Scanner in = new Scanner(System.in);
        setLength(in.nextInt());
        System.out.println("Length is " + getLength());
    }

    private void inputMatrixWidth() {
        System.out.println("Input matrix width:");
        Scanner in = new Scanner(System.in);
        setWidth(in.nextInt());
        System.out.println("Width is " + getWidth());
    }

    private void inputMatrix(int length, int width) {
        System.out.println("Input matrix with size [" + length + "][" + width + "]:");
        int[][] newMatrix = new int[length][width];
        Scanner in = new Scanner(System.in);
        for (int row = 0; row < length; row++) {
            for (int column = 0; column < width; column++) {
                newMatrix[row][column] = in.nextInt();
            }
        }
        setMatrix(newMatrix);
    }

    public void outputMatrix() {
        int[][] outputMatrix = getMatrix();
        System.out.println("Output matrix with size [" + getLength() + "][" + getWidth() + "]:");
        for (int row = 0; row < getLength(); row++) {
            for (int column = 0; column < getWidth(); column++) {
                System.out.print(outputMatrix[row][column] + " ");
            }
            System.out.print("\n");
        }
    }

    public void multiplyMatrix(int[][] secondMatrix, int secondMatrixWidth, int secondMatrixLength) {
        if (isMultipliable(secondMatrixLength)) {
            int[][] newMatrix = new int[getLength()][getWidth()];
            for (int row = 0; row < getLength(); row++) {
                for (int column = 0; column < secondMatrixWidth; column++) {
                    newMatrix[row][column] = multiplyRowAndColumn(column, row, secondMatrix);
                }
            }
            setWidth(secondMatrixWidth);
            setMatrix(newMatrix);
        } else {
            throw new IllegalArgumentException("Not multipliable matrixs");
        }
    }

    private boolean isMultipliable(int secondMatrixLength) {
        return (getWidth() == secondMatrixLength);
    }

    private int multiplyRowAndColumn(int column, int row, int[][] secondMatrix) {
        int[][] firstMatrix = getMatrix();
        int rowOnColumnMultiplicationResult = 0;
        for (int secondMatrixColumn = 0; secondMatrixColumn < getWidth(); secondMatrixColumn++) {
            rowOnColumnMultiplicationResult += firstMatrix[row][secondMatrixColumn] * secondMatrix[secondMatrixColumn][column];
        }
        return rowOnColumnMultiplicationResult;
    }
}
