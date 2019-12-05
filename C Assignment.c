#include <stdio.h>
double compute_pi(int n){
	double pi;					/* A variable to return the value of pi*/
	double count = -3.0;		/* A variable to represent the denominator in the equation*/
	double number = 1.0;		/* A variable to represent the parenthesis value in the equation*/
	int i;						/* Required for the For loop*/
		
	for(i=0; i<n; i++){
		number = number + (1/count);	/* Computes (1-(1/3)+(1/5)-(1/7)...)*/
		
		if(i%2 == 0.0){
			count = (count * -1) + 2;	/* Updates the demoninator based on if i is odd/even*/
		}
		else{
			count = (count + 2) * -1;
		}
	}
	
	pi = 4 * number;			/* Finishes the equation calculation*/
	return pi;					/* Returns result*/
}

double compute_sqrt(double x){
	double last = 1;				/* A variable to represent "last" in the given equation*/
	double next;					/* A variable to represent "next" in the given equation*/
	int i;							/* Required for the For loop*/
	
	for(i=0; i<10; i++){
		next = 0.5*(last+(x/last)); /* Calculates the "next" value based off the given equation*/
		last = next;				/* Sets last to next to continue calculating*/
	}
	
	return last;					/* Returns final value*/
}

int is_prime(int n){
	int i;					/* Required for For loop*/
	
	if(n<=2){				/* Checks to see if n is less than or equal to 2, if so, return 1*/
		return 1;
	}
	for(i=2; i<n; i++){
		if(n%i == 0){		/* Increments by 1, checks to see if n is divisible by i*/
			return 0;		/* if n is ever divisible by i, n is not prime*/
		}
	}
	
	return 1;				/* If it makes it all the qay through the loop, its prime*/
}

void display_primes(int n){
	int i;					/* Required for For loop*/
	
	for(i=2; i<=n; i++){				/* Checks all numbers below and up to n*/
		int calculate = is_prime(i);	/* Checks to see if i is a prime number*/
		if(calculate == 1){
			printf("%d is a prime number \n", i);		/* If i is prime, display it*/
		}
	}
}

void process_scores(){
	typedef struct{			/* A structure to make student objects*/
		int score;			
		char name[20];
	}student; 
	
	int counter = 0;		/* A variable to count the amount of students that get entered*/
	double avg;				/* A variable to hold the average of all the scores*/
	int max;				/* A variable to hold the maximum score*/
	int min;				/* A variable to hold the minimum score*/
	int sum = 0;			/* A variable to hold the sum of all the entered scores*/
	char maxName[20];		/* A string variable to hold the name of the highest scoring student*/
	char minName[20];		/* A string variable to hold the name of the lowest scoring student*/
	student s[20];			/* Groups all the students together so they can be created and accessed easily*/
	
	
	while(counter>=0){
		printf("Please enter the name and score of Student #%d: \n", (counter+1));
		char sName[20];
		scanf("%s", sName);				/* Assigns user's input to the name variable*/
		
		if(sName[0] == 'q'){
			break;						/* If the user inputs 'q', stop the loop*/
		}
		
		int sScore;						/* Assigns user's input to the score variable*/
		scanf("%d", &sScore);
		
		if(sName[0] != 'q'){
			int i;
			for(i=0; i<20; i++){					/* Assigns the object's name to the user input's name*/
				s[counter].name[i] = sName[i];
			}
			s[counter].score = sScore;				/* Assigns the object's score to the user input's score*/
		
			counter = counter + 1;				/* Increment the counter the account for the new student*/
		}
	}
	
	max = s[0].score;					/* Sets the default min & max to the first student*/
	min = s[0].score;
	int a;								/* Variable required for the For loop*/
	for(a=0; a<20; a++){
		maxName[a] = s[0].name[a];		/* Sets the default min & max names to the first student*/
		minName[a] = s[0].name[a];
	}
	
	int j;
	for(j=0; j<counter; j++){
		sum = sum + s[j].score;			/* Adds the value to sum*/
		if(max < s[j].score){			/* if the current student has a higher score than the current max, update the max*/
			max = s[j].score;
			int n;
			for(n=0; n<20; n++){
				maxName[n] = s[j].name[n];		/* Update the max name*/
			}
		}
		if(min > s[j].score){			/* if the current student has a lower score than the current min, update the min*/
			min = s[j].score;
			int n;
			for(n=0; n<20; n++){
				minName[n] = s[j].name[n];		/* Update the min name*/
			}
		}
	}
	avg = (sum/(counter+0.0));			/* Calculate the average based off the sum and counter*/
	
	printf("The average of all scores: %lf \nThe lowest scorer: %s (%d) \nThe highest scorer: %s (%d) \n", avg, minName, min, maxName, max);
	/* Print the results*/
	
	
}

