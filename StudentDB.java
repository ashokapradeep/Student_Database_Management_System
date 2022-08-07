import java.util.*;
class StudentDB{
	
	public static String[] stIdArray=new String[0];
	public static String[] stNameArray=new String[0];
	public static int[] dbmsMarksArray=new int[0];
	public static int[] prfMarksArray=new int[0];
	
	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
			} catch (final Exception e) {
				e.printStackTrace();
			// Handle any exceptions.
		}
	}
	
	
	public static void addNewStudent(){
		clearConsole();
		Scanner input=new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------------\n|\t\t\t\t ADD NEW STUDENT \t\t\t\t\t|\n-----------------------------------------------------------------------------------------");
		
		String stId;
		String stName;
		char res ='y';
		while(res=='y'){			
			System.out.print("\nEnter Student Id : ");
			stId=input.nextLine();			
			//----------------------------------------------------------check duplicability--------------------------------
			int check =0;			
			for(int i=0; i<stIdArray.length; i++){
				if (stIdArray[i].equals(stId)){
					System.out.println("The student Id Already exists. Please enter a new id.");
					check =1;
					break;
					}
				}
			if (check==1){
				continue;
				}
			//----------------------------------------------------------check duplicability--------------------------------		
				
			System.out.print("Enter Student Name : ");
			stName=input.nextLine();
			
			String[] tempIdAr= new String[stIdArray.length+1];
			String[] tempNameAr= new String[stNameArray.length+1];
			int[] tempDbmsAr= new int[dbmsMarksArray.length+1];
			int[] tempPrfAr= new int[prfMarksArray.length+1];
			for(int i=0; i<stIdArray.length; i++){
				tempIdAr[i]=stIdArray[i];
				tempNameAr[i]=stNameArray[i];				
				tempDbmsAr[i]=dbmsMarksArray[i];				
				tempPrfAr[i]=prfMarksArray[i];					
				}
			tempIdAr[tempIdAr.length-1]=stId;
			tempNameAr[tempNameAr.length-1]=stName;			
			stIdArray=tempIdAr;
			stNameArray=tempNameAr;
			dbmsMarksArray=tempDbmsAr;
			prfMarksArray=tempPrfAr;
			
			System.out.print("\nStudent has been added succefully. Do you want to add another student (y/n) ? : ");
			res=input.next().charAt(0);
			input.nextLine();
						
			}		
		}
	
		
	public static void addNewStudentWithMarks(){
		clearConsole();
		Scanner input=new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------------\n|\t\t\t\t ADD NEW STUDENT WITH MARKS \t\t\t\t|\n-----------------------------------------------------------------------------------------");
		
		String stId;
		String stName;
		int dbmsMarks;
		int prfMarks;
		char res ='y';
		while(res=='y'){			
			System.out.print("\nEnter Student Id : ");
			stId=input.nextLine();			
			//----------------------------------------------------------check duplicability--------------------------------
			int check =0;			
			for(int i=0; i<stIdArray.length; i++){
				if (stIdArray[i].equals(stId)){
					System.out.println("The student Id Already exists. Please enter a new id.");
					check =1;
					break;
					}
				}
			if (check==1){
				continue;
				}
			//----------------------------------------------------------check duplicability--------------------------------		
				
			System.out.print("Enter Student Name : ");
			stName=input.nextLine();
			System.out.print("Enter Student DBMS Marks : ");
			dbmsMarks=input.nextInt();
			//----------------------------------------------------------check marks within range--------------------------------	
			if(dbmsMarks<0 | dbmsMarks>101){
				do{
					System.out.println("Invalid input. Enter a value within 0 to 100");
					System.out.print("Enter Student DBMS Marks : ");
					dbmsMarks=input.nextInt();
					}while(dbmsMarks<0 | dbmsMarks>100);
				}
			
			System.out.print("Enter Student Pro Fund.. Marks : ");
			prfMarks=input.nextInt();
			
			//----------------------------------------------------------check marks within range--------------------------------	
			if(prfMarks<0 | prfMarks>101){
				do{
					System.out.println("Invalid input. Enter a value within 0 to 100");
					System.out.print("Enter Student Pro Fund.. Marks : ");
					prfMarks=input.nextInt();
					}while(prfMarks<0 | prfMarks>100);
				}
			
			String[] tempIdAr= new String[stIdArray.length+1];
			String[] tempNameAr= new String[stNameArray.length+1];
			int[] tempDbmsAr= new int[dbmsMarksArray.length+1];
			int[] tempPrfAr= new int[prfMarksArray.length+1];
			for(int i=0; i<stIdArray.length; i++){
				tempIdAr[i]=stIdArray[i];
				tempNameAr[i]=stNameArray[i];				
				tempDbmsAr[i]=dbmsMarksArray[i];				
				tempPrfAr[i]=prfMarksArray[i];				
				}
			tempIdAr[tempIdAr.length-1]=stId;
			tempNameAr[tempNameAr.length-1]=stName;			
			tempDbmsAr[tempDbmsAr.length-1]=dbmsMarks;			
			tempPrfAr[tempPrfAr.length-1]=prfMarks;			
			stIdArray=tempIdAr;
			stNameArray=tempNameAr;
			dbmsMarksArray=tempDbmsAr;
			prfMarksArray=tempPrfAr;
			
			System.out.print("\nStudent has been added succefully. Do you want to add another student (y/n) ? : ");
			res=input.next().charAt(0);
			input.nextLine();
						
			}
		}
	
	
	public static void addMarks(){
		clearConsole();
		Scanner input=new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------------\n|\t\t\t\t\t ADD MARKS \t\t\t\t\t|\n-----------------------------------------------------------------------------------------");
		
		String stId;
		int dbmsMarks;
		int prfMarks;
		char res ='y';
		while(res=='y'){			
			System.out.print("\nEnter Student Id : ");
			stId=input.nextLine();			
			//----------------------------------------------------------check ID validity--------------------------------
			int check =0;
			int pos=0;			
			for(int i=0; i<stIdArray.length; i++){
				if (stIdArray[i].equals(stId)){
					pos=i;					
					check =1;
					break;
					}
				}
			if (check==0){
				System.out.print("Invalid student ID. Do you want to search again ? (y/n) : ");
				res=input.next().charAt(0);				
				input.nextLine();
				if(res=='y'){
					continue;
				}else{
					break;
					}
			}
			//----------------------------------------------------------print st name--------------------------------		
				
			System.out.println("Student name : "+stNameArray[pos]);
			//----------------------------------------------------------check whether marks already added or not--------------------------------	
			if(dbmsMarksArray[pos]!=0){
				System.out.println("Student Marks has been already added.\nIf you want to update marks, please use [4] Update Marks option in home page");
				System.out.print("Do you want to add marks for another student ? (y/n) : ");
				res=input.next().charAt(0);				
				input.nextLine();
				if(res=='y'){
					continue;
				}else{
					break;
					}
				}
			
			
			System.out.print("Enter Student DBMS Marks : ");
			dbmsMarks=input.nextInt();
			//----------------------------------------------------------check marks within range--------------------------------	
			if(dbmsMarks<0 | dbmsMarks>101){
				do{
					System.out.println("Invalid input. Enter a value within 0 to 100");
					System.out.print("Enter Student DBMS Marks : ");
					dbmsMarks=input.nextInt();
					}while(dbmsMarks<0 | dbmsMarks>100);
				}
			
			System.out.print("Enter Student Pro Fund.. Marks : ");
			prfMarks=input.nextInt();
			
			//----------------------------------------------------------check marks within range--------------------------------	
			if(prfMarks<0 | prfMarks>101){
				do{
					System.out.println("Invalid input. Enter a value within 0 to 100");
					System.out.print("Enter Student Pro Fund.. Marks : ");
					prfMarks=input.nextInt();
					}while(prfMarks<0 | prfMarks>100);
				}
			
			dbmsMarksArray[pos]=dbmsMarks;
			prfMarksArray[pos]=prfMarks;
			
			System.out.print("\nStudent marks has been added succefully. Do you want to add marks for another student (y/n) ? : ");
			res=input.next().charAt(0);
			input.nextLine();
						
			}	
		
		}
		
		
	public static void updateStudentDetails(){
		clearConsole();
		Scanner input=new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------------\n|\t\t\t\t UPDATE STUDENT DETAILS \t\t\t\t|\n-----------------------------------------------------------------------------------------");
		
		String stId;
		String stName;
		char res ='y';
		while(res=='y'){			
			System.out.print("\nEnter Student Id : ");
			stId=input.nextLine();			
			//----------------------------------------------------------check ID validity--------------------------------
			int check =0;
			int pos=0;			
			for(int i=0; i<stIdArray.length; i++){
				if (stIdArray[i].equals(stId)){
					pos=i;					
					check =1;
					break;
					}
				}
			if (check==0){
				System.out.print("Invalid student ID. Do you want to search again ? (y/n) : ");
				res=input.next().charAt(0);				
				input.nextLine();
				if(res=='y'){
					continue;
				}else{
					break;
					}
			}
			//----------------------------------------------------------print st name--------------------------------		
				
			System.out.println("Student Current name : "+stNameArray[pos]);
			
			System.out.print("\nEnter the new student name : ");
			stName=input.nextLine();
			stNameArray[pos]=stName;
			
			System.out.print("\nStudent details has been updated succefully. \nDo you want to update student details of another student (y/n) ? : ");
			res=input.next().charAt(0);
			input.nextLine();
						
			}	
		
		
		}
		
		
	public static void updateMarks(){
		clearConsole();
		Scanner input=new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------------\n|\t\t\t\t\t UPDATE MARKS \t\t\t\t\t|\n-----------------------------------------------------------------------------------------");
		
		String stId;
		int dbmsMarks;
		int prfMarks;
		char res ='y';
		while(res=='y'){			
			System.out.print("\nEnter Student Id : ");
			stId=input.nextLine();			
			//----------------------------------------------------------check ID validity--------------------------------
			int check =0;
			int pos=0;			
			for(int i=0; i<stIdArray.length; i++){
				if (stIdArray[i].equals(stId)){
					pos=i;					
					check =1;
					break;
					}
				}
			if (check==0){
				System.out.print("Invalid student ID. Do you want to search again ? (y/n) : ");
				res=input.next().charAt(0);				
				input.nextLine();
				if(res=='y'){
					continue;
				}else{
					break;
					}
			}
			//----------------------------------------------------------print st name--------------------------------		
				
			System.out.println("Student name : "+stNameArray[pos]);
			//----------------------------------------------------------check whether marks already added or not--------------------------------	
			if(dbmsMarksArray[pos]==0){
				System.out.print("This student's marks yet to be added.\nDo you want to update the marks of another student ? (y/n) : ");
				res=input.next().charAt(0);				
				input.nextLine();
				if(res=='y'){
					continue;
				}else{
					break;
					}
				}			
			
			System.out.println("\nDatabse Management System Marks\t : "+dbmsMarksArray[pos]);
			System.out.println("Programing Fundamentals Marks\t : "+prfMarksArray[pos]);
			
			System.out.print("\nEnter new Databse Management System marks\t\t : ");
			dbmsMarks=input.nextInt();
			//----------------------------------------------------------check marks within range--------------------------------	
			if(dbmsMarks<0 | dbmsMarks>101){
				do{
					System.out.println("Invalid input. Enter a value within 0 to 100");
					System.out.print("Enter new Databse Management System Marks :");
					dbmsMarks=input.nextInt();
					}while(dbmsMarks<0 | dbmsMarks>100);
				}
			
			System.out.print("Enter new Programing Fundamentals marks : ");
			prfMarks=input.nextInt();
			
			//----------------------------------------------------------check marks within range--------------------------------	
			if(prfMarks<0 | prfMarks>101){
				do{
					System.out.println("Invalid input. Enter a value within 0 to 100");
					System.out.print("Enter new Programing Fundamentals marks : ");
					prfMarks=input.nextInt();
					}while(prfMarks<0 | prfMarks>100);
				}
			
			dbmsMarksArray[pos]=dbmsMarks;
			prfMarksArray[pos]=prfMarks;
			
			System.out.print("\nStudent marks has been updeted succefully.\n Do you want update add marks of another student (y/n) ? : ");
			res=input.next().charAt(0);
			input.nextLine();
						
			}
		
		}
		
	
	public static void deleteStudent(){
		clearConsole();
		Scanner input=new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------------\n|\t\t\t DELETE STUDENT \t\t\t|\n-----------------------------------------------------------------------------------------");
		
		String stId;
		char res ='y';
		while(res=='y'){			
			System.out.print("\nEnter Student Id : ");
			stId=input.nextLine();			
			//----------------------------------------------------------check ID validity--------------------------------
			int check =0;
			int pos=0;			
			for(int i=0; i<stIdArray.length; i++){
				if (stIdArray[i].equals(stId)){
					pos=i;					
					check =1;
					break;
					}
				}
			if (check==0){
				System.out.print("Invalid student ID. Do you want to search again ? (y/n) : ");
				res=input.next().charAt(0);				
				input.nextLine();
				if(res=='y'){
					continue;
				}else{
					break;
					}
			}
			//----------------------------------------------------------updating arrays--------------------------------		
				
			
			String[] tempIdAr= new String[stIdArray.length-1];
			String[] tempNameAr= new String[stNameArray.length-1];
			int[] tempDbmsAr= new int[dbmsMarksArray.length-1];
			int[] tempPrfAr= new int[prfMarksArray.length-1];
			for(int i=0; i<pos; i++){
				tempIdAr[i]=stIdArray[i];
				tempNameAr[i]=stNameArray[i];				
				tempDbmsAr[i]=dbmsMarksArray[i];				
				tempPrfAr[i]=prfMarksArray[i];				
				}
			for(int i=pos; i<stIdArray.length-1; i++){
				tempIdAr[i]=stIdArray[pos+i];
				tempNameAr[i]=stNameArray[pos+i];				
				tempDbmsAr[i]=dbmsMarksArray[pos+i];				
				tempPrfAr[i]=prfMarksArray[pos+i];				
				}	
											
			stIdArray=tempIdAr;
			stNameArray=tempNameAr;
			dbmsMarksArray=tempDbmsAr;
			prfMarksArray=tempPrfAr;
					
			
			System.out.print("\nStudent has been deleted succefully.\n Do you want to delete another student (y/n) ? : ");
			res=input.next().charAt(0);
			input.nextLine();

						
			}
		
		}
			
		
	public static void printStudentDetails(){
		
		Scanner input=new Scanner(System.in);
				
		String stId;
		double avg;
		char res ='y';
		while(res=='y'){
			clearConsole();	
			System.out.println("-----------------------------------------------------------------------------------------\n|\t\t\t\t\t PRINT STUDENT DETAILS \t\t\t\t|\n-----------------------------------------------------------------------------------------");
				
			System.out.print("\nEnter Student Id : ");
			stId=input.nextLine();			
			//----------------------------------------------------------check ID validity--------------------------------
			int check =0;
			int pos=0;			
			for(int i=0; i<stIdArray.length; i++){
				if (stIdArray[i].equals(stId)){
					pos=i;					
					check =1;
					break;
					}
				}
			if (check==0){
				System.out.print("Invalid student ID. Do you want to search again ? (y/n) : ");
				res=input.next().charAt(0);				
				input.nextLine();
				if(res=='y'){
					continue;
				}else{
					break;
					}
			}
			//----------------------------------------------------------print st name--------------------------------		
				
			System.out.println("Student name : "+stNameArray[pos]);
			//----------------------------------------------------------check whether marks already added or not--------------------------------	
			if(dbmsMarksArray[pos]==0){
				System.out.print("Student Marks yet to be added.\nDo you want to search another student details ? (y/n) : ");
				res=input.next().charAt(0);				
				input.nextLine();
				if(res=='y'){
					continue;
				}else{
					break;
					}
				}
			
			avg=(dbmsMarksArray[pos]+prfMarksArray[pos])/2;	
			
			System.out.println("\nDatabse Management System Marks\t : "+dbmsMarksArray[pos]);
			System.out.println("Programing Fundamentals Marks\t : "+prfMarksArray[pos]);
			System.out.println("Total Marks\t\t\t : "+(dbmsMarksArray[pos]+prfMarksArray[pos]));
			System.out.println("Average Marks\t\t\t : "+avg);
					

			
			System.out.print("\n\nDo you want search another student (y/n) ? : ");
			res=input.next().charAt(0);
			input.nextLine();
		}
	}
		
		
	public static void bestInProgrammingFundamentals(){
		clearConsole();
		Scanner input=new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------------\n|\t\t\t\t BEST IN PROGRAMMING FUNDAMENTALS \t\t\t|\n-----------------------------------------------------------------------------------------");
		
		
		//----------------------------------------------------------start sorting prfMarksArray --------------------------------
		
		int[] sortedMarksArray = new int[prfMarksArray.length];
		for(int i=0; i<prfMarksArray.length; i++){
			sortedMarksArray[i]=prfMarksArray[i];
			}
			
		for(int i=0; i<sortedMarksArray.length-1; i++){
			for(int j=0; j<sortedMarksArray.length-1-i; j++){			
				if(sortedMarksArray[j]<sortedMarksArray[j+1]){
					int tempvalue=sortedMarksArray[j];
					sortedMarksArray[j]=sortedMarksArray[j+1];
					sortedMarksArray[j+1]=tempvalue;
					}
				}
			}
		
		int pos=0;
		int[] posAr = new int[prfMarksArray.length];;
					
		for(int i=0; i<prfMarksArray.length; i++){
			for(int j=0; j<sortedMarksArray.length; j++){
				if (sortedMarksArray[i]==prfMarksArray[j]){
					posAr[i]=j;	
					}
				}
			}	
		//----------------------------------------------------------end sorting prfMarksArray --------------------------------	
		
		//----------------------------------------------------------print sorted prfMarksArray --------------------------------	
		
		System.out.println("Student ID \tStudent Name \t PF Marks \t DBMS Marks");
		for(int i=0; i<prfMarksArray.length; i++){
			System.out.println("   "+stIdArray[posAr[i]]+"\t\t"+stNameArray[posAr[i]]+" \t\t\t "+sortedMarksArray[i]+" \t\t\t "+dbmsMarksArray[posAr[i]]);
			}
		
		
		System.out.print("\n\nPress Enter to go back to main menu >> : ");
		String anykey=input.nextLine();
		
		}
	
	
	public static void bestInDBMS(){
		clearConsole();
		Scanner input=new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------------\n|\t\t\t\t BEST IN DATABSE MANAGEMENT SYSTEMS \t\t\t|\n-----------------------------------------------------------------------------------------");
		
		
		//----------------------------------------------------------start sorting dbmsMarksArray --------------------------------
		
		int[] sortedMarksArray = new int[dbmsMarksArray.length];
		for(int i=0; i<dbmsMarksArray.length; i++){
			sortedMarksArray[i]=dbmsMarksArray[i];
			}
			
		for(int i=0; i<sortedMarksArray.length-1; i++){
			for(int j=0; j<sortedMarksArray.length-1-i; j++){			
				if(sortedMarksArray[j]<sortedMarksArray[j+1]){
					int tempvalue=sortedMarksArray[j];
					sortedMarksArray[j]=sortedMarksArray[j+1];
					sortedMarksArray[j+1]=tempvalue;
					}
				}
			}
		
		int pos=0;
		int[] posAr = new int[dbmsMarksArray.length];;
					
		for(int i=0; i<dbmsMarksArray.length; i++){
			for(int j=0; j<sortedMarksArray.length; j++){
				if (sortedMarksArray[i]==dbmsMarksArray[j]){
					posAr[i]=j;	
					}
				}
			}	
		//----------------------------------------------------------end sorting prfMarksArray --------------------------------	
		
		//----------------------------------------------------------print sorted prfMarksArray --------------------------------	
		
		System.out.println("Student ID \tStudent Name \t DBMS Marks \t PF Marks");
		for(int i=0; i<dbmsMarksArray.length; i++){
			System.out.println("   "+stIdArray[posAr[i]]+"\t\t"+stNameArray[posAr[i]]+" \t\t\t "+sortedMarksArray[i]+" \t\t\t "+prfMarksArray[posAr[i]]);
			}
		
		
		System.out.print("\n\nPress Enter to go back to main menu >> : ");
		String anykey=input.nextLine();
		
		}	

	
	public static void printAllStudentDetails(){
		clearConsole();
		Scanner input=new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------------\n|\t\t\t\t\t STUDENT DETAILS \t\t\t\t|\n-----------------------------------------------------------------------------------------");
				
		System.out.println("Student Id \t\t Student Name\t\t DBMS Marks\t\t Pro..Fund.. Marks");
		for(int i=0; i<stIdArray.length; i++){
			System.out.println(stIdArray[i]+"\t\t\t\t"+stNameArray[i]+"\t\t\t"+dbmsMarksArray[i]+"\t\t\t"+prfMarksArray[i]);	
			}		
		System.out.print("\n\nPress Enter to go back to home page >> : ");
		String anykey=input.nextLine();
		}	
		
	public static void main(String args[]){		
		Scanner input=new Scanner(System.in);
			
		do{
			clearConsole();			
			System.out.println("-------------------------------------------------------------------------------------------------\n|\t\t\t WELCOME TO GDSE MARKS MANAGEMENT SYSTEM \t\t\t\t|\n-------------------------------------------------------------------------------------------------\n\n");
			System.out.println("[1] Add New Student\t\t\t\t\t[2] Add New Student With Marks");
			System.out.println("[3] Add Marks\t\t\t\t\t\t[4] Update Student Details");
			System.out.println("[5] Update Marks\t\t\t\t\t[6] Delete Student");
			System.out.println("[7] Print Student Details\t\t\t\t[8] Best in Programming Fundamentals");
			System.out.println("[9] Best in Database Management Systems\t\t\t[0] Exit");		
			System.out.print("\n\nEnter an Option to continue >> : ");
			
			int op=input.nextInt();
			switch(op){
				case 0 : return;
				case 1 : addNewStudent();break;
				case 2 : addNewStudentWithMarks();break;
				case 3 : addMarks();break;
				case 4 : updateStudentDetails();break;
				case 5 : updateMarks();break;			
				case 6 : deleteStudent();break;
				case 7 : printStudentDetails();break;
				case 8 : bestInProgrammingFundamentals();break;
				case 9 : bestInDBMS();break;
				default : break;
				}
			
			}while(true);
	}
} 
