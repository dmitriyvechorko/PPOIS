import java.io.FileNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

public class RealMatrixTest {

    @Test
    public void test2() {
        RealMatrix matrix = new RealMatrix(2, 2);
        matrix.setElement(0, 1, 3.);
        matrix.setElement(0, 0, 5.);
        matrix.setElement(1, 0, 7.);
        matrix.setElement(1, 1, 8.);
        Assert.assertEquals(2, matrix.getRows());
        Assert.assertEquals(2, matrix.getCols());
    }
    @Test
    public void test3() {
        RealMatrix matrix = new RealMatrix(2, 2);
        matrix.setElement(0, 0, 6.);
        matrix.setElement(0, 1, 1.);
        matrix.setElement(1, 0, 3.);
        matrix.setElement(1, 1, -4.);
        Assert.assertEquals(6., matrix.getElement(0,0), 0.001);
        Assert.assertEquals(1., matrix.getElement(0,1), 0.001);
        Assert.assertEquals(3., matrix.getElement(1,0), 0.001);
        Assert.assertEquals(-4., matrix.getElement(1,1), 0.001);
    }
    @Test
    public void test4() {
        RealMatrix matrix = new RealMatrix(4, 3);
        matrix.setElement(0, 0, 6.);
        matrix.setElement(0, 1, 1.);
        matrix.setElement(0, 2, 3.);
        matrix.setElement(1, 0, -4.);
        matrix.setElement(1, 1, 6.);
        matrix.setElement(1, 2, 1.);
        matrix.setElement(2, 0, 3.);
        matrix.setElement(2, 1, -4.);
        matrix.setElement(2, 2, -4.);
        matrix.setRows(2);
        matrix.setCols(2);
        Assert.assertEquals(2, matrix.getRows());
        Assert.assertEquals(2, matrix.getCols());
    }
    @Test
    public void test5() {
        RealMatrix matrix = new RealMatrix(3,2);
        try {
            matrix.loadFromFile("D:\\PPOIS\\lab1\\src\\Matrix.txt");
            double[][] expected = {{1.0, 2.0}, {3.0, 4.0}};
            double[][] actual = matrix.getMatrix();
            assertArrayEquals(expected, actual);
        } catch (FileNotFoundException e) {
            fail("File not found: " + e.getMessage());
        }
    }
    @Test(expected = FileNotFoundException.class)
    public void test6() throws FileNotFoundException {
        RealMatrix matrix = new RealMatrix(3, 4);
        matrix.loadFromFile("invalid.txt");
    }
    @Test
    public void test7(){
        RealMatrix matrix = new RealMatrix(4, 4);
        matrix.setElement(0, 0, 1.0);
        matrix.setElement(0, 1, 2.0);
        matrix.setElement(0, 2, 3.0);
        matrix.setElement(0, 3, 4.0);
        matrix.setElement(1, 0, 5.0);
        matrix.setElement(1, 1, 6.0);
        matrix.setElement(1, 2, 7.0);
        matrix.setElement(1, 3, 8.0);
        matrix.setElement(2, 0, 9.0);
        matrix.setElement(2, 1, 10.0);
        matrix.setElement(2, 2, 11.0);
        matrix.setElement(2, 3, 12.0);
        matrix.setElement(3, 0, 13.0);
        matrix.setElement(3, 1, 14.0);
        matrix.setElement(3, 2, 15.0);
        matrix.setElement(3, 3, 16.0);
        RealMatrix subMatrix = matrix.getSubMatrix(1, 1, 2, 2);
        Assert.assertEquals(6.0, subMatrix.getElement(0, 0), 0.001);
        Assert.assertEquals(7.0, subMatrix.getElement(0, 1), 0.001);
        Assert.assertEquals(10.0, subMatrix.getElement(1, 0), 0.001);
        Assert.assertEquals(11.0, subMatrix.getElement(1, 1), 0.001);
    }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test8() {
        RealMatrix matrix = new RealMatrix(2, 2);
        matrix.getSubMatrix(1, 1, 4, 4);
    }
    @Test
    public void test9() {
        RealMatrix matrix = new RealMatrix(3, 3);
        Assert.assertTrue(matrix.isSquare());
    }

    @Test
    public void test10() {
        RealMatrix matrix = new RealMatrix(3, 4);
        Assert.assertFalse(matrix.isSquare());
    }
    @Test
    public void test11() {
        RealMatrix matrix = new RealMatrix(3, 3);
        matrix.setElement(0, 0, 1.0);
        matrix.setElement(1, 1, 1.0);
        matrix.setElement(2, 2, 1.0);
        Assert.assertTrue(matrix.isDiagonal());
    }
    @Test
    public void test12() {
        RealMatrix matrix = new RealMatrix(3, 3);
        matrix.setElement(0, 0, 1.0);
        matrix.setElement(1, 1, 1.0);
        matrix.setElement(1, 2, 3.0);
        matrix.setElement(2, 2, 1.0);
        Assert.assertFalse(matrix.isDiagonal());
    }
    @Test
    public void test13() {
        RealMatrix matrix = new RealMatrix(3, 3);
        Assert.assertTrue(matrix.isZero());
    }

