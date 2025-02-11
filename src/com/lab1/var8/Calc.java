package com.lab1.var8;
import java.util.Scanner;

public class Calc {
    public static void main(Integer[] args) {
        /*   var ugol= Integer.parseInt(args[0])  * Math.PI / 180;
        System.out.printf("Degree " + ugol);

         */


        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите угол в градусах: ");
        double degrees = scanner.nextDouble();

        double radians = degrees * Math.PI / 180;

        System.out.printf("Угол в радианах: %.4f%n", radians);


    }
}

/*
package com.lab1.var8;

import java.util.Scanner;

public class Calc {

    Scanner scanner = new Scanner(System.in);

        System.out.print("Введите угол в градусах: ");
    double degrees = scanner.nextDouble();

    double radians = degrees * Math.PI / 180;

        System.out.printf("Угол в радианах: %.4f%n", radians);
}
*/