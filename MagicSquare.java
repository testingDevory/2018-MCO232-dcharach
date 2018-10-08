import java.util.*;
public class MagicSquare 
{
	public static void main (String [] args)
	{
		System.out.println("Hello, you will create a magic square/grid that's has "
				+ "3 rows and 3 columns. \nIt must contain the numbers 1 through 9"
				+ "\nand every number must only be used once. \nThe sum of each row, column"
				+ " and diagonal must add up to the same number. \nGood Luck!");
		
		//call method to ask user for numbers
		int [][] magicSquare = getNumbers();
		
		//call method to check if rows, columns, and diagonals add up to the same number
		checkSum(magicSquare);
		
		//call method to display the magic square
		displayArray(magicSquare);
	}
	
	/**the getNumbers method asks the user to enter the numbers in the order
	 * they want to place them in the magic square and checks that the input 
	 * is valid (no number is used twice, and the numbers are between 1 and 9)
	 * @return returns the array holding all the numbers in their place
	 */
	public static int[][] getNumbers ()
	{
		Scanner keyboard = new Scanner (System.in);
        int number=0;
		int[] [] magicSquare = new int [3] [3];
		

		try
		{//create two dimensional array filled with numbers the user entered
		for( int x=0; x<3; x++)
		{
			for (int c=0; c<3; c++ )
				{
				System.out.println("please enter the number you want in the magic square "
						+ "for row " + (x+1) + " column " + (c+1));
				number= keyboard.nextInt();
				
				//check that the number hasn't already been used
				//used a loop to allow the user to continue entering
				
				
				for (int q=0; q<3; q++)
				{
					for (int w=0; w<3; w++)
						{
							while (number==magicSquare[q][w] && !(number==0))//bcuz auto filled with 0
								{
								System.out.println("You have already used that number."
										+ "\n Please enter a different number");
								number=keyboard.nextInt();
								}
						}
				}
				
				while(number>9 |number<1)
				{
					System.out.println("You must enter a number from 1 to 9."
							+"\nPlease enter a different number");
					number=keyboard.nextInt();
				}
				magicSquare [x][c]= number;
				
				}
			
		}
		
		keyboard.close();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.exit(1);
		}
		catch(InputMismatchException e)//catch to make sure the user entered an int value
		{
			System.out.println("you must enter an integer value from 1-9. Let's restart");
			 magicSquare = getNumbers();
			
			//call method to check if rows, columns, and diagonals add up to the same number
			checkSum(magicSquare);
			
			//call method to display the magic square
			displayArray(magicSquare);
		}
		return magicSquare;
		
	}
	
	/**The checkSum method checks that the sum of all the rows, columns, and 
	 * diagonals are equal to each other 
	 * @param magicSquare holds the magicSquare array
	 */
	public static void checkSum (int [][] magicSquare)
	{
		int  sum7=0, sum8=0;   
		int sum1=0, sum2=0, row=0;
		
		//get sum of rows
		for (int col = 0; col < magicSquare.length; col++)  
		{
			sum1 += magicSquare[row][col]; //hold the sum of the first row 
		}
		  
		for(row=1; row<magicSquare.length; row++)
		{
			sum2=0;
			for (int col=0; col<magicSquare.length; col++)
				{
				sum2 +=magicSquare[row][col]; 
				}
			if (!(sum1==sum2))
				{
				System.out.println("\nSorry your rows don't add up to the same number, you lose");
				System.exit(0);
				}
		}
		 //get sum of columns
		for (int col=0; col<magicSquare.length; col++)
		{
			sum2=0;
			for (row=0; row<magicSquare.length; row++)
				{
				sum2+=magicSquare[row][col]; 
				}
			if(!(sum1==sum2))
				{
				System.out.println("\nSorry your columns don't add up to the same number, you lose");
				System.exit(0);
				}
		}	
			
		
		int col=0;
		for(row=0; row<magicSquare.length; row++)
		{
			sum7+=magicSquare[row][col++]; //holds the sum of the diagonal top left to btm right
		}
		
		if(sum1==sum7)
			{
			row=2;
			for(col=0; col<magicSquare.length; col++)
				sum8+=magicSquare[row--][col]; //holds the sum of the diagonal btm left to top right
			}
		else
		{
			System.out.println("\nSorry your diagonals don't add up to the same number, you lose");
			System.exit(0);
		}
		
		if (!(sum1==sum8))
		{
		System.out.println("\nSorry your diagonals don't add up to the same number, you lose");
		System.exit(0);
		}
	    	  	
	     	  
		
	}
	
	
	/**The displayArray method displays the array holding the magic square 
	 * values 
	 * @param magicSquare holds the magicSquare array 
	 */
	public static void displayArray(int [][] magicSquare)
	{
		System.out.println("Your Magic Square is:");
		  for (int x=0; x<magicSquare.length; x++)
		  {
		  	int y=0;
		  	System.out.println();// go to new line for each row 
		  	 for (int i=0; i<magicSquare[x].length; i++)
		 		{
		  			System.out.printf("%-3d", magicSquare[x][y++]);
		  		}
		  } 
	}
}
