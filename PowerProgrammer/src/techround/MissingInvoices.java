package techround;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MissingInvoices {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		Map<String, List<Integer>> invoiceMap = new HashMap<String, List<Integer>>();
		List<Integer> invoiceList = null;
		
		for (int i = 0; i < length; i++) {
			String clientName = scan.next();
			String year = scan.next();
			int start = scan.nextInt();
			int end = scan.nextInt();
			if(invoiceMap.containsKey(clientName+year)){
				invoiceList = invoiceMap.get(clientName+year);
			}
			else{
				invoiceList = new ArrayList<Integer>();
			}
			
			for (int j = start; j <= end; j++) {
				invoiceList.add(j);
			}
			Collections.sort(invoiceList);
			invoiceMap.put(clientName+year, invoiceList);
		}
		
		
		Set<String> invoiceKeySet = invoiceMap.keySet();
		Iterator<String> iterator= invoiceKeySet.iterator();
		List<Integer> missingNumbers = new ArrayList<Integer>();
		System.out.println("here");
		while (iterator.hasNext()) {
			String string = (String) iterator.next(); 
			List<Integer> list = invoiceMap.get(string);
			
			int first = list.get(0);
			int last = list.get(list.size()-1);
			StringBuilder sb = new StringBuilder();
			sb.append(string).append("--->");
			for (int i = first+1; i < last; i++) {
				if(!list.contains(i)){
					sb.append(i).append(",");
				}
			}
			// delete comma
			if(sb.lastIndexOf(",") == sb.length()-1){
				sb.deleteCharAt(sb.length()-1);
			}
			System.out.println("Output : "+new String(sb));
		}
		
		
	}

}
