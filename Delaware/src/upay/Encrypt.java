package upay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Encrypt {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		String[] arr_a = br.readLine().split(" ");
		int[] a = new int[n];
		for (int i_a = 0; i_a < arr_a.length; i_a++) {
			a[i_a] = Integer.parseInt(arr_a[i_a]);
		}

		int out_ = solve(a);
		System.out.println(out_);

		wr.close();
		br.close();

	}

	static int solve(int[] a) {
		Arrays.sort(a);
		List<HashSet<Integer>> setList = new ArrayList<HashSet<Integer>>();
		List<List<Integer>> subsets = getAllSubSets(a);
		Map<Integer, Integer> highestSubset = new HashMap<Integer, Integer>();
		for (int i = 0; i < a[a.length - 1]; i++) {
			getLargestSubset(subsets, i, highestSubset);
		}
		int encryptValue = 0;
		for (Integer keys : highestSubset.keySet()) {
			encryptValue = ((int) (encryptValue + (highestSubset.get(keys)*Math.pow(31, keys))));
		}
		
		return encryptValue;

	}

	private static List<List<Integer>> getAllSubSets(int[] a) {
		int n = a.length;
		List<Integer> setItems = null;
		List<List<Integer>> integerSetList = null;
		for (int i = 0; i < (Math.pow(2, n)); i++) {
			integerSetList = new ArrayList<List<Integer>>();
			setItems = new ArrayList<Integer>();
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) > 0) {
					setItems.add(a[i]);
				}
			}

			integerSetList.add(setItems);
		}
		return integerSetList;
	}

	private static Map<Integer, Integer> getLargestSubset(
			List<List<Integer>> subsets, int i,
			Map<Integer, Integer> highestSubset) {
		int previousSubsetSize = 0;
		for (int j = 0; j < subsets.size(); j++) {
			int xor = 0;
			List<Integer> subSet = subsets.get(j);
			for (int j2 = 0; j2 < subSet.size(); j2++) {
				xor ^= subSet.get(j2);
			}
			if (previousSubsetSize < subSet.size() && xor == i) {
				previousSubsetSize = subSet.size();
				highestSubset.put(i, previousSubsetSize);
			}
		}
		return highestSubset;
	}

}
