import java.util.Scanner; 
public class Main {
		public static void main(String [] args) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Welcome to the Binary Conversion App, What would you like to do?");
			
			while(true) {
				System.out.println("1. Convert Decimal to Binary");
				System.out.println("2. Convert Binary to Decimal");
				System.out.println("3. Exit Program");
				int menuInput = scan.nextInt();
				scan.nextLine();
				
				if(menuInput == 1) {
					System.out.println("Please enter the number you want to convert to Binary: (-128-127)");
					while(true) {
					        int number = scan.nextInt();
						if(number < -128 || number > 127) {
							System.out.println("Please enter a valid number");
						}
						else {
							decToBin(number);
							break;
						}
					}
				}
				else if(menuInput == 2) {
					System.out.println("Please enter the binary code you want to convert to Decimal: (must be 8-digits)");
					String binary = scan.nextLine();
					if(binary.length() == 8){
					    binToDec(binary);
					}else{
					       System.out.println("That's not a valid 8-bit binary number!!");
					}
				}
				else if(menuInput == 3) {
					scan.close();
					Exit();
				}
				else {
					System.out.println("please input a valid number");
				}
			}
		}
		public static void Exit() {
			System.out.println("Thank you for using the Binary Conversion App, Goodbye!");
			System.exit(0);
		}
		public static void binToDec(String input) {
			int power = 0;
			int dec = 0;
			int[] ar = new int[8];
			boolean isNeg = false;

			for(int a = 0; a<8; a++){
			    if(input.charAt(a) == '0' || input.charAt(a) == '1'){        //checks to see if input is valid
			        ar[a] = input.charAt(a);            				 //adds digit into the array
			     }
			    else{
			        System.out.println("That isn't binary code!");       //sends out if not valid
			        return;
			     }
			 }
	
			 int inputt = Integer.parseInt(input);				
			 if(ar[0] == '1'){							//checks if the code is negative
			    isNeg = true;
			    for(int a = 0; a<8; a++) {
			    	if(ar[a] == '1') ar[a] = 0;			//switches 1s and 0s
			    	else ar[a] = 1;
			    }
			    int[] one = {0, 0, 0, 0, 0, 0, 0, 1};			//arrays required for adding the binaries
			    int[] carry = {0, 0, 0, 0, 0, 0, 0, 0};
			    int[] sum = {0, 0, 0, 0, 0, 0, 0, 0};
			    for(int i=7; i>=0; i--) {
			    	int s = ar[i]+one[i]+carry[i];		//possible outcomes are 0,1,2,3
			    	switch(s)
			    	{case 0:					
			    		sum[i]=0;					//0+0 = 0
			    		if(i>0) carry[i-1]=0;
			    		break;
			    	case 1:
			    		sum[i]=1;					//0+1 = 1
			    		if(i>0) carry[i-1]=0;
			    		break;
			    	case 2:
			    		sum[i]=0;					//1+1 = 0, carry 1
			    		if(i>0) carry[i-1]=1;
			    		break;
			    	case 3:
			    		sum[i]=1;					//1+1+1 = 1, carry 1
			    		if(i>0) carry[i-1]=1;
			    		break;
			    	}
			    }
			    inputt = 0;
			    for(int i = 0; i < ar.length; i++) inputt += Math.pow(10,i) * ar[ar.length - i - 1];
			 }
			while(true){
				if(inputt == 0) {			//lets me know when the process is complete
					break;
				}
				else {
					int temp = inputt%10;
					dec += temp*Math.pow(2, power);
					inputt = inputt/10;
					power++;
				}
			}
			if(isNeg == true) {						//converts positive decimal to negative
				dec= 0 - dec - 1;
			}
		
			System.out.println("The Decimal form is:"+dec);
		}
		public static void decToBin(int input) {
			int [] binary = new int [8];
			int counter = 0;
			boolean isNeg = false;
			
			if(input < 0){                           //tells me if the input is negative
			    isNeg = true;
			    input++;
			 }
			while(input != 0) {
				if(input%2 == 1 || input%2 == -1)       //Fixes the problem where the 1s would show as -1
				    binary[counter] = 1;
				else
			            binary[counter] = input%2;
				input = input / 2;
				counter++;
			}
			
			for(int add = counter+1; add<8; add++){      //add 0s to the end of the binary if less than 8 bits
			    binary[add] = 0;
			 }
			 
			if(isNeg == true){                           //converts it to negative if it's negative
			    for(int a = 0; a < 8; a++)
			    {
			        if(binary[a] == 1)           //swapping 1s and 0s
			             binary[a] = 0;
			        else if(binary[a] == 0)
			             binary[a] = 1;
			     }
			}
			
			System.out.print("The binary form is: ");
			for(int a = 7; a >= 0; a--) {                //print out the array for binary code
				System.out.print(binary[a]);
			}
			System.out.println(" ");
		}
}

