package dynamic;

import java.util.Scanner;

import org.omg.CORBA.INITIALIZE;

public class LCSMemoid {
	
	
	public int lookup[][];
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String seq1 = scan.next();
		String seq2 = scan.next();
		
		char seqArr1[] = seq1.toCharArray();
		char seqArr2[] = seq2.toCharArray();
		LCSMemoid l = new LCSMemoid();
		l.lookup = new int[seqArr1.length][seqArr2.length];
		l.initialize(l.lookup);
		int result = l.lcs(seqArr1,seqArr2,seqArr1.length-1,seqArr2.length-1);
		System.out.println(result+1);
	
	}

	
	private void initialize(int[][] lookup2) {
		for (int i = 0; i < lookup2.length; i++) {
			for (int j = 0; j < lookup2[i].length; j++) {
				lookup2[i][j] = -1;
			}
		}
		
	}


	private int lcs(char[] seqArr1, char[] seqArr2, int m,
			int n) {
		int sol1,sol2,sol3;
		if(m == 0 || n == 0){
			return 0;
		}
		
		if(lookup[m][n] >= 0){
			return lookup[m][n];
		}
		
		if(seqArr1[m-1] == seqArr2[n-1]){
			sol1 = lcs(seqArr1, seqArr2, m-1, n-1);
			lookup[m][n] = sol1 + 1;
			return sol1 + 1;
		}
		else{
			sol2 = lcs(seqArr1, seqArr2, m-1, n);
			sol3 = lcs(seqArr1, seqArr2, m, n-1);
			
			return Math.max(sol2, sol3);
		}
	}

}