double compute_tax(int income, char *status, char state){
	double taxRate;				/* Holds the tax percentage based off input*/
	if(status[0] == 's'){		/* Checks if single*/
		if(income <30000){		/* Checks in income is lower than 30,0000*/
			taxRate = 0.20;		/* Set tax rate*/
		}else{
			taxRate = 0.25; 	/* Set tax rate if income is higher than 30,000*/
		}
	}else if(status[0] == 'm'){ /* Checks if married*/
		if(income <50000){		/* Checks if income is lower than 50,000*/
			taxRate = 0.10;		/* Set tax rate*/
		}else{
			taxRate = 0.15;		/* Set tax rate if income is more than 50,000*/
		}
	}else{
		return -1;				/* if input isnt s or m, return -1*/
	}
	if(state == 'o'){			/* Adjust rate if out of state*/
		taxRate = taxRate - 0.03;
	}else if(state != 'o' && state != 'i'){
		return -1;				/* Return -1 if state isnt o or i*/
	}
	
	double taxesPaid = (income*taxRate);	/* Calculate the taxes you pay based off income and tax rate*/
	return taxesPaid;						/* Return calculated value*/
}

int quadratic(double a, double b, double c, double *solution1, double *solution2){
	int value1;
	value1 = (b*b)-(4*a*c);			/* Calculate first part of the equation*/
	
	if(value1 < 0){					/* Check if no solution*/
		solution1 = 0;
		solution2 = 0;
		return 0;
	}
	
	double value2;					/* Find first solution using the formula*/
	value2 = ((-1*b) + (compute_sqrt(value1)))/(2*a);
	
	double value3;					/* Find the second solution using the formula*/
	value3 = ((-1*b) - (compute_sqrt(value1)))/(2*a);
	
	*solution1 = value2;			/* Pass the solutions that were found*/
	*solution2 = value3;

	return 1;						/* Show that there is a solution*/
}

int factorial(int n){
	if(n >= 1){						/* Check to see if n is greater than or equal to 1*/
		return (n*factorial(n-1));	/* Keep going through the same function going down by 1 each time*/
	}else{
		return 1;					/* Stop at 1*/
	}
}

void file_count(char *file, int *characters, int *lines){
	FILE *fileRead;						/* Sets up the file to be read*/
	fileRead = fopen(file, "r");
	int lineCount;						/* A variable to count each line*/
	int charCount;						/* A variable to count each char*/
	
	if(fileRead == NULL){				/* Checks to see if the file exists*/
		printf("Could not find file named: %s", file);
	}
	
	char c;								/* Loops through the file based on if the next char is EOF*/
	for (c=getc(fileRead); c!=EOF; c=getc(fileRead)){
		charCount = charCount + 1;		/* Increment at each step*/
        if (c == '\n'){
            lineCount = lineCount + 1;	/* Increment at each line*/
		}
	}
	
	*characters = charCount;			/* Update the output values*/
	*lines = lineCount;
	fclose(fileRead);					/* Close the file*/
}

void file_sort(char *infile, char *outfile){
	FILE *fileRead;			/* Open the file based on user input*/ 
	fileRead = fopen(infile, "r");
	
	typedef struct{			/* A structure to make student objects*/
		int id;			
		char grade;
		double gpa;
	}student;
	
	if(fileRead == NULL){				/* Checks to see if the file exists*/
		printf("Could not find file named: %s", infile);
		return;
	}
	
	int numStudents;					/* Grabs the number of students at the top of the file*/
	fscanf(fileRead, "%d", &numStudents);
	student s[numStudents];
	
	int i;								
	for(i=0; i<numStudents; i++){		/* fills in the first array based on the amount of students*/
		fscanf(fileRead, "%d", &s[i].id);
		fscanf(fileRead, "%c", &s[i].grade);
		fscanf(fileRead, "%c", &s[i].grade);
		fscanf(fileRead, "%lf", &s[i].gpa);
	}	
	fclose (fileRead);					/* Close the input file*/
	
	student sPar[numStudents];			/* Parallel array to help sort the student objects*/
	int maxId = s[0].id;				/* Variables to track the max student*/
	int maxGrade = s[0].grade;
	int maxGpa = s[0].gpa;
	
	int j;
	for(i=0; i<numStudents; i++){		/* This for loops goes through the parallel array to fill it*/
		for(j=0; j<numStudents; j++){	/* This for loop goes through the original array and finds the max for each element of the parAr*/
			if(s[j].id > maxId){		/* Checks for max ID*/
				maxId = s[j].id;		/* Set max student*/
				maxGrade = s[j].grade;
				maxGpa = s[j].gpa;
				s[j].id = 0;			/* Change that student's ID to 0 so it doesnt get picked up again*/
			}
		}
		sPar[i].id = maxId;				/* Fill the parallel array*/
		sPar[i].grade = maxGrade;
		sPar[i].gpa = maxGpa;
		maxId = 0;						/* reset maxID*/
	}
		
	FILE *fileWrite;					/* Create the file to be written on*/
	fileWrite = fopen(outfile, "w");
	
	if(fileWrite == NULL){				/* Checks to see if the file exists*/
		printf("Could not find file named: %s", outfile);
		return;
	}
	
	fprintf(fileWrite, "%d\n", numStudents);
	for(i=0; i<numStudents; i++){		/* Writes out each student, since theyre already organized*/
		fprintf(fileWrite, "%d %c %lf", sPar[i].id, sPar[i].grade, sPar[i].gpa);
	}
	
}

