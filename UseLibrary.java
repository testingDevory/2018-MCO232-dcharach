package project1;
import java.util.*;
import java.time.*;

public class UseLibrary {

	public static void main(String[] args) {
		Scanner kybd= new Scanner(System.in);
		String libName;
		System.out.println("Welcome to your personal library system!");
		System.out.println("Please enter the name of your library and then we will begin");
		libName=kybd.nextLine();
		
		Library library =new Library(libName);//create new Library
		
		ArrayList<Person>authors=new ArrayList<>();
		ArrayList<BookCategory>bookCategories=new ArrayList<>();
		
		getMenu(library,authors,bookCategories);
	}//end main

	public static void getMenu(Library library,ArrayList<Person>authors,ArrayList<BookCategory>bookCategories) {
		int choice;
		Scanner input = new Scanner (System.in);
		System.out.println("\nTo add a regular employee press '1', \nTo add a librarian press '2'"
				+ "\nTo add a library book press '3' \nto modify an employee's last name through their name and dob press '4'"
				+ "\nTo change an employee's last by through their employee id number press '5' "
				+ "\nTo post time sheet press '6' \nTo get the total wages for an employee press '7'"
				+ "\nTo get total wages paid for all employees press '8'"
				+ "\nTo terminate an employee press '9' \nTo modify an employee's pay press '10'"
				+ "\nTo display all press '11'\nOr press '12' to exit");
		choice = input.nextInt();
		
		process(library,choice,authors,bookCategories);
	}//end getMenu
	
	public static void process(Library library, int choice,ArrayList<Person>authors,ArrayList<BookCategory>bookCategories) {
		Scanner keyboard = new Scanner (System.in);
		switch (choice) {
		
		case 1: addEmployee(library,authors,bookCategories);
				break;
		case 2: addLibrarian(library,authors,bookCategories);
				break;
		case 3: addLibraryBook(library,authors,bookCategories);            
				break;
		case 4:modifyLastNameByName(library,authors,bookCategories);
				break;
		case 5: modifyLastNameById(library,authors,bookCategories);
				break;
		case 6: postTimeSheet(library,authors,bookCategories);
				break;
		case 7: getEmployeeWages(library,authors,bookCategories);
				break;
		case 8: getTotalWages(library,authors,bookCategories);
				break;
		case 9: terminateEmployee(library,authors,bookCategories);
				break;
		case 10: modifyPay(library,authors,bookCategories);
				break;
		case 11: display(library,authors,bookCategories);
				break;
		case 12: System.out.println("Bye Bye!");
				System.exit(0);
		default: System.out.println("You must enter a number from 1-12"
				+ "/nPlease reenter your number");
				choice=keyboard.nextInt();
				process(library, choice,authors,bookCategories);
				break;
		}//end switch
	}//end process
	
	public static void addEmployee(Library library,ArrayList<Person>authors,ArrayList<BookCategory>bookCategories) {
		Scanner kybd = new Scanner(System.in);
		
		String f,l,bday,hireDate;
		Address addr;
		String street,city,state,zip;
		double wages;
		
		//get all the info from the user about the emloyee
		System.out.println("Enter the following information \nfirst name");
		f=kybd.nextLine();
		System.out.println("last name");
		l=kybd.nextLine();
		System.out.println("Street");
		street=kybd.nextLine();
		System.out.println("City");
		city=kybd.nextLine();
		System.out.println("Full state name");
		state=kybd.nextLine();
		System.out.println("zip");
		zip=kybd.nextLine();
		System.out.println("birthday in the format yyyy-mm-dd");
		bday=kybd.nextLine();
		System.out.println("date hired in the format yyyy-mm-dd");
		hireDate=kybd.nextLine();
		System.out.println("wage");
		wages=kybd.nextDouble();
		kybd.nextLine();//absorb the enter
		
		addr=new Address(street,city,state,zip);
		library.addEmployee(f,l,addr,bday,hireDate,wages);
		getMenu(library,authors,bookCategories);
		
	}//end addEmployee
	
	public static void addLibrarian(Library library,ArrayList<Person>authors,ArrayList<BookCategory>bookCategories) {
		Scanner kybd = new Scanner(System.in);
		
		String f,l,bday,hireDate;
		Address addr;
		String street,city,state,zip;
		double salary;
		String deg;
		EarnedDegree degree;
		
		//get all the info from the user about the emloyee
		System.out.println("Enter the following information \nfirst name");
		f=kybd.nextLine();
		System.out.println("last name");
		l=kybd.nextLine();
		System.out.println("Street");
		street=kybd.nextLine();
		System.out.println("City");
		city=kybd.nextLine();
		System.out.println("Full state name");
		state=kybd.nextLine();
		System.out.println("zip");
		zip=kybd.nextLine();
		System.out.println("birthday in the format yyyy-mm-dd");
		bday=kybd.nextLine();
		System.out.println("date hired in the format yyyy-mm-dd");
		hireDate=kybd.nextLine();
		System.out.println("Degree");
		deg=kybd.nextLine();
		System.out.println("salary");
		salary=kybd.nextDouble();
		kybd.nextLine();//absorb the enter
		
		int pos =deg.indexOf(" "); //search for a space and hold the index number
		if(pos>=0) //if there is a space 
			deg=deg.substring(0, pos)+deg.substring(pos+1);//value without the space
		degree=EarnedDegree.valueOf(deg.toUpperCase()); //change to upper case 
		
		addr=new Address(street,city,state,zip);
		library.addLibrarian(f,l,addr,bday,hireDate,salary,degree);
		getMenu(library,authors,bookCategories);
	}//end addLibrarian
	
