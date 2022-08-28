package Lesson4;

import java.io.IOException;
import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) throws MyException {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(triangleArea(a, b, c));




    }
    public static double triangleArea (int a, int b, int c) throws MyException {
        if(a + b < c || b + c < a || a + c < b || a <= 0 || b <= 0 || c <= 0) throw new MyException("It is not a triangle");
        double p = ( a + b + c ) / 2;

        double result = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        return result;

    }






}

