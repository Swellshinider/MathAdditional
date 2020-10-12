## MAMatrix class

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
> public double[][] multiply(MAMatrix other) throws IncompatibleMatrixException

returns a double[][], resulting from the multiplication between the matrix in which the function was called and "other".
`IncompatibleMatrixException` is called when the matrices are incompatible to be multiplied.

> public double[][] sum(MAMatrix other) throws IncompatibleMatrixException

returns a double[][], resulting from the sum of the matrix in which the function was called and "other".
`IncompatibleMatrixException` is called when the matrices are incompatible to be added

> public double[][] sub(MAMatrix other) throws IncompatibleMatrixException

returns a double [] [], the result of the subtraction between the matrix in which the function was called and "other".
`IncompatibleMatrixException` is called when arrays are incompatible with being subtracted