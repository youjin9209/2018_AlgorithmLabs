/*
예제) 
(()[[]])([])
출력)
28
단, 올바르지 않은 괄호일경우  0 출력 
*/
import java.util.Scanner;
import java.util.Stack;

public class course_8_7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		String line = sc.nextLine();
		int len = line.length();
		int sum = 0;
		for (int i = 0; i < len; i++) {
			char token = line.charAt(i);
			if (token == '(') { // -1
				stack.push(-1);
			} else if (token == ')') {
				if (i > 0 && line.charAt(i-1) == '(') { // 바로 직전 == '('일 때 
					stack.pop();
					stack.push(2);
				} else {
					int num2 = 0;
					while (!stack.isEmpty() && stack.peek() != -1) {
						num2 += stack.pop();
					}
					if (!stack.isEmpty() && stack.peek() == -1) {
						stack.pop();
						num2 *= 2;
						stack.push(num2);
					}
				}
			} else if (token == '[') { // -2
				stack.push(-2);
			} else if (token == ']') {
				if (i > 0 && line.charAt(i-1) == '[') { // 바로 직전 == '['일 때 
					stack.pop();
					stack.push(3);
				} else {
					int num2 = 0;
					while (!stack.isEmpty() && stack.peek() != -2) {
						num2 += stack.pop();
					}
					if (!stack.isEmpty() && stack.peek() == -2) {
						stack.pop();
						num2 *= 3;
						stack.push(num2);
					}
				}
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek() == -1 || stack.peek() == -2) {
				System.out.println(0);
				System.exit(0);
			}
			sum += stack.pop();
		}
		if (sum <= 0) {
			System.out.println(0);
		} else {
			System.out.println(sum);
		}
	}
}
