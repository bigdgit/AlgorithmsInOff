import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Problem1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int t_i = 0; t_i < T; t_i++) {
			String s = br.readLine();

			String out_ = decode(s);
			System.out.println(out_);
		}

		wr.close();
		br.close();
	}

	static String decode(String s) {
		
		/*StringBuilder result = new StringBuilder();
		int strLength = s.length();
		int midElement = (strLength%2==0 ? (strLength/2)-1 : strLength/2);
		System.out.println("Mid Element -->"+midElement);
		char[] charArr = new char[strLength];
		charArr[midElement]=s.charAt(0);
		for (int i = 0; i < charArr.length; i++) {
			
		}
		return result.toString();*/
		
		StringBuilder result = new StringBuilder();
		result.append(s.charAt(0));
		boolean even = false;
		if(s.substring(1).length()%2 == 0){
			even = true;
		}
		for (int i = 1; i < s.length(); i++) {
			if (even) {
				result.insert(0, s.charAt(i));
				even = false;
			} else {
				result.append(s.charAt(i));
				even = true;
			}
		}
		return result.toString();
	}
}
