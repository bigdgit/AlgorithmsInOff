package upay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Balls {
	public static void main(String[] args) {
		System.out.println(3^5);
		Scanner scan = new Scanner(System.in);
		int testCase = scan.nextInt();
		for (int i = 0; i < testCase; i++) {
			int size = scan.nextInt();
			List<Integer> intList = new ArrayList<Integer>();
			
			for (int j = 0; j < size; j++) {
				intList.add(scan.nextInt());
			}
			
			boolean removed = true;
			while(intList.size() > 0 && removed){
				int listSize = intList.size();
				removed = intList.removeAll(Arrays.asList(listSize));
			}
			
			if(intList.size() > 0){
				System.out.println("NO");
			}
			else{
				System.out.println("YES");
			}
		}
		
	}
}
