package project1;
import java.time.*;
import java.util.*;

public class Library {

	private String libraryName;
	private ArrayList<Person>persons;
	private ArrayList<Book>libraryBooks;
	
	/**Constructor accepting the name of the library and instantiating the arrays
	 * @param name the name of the library
	 */
	public Library(String name) {
		this.libraryName=name;
		this.persons=new ArrayList<Person>();
		this.libraryBooks=new ArrayList<Book>();
	}
	
	public void addEmployee(String f, String l, Address addr, String birthdate, String hireDate, double wages ) {
		Employee e = new Employee(f,l,addr,birthdate,hireDate,wages);
		if(!(persons.contains(e))) {
			persons.add(e);
		}
	}
	
	public void addLibrarian(String f, String l, Address addr, String birthdate, String hireDate, double salary, EarnedDegree degree) {
		Librarian lib= new Librarian(f,l,addr,birthdate,hireDate,degree,salary);
		if(!(persons.contains(lib))) {
			persons.add(lib);
			
		}
		
	}
	
	public void addLibraryBook(String isbn,String title, ArrayList<Person>authors, ArrayList<BookCategory>categories) {
		Book b= new Book(isbn,title,authors,categories);
		libraryBooks.add(b);
		 
	}
	
	public void modifyLastName(String firstName, String lastName, String newLN, LocalDate birthDate) {
		for(int x=0; x<persons.size(); x++)
		{
			if(persons.get(x).getFirstName().equalsIgnoreCase(firstName) && persons.get(x).getLastName().equalsIgnoreCase(lastName)
					&& persons.get(x).getBirthDate().isEqual(birthDate))
			{
				persons.get(x).setLastName(newLN);
			}
		}
	}
	
	public void modifyLastName(int employeeid, String newLastName) {
		for(int x=0; x<persons.size();x++) {
			if(((Employee) persons.get(x)).getEmployeeID()==employeeid) {
				persons.get(x).setLastName(newLastName);
			}
		}
	}//end method
	
	public void postTimeSheet(int employeeid,  int hours) {
		for(int x=0; x<persons.size();x++) {
			if(persons.get(x)instanceof Employee) {
				if(((Employee) persons.get(x)).getEmployeeID()==employeeid) {
					 ((Employee) persons.get(x)).completeTimeSheet((double)hours);
				}//close nested if statement 
			}
			else if(persons.get(x)instanceof Librarian) {
				throw new NoTimeSheetException("Librarians do not have a time sheet");
			}
		}//close for loop
	}
	
	public double getTotalWages(int employeeID) {
		double totalWages=0;
		for(int x=0; x<persons.size();x++) {
			if(((Employee) persons.get(x)).getEmployeeID()==employeeID) {
				if(persons.get(x)instanceof Librarian) {
					int startedYear= ((Librarian) persons.get(x)).getHireDate().getYear();
					int currentyear=LocalDate.now().getYear();
					int ttlYears=currentyear-startedYear;
					totalWages=((Librarian) persons.get(x)).getTotalPay(startedYear)*ttlYears;
						
				}
				else if(persons.get(x)instanceof Employee) {
				
					int year= ((Employee) persons.get(x)).getHireDate().getYear();
					while(year<=LocalDate.now().getYear()) {
						totalWages+=((Employee) persons.get(x)).getTotalPay(year);
						year++;
				}//end while loop
			}//close nested if
			}
		}//close for loop
		return totalWages;
	}//end method
	
	public double getTotalWages() {
		double totalWages=0;
		for(int x=0; x<persons.size();x++) {
			if(persons.get(x)instanceof Librarian) {
				int monthsPassed=LocalDate.now().getMonthValue()-1;
				totalWages+=(((Librarian) persons.get(x)).getTotalPay(LocalDate.now().getYear())/12)*monthsPassed;
			}
			else {
				totalWages+=((Employee) persons.get(x)).getTotalPay(LocalDate.now().getYear());
			}
		}
		return totalWages;
	}
	
	public void terminateEmployee(int employeeid) {
		for(int x=0; x<persons.size();x++) {
			if(((Employee) persons.get(x)).getEmployeeID()==employeeid) {
				persons.remove(x);
			}
		}
	}
	
	public void modifypay(int employeeid, double newPay) {//overloaded
		for(int x=0; x<persons.size();x++) {
			if(((Employee) persons.get(x)).getEmployeeID()==employeeid) {
				if(persons.get(x)instanceof Librarian)
				((Librarian) persons.get(x)).modifyPay(newPay);
				else if(persons.get(x)instanceof Employee)
					((Employee) persons.get(x)).modifyPay(newPay);
				}
			}
	}
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder(this.libraryName+ " library:");
		
		for(int x=0; x<persons.size();x++) {
			output.append(((Employee)persons.get(x)).toString());
			output.append("\n");
		}
		for(int x=0; x<libraryBooks.size();x++) {
			output.append(libraryBooks.get(x).toString());
			output.append("\n");
		}
		return output.toString();
	}
	 

}
