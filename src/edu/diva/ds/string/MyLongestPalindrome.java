package edu.diva.ds.string;

public class MyLongestPalindrome {

	public static void main(String[] args) {
		String str = "xyammammaz";
		int maxLength = 1, startIndex = 0;
		for(int i = 0;i<str.length();i++) {
			while(true) {
				int tempLength = maxLength, currentStart = i, end = tempLength + currentStart;
				while((tempLength+i) < str.length()-1 && str.charAt(currentStart) != str.charAt(end)) {
					tempLength++;
					end = tempLength + currentStart;
				}
				while(currentStart < end && str.charAt(currentStart) == str.charAt(end)) {
					currentStart++;
					end--;
				}
				if(currentStart >= end) {
					maxLength = tempLength;
					startIndex = i;
				}
				if(end >= str.length()-1) {
					break;
				}
				tempLength++;
			}
		}
		System.out.println("Max Palindrome string is\t" + str.substring(startIndex, maxLength+startIndex));
	}

}
