import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

//B221202371
//Yusuf Dilekçi
//SWE202 SOFTWARE VERIFICATION AND VALIDATION
//HOMEWORK 1
//https://github.com/YusufDilekci/TDDExample
class CalculatorTest {
	
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    
    public static Collection<Object[]> data(){
    	return Arrays.asList(new Object[][] {
    		{10, 2, 5},
    		{10, 4, 2.5},
    		{12.5, 5 ,2.5},
    		{10, 2.5, 4},
    		{12.5, 2.5, 5},
    	});
    }
    
    @ParameterizedTest
    @MethodSource("data")
    void myDivision(double dividend, double divider, double expected) {
        assertEquals(expected, Calculator.divide(dividend, divider));
    }

    
    
    @Test
    void testDivision1() {
        assertEquals(5, Calculator.divide(10, 2));
    }

    @Test
    void testDivision2() {
        assertEquals(2.5, Calculator.divide(10, 4));
    }

    @Test
    void testDivision3() {
        assertEquals(2.5, Calculator.divide(12.5, 5));
    }

    @Test
    void testDivision4() {
        assertEquals(4, Calculator.divide(10, 2.5));
    }

    @Test
    void testDivision5() {
        assertEquals(5, Calculator.divide(12.5, 2.5));
    }

    @Test
    void testDivision6() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Calculator.divide(12.5, 0),
                "IllegalArgumentException expected."
        );

    }
}