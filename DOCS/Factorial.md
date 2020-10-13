## Factorial class

> Factorial class documentation, the class Factorial consists of creating a factorial number, and properties of them

### Instantiating:
```
public static void main(String[] args){
    
    int number = 5;

    try {

        Factorial fact = new Factorial(number);
        System.out.println(fact);

    } catch (Exception e) {
        e.printStackTrace();
    } 
}
```
To instantiate this class you will need to add a try catch block or use throws in the method signature.
`ValueExceedsRamException` is called when the number used to instantiate the class is too high to calculate its factorial.

output:
```
120
```
The Factorial class already contains toString().

<hr>

### Methods:

##### int getNDigitsOfFactorial()

return the number of digits of factorial.

<hr>

##### BigInteger getFactorial() 

return a BigInteger, the calculated factorial.

<hr>

##### long getNZerosInTheEnd()

returns the number of zeros at the end of the factorial.

<hr>

##### String toString()

is the same as getFactorial().toString().

<hr>

## Meta

Eduardo Ribeiro Leal – [Twitter](https://twitter.com/Eduardo_R_Leal) – eduardoleal.contact@gmail.com

Distributed under the MIT license. See ``LICENSE`` for more information.
