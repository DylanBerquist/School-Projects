import java.util.Scanner;
import java.io.*; 
import java.io.FileOutputStream;

public class Part2
{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter the name of the file you'd like to load from: ");
                //scan.nextLine();
                String file = scan.nextLine();
                
                partTwo(file);
    }
    public static void partTwo(String x){
        File file = new File(x);
        try{
            Scanner sc = new Scanner(file);

            int arSize = sc.nextInt();
            int [] userAr = new int [arSize];
            
            for(int i = 0; i < arSize; i++){        //fill first array
                userAr [i] = sc.nextInt();
            }
            
            int arSize2 = sc.nextInt();
            int [] userAr2 = new int [arSize2];
            
            for(int i = 0; i < arSize2; i++){       //fill second array
                userAr2[i] = sc.nextInt();
            }
            
            int arSize3 = sc.nextInt();
            int [][] match = new int [2][arSize3];      //creates the match array to see pairs
            int ontoCounter = 0;
            
            if(arSize == arSize2){      //check to see if it isnt onto
                ontoCounter++;
            }
            
            for(int i = 0; i < arSize; i++){            //check to see if it isnt onto
                    if(userAr[i] == userAr2[i]){
                        ontoCounter++;
                    }
            }
            
            for(int i = 0; i < arSize3; i++){       //fill match array
                for(int j = 0; j < 2; j++){
                    match[j][i] = sc.nextInt();
                }
            }
            
            int one2oneCounter = 0;
            
            for(int i = 0; i < arSize3; i++){       //Check to see if its not 1 to 1
                for(int j = 0; j < arSize3; j++){
                    if(match[1][i]==match[1][j]){
                            one2oneCounter++;
                        }
                }
            }
            
            if(ontoCounter > 0){            //print results
                System.out.println("Not onto");
            }else{
                System.out.println("Onto!");
            }
            if(one2oneCounter > 0){
                System.out.println("Not One to One");
            }else{
                System.out.println("One to One!");
            }
            if(ontoCounter == 0 && one2oneCounter == 0){
                System.out.println("Bijection!");
            }else{
                System.out.println("Not a bijection");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
