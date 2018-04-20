package edu.diva.ds.string;

public class AllAnagrams {

	public static void main(String[] args) {
		findAllPossibilities("", "abc", 3);
	}
	
	private static String findAllPossibilities(String s1, String s2, int length) {
		if(s2.length() == 1) {
			return s2;
		}
		for(int i = 0;i<s2.length();i++) {
			String s = s1.concat(findAllPossibilities(s2.charAt(i)+"", restOfCharacters(i, s2), length));
			if(s.length() == length) {
				System.out.println(s);
			}
		}
		return "";
	}
	
	private static String restOfCharacters(int j, String s2) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0;i<s2.length();i++) {
			if(i != j)
				builder.append(s2.charAt(i));
		}
		return builder.toString();
	}
}
