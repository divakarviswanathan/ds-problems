package edu.diva.ds.string;

public class AllAnagram {
	
	public static void main(String[] args) {
		permute(new int[] {1,1,1}, new char[] {'a','b','c'},new char[3], 0);
	}
	
	private static void printResult(char[] res) {
		System.out.println();
		for(int i = 0;i<res.length;i++) {
			System.out.print(res[i]);
		}
	}
	
	private static void permute(int count[], char[] origina, char[] result, int level) {
		if(level == origina.length) {
			printResult(result);
			return;
		}
		
		for(int i = 0;i<origina.length;i++) {
			if(count[i] == 0)
				continue;
			count[i]--;
			result[level] = origina[i];
			permute(count, origina, result, level+1);
			count[i]++;
		}
	}
}