int main(){
	while(1){
		int input;		/* Pick up int values from the user 1-11, then go to the designated part of the loop*/
		printf("\nPlease select the function you'd like to use: \n 1 - computing pi \n 2 - computing square root \n 3 - displaying primes \n 4 - processing grades \n 5 - computing tax \n 6 - solving quadratic \n 7 - computing factorial \n 8 - couting file \n 9 - sorting file \n 10 - student file \n 11 - Quit \n");
		scanf("%d", &input);
	
		if(input == 1){
			double value;		/* Get values needed for the Function*/
			printf("please enter the double value you'd like to compute for pi: \n");
			scanf("%lf", &value);
		
			printf("%f", compute_pi(value));		/* Call the Function*/
		}else if(input == 2){
			double value;		/* Get values needed for the Function*/
			printf("Please enter the number you'd like to find the square root of: \n");
			scanf("%lf", &value);
		
			printf("%f", compute_sqrt(value));		/* Call the Function*/
		}else if(input == 3){
			int value;			/* Get values needed for the Function*/
			printf("Please enter the int value you'd like to see all the prime numbers for: \n");
			scanf("%d", &value);
		
			display_primes(value);
		}else if(input == 4){
			process_scores(); 		/* Call the Function*/
		}else if(input == 5){
			int income;			/* Get values needed for the Function*/
			printf("Please enter your income amount: \n");
			scanf("%d", &income);
		
			char status[20];		/* Get values needed for the Function*/
			printf("Please enter your relationship status: \n");
			scanf("%s", status);
		
			char state;		/* Get values needed for the Function, this needed 2 scans for the char b/c it picks up the space*/
			printf("Please enter whether you are in-state or out-of-state: \n");
			scanf("%c", &state);
			scanf("%c", &state);
		
			double result = compute_tax(income, status, state);		/* Call the Function*/
			printf("your tax results: %lf", result);		/* print the results */
		}else if(input == 6){			/* Instructions were very unclear about what the output looks like for this.*/ 
			int a; 				/* Get values needed for the Function*/
			printf("Please enter the first coefficient: \n");
			scanf("%d", &a);
		
			int b;				/* Get values needed for the Function*/
			printf("Please enter the second coefficient: \n");
			scanf("%d", &b);
		
			int c;				/* Get values needed for the Function*/
			printf("Please enter the third coefficient \n");
			scanf("%d", &c);
		
			double *solution1;		/* create space for the two solutions */
			double *solution2;
			int results = quadratic(a, b, c, solution1, solution2); /* Call the Function*/
			
			if(results == 1){		/* Only show the solution data if there actually is a solution*/
				printf("The first solution is: %lf \nThe second solution is: %lf", *solution1, *solution2);
			}else{
				printf("No solution..");
			}
		}else if(input == 7){
				int n;				/* Get values needed for the Function*/
				printf("Please enter the number you'd like to find the factorial of: \n");
				scanf("%d", &n);
			
				printf("the factorial of %d is: %d", n, factorial(n));		/* Call the Function*/
		}else if(input == 8){
			char file[20];			/* Get values needed for the Function*/
			printf("Please enter the name of the file you'd like to count: \n");
			scanf("%s", file);
		
			int *characters = 0;	/*create space for the result of the function*/
			int *lines = 0;
		
			file_count(file, characters, lines);			/* Call the Function*/
			printf("There are %d lines, and %d characters.", *lines, *characters);
		}else if(input == 9){
			char inFile[20];		/* Get values needed for the Function*/
			printf("Please enter the name of the file you'd like to read from: \n");
			scanf("%s", inFile);
			
			char outFile[20];		/* Get values needed for the Function*/
			printf("Please enter the name of the file you'd like to have the sorted data go to: \n");
			scanf("%s", outFile);
			
			file_sort(inFile, outFile);					/* Call the Function*/
		}else if(input == 11){
			return 0;
		}else{
			return 0;
		}
	
	}
}
