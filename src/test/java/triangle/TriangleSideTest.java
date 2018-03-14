package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Scanner;

/**
 * Created by mila on 3/11/18.
 */
@Test
public class TriangleSideTest {
    private Triangle triangle;

    @DataProvider(name = "simpleDataProvider") public Object[][] createSomeData() {
// Просто передаём входные данные и ожидаемый результат.
        return new Object[][]
                {
                        // negative testing a triangle side to be <= 0.
                        { 0, 4, 5, "a = 0" },       // a =0
                        { 2, 0, 5, "b = 0" },       // b = 0
                        { 3, 1, 0, "c = 0" },       // c =0
                        { -5, 3, 1, "a < 0" },      // a < 0
                        { 1, -3, 3, "b < 0" },      // b < 0
                        { 1, 3, -3, "c < 0" },      // c < 0
                        { 2, 5, 5, "a,b,c > 0" },   // a,b,c > 0 - TRUE

                        // validate, if we can construct a triangle from the given sides.
                        { 1, 4, 5, " a + b = c " },    // a + b = c
                        { 2, 5, 5, " a + b > c " },     // a + b > c
                        { 3, 1, 5, " a + b < c " },     // a + b < c  error
                        { 5, 3, 1, " c + b < a " },     // c + b < a   error
                        { 1, 5, 3, " a + c < b " }      // a + c < b    error
                };
    }

    @Test(dataProvider = "simpleDataProvider")
    public void TriangleSideTesting(int a, int b, int c, String str){

        triangle  = new Triangle(a, b, c);
        Assert.assertTrue(triangle.checkTriangle(), str);
//        System.out.println("inside - Testing Triangle Sides.");
    }
}
