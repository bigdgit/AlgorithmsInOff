package trials;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Subsequence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();
        String result = solve(s, k);
        System.out.println(result);
        in.close();
	}

	private static String solve(String s, int k) {
		Map<Character, Integer>characters = new TreeMap<Character, Integer>(Collections.reverseOrder());
		char[] charArr = s.toCharArray();
		populateCharacterMap(characters,charArr,0);
		
		
		StringBuilder sb = new StringBuilder();
		char maxValidChar = '\0';
		for(Character key : characters.keySet())
		{
			if(characters.get(key) >= k)
			{
				maxValidChar = key;
				break;
			}
		}
		
		int maxValidCharPosition = 0;
		for (int i = 0; i < charArr.length; i++) {
			if(charArr[i] == maxValidChar)
			{
				maxValidCharPosition = i;
				break;
			}
		}
		
		characters.clear();
		
		populateCharacterMap(characters, charArr, maxValidCharPosition);
		
		char lastAppendedChar = '\0';
		for (int i = maxValidCharPosition; i < charArr.length; i++) {
			if(characters.get(charArr[i]) >=k){
				if(lastAppendedChar != '\0')
				{
					if(lastAppendedChar < charArr[i])
					{
						sb.deleteCharAt(sb.length()-1);
						sb.append(charArr[i]);
						
					}
					else{
						sb.append(charArr[i]);
					}
					lastAppendedChar = charArr[i];
				}
				else{
					sb.append(charArr[i]);
					lastAppendedChar = charArr[i];
				}
			}
			
		}
		Map<Character, Integer> characterCounts = new HashMap<Character, Integer>();
		populateCharacterMap(characterCounts, sb.toString().toCharArray(), 0);
		
		for (int i = 0; i < sb.length(); i++) {
			if(characterCounts.get(sb.charAt(i)) < k){
				sb.deleteCharAt(i);
			}
				
		}
		return sb.toString();
	}

	private static void populateCharacterMap(
			Map<Character, Integer> characters, char[] charArr,int index) {
		for (int i = index; i < charArr.length; i++) {
			if(characters.containsKey(charArr[i]))
			{
				characters.put(charArr[i],characters.get(charArr[i])+1);
			}
			else{
				characters.put(charArr[i],1);
			}
		}
		
	}

	

}
