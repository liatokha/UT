package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Scanner;

/**
 * Created by mila on 3/11/18.
 */
public class TriangleAreaTest {

    final int TR_EQUILATERAL = 1; // равносторонний
    final int TR_ISOSCELES = 2;   // равнобедренный
    final int TR_ORDYNARY = 4;    // обычный
    final int TR_RECTANGULAR = 8; // прямоугольный
    final int TR_ERROR_TYPE = -1; // ! - не треугольник
    private Triangle triangle = null;

    @DataProvider(name = "simpleDataProvider") public Object[][] createSomeData() {
// Просто передаём входные данные и ожидаемый результат.
        return new Object[][]
                {
                        // positive testing. Define triangle type.
                        //  длинны сторон треугольника (по типам треугольника)
                        { 2, 3, 4, TR_ORDYNARY, " 'TR_ORDYNARY = 4;  обычный' " },     // обычный
                        { 6, 8, 4, TR_ORDYNARY, " 'TR_ORDYNARY = 4;  обычный' " },     // обычный


                        { 3, 4, 5,  TR_RECTANGULAR, " 'TR_RECTANGULAR = 8;  прямоугольный' 3, 4, 5" },      // прямоугольный
                        { 3, 5, 4,  TR_RECTANGULAR, " 'TR_RECTANGULAR = 8;  прямоугольный' 3, 5, 4" },     // прямоугольный
                        { 4, 3, 5,  TR_RECTANGULAR, " 'TR_RECTANGULAR = 8;  прямоугольный' 4, 3, 5" },     // прямоугольный
                        { 4, 5, 3,  TR_RECTANGULAR, " 'TR_RECTANGULAR = 8;  прямоугольный' 4, 5, 3" },      // прямоугольный
                        { 5, 3, 4,  TR_RECTANGULAR, " 'TR_RECTANGULAR = 8;  прямоугольный' 5, 3, 4" },     // прямоугольный
                        { 5, 4, 3,  TR_RECTANGULAR, " 'TR_RECTANGULAR = 8;  прямоугольный' 5, 4, 3" },     // прямоугольный


                        { 2, 2, 3,  TR_ISOSCELES, " 'TR_ISOSCELES = 2;   равнобедренный' " },     // равнобедренный
                        { 2, 3, 2, TR_ISOSCELES, " 'TR_ISOSCELES = 2;   равнобедренный' " },    // равнобедренный
                        { 3, 2, 2, TR_ISOSCELES, " 'TR_ISOSCELES = 2;   равнобедренный' " },    // равнобедренный

                        { 3, 3, 3, TR_EQUILATERAL | TR_ISOSCELES, " 'TR_EQUILATERAL = 1;  равносторонний' " },     // равносторонний
                        { 5, 5, 5, TR_EQUILATERAL | TR_ISOSCELES, " 'TR_EQUILATERAL = 1;  равносторонний' " },     // равносторонний

                        { 2.0, 2.0, 2.83, TR_RECTANGULAR | TR_ISOSCELES, " 'R_RECTANGULAR | TR_ISOSCELES = 10; прямоугольный и равнобедренный' " },   // прямоугольный и равнобедренный
                        { 7, 7, 9.90,     TR_RECTANGULAR | TR_ISOSCELES, " 'R_RECTANGULAR | TR_ISOSCELES = 10; прямоугольный и равнобедренный' " },    // прямоугольный и равнобедренный

                        // negative testing.
                        { 5, 3, 1, TR_ERROR_TYPE, " c + b < a,  error - NOT triangle" },      // c + b < a   error - not triangle
                        { 1, 5, 3, TR_ERROR_TYPE, " a + c < b,  error - NOT triangle" },      // a + c < b   error - not triangle
                        { 1, 3, 5, TR_ERROR_TYPE, " a + c < b,  error - NOT triangle" }       // a + b < c   error - not triangle
                };
    }

    @Test(dataProvider = "simpleDataProvider")
    public void TriangleAreaTesting(double a, double b, double c, int type, String str){

        double p = (a+b+c)/2;   // half of perimeter
        double expectedSquer = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        double inputSquer = new Triangle(a, b, c).getSquare();

        Assert.assertEquals(inputSquer, expectedSquer, 0.001, str);
    }
}