	public static void addLibraryBook(Library library,ArrayList<Person>authors,ArrayList<BookCategory>bookCategories) {
		Scanner kybd = new Scanner(System.in);
		
		String isbn,title,f,l,street,city,state,zip,dob,category;
		
		System.out.println("Enter isbn");
		isbn=kybd.nextLine();
		System.out.println("Enter title");
		title=kybd.nextLine();
		System.out.println("author's first name");
		f=kybd.nextLine();
		System.out.println("author's last name");
		l=kybd.nextLine();
		System.out.println("Street");
		street=kybd.nextLine();
		System.out.println("City");
		city=kybd.nextLine();
		System.out.println("Full state name");
		state=kybd.nextLine();
		System.out.println("zip");
		zip=kybd.nextLine();
		System.out.println("birthday in the format yyyy-mm-dd");
		dob=kybd.nextLine();
		System.out.println("book category");
		category=kybd.nextLine();
		
		int pos =category.indexOf(" "); //search for a space and hold the index number
		if(pos>=0) //if there is a space 
			category=category.substring(0, pos)+category.substring(pos+1);//value of variable without the space
		BookCategory c=BookCategory.valueOf(category.toUpperCase()); //change to enum type
		
		Address address = new Address(street,city,state,zip);
		Person author=new Person(f,l,address,dob);
		authors.add(author);
		bookCategories.add(c);
		library.addLibraryBook(isbn, title, authors, bookCategories);
		getMenu(library,authors,bookCategories);
		
		
	}//end addLibraryBook
	
	public static void modifyLastNameByName(Library library,ArrayList<Person>authors,ArrayList<BookCategory>bookCategories) {
		Scanner kybd=new Scanner(System.in);
		String fn,ln,newLn,dob;
		LocalDate bday;
		
		System.out.println("enter the first name of the employee who's last name you want to change");
		fn=kybd.nextLine();
		System.out.println("Enter their old last name");
		ln=kybd.nextLine();
		System.out.println("Enter their new last name");
		newLn=kybd.nextLine();
		System.out.println("Enter their date of birth in thr format yyyy-mm-dd");
		dob=kybd.nextLine();
		bday=LocalDate.parse(dob);
		
		library.modifyLastName(fn, ln, newLn, bday);
		getMenu(library,authors,bookCategories);
		
	}//end modifyLastNameByName
	
	public static void modifyLastNameById(Library library,ArrayList<Person>authors,ArrayList<BookCategory>bookCategories) {
		Scanner kybd = new Scanner(System.in);
		int id;
		String newLn;
		
		System.out.println("Enter the new last name");
		newLn=kybd.nextLine();
		System.out.println("Enter the ID number of the employee who's last name you want to change");
		id=kybd.nextInt();
		kybd.nextLine();//absorb the enter
		
		library.modifyLastName(id, newLn);
		getMenu(library,authors,bookCategories);
	}//end modifyLastNameById
	
	public static void postTimeSheet(Library library,ArrayList<Person>authors,ArrayList<BookCategory>bookCategories) {
		Scanner kybd = new Scanner (System.in);
		int id,hours;
		
		System.out.println("Enter the employee ID");
		id=kybd.nextInt();
		System.out.println("Enter hours worked");
		hours=kybd.nextInt();
		kybd.nextLine();//absorb the enter
		
		library.postTimeSheet(id, hours);
		getMenu(library,authors,bookCategories);
	}//end postTimeSheet 
	
	public static void getEmployeeWages(Library library,ArrayList<Person>authors,ArrayList<BookCategory>bookCategories) {
		Scanner kybd = new Scanner (System.in);
		int id;
		double totalWages;
		System.out.println("Enter the id of the employee who's wages you would like to get");
		id=kybd.nextInt();
		kybd.nextLine();//absorb the enter
		
		totalWages=library.getTotalWages(id);
		System.out.println("\ntotal wages is: " + totalWages);
		getMenu(library,authors,bookCategories);
		
	}//end getEmployeeWages
	
	public static void getTotalWages(Library library,ArrayList<Person>authors,ArrayList<BookCategory>bookCategories) {
		double totalWages=library.getTotalWages();
		
		System.out.println("Total for all employees is " + totalWages);
		getMenu(library,authors,bookCategories);
	}//end getTotalWages
	
	public static void terminateEmployee(Library library,ArrayList<Person>authors,ArrayList<BookCategory>bookCategories) {
		Scanner k = new Scanner (System.in);
		int id;
		System.out.println("\nplease enter the id number of the employee you wish to terminate");
		id=k.nextInt();
		k.nextLine();//absorb the enter
		
		library.terminateEmployee(id);
		System.out.println("removed\n");
		getMenu(library,authors,bookCategories);
	}//end terminateEmployee
	
	public static void modifyPay(Library library,ArrayList<Person>authors,ArrayList<BookCategory>bookCategories) {
		Scanner k= new Scanner (System.in);
		int id;
		double newPay;
		
		System.out.println("Please enter the ID number of the employee who's pay you wish to change");
		id=k.nextInt();
		System.out.println("Enter the new pay");
		newPay=k.nextDouble();
		k.nextLine();//absorb the enter
		
		library.modifypay(id, newPay);
		System.out.println("changed");
		getMenu(library,authors,bookCategories);
	}//end modifyPay
	
	public static void display(Library library,ArrayList<Person>authors,ArrayList<BookCategory>bookCategories) {
		System.out.println(library.toString());
		getMenu(library,authors,bookCategories);
	}//end display
	
	
	
}//end library class