    @Test
    public void test14() {
        RealMatrix matrix = new RealMatrix(3, 3);
        matrix.setElement(1, 1, 1.0);
        Assert.assertFalse(matrix.isZero());
    }
    @Test
    public void test15() {
        RealMatrix matrix = new RealMatrix(3, 3);
        matrix.setElement(0, 0, 1.0);
        matrix.setElement(1, 1, 1.0);
        matrix.setElement(2, 2, 1.0);
        Assert.assertTrue(matrix.isIdentity());
    }
    @Test
    public void test16() {
        RealMatrix matrix = new RealMatrix(3, 3);
        matrix.setElement(0, 0, 1.0);
        matrix.setElement(1, 1, 1.0);
        matrix.setElement(2, 2, 2.0);
        Assert.assertFalse(matrix.isIdentity());
    }
    @Test
    public void test17() {
        RealMatrix matrix = new RealMatrix(3, 3);
        matrix.setElement(0, 0, 1.0);
        matrix.setElement(0, 1, 2.0);
        matrix.setElement(1, 0, 2.0);
        matrix.setElement(1, 1, 3.0);
        Assert.assertTrue(matrix.isSymmetric());
    }
    @Test
    public void test18() {
        RealMatrix matrix = new RealMatrix(3, 3);
        matrix.setElement(0, 0, 1.0);
        matrix.setElement(0, 1, 2.0);
        matrix.setElement(1, 0, 4.0);
        matrix.setElement(1, 1, 5.0);
        Assert.assertFalse(matrix.isSymmetric());
    }
    @Test
    public void test19() {
        RealMatrix matrix = new RealMatrix(3, 3);
        matrix.setElement(0, 0, 1.0);
        matrix.setElement(0, 1, 2.0);
        matrix.setElement(0, 2, 3.0);
        matrix.setElement(1, 1, 4.0);
        matrix.setElement(1, 2, 5.0);
        matrix.setElement(2, 2, 6.0);
        Assert.assertTrue(matrix.isUpperTriangular());
    }
    @Test
    public void test20() {
        RealMatrix matrix = new RealMatrix(2, 2);
        matrix.setElement(0, 0, 1.0);
        matrix.setElement(0, 1, 2.0);
        matrix.setElement(1, 0, 3.0);
        matrix.setElement(1, 1, 4.0);
        Assert.assertFalse(matrix.isUpperTriangular());
    }
    @Test
    public void test21() {
        RealMatrix matrix = new RealMatrix(3, 3);
        matrix.setElement(0, 0, 1.0);
        matrix.setElement(1, 0, 2.0);
        matrix.setElement(1, 1, 3.0);
        matrix.setElement(2, 0, 4.0);
        matrix.setElement(2, 1, 5.0);
        matrix.setElement(2, 2, 6.0);
        Assert.assertTrue(matrix.isLowerTriangular());
    }
    @Test
    public void test22() {
        RealMatrix matrix = new RealMatrix(2, 2);
        matrix.setElement(0, 0, 1.0);
        matrix.setElement(0, 1, 2.0);
        matrix.setElement(1, 0, 3.0);
        matrix.setElement(1, 1, 4.0);
        Assert.assertFalse(matrix.isLowerTriangular());
    }
    @Test
    public void test23() {
        RealMatrix matrix = new RealMatrix(3, 3);
        matrix.setElement(0, 0, 1.0);
        matrix.setElement(0, 1, 2.0);
        matrix.setElement(0, 2, 3.0);
        matrix.setElement(1, 0, 4.0);
        matrix.setElement(1, 1, 5.0);
        matrix.setElement(1, 2, 6.0);
        matrix.setElement(2, 0, 7.0);
        matrix.setElement(2, 1, 8.0);
        matrix.setElement(2, 2, 9.0);
        RealMatrix transposedMatrix = matrix.transpose();
        Assert.assertEquals(1.0, transposedMatrix.getElement(0, 0), 0.001);
        Assert.assertEquals(4.0, transposedMatrix.getElement(0, 1), 0.001);
        Assert.assertEquals(7.0, transposedMatrix.getElement(0, 2), 0.001);
        Assert.assertEquals(2.0, transposedMatrix.getElement(1, 0), 0.001);
        Assert.assertEquals(5.0, transposedMatrix.getElement(1, 1), 0.001);
        Assert.assertEquals(8.0, transposedMatrix.getElement(1, 2), 0.001);
        Assert.assertEquals(3.0, transposedMatrix.getElement(2, 0), 0.001);
        Assert.assertEquals(6.0, transposedMatrix.getElement(2, 1), 0.001);
        Assert.assertEquals(9.0, transposedMatrix.getElement(2, 2), 0.001);
    }
    @Test
    public void test24() {
        RealMatrix matrix = new RealMatrix(3, 2);
        matrix.setElement(0, 0, 1.0);
        matrix.setElement(0, 1, 2.0);
        matrix.setElement(1, 0, 3.0);
        matrix.setElement(1, 1, 4.0);
        matrix.setElement(2, 0, 5.0);
        matrix.setElement(2, 1, 6.0);
        RealMatrix transposedMatrix = matrix.transpose();
        Assert.assertEquals(1.0, transposedMatrix.getElement(0, 0), 0.001);
        Assert.assertEquals(3.0, transposedMatrix.getElement(0, 1), 0.001);
        Assert.assertEquals(5.0, transposedMatrix.getElement(0, 2), 0.001);
        Assert.assertEquals(2.0, transposedMatrix.getElement(1, 0), 0.001);
        Assert.assertEquals(4.0, transposedMatrix.getElement(1, 1), 0.001);
        Assert.assertEquals(6.0, transposedMatrix.getElement(1, 2), 0.001);
    }
}