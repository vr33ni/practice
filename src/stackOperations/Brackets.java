package stackOperations;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Brackets {

	//VERSION 1
	 static HashMap<Character, Character> bMap;
	 
	    static {
	        bMap = new HashMap<>();
	        bMap.put('(', ')');
	        bMap.put('[', ']');
	        bMap.put('{', '}');
	    }
	 
	    static String isBalanced(String str) {
	 
	        if ((str.length() % 2) != 0) {
	            return "NO";
	        }
	        Stack<Character> stack = new Stack<>();
	        for(int i=0; i < str.length(); i++) {
	            Character ch = str.charAt(i);
	            if(bMap.containsKey(ch)) {
	                stack.push(ch);
	            } else if(stack.isEmpty() || ch != bMap.get(stack.pop())) {
	                return "NO";
	            }
	        }
	 
	        return stack.isEmpty()? "YES": "NO";
	    }
	    
	    
	//VERSION 2
	static char getReverseBracket(char c) {
		
		if (c == '}') return '{';
		else if (c == ')') return '(';
		else if (c== ']') return '[';
		else return c;
		
	}
	static boolean isValid(String brackets) {
		
		Stack<Character> stack = new Stack<>();
		
		char[] arr = brackets.toCharArray();
		
		for (int i=0; i<arr.length; i++) {
			if (arr[i] == '[' || arr[i] == '{' || arr[i] == '(') {
				stack.push(arr[i]);
			}
			else if (stack.empty() || stack.pop() != getReverseBracket(arr[i])) {
				return false;				
			}
			
		}
		
		
		return stack.empty();
	}
	
	
	
	public static void main(String[]args) {
		String brackets = "[[{}]()]";
		System.out.println(isBalanced(brackets));
		System.out.println(isValid(brackets));
		
		
	}
}
