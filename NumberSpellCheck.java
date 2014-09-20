package numberSpellCheck;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
/**
 * Class Numeric Spell Checker create array of random 100 integers.  
 * When the user enter integer it check for the nearest integer above and below entered integer, 
 * if there are another nearest integers within different number then it print out 3 integers. 
 * If the integer exact match with input number it inform user of the exact match.
 * 
 * @author David Sajdl
 * username dsajdl01
 * @version 02/09/2014
 */
public class NumberSpellCheck
{
    // instance variables
    private int [] dictionary;

    /**
     * Constructor 
     * 
     * @param size it defined length of the array
     */
    public NumberSpellCheck(int size)
    {
        this.dictionary = new int[size];
    }

    /**
     * creates array 
     * 
     * @param  size integer that defined length of the array
     * @return     randomArray is a new array that was created
     */
    public static int[] generateRandomArray(int size)
    {
        int[] randomArray = new int[size];
        return randomArray;
    }
    
     /**
     * copies array values into array instance variable
     * 
     * @param  number array that holds random of the integers
     * 
     */
    public void createDictionary(int[] numbers){
        dictionary = Arrays.copyOf(numbers, numbers.length);
    }
    
    /**
     * creates a new array with 100 random integers 
     * then method call createDidtionary() method
     * 
     * @param  size integer that defined length of the array 
     * 
     */
    public void createRandomDictionary(int size){
        Random randomno = new Random();
        int[] myRanArray = generateRandomArray(size);
        for(int i = 0; i < myRanArray.length;i++){
            myRanArray[i] = randomno.nextInt();
        }
        createDictionary(myRanArray);
    }
    
    /**
     * checks array if any value in the array is equal to input number 
     * 
     * @param  intutNumber integer of user inputs 
     * @return  true / false if input number match returns true otherwise false
     */
     public boolean exactMatch(int inputNumber){
        
        for(int i = 0; i< dictionary.length; i++){
            if(dictionary[i] == inputNumber)
                return true;
        }
        return false;
    }
    
    /**
     * searches for the nearest integers in the array
     * 
     * @param  intutNumber integer of user input 
     * @return bestMatchArr array that holds nearest integers of the input number 
     */
    public int[] findBestMatches(int inputNumber){
       
        int[] newCopyArr = dictionary;
        Arrays.sort(newCopyArr);
        int [] bestMatchArr = new int[3];
        int bestNum1 = 0;
        int bestNum2 = newCopyArr[newCopyArr.length - 1]; 
        for(int range: newCopyArr)                                                                                                                                                                                                      
            if(range < inputNumber){
                bestNum1 = range;
            }
            else if(range > inputNumber){
                int max = range;
                bestNum2 = Math.min(bestNum2,max);
            }
        if(bestNum1 ==0){
            bestMatchArr[0] = newCopyArr[0];
        }
        else
        {
            bestMatchArr[0] = bestNum1;
        }
        bestMatchArr[1] = bestNum2;
           bestMatchArr[2] = getOtherBestMatch(inputNumber);
           bestMatchArr = assignDuplicateValueToZero(bestMatchArr);
        return bestMatchArr;   
    }
    
     /**
     *  checks if the array do not hold same value
     *  if yes values are assigned to zero
     * 
     * @param  bestMatchArr array the holds 3 nearest integers of  the input number
     * @return bestMatchArr array with 3 values that not contain same value except zero 
     */
    public static int[] assignDuplicateValueToZero(int[] bestMatchArr){
        if(bestMatchArr[0] == bestMatchArr[1] || bestMatchArr[0] ==bestMatchArr[2]){
            bestMatchArr[0] = 0;
        }
        if(bestMatchArr[1] == bestMatchArr[2]){
            bestMatchArr[1] = 0;
        }
        return bestMatchArr;
    }
    
    /**
     * checks input number for the smaller difference between the array value.
     * 
     * @param  num integer that is input number from the user
     * @return lowestDiff with lowest different
     */
    public int getOtherBestMatch(int num){
        //int [] numOfDigits = new int[numericSpellChecker.length];
        int result = 99;
        int lowestDiff = 0;
        for(int j = 0; j < dictionary.length; j++)
        {
            int numOfDigits = countDifferences(dictionary[j],num);
            if(numOfDigits < result){
                result = numOfDigits;
                lowestDiff = dictionary[j];
            }
        }
        return lowestDiff;
    }
    
    /**
     * counts difference two between two value.
     * 
     * @param  a and b are integers that will be compared 
     * @return sum integer total different between a and b parameters value  
     */
    public static int countDifferences(int a, int b){
        int length = 0;
        int sum = 0;
        if(a < 0){
                a *= -1;
                sum++;
            }
            
        if(b<0){
                b *= -1;
                sum++;
            }
            
        if(String.valueOf(a).length()> String.valueOf(b).length()){
            length = a;
        }
        else{
            length = b;
        }
        
        if(sum == 2){
            sum = 0;
        }
        while(length > 0){
            if((a % 10) !=(b % 10)){
                sum++;
            }
            a /= 10;
            b /=10;
            length /=10; 
        }
       return sum;
    }
    
   
   /**
       * 
       * creates a new object spellCheckOfThisNum 
       * then it calls method getnumber() that return integer from the user input
       * Then integer is send to NumberSpellCheck cless's methods and print out results.
       * 
       * 
       */ 
    //@SuppressWarnings({ "unused", "static-access" })
	@SuppressWarnings("static-access")
	public static void main(String[]args){
        
        final int length = 100;
        NumberSpellCheck spellCheckOfThisNum = new NumberSpellCheck(length);
        spellCheckOfThisNum.createRandomDictionary(length);
        int itIsZero = -1;
            while(itIsZero != 0){
                int input = getNumber(); //call method get number
                itIsZero = input;
                if(itIsZero == 0){
                    System.out.println("programs ENDs");
                    itIsZero = 0;
                    break;
                }
                else{
                    System.out.println("Your input integer is: " + input); // add number into object with method called adddecimalNum
                    if(spellCheckOfThisNum.exactMatch(input)){
                        System.out.println("\nYour input number " + input + " match with our library dictionary");
                    }
                    else{
                        int[] bestMatch = spellCheckOfThisNum.findBestMatches(input);
                        for(int e: bestMatch){
							int different = spellCheckOfThisNum.countDifferences(e,input);
                            if(e != 0){
                                System.out.println("The nearest integer is " + e + " with " + different +" different");
                            }
                        }
                    }
                }
            }
    }
    /**
     * allows user to enter value and check if the value is an integer.
     *  if the value is not an integer it informs user of incorrect input and allow user to enter another value 
     * 
     * @return result integer that user entered
     */
    @SuppressWarnings("resource")
	public static int getNumber(){
       
        System.out.println("Enter any integer or zero to escape.");
        Scanner in = new Scanner(System.in); // called Scanner
          while(true){
            if(in.hasNextInt()){
                int result = in.nextInt();
                return result;
            }
            else{
                System.out.print("\""+ in.nextLine() + "\" is not an integer. try again: ");
            }
        }
    }
}