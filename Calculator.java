
public class Calculator
{
	public static void main(String[] args)
	{
		String input = "12345";
		int output = calculate(input);
		System.out.println("Output: " + output);
	}

	public static int calculate(String equation)
	{
		int out = 0;
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
				out = number;
			}
		}
		return out;
	}
}
