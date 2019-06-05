package trials;

import java.util.Scanner;

public class ValidateEmail {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String email = scan.next();
		boolean isValidName = false;
		String emailArr[] = email.split("@");
		if(emailArr.length == 2){
			String emailName = emailArr[0];
			
			isValidName = validateEmailName(emailName) && 
					emailArr[1].equals("hogwarts.com");
			if(isValidName)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		else{
			System.out.println("No");
		}
		
	}

	private static boolean validateEmailName(String emailName) {
		char[] strArr = emailName.toCharArray();
		if(strArr.length != 5)
			return false;
		for (int i = 0; i < strArr.length; i++) {
			if(strArr[i] >= 97 && strArr[i]  <= 122){
				
			}
			else{
				return false;
			}
		}
		return true;
	}

}
