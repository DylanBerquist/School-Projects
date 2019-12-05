import java.util.Scanner;
import java.io.*; 
import java.io.FileOutputStream;

public class Part4
{
    public static void main(String[] args){
        partFour();
    }
    public static void partFour(){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the int values youd like to calculate the primes for: ");
            int value1 = sc.nextInt();
            int value2 = sc.nextInt();
            
            for(int val = value1; val <= value2; val=val+2){        // increment by 2
                for(int i = 0; i < val; i++){       //check all values that add up to the value
                    int j = (val - i);
                    if(isPrime(i) == true && isPrime(j) == true){       //use the prime function to make my life easier
                        System.out.println(i+" + "+j+" = "+val);        //print out the primes, but only one pair for each number
                        break;
                    }   
                }   
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static boolean isPrime(int x){
        if(x == 0 || x == 1){       //function to calculate if a number is prime
            return false;
        }
        for(int i = 2; i < x; i++){
            if(x%i == 0){
                return false;
            }
        }
        return true;
    }
}
