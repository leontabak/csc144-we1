package com.eonsahead.matrix;

/**
 * Model a matrix.
 *
 * @author Leon Tabak
 * @version 1 April 2020
 */
public class Matrix {

    private double[][] elements;

    public Matrix() {
        double[] row0 = {1, 0, 0, 0};
        double[] row1 = {0, 1, 0, 0};
        double[] row2 = {0, 0, 1, 0};
        double[] row3 = {0, 0, 0, 1};
        double[][] e = {row0, row1, row2, row3};
        this.elements = e;
    } // Matrix()

    public double get(int row, int column) {
        return this.elements[row][column];
    } // get( int, int )

    public void set(int row, int column, double value) {
        this.elements[row][column] = value;
    } // set( int, int, double )

    public void identity() {
        for( int i = 0; i < 4; i++ ) {
            for( int j = 0; j < 4; j++ ) {
                if( i == j ) {
                    this.elements[i][j] = 1.0;
                } // if
                else {
                    this.elements[i][j] = 0.0;
                } // else
            } // for
        } // for
    } // identity()
    
    public void rotationZ(double angle) {
        this.identity();
        this.set( 0, 0, Math.cos(angle) );
        this.set( 0, 1, -Math.sin(angle) );
        this.set( 1, 0, Math.sin(angle) );
        this.set( 1, 1, Math.cos(angle) );
    } // rotationZ( double )

    public Matrix multiply(Matrix otherMatrix) {
        Matrix product = new Matrix();
        for( int row = 0; row < 4; row++ ) {
            for( int column = 0; column < 4; column++ ) {
                double sum = 0.0;
                for( int k = 0; k < 4; k++ ) {
                    sum += this.elements[row][k] * 
                            otherMatrix.elements[k][column];
                } // for
                product.set( row, column, sum );
            } // for
        } // for
        return product;
    } // multiply( Matrix )

    private String rowToString(int row) {
        StringBuilder result = new StringBuilder();
        result.append("( ");
        result.append(this.elements[row][0]);
        result.append(",");
        result.append(this.elements[row][1]);
        result.append(",");
        result.append(this.elements[row][2]);
        result.append(",");
        result.append(this.elements[row][3]);
        result.append(" )");
        return result.toString();
    } // rowToString( int )

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append( "[ " );
        for( int i = 0; i < 4; i++ ) {
            result.append( rowToString(i) );
        } //
        result.append( " ]" );
        return result.toString();
    } // toString()

    public static void main(String[] args) {
        Matrix identity = new Matrix();
        System.out.println("identity = " + identity);

        Matrix product = identity.multiply(identity);
        System.out.println("product = " + product);

        Matrix ccw = new Matrix();
        ccw.rotationZ(Math.PI / 4);
        System.out.println("counter-clockwise rotation = " + ccw);

        Matrix cw = new Matrix();
        cw.rotationZ(-Math.PI / 4);
        System.out.println("clockwise rotation = " + cw);

        Matrix netRotation = ccw.multiply(cw);
        System.out.println("net rotation = " + netRotation);
    } // main( String [] )

} // Matrix
