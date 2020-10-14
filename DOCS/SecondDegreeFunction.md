## SecondDegreeFunction class

> SecondDegreeFunction class documentation, the class consists of facilitating the calculation of second degree equations

### Instantiating:
```
public static void main(String[] args){
    
    double a = 1;
    double b = 9;
    double c = -10;
    
    try {
        SecondDegreeFunction sdf = new SecondDegreeFunction(a, b, c);
        System.out.println(sdf);

    } catch (InvalidValue e) {
        e.printStackTrace();
    }
}
```
To instantiate this class you will need to add a try catch block or use throws in the method signature.
`InvalidValue` is called when value a is equal to zero, because it is no longer a second degree equation.

output:
```
(1.0)x² + (9.0)x + (-10.0) = 0
```

SecondDegreeFunction class already contains toString().

<hr>

### Methods:

##### String[] calcFunction(boolean calculateComplex)

returns a String[] with the roots of equation.
@param calculateComplex If the parameter is true, and the delta is negative the value returned will be of the complex plane.

<hr>

##### double[] calcFunction()

returns a double[] with the roots of equation.

<hr>

#### Gets

The class contains get for 'a', 'b' and 'c' variables.

<hr>

## Meta

Eduardo Ribeiro Leal – [Twitter](https://twitter.com/Eduardo_R_Leal) – eduardoleal.contact@gmail.com

Distributed under the MIT license. See ``LICENSE`` for more information.
