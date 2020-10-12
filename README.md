# MathAdditional

> Java library, additional math tools to make your life easier.

## Installation

Steps:
```
1- Download MathAdditional.zip
2- Extract.
3- Drag it anywhere.
4- Ready to use
```

## Usage example

Using MAMatrix.class:
```java
double[][] m1 = {
    {2, 3, 4},
    {4, 5, 6}
};

double[][] m2 = {
        {9, 5},
        {5, 5},
        {1, 3}
};

try {

    MAMatrix maMatrix1 = new MAMatrix(m1);
    MAMatrix maMatrix2 = new MAMatrix(m2);

    double[][] multiplicationM1andM2 = maMatrix1.multiply(maMatrix2);

    System.out.println(new MAMatrix(multiplicationM1andM2));
} catch (Exception e) {
    e.printStackTrace();
}

```
output:
```
[37.0, 37.0]
[67.0, 63.0]
```

See ``DOCS`` for morr information.

## Development

- [x] Matrix class.
- [x] Factorial class.
- [x] Exceptions classes.
- [x] Prime static class
- [ ] Second Degree Equation Solver
- [ ] Simple Base Conversor

## Meta

Eduardo Ribeiro Leal – [Twitter](https://twitter.com/Eduardo_R_Leal) – eduardoleal.contact@gmail.com

Distributed under the MIT license. See ``LICENSE`` for more information.
