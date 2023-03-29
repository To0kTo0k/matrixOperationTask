package org.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatrixDto {
    private int length;
    private int width;
    private int[][] body;
}
