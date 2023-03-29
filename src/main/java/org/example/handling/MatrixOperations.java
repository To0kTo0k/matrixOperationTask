package org.example.handling;

import lombok.Getter;
import org.example.dto.MatrixDto;

import java.util.Scanner;

@Getter
public class MatrixOperations {

    MatrixDto dto = new MatrixDto();

    public void initMatrix() {
        inMatrixLength();
        inMatrixWidth();
        inMatrix();
    }

    private void inMatrixLength() {
        System.out.println("Input matrix length:");
        Scanner in = new Scanner(System.in);
        dto.setLength(in.nextInt());
        System.out.println("Length is " + dto.getLength());
    }

    private void inMatrixWidth() {
        System.out.println("Input matrix width:");
        Scanner in = new Scanner(System.in);
        dto.setWidth(in.nextInt());
        System.out.println("Width is " + dto.getWidth());
    }

    private void inMatrix() {
        System.out.println("Input matrix with size [" + dto.getLength() + "][" + dto.getWidth() + "]:");
        int[][] matrix = new int[dto.getLength()][dto.getWidth()];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < dto.getLength(); i++) {
            for (int j = 0; j < dto.getWidth(); j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        dto.setBody(matrix);
    }

    public void outMatrix() {
        int[][] matrix = dto.getBody();
        System.out.println("Output matrix with size [" + dto.getLength() + "][" + dto.getWidth() + "]:");
        for (int i = 0; i < dto.getLength(); i++) {
            for (int j = 0; j < dto.getWidth(); j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public void multiplyMatrix(MatrixDto matrix) {
        if (isMultipliable(dto, matrix)) {
            int[][] newMatrix = new int[dto.getLength()][matrix.getWidth()];
            for (int i = 0; i < dto.getLength(); i++) {
                for (int j = 0; j < matrix.getWidth(); j++) {
                    newMatrix[i][j] = multiplyRowAndColumn(j, i, matrix);
                }
            }
            dto.setWidth(matrix.getWidth());
            dto.setBody(newMatrix);
        } else {
            throw new RuntimeException("Not multipliable matrixs");
        }
    }

    private boolean isMultipliable(MatrixDto firstMatrix, MatrixDto secondMatrix) {
        return (firstMatrix.getWidth() == secondMatrix.getLength());
    }

    private int multiplyRowAndColumn(int column, int row, MatrixDto matrixDto) {
        int[][] firstMatrix = dto.getBody();
        int[][] secondMatrix = matrixDto.getBody();
        int sum = 0;
        for (int i = 0; i < dto.getWidth(); i++) {
            sum += firstMatrix[row][i] * secondMatrix[i][column];
        }
        return sum;
    }

    public void transposeMatrix() {
        int[][] matrix = dto.getBody();
        int[][] transposedMatrix = new int[dto.getWidth()][dto.getLength()];
        for (int i = 0; i < dto.getLength(); i++) {
            for (int j = 0; j < dto.getWidth(); j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        dto.setBody(transposedMatrix);
    }
}
