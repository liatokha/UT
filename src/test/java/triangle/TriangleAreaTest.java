package triangle;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

/**
 * Created by mila on 3/11/18.
 */
public class TriangleAreaTest {
    final int TR_EQUILATERAL = 1; // равносторонний
    final int TR_ISOSCELES = 2;   // равнобедренный
    final int TR_ORDYNARY = 4;    // обычный
    final int TR_RECTANGULAR = 8; // пр€моугольный

    private double a;
    private double b;
    private double c;




    @Test
    public void TriangleAreaTesting(double a, double b, double c, String str){

        triangle  = new Triangle(a, b, c);

        // half of perimeter
        double halfPerimetr = (a+b+c)/2;
        double expectedSquer = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        double inputSquer =
}

}
