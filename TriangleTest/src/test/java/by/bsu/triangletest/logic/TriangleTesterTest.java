package by.bsu.triangletest.logic;

import by.bsu.triangletest.exception.InvalidSidesException;
import by.bsu.triangletest.exception.NullSidesException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleTesterTest {
    @Test(dataProvider = "positiveNumbers")
    public void testTestWhenPositiveNumbersArePassed(double a, double b, double c, boolean expected) throws InvalidSidesException, NullSidesException {
        boolean actual = TriangleTester.test(a, b, c);
        Assert.assertEquals(expected, actual);
    }

    @DataProvider(name = "positiveNumbers")
    public Object[][] positiveNumbers(){
        return new Object[][]{
                {4, 5, 3, true},
                {7, 2, 7, true},
                {5, 5, 5, true},
                {10, 5, 5, true},
                {20, 2, 1, false},
                {30, 100, 30, false}
        };
    }

    @Test(expectedExceptions = InvalidSidesException.class, dataProvider = "incorrectNumbers")
    public void shouldThrowInvalidSidesExceptionWhenInvalidDataPassed(double a, double b, double c) throws InvalidSidesException, NullSidesException{
        TriangleTester.test(a, b, c);
    }

    @DataProvider(name = "incorrectNumbers")
    public Object[][] incorrectNumbers(){
        return new Object[][]{
                {4, 5, -3},
                {0, 2, 1},
                {-3, -2, -1}
        };
    }

    @Test(expectedExceptions = NullSidesException.class)
    public void shouldThrowNullSidesExceptionWhenNullSidePassed() throws InvalidSidesException, NullSidesException{
        Double a = 4.;
        Double b = 5.;
        Double c = null;
        TriangleTester.test(a, b, c);
    }
}
