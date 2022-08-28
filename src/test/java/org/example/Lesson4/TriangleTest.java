package org.example.Lesson4;

import Lesson4.MyException;
import Lesson4.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangleTest {

    @Test
    void triangleTest() throws MyException {
        Triangle triangle = new Triangle();
        Assertions.assertEquals(6d, Triangle.triangleArea(5, 3 , 4));
        Assertions.assertThrows(MyException.class,()-> Triangle.triangleArea(1,100, 2));
        Assertions.assertThrows(MyException.class,()-> Triangle.triangleArea(-1,-2, -3));
        Assertions.assertThrows(MyException.class,()-> Triangle.triangleArea(0,5, 6));
    }

    @ParameterizedTest
    @CsvSource({"5, 3, 4, 6", "6, 5, 5, 12"})
    void triangleTestWithParam (int a, int b, int c, double result) throws MyException{
        Triangle triangle = new Triangle();
        Assertions.assertEquals(result, Triangle.triangleArea(a, b, c));

    }

}
