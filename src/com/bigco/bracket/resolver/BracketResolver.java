package com.bigco.bracket.resolver;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class BracketResolver {

	private final static char BRACKET = 'B';
	private static Map<Character, Character> BRACKET_MATCHER = new HashMap<>();
	static {
		BRACKET_MATCHER.put(')','(');
		BRACKET_MATCHER.put('}','{');
		BRACKET_MATCHER.put(']','[');
	}
	
	public static void main(String[] args) {
		String s[] = {"[{B]","[{(B)}{(B)(B)}]"};
		for(String str : s) {
			if(args[0].equals("0")) {
				validateSequence(str, 0);
			} else if(args[0].equals("1")) {
				validateSequence(str, 1);
			} else if(args[0].equals("2")) {
				
			}
		}
	}
	
	private static void validateSequence(String sequence, int mode) {
		Stack<Character> charStack = new Stack<>();
		for(int i=0;i<sequence.length();i++) {
			char c = sequence.charAt(i);
			if(c!=BRACKET) {
				if(c != ')' && c!= '}' && c != ']') {
					charStack.push(c);
				} else {
					if(charStack.pop() != BRACKET_MATCHER.get(c)) {
						System.out.println(sequence + "\t" + "BAD");
					}
				}
			}
		}
		if(mode == 0) {
			System.out.println(sequence + "\t" + (charStack.size() > 0 ? "BAD" : "OKAY"));
		} else if(mode == 1) {
			System.out.println((sequence + "\t" + correctTheSequence(sequence)));
		}
	}
	
	private static String correctTheSequence(String sequence) {
		String s = "[{b]";
		Deque<Character> deQueue = new LinkedList<>();
		for(int i = 0;i<sequence.length();i++) {
			char c = sequence.charAt(i);
			if(!BRACKET_MATCHER.containsKey(c)) {
				deQueue.addFirst(c);
			} else if(BRACKET_MATCHER.get(c).equals(deQueue.peekLast())) {
				deQueue.pollLast();
			} else {
				deQueue.addFirst(e);
			}
		}
		return null;
	}
}
