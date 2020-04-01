package com.eonsahead.matrix;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {

    public MatrixTest() {
    }

    @Test
    public void testRotation() {
        System.out.println("rotation");
        double angle = Math.PI;
        Matrix instance = new Matrix();
        instance.rotation(angle);
        
        System.out.println( "instance = " + instance );
        assertEquals(instance.get(0, 0), 0.0, 1E-8);
        assertEquals(instance.get(0, 1), -1.0, 1E-8);
        assertEquals(instance.get(1, 0), 0.0, 1E-8);
        assertEquals(instance.get(1, 1), 1.0, 1E-8);
    } // testRotation()

    @Test
    public void testMultiply() {
        System.out.println("multiply");
        Matrix otherMatrix = new Matrix();
        Matrix instance = new Matrix();
        Matrix expResult = new Matrix();
        Matrix result = instance.multiply(otherMatrix);
        assertEquals(expResult.get(0, 0), result.get(0, 0), 1E-8);
        assertEquals(expResult.get(0, 1), result.get(0, 1), 1E-8);
        assertEquals(expResult.get(1, 0), result.get(1, 0), 1E-8);
        assertEquals(expResult.get(1, 1), result.get(1, 1), 1E-8);
    } // testMultiply()

}
