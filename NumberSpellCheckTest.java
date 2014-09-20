package numberSpellCheck;
import org.junit.Assert;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NumberSpellCheckTest.
 *
 * @author  David Sajdl
 * username dsajdl01
 * @version 10/12/101
 */
public class NumberSpellCheckTest{
	
	 private int[] testArray;
	 private NumberSpellCheck nsc;
    /**
     * Default constructor for test class NumberSpellCheckTest
     */
    public NumberSpellCheckTest(){
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
    	  nsc = new NumberSpellCheck(5);
    	  testArray = new int[5];
    	  testArray[0] = 12345670; 
    	  testArray[1]  = 11115555;
    	  testArray[2] = -12345678;
    	  testArray[3] = -55551111;
    	  testArray[4] = 11555551;
    }
   /**
     * Sets up the test fixture.
     *
     * Called every test case method.
     */
    
    /**
     * Test that check exactMatch() method from class NumberSpellCheck.
     *
     * test create array of 5 integers and then it it simulated input number and compare result.
     * 
     * test check two same value or equal result / true
     */
     @Test
    public void bestMatchEqual(){
        int inputNumber = -12345678;
        nsc.createDictionary(testArray);
        assertEquals(true,nsc.exactMatch(inputNumber));
    }
    
    /**
     * Test that check exactMatch() method from class NumberSpellCheck.
     *
     * test create array of 5 integers and then it it simulated input number and compare result.
     * 
     * test check two different value or NotEqualTo result / false
     */
     @Test
    public void bestMatchNotEqual(){
        int inputNumber = -12345699;
        nsc.createDictionary(testArray);
        assertEquals(false,nsc.exactMatch(inputNumber));
    }
    @Test
    
    /**
     * Test that check findBestMatchs() method from class NumberSpellCheck.
     *
     * test create array of 5 integers and then it it simulated input number and compare result.
     * 
     * test check if method find 3 nearest matches in the array.
     */
    public void findBestMatchsTest(){
        int inputNumber = 11615555;
        int[] toBeMatched = {11555551, 12345670, 11115555};
        nsc.createDictionary(testArray);
        Assert.assertArrayEquals(toBeMatched,nsc.findBestMatches(inputNumber));
    }
   
    /**

     * Test check findBestMatchs() method from class NumberSpellCheck.
     *
     * test create array of 5 integers and then is simulated input number and compare result.
     * 
     * test check if method find 3 nearest matches in the array.
     */
    @Test
    public void findBestMatchsTestI(){
        int inputNumber = 0;
        int[] toBeMatched = {-12345678, 11115555,12345670};
        nsc.createDictionary(testArray);
        Assert.assertArrayEquals(toBeMatched,nsc.findBestMatches(inputNumber));
    }
    /**

     * Test that check findBestMatchs() method from class NumberSpellCheck.
     *
     * test create array of 5 integers and then it it simulated input number and compare result.
     * 
     * test check if method find 3 nearest matches in the array.
     */
     @Test
    public void findBestMatchsTestII(){
        int inputNumber = 1165551;
        int[] toBeMatched = {-12345678, 0, 11115555};
        nsc.createDictionary(testArray);
        Assert.assertArrayEquals(toBeMatched,nsc.findBestMatches(inputNumber));
    }
    
    /**
     * Test that check assignDuplicateValueToZero() method from class NumberSpellCheck.
     *
     * test create array of 3 integers which two values are same. 
     * 
     * test check if one of the duplicate value has been assigned to zero. 
     */
    @SuppressWarnings("static-access")
    @Test
    public void assignDupToZero(){
        int[] testPrArray = {12345678, -12345678, 12345678};
        int[] toBeMatched = {0, -12345678, 12345678};
        Assert.assertArrayEquals(toBeMatched,nsc.assignDuplicateValueToZero(testPrArray));
    }
    
    /**
     * Test that check assignDuplicateValueToZero() method from class NumberSpellCheck.
     *
     * test create array of 3 integers which two values are same. 
     * 
     * test check if one of the duplicate value has been assigned to zero. 
     */ 
    @SuppressWarnings("static-access")
    @Test
    public void assignDupToZeroII(){
        int[] testPrArray = {-12345678,-91234567, -91234567};
        int[] toBeMatched = {-12345678, 0, -91234567,};
        Assert.assertArrayEquals(toBeMatched,nsc.assignDuplicateValueToZero(testPrArray));
    }
    
    /**
     * Test that check assignDuplicateValueToZero() method from class NumberSpellCheck.
     *
     * test create array of 3 the same values of integers. 
     * 
     * test check if one of the duplicate value has been assigned to zero. 
     */ 
    @SuppressWarnings("static-access")
    @Test
    public void assignDupToZeroIII(){
        int[] testPrArray = {-91234567,-91234567, -91234567};
        int[] toBeMatched = {0, 0, -91234567,};
        Assert.assertArrayEquals(toBeMatched,nsc.assignDuplicateValueToZero(testPrArray));
    }
    
    /**
     * Test that check assignDuplicateValueToZero() method from class NumberSpellCheck.
     *
     * test create array of 3 different integers. 
     * 
     * test check if the result remind the same. 
     */
    @SuppressWarnings("static-access")
    @Test
    public void assignDupToZeroIV(){
        int[] testPrArray = {-12345678,-91234567, 91234567};
        int[] toBeMatched = {-12345678, -91234567,91234567};
        Assert.assertArrayEquals(toBeMatched,nsc.assignDuplicateValueToZero(testPrArray));
    }
    @Test
    
    /**
     * Test that check getOtherBestMatch() method from class NumberSpellCheck.
     *
     * test create array of 5 integers and send input number. 
     * 
     * test check for smallest different between input number and array value. 
     */ 
    public void testOtherBestMatch(){
        int inputNumber = -12345677;
        nsc.createDictionary(testArray);
        assertEquals(-12345678,nsc.getOtherBestMatch(inputNumber));
    }
    
    /**
     * Test that check getOtherBestMatch() method from class NumberSpellCheck.
     *
     * test create array of 5 integers and send input number. 
     * 
     * test check for smallest different between input number and array value. 
     */ 
     @Test
    public void testOtherBestMatchII(){
        int inputNumber = 55551111;
        nsc.createDictionary(testArray);
        assertEquals(-55551111,nsc.getOtherBestMatch(inputNumber));
    }
    
    
     /**
     * Test that check countDifferences() method from class NumberSpellCheck.
     *
     * test create 2 inputs number and count different between two numbers. 
     * 
     * test check different between two numbers and return . 
     */
    @SuppressWarnings("static-access")
 	@Test
     public void testCountDiff(){
        int aa = 123456789;
        int bb = -543216789;
        assertEquals(5,nsc.countDifferences(aa,bb));
    }
    
    /**
     * Test that check countDifferences() method from class NumberSpellCheck.
     *
     * test create 2 inputs number and count different between two numbers. 
     * 
     * test check different between two numbers and return . 
     */
    @SuppressWarnings("static-access")
	@Test
    public void testCountDiffII(){
        int aa = -122456781;
        int bb = -543216789;
        assertEquals(6,nsc.countDifferences(aa,bb));
    }
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown(){
    	nsc = null;
    }
}
