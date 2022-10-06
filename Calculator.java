import java.util.Scanner;
import java.util.Stack;

public class Calculator
{
	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
		boolean exit = false;
		
		// while loop to keep calculator working until prompted to stop by typing exit
		while(!exit)
		{
			System.out.println("Please Enter a Mathematical Expression :D");
			String input = userInput.nextLine();
			
			if(input.equalsIgnoreCase("Exit"))
			{
				exit = true;
			}
			else
			{	
				if(isValidExpression(input) == false)
				{
					System.out.println("ERROR - not a valid expression >:(\n");
				}
				else
				{
					int answer = calculate(input);
					System.out.println("The Answer is: " + answer);
				}
			}
		}
		System.out.println("Shutting down calcultor :(");
		userInput.close();
	}

	/**
	 * isValidFunction which checks if the inputted string from a user is valid
	 * 
	 * @param String input (user input expression)
	 * @return true if the input string is a valid mathematical expression
	 * 		   else return false if input string is invalid.
	 */
	public static boolean isValidExpression(String input)
	{
		boolean bool = true;
		
		String in = input.replaceAll("\\s+", "");
		char[] inputArray = in.toCharArray();
		
		if(isOperator(inputArray[0]) == true)
		{
			return bool = false;
		}
		else if(isOperator(inputArray[inputArray.length - 1]) == true)
		{
			return bool = false;
		}
		
		for(int i = 0; i < inputArray.length; i++)
		{
			if(!Character.isDigit(inputArray[i]) && !isOperator(inputArray[i]))
			{
				bool = false;
				break;
			}
			else if(isOperator(inputArray[i]) && isOperator(inputArray[i + 1]))
			{
				bool = false;
				break;
			}	
		}
		return bool;
	}
	
	/**
	 * isOperator function which checks a character in a character array to see if it is
	 * either '+', '-', or '*'
	 * 
	 * @param char character
	 * @return return true if character is either '+', '-', '*'
	 * 	       else return false;
	 */
	public static boolean isOperator(char character) 
	{
		if(character == '+' || character == '-' || character == '*')
		{
			return true;
		}
		else return false;
	}

	/**
	 * calculate function which calculates the answer to the inputted expression
	 * 
	 * @param String equation
	 * @return an integer (the answer to the user input expression)
	 */
	public static int calculate(String equation)
	{
		Stack<Integer> numberStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();

		String in = equation.replaceAll("\\s+", "");
		char[] characterArray = in.toCharArray();

		for(int i = 0; i < characterArray.length; i++)
		{
			if(Character.isDigit(characterArray[i]))
			{
				int number = 0;
				char integer = characterArray[i];

				while(Character.isDigit(integer))
				{
					number = number * 10 + (integer - 0x30);

					i++;

					if(i < characterArray.length)
					{
						integer = characterArray[i];
					}
					else
					{
						break;
					}
				}
				i--;

				numberStack.push(number);
			}
			else if((characterArray[i]) == '+' ||(characterArray[i]) == '-' || (characterArray[i]) == '*')
			{
				while((operatorStack.isEmpty() == false) && (opPrecedence(characterArray[i])<= opPrecedence(operatorStack.peek())))
				{
					int solution = 0;
					int numOne = numberStack.pop();
					int numTwo = numberStack.pop();
					char operate = operatorStack.pop();

					if(operate == '+')
					{
						solution = numOne + numTwo;
					}
					else if(operate == '-')
					{
						solution = numTwo - numOne;
					}
					else
					{
						solution = numOne * numTwo;
					}
					numberStack.push(solution);
				}
				operatorStack.push(characterArray[i]);
			}
		}

		while(operatorStack.isEmpty() == false)
		{
			int solution = 0;
			int numOne = numberStack.pop();
			int numTwo = numberStack.pop();
			char operate = operatorStack.pop();

			if(operate == '+')
			{
				solution = numOne + numTwo;
			}
			else if(operate == '-')
			{
				solution = numTwo - numOne;
			}
			else
			{
				solution = numOne * numTwo;
			}
			numberStack.push(solution);
		}
		return numberStack.pop();
	}

	/**
	 * opPrecendence function checks the precedence of an operator
	 * 
	 * @param char ch 
	 * @return 1 if ch == '+' or '-'
	 *         else return 2 if ch '*'
	 *         else return 0
	 */
	public static int opPrecedence(char ch)
	{
		if(ch == '+' || ch == '-')
		{
			return 1;
		}
		else if(ch == '*')
		{
			return 2;
		}
		else return 0;
	}
}