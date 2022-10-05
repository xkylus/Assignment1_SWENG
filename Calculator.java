import java.util.Scanner;
import java.util.Stack;

public class Calculator
{
	public static void main(String[] args)
	{
		System.out.println("Please Enter a Mathematical Expression :D");

		Scanner userInput = new Scanner(System.in);
		int answer = calculate(userInput.nextLine());
		System.out.println("The Answer is: " + answer);
		userInput.close();
	}

	public static int calculate(String equation)
	{
		Stack<Integer> numberStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();
		
		char[] characterArray = equation.toCharArray();

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
				while((operatorStack.isEmpty() == false))
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
}