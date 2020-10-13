## MAMatrix class

> MAMatrix class documentation, all methods with description.

### Instantiating:
```
public static void main(String[] args){
    
    double[][] matrix1 = {
        {1, 2},
        {3 , 4}
    };

    try {
        MAMatrix m1 = new MAMatrix(matrix1);
        System.out.println(m1);
        
    } catch (InvalidMatrixException e) {
        e.printStackTrace();
    }
}
```
To instantiate this class you will need to add a try catch block or use throws in the method signature.
`InvalidMatrixException` is called when any matrix value is Double.Infinity or Double.NaN.

output:
```
[1, 2]
[3, 4]
```
The MAMatrix Class already contains toString().

<hr>

### Methods:

##### double[][] multiply(MAMatrix other) throws IncompatibleMatrixException


returns a double[][], resulting from the multiplication between the matrix in which the function was called and "other".
`IncompatibleMatrixException` is called when the matrices are incompatible to be multiplied.

<hr>

##### double[][] sum(MAMatrix other) throws IncompatibleMatrixException

returns a double[][], resulting from the sum of the matrix in which the function was called and "other".
`IncompatibleMatrixException` is called when the matrices are incompatible to be added.

<hr>

##### double[][] sub(MAMatrix other) throws IncompatibleMatrixException

returns a double[][], the result of the subtraction between the matrix in which the function was called and "other".
`IncompatibleMatrixException` is called when arrays are incompatible with being subtracted.

<hr>

##### double[][] getMatrix()

returns a double[][], return the initial double[][] used to instantiate class.

<hr>

##### double getDeterminant() throws CannotUseMatrixException

returns a double, determinant of matrix NxN.
`CannotUseMatrixException` is called when matrix is not NxN (Mij, i != j).

<hr>

##### double[][] getInverse() throws CannotUseMatrixException

returns a double[][], the inverse matrix, returns null if do not have inverse.
`CannotUseMatrixException` is called when matrix is not NxN (Mij, i != j).

<hr>

##### getIdentity() throws CannotUseMatrixException

returns a double[][], the identity matrix.
`CannotUseMatrixException` is called when matrix is not NxN (Mij, i != j).

<hr>

##### getTranspose()

returns a double, the transpose matrix.

<hr>

##### String toString()

return a String with a nice format to read in terminal.

<hr>

## Meta

Eduardo Ribeiro Leal – [Twitter](https://twitter.com/Eduardo_R_Leal) – eduardoleal.contact@gmail.com

Distributed under the MIT license. See ``LICENSE`` for more information.
