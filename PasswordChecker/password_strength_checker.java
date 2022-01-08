import PasswordCracker1.*;
import java.util.*;

public class password_strength_checker {


	public static void printStrongNess(String input)
	{
		PasswordCracker1 ob = new PasswordCracker1();
		int x = ob.runner(input);
		int n = input.length();
		boolean hasLower = false, hasUpper = false,
				hasDigit = false, specialChar = false;
		Set<Character> set = new HashSet<Character>(
			Arrays.asList('!', '@', '#', '$', '%', '^', '&',
						'*', '(', ')', '-', '+'));
		for (char i : input.toCharArray())
		{
			if (Character.isLowerCase(i))
				hasLower = true;
			if (Character.isUpperCase(i))
				hasUpper = true;
			if (Character.isDigit(i))
				hasDigit = true;
			if (set.contains(i))
				specialChar = true;
		}
	
		System.out.print("Password Strength:");
		if (hasDigit && hasLower && hasUpper && specialChar
			&& (n >= 8) &&(x!=1))
			System.out.print(" Strong");
		else if ((hasLower || hasUpper || specialChar)
				&& (n >= 6)&&(x!=1))
			System.out.print(" Moderate");
		else
			System.out.print(" Weak");
	}

	
	public static void main(String[] args)
	{
		int i =1;
		while(i>0){
		System.out.print("Enter your password:");
		Scanner sc = new Scanner(System.in);
		String input=sc.nextLine();
		printStrongNess(input);
		System.out.println("\nDo you want to check another password(Y/N):");
		String c = sc.nextLine();
		c = c.toLowerCase();
		String n = "n";
		if(c.equals(n))
		{
			
			System.exit(1);
		}
		else
		continue;
		sc.close();}
	}

	
}

