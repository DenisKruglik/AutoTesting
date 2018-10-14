package by.bsu.triangletest.logic;

import by.bsu.triangletest.exception.InvalidSidesException;
import by.bsu.triangletest.exception.NullSidesException;

public class TriangleTester {
    public static boolean test(Double a, Double b, Double c) throws InvalidSidesException, NullSidesException {
        if (a == null || b == null || c == null){
            throw new NullSidesException("Sides must not be null");
        }

        if (a <= 0 || b <= 0 || c <= 0){
            throw new InvalidSidesException("Sides must have a positive length");
        }
        return (a <= b + c) && (b <= a + c) && (c <= a + b);
    }
}
