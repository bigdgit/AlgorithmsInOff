package techround;

import java.util.Scanner;

public class NextPalindrome {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		
		System.out.println(number);
		int length = (number+"").length();
		int base = (int) Math.pow(10, length-1);
		int temp = number;
		int a[] = new int[length];
		int index = length-1;
		while(base != 1 ){
			a[index] = temp/base;
			index-=1;
			temp = temp % base;
			base = base / 10;			
		}
		a[index] = temp;
		
		int midIndex = a.length/2;
		StringBuilder sb = new StringBuilder();
		for (int i = midIndex; i < a.length; i++) {
			sb.append(a[i]);
		}
		sb = sb.reverse();
		
		int n = Integer.parseInt(new String(sb));
			
		
	}

	private static int getIndex(int[] a) {
		if(a.length%2 != 0){		
			return a.length/2;
		}
		else{
			
		}
		return 0;
	}
}
