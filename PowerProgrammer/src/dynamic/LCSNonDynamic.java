package dynamic;

import java.util.Scanner;

public class LCSNonDynamic {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String seq1 = scan.next();
		String seq2 = scan.next();
		
		char seqArr1[] = seq1.toCharArray();
		char seqArr2[] = seq2.toCharArray();
		
		int result = lcs(seqArr1,seqArr2,seqArr1.length,seqArr2.length);
		System.out.println(result);
	}

	private static int lcs(char[] a, char[] b, int m,
			int n) {
		if(m == 0 || n == 0){
			return 0;
		}
		if(a[m-1] == b[n-1]){
			return 1 + lcs(a, b, m-1, n-1);
		}
		else{
			return Math.max(lcs(a, b, m, n-1),lcs(a, b, m-1, n));
		}
		
	}

}
