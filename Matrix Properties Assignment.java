import java.util.Scanner;
import java.io.*; 
import java.io.FileOutputStream;
public class Part_One
{
    public static void main(String[] args)
    {
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
            System.out.println("");
            
            int arSize = sc.nextInt();
            int [][] userAr = new int [arSize][arSize];
            
            for(int i = 0; i < arSize; i++){
                for(int j = 0; j < arSize; j++){
                    userAr[i][j] = sc.nextInt();
                }
            }
            
            //REFLEXIVE CALCULATION
            boolean reflexive;
            int count = 0;
            for(int i = 0; i < arSize; i++){
                if(userAr[i][i] == 1){
                    count++;
                }
            }
            if(count == arSize){
                System.out.println("reflexive - yes");
                reflexive = true;
            }else{
                System.out.println("reflexive - no");
                reflexive = false;
            }
            
            //SYMMETRIC CALCULATION
            boolean symmetric;
            count = 0;
            for(int i = 0; i < arSize; i++){
                for(int j = 0; j < arSize; j++){
                    if(userAr[i][j] == userAr[j][i]){
                        count++;
                    }
                }
            }
            if(count == (arSize*arSize)){
                System.out.println("symmetric - yes");
                symmetric = true;
            }else{
                System.out.println("symmetric - no");
                symmetric = false;
            }
            
            //ANTI SYMMETRIC CALCULATION
            boolean antisymmetric;
            count = 0;
            for(int i = 0; i < arSize; i++){
                for(int j = 0; j < arSize; j++){
                    if(userAr[i][j] == 1 && userAr[j][i] == 1){
                        count++;
                    }
                }
            }
            if(count <= arSize){
                System.out.println("anti symmetric - yes");
                antisymmetric = true;
            }else{
                System.out.println("anti symmetric - no");
                antisymmetric = false;
            }
            
            //TRANSITIVE CALCULATION
            boolean transitive = true;
            for(int a = 0; a < arSize; a++){
                for(int b = 0; b < arSize; b++){
                    for(int c = 0; c < arSize; c++){
                        if(userAr[a][b] == 1 && userAr[b][c] == 1 && userAr[a][c] != 1){
                            transitive = false;
                        }
                    }
                }
            }
            if(transitive){
                System.out.println("transitive - yes");
            }else{
                System.out.println("transitive - no");
            }
            
            //EQUIVALENCE CALCULATION
            if(reflexive && symmetric && transitive){
                System.out.println("equivalence - yes");
            }else{
                System.out.println("equivalence - no");
            }
            
            //PARTIAL ORDER CALCULATION
            if(reflexive && antisymmetric && transitive){
                System.out.println("partial order - yes");
            }else{
                System.out.println("partial order - no");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

