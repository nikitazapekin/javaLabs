package com.lab1.var8;

import java.util.Scanner;

public class Degree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите угол в градусах: ");
        double degrees = scanner.nextDouble();

        double radians = degrees * Math.PI / 180;

        System.out.printf("Угол в радианах: %.4f%n", radians);
    }
}
