import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Problem2 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String P = br.readLine();
            String Q = br.readLine();
            int cost_size = Integer.parseInt(br.readLine().trim());
            String[] arr_cost = br.readLine().split(" ");
            int[] cost = new int[cost_size];
            for(int i_cost=0; i_cost<arr_cost.length; i_cost++)
            {
            	cost[i_cost] = Integer.parseInt(arr_cost[i_cost]);
            }

            int out_ = amount_to_pay(Q, P, cost);
            System.out.println(out_);
         }

         wr.close();
         br.close();
    }
    static int amount_to_pay(String Q, String P, int[] cost){
    	List<Integer> matches = new ArrayList<Integer>();
    	for (int i = 0; i <= P.length()-Q.length(); ) {
    		int index = P.substring(i).indexOf(Q)+i;
    		if(index >= 0){
    			matches.add(P.substring(i).indexOf(Q)+i);
    			if(index == 0 || i == index)
    				i++;
    			else
    				i=index;
    		}
    		else
    			break;
		}
    	
    	if(matches.isEmpty()){
    		return 0;
    	}
    	int max = 0;
    	int sum=0;
    	for (int i = 0; i < matches.size(); i++) {
    		//System.out.println(i);
    		sum=cost[matches.get(i)];
    		//System.out.println("i-->"+i);
    		int mIndex = i;
			for (int j = i + 1; j < matches.size(); j++) {
				if (matches.get(j) >= mIndex+Q.length()){
					sum += cost[matches.get(j)];
					mIndex+=2;
				}
			}
			if(sum > max){
				max = sum;
			}
		}
    	
		return max;
    }

}
