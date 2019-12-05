import java.util.Scanner;
import java.io.*; 
import java.io.FileOutputStream;

public class Part1
{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter the name of the file you'd like to load from: ");
                //scan.nextLine();
                String file = scan.nextLine();
                
                partOne(file);
    }
     public static void partOne(String x){
        File file = new File(x);
        try{
            Scanner sc = new Scanner(file);
            
            int arSize = sc.nextInt();
            int [] userAr = new int [arSize];
            
            for(int i = 0; i < arSize; i++){        //fills first array
                userAr [i] = sc.nextInt();
            }
            
            int arSize2 = sc.nextInt();
            int [] userAr2 = new int [arSize2];
            
            for(int i = 0; i < arSize2; i++){       //fills second array
                userAr2[i] = sc.nextInt();
            }
            
            int unionSize = arSize + arSize2;       //variable declaration
            int intersectionSize = arSize;
            int [] union = new int [unionSize];
            int [] intersection = new int [intersectionSize];
            int counter = 0;
            int counter2 = 0;
            int counter3 = 0;
            
            for(int i = 0; i < arSize2; i++){       //starts off the union array with ar2
                union [i] = userAr2[i];
            }
            
            for(int i = 0; i < arSize; i++){        //compute the union arrray
                counter = 0;
                for(int j = 0; j < arSize2; j++){
                    if(userAr[i] != userAr2[j]){
                        counter ++;
                    }
                }
                if(counter == arSize2){     //adds values to the array
                    counter2++;
                    union [arSize + counter2] = userAr [i]; 
                }
            }
            
            for(int i = 0; i < arSize; i++){
                for(int j = 0; j < arSize2; j++){
                    if(userAr[i] == userAr2[j]){        //computes intersection array
                        intersection[counter3] = userAr [i];
                        counter3++;
                    }
                }
            }
            
            //FileOutputStream filewriter = new FileOutputStream("newFile.txt");
            //PrintWriter writer = new PrintWriter(filewriter);
            
            System.out.println(counter2+arSize2);       //tried to use file output but it didn't work for some reason
            //writer.write(unionSize);
            for(int i = 0; i < (counter2+arSize2); i++){
                System.out.print(union[i]+" ");
                //filewriter.write(union[i]+" ");
            }
            System.out.println("");
            //filewriter.write("");
            System.out.println(counter3);
            //writer.write(intersectionSize);
            for(int i = 0; i < counter3; i++){
                System.out.print(intersection[i]+" ");
                //filewriter.write(intersection[i]+" ");
            }
            System.out.println("");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
