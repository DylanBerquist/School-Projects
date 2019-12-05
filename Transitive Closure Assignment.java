import java.util.Scanner;
import java.io.*; 
import java.io.FileOutputStream;
import java.util.Random;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;
public class Part_Two
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter the name of the file you'd like to load from: ");

        String file = scan.nextLine();
                
        partTwo(file);
    }
    public static void partTwo(String x){
        File file = new File(x);
        Random rand = new Random();
        try{
            Scanner sc = new Scanner(file);
            
            //DECLARATION
            int arSize = sc.nextInt();
            int [][] userAr = new int [arSize][arSize];
            int [][] parAr = new int [arSize][arSize];
            
            //FILL ARRAY
            for(int i = 0; i < arSize; i++){
                for(int j = 0; j < arSize; j++){
                    userAr[i][j] = sc.nextInt();
                    parAr[i][j] = userAr[i][j];
                }
            }
            
            userAr = WARSHALS(userAr, arSize);
            
            //PRINT RESULT ARRAY
            System.out.println("");
            System.out.println("transitive closure: ");
            for(int i = 0; i < arSize; i++){
                for(int j = 0; j < arSize; j++){
                    System.out.print(userAr[i][j]+" ");
                }
                System.out.println("");
            }
            
            //DECLARE RANDOM ARRAYS
            int [][] rand1 = new int [100][100];
            int [][] rand2 = new int [200][200];
            int [][] rand3 = new int [300][300];
            int [][] rand4 = new int [500][500];
            int [][] rand5 = new int [1000][1000];
            
            //FILL RANDOM ARRAYS
            for(int i = 0; i < 100; i++){
                for(int j = 0; j < 100; j++){
                    rand1[i][j] = rand.nextInt(2);
                }
            }
            for(int i = 0; i < 200; i++){
                for(int j = 0; j < 200; j++){
                    rand2[i][j] = rand.nextInt(2);
                }
            }
            for(int i = 0; i < 300; i++){
                for(int j = 0; j < 300; j++){
                    rand3[i][j] = rand.nextInt(2);
                }
            }
            for(int i = 0; i < 500; i++){
                for(int j = 0; j < 500; j++){
                    rand4[i][j] = rand.nextInt(2);
                }
            }
            for(int i = 0; i < 1000; i++){
                for(int j = 0; j < 1000; j++){
                    rand5[i][j] = rand.nextInt(2);
                }
            }
            
            //TIMING FUNCTION CALLS
            System.out.println("");
            long startTime = System.nanoTime();
            rand1 = WARSHALS(rand1, 100);
            long endTime = System.nanoTime();
            System.out.println("Runtime for randomized array with size 100: "+((endTime - startTime)/1000000)+" milliseconds");
            
            startTime = System.nanoTime();
            rand2 = WARSHALS(rand2, 200);
            endTime = System.nanoTime();
            System.out.println("Runtime for randomized array with size 200: "+((endTime - startTime)/1000000)+" milliseconds");
            
            startTime = System.nanoTime();
            rand3 = WARSHALS(rand3, 300);
            endTime = System.nanoTime();
            System.out.println("Runtime for randomized array with size 300: "+((endTime - startTime)/1000000)+" milliseconds");
            
            startTime = System.nanoTime();
            rand4 = WARSHALS(rand4, 500);
            endTime = System.nanoTime();
            System.out.println("Runtime for randomized array with size 500: "+((endTime - startTime)/1000000)+" milliseconds");
            
            startTime = System.nanoTime();
            rand5 = WARSHALS(rand5, 1000);
            endTime = System.nanoTime();
            System.out.println("Runtime for randomized array with size 1000: "+((endTime - startTime)/1000000)+" milliseconds");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static int[][] WARSHALS(int[][] userAr, int arSize){
            //CREATE PAR ARRAY
            int[][] parAr = new int [arSize][arSize];
            for(int i = 0; i < arSize; i++){
                for(int j = 0; j < arSize; j++){
                    parAr[i][j] = userAr[i][j];
                }
            }
            
            //WARSHALS ALGORITHM
            for(int a = 0; a < arSize; a++){
                for(int i = 0; i < arSize; i++){
                    for(int j = 0; j < arSize; j++){
                        parAr[i][j] = OR(userAr[i][j], (AND(userAr[i][a], userAr[a][j])));
                    }
                }
                for(int i = 0; i < arSize; i++){
                    for(int j = 0; j < arSize; j++){
                        userAr[i][j] = parAr[i][j];
                    }
                }
            }
            return userAr;
    }
    public static int AND(int a, int b){
        if(a == 0 && b == 0){
            return 0;
        }else if(a == 0 && b == 1){
            return 0;
        }else if(a == 1 && b == 0){
            return 0;
        }else if(a == 1 && b == 1){
            return 1;
        }else{
            return 7;
        }
    }
    public static int OR(int a, int b){
        if(a == 0 && b == 0){
            return 0;
        }else if(a == 0 && b == 1){
            return 1;
        }else if(a == 1 && b == 0){
            return 1;
        }else if(a == 1 && b == 1){
            return 1;
        }else{
            return 7;
        }
    }
}
