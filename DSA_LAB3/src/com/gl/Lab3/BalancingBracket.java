package com.gl.Lab3;
import java.util.Stack;
import java.util.Scanner;

public class BalancingBracket {
	Stack<Character> q = new Stack<Character>();
//creating function to insert relevant braces and check the closing as well
	public boolean inputBraces(String arg) {
		for (int i = 0; i < arg.length(); i++) {
			char c = arg.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				q.push(c);
				continue;
			}

			if (q.isEmpty())
				return false;
			char x;
			switch (c) {
			case ')':
				x = q.pop();
				if (x == '{' || x == '[')
					return false;
				break;

			case '}':
				x = q.pop();
				if (x == '(' || x == '[')
					return false;
				break;

			case ']':
				x = q.pop();
				if (x == '(' || x == '{')
					return false;
				break;
			}
		}
		return (q.isEmpty());
	}
// Driver class to implement business logic
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String Braces to Check whether it's balanceing or not: ");
		BalancingBracket b = new BalancingBracket();
		if (b.inputBraces(sc.nextLine())) {
			System.out.println("Input Bracess is Balanced");
		} else {
			System.out.println("Input Bracess Not Balanced");
		}

	}
}
