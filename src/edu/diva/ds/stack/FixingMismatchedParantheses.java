package edu.diva.ds.stack;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;

public class FixingMismatchedParantheses {

	private static final Map<Character, Character> openMap = new HashMap<>();
	private static final Map<Character, Character> closeMap = new HashMap<>();
	static {
		openMap.put('{', '}');
		openMap.put('[', ']');
		openMap.put('(', ')');
		closeMap.put('}','{');
		closeMap.put(']','[');
		closeMap.put(')','(');
	}
	public static void main(String[] args) {
		
		
		//String s = "[{B]";
		System.out.println(reverseDesc(fixDescriptionFull(reverseDesc(fixDescriptionFull("B(B)]")))));
		//System.out.println(reverseDesc(fixDescription(reverseDesc(fixDescription("B(B)")))));
		//System.out.println(fixDescription("[}}(B)]"));
		//System.out.println(reverseDesc(fixDescription(s)));
	}
	
	private static String fixDescriptionFull(String str) {
		Stack<Character> closers = new Stack<>();
		StringBuilder fixed = new StringBuilder();
		for(int i = 0; i< str.length();i++) {
			if(openMap.containsKey(str.charAt(i))) {
				closers.push(openMap.get(str.charAt(i)));
			} else if(closeMap.containsKey(str.charAt(i))) {
				try {
					char closer = closers.pop();
					while(closer != str.charAt(i)) {
						fixed.append(closer);
						closer = closers.pop();
					}
					fixed.append(closer);
				} catch(EmptyStackException e) {
					fixed.append(str.charAt(i));
				}
				continue;
			}
			fixed.append(str.charAt(i));
		}
		while(!closers.isEmpty()) {
			fixed.append(closers.pop());
		}
		System.out.println(fixed.toString());
		return fixed.toString();
	}
	
	private static String fixDescription(String str) {
		Stack<Character> closers = new Stack<>();
		StringBuilder fixed = new StringBuilder();
		for(int i = 0; i< str.length();i++) {
			if(openMap.containsKey(str.charAt(i))) {
				closers.push(openMap.get(str.charAt(i)));
			} else if(closeMap.containsKey(str.charAt(i))) {
				try {
					char closer = closers.pop();
					while(closer != str.charAt(i)) {
						fixed.append(closer);
						closer = closers.pop();
					}
					fixed.append(closer);
				} catch(EmptyStackException e) {
					//Do nothing
				}
				continue;
			}
			fixed.append(str.charAt(i));
		}
		while(!closers.isEmpty()) {
			fixed.append(closers.pop());
		}
		System.out.println(fixed.toString());
		return fixed.toString();
	}
	
	private static String reverseDesc(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< str.length();i++) {
			if(openMap.containsKey(str.charAt(i))) {
				sb.append(openMap.get(str.charAt(i)));
			} else if(closeMap.containsKey(str.charAt(i))) {
				sb.append(closeMap.get(str.charAt(i)));
			} else {
				sb.append(str.charAt(i));
			}
		}
		String str2 = sb.reverse().toString();
		System.out.println(str2);
		return str2;
	}
}
