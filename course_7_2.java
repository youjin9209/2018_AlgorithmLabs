/*
대 <-> 소문자

예제 입력
hELLO wORLD!
예제 출력
Hello World!
*/
import java.util.Scanner;

public class course_7_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < line.length(); i++) {
			char token = line.charAt(i);
			if (Character.isUpperCase(token))
				sb.append(Character.toString(token).toLowerCase());
			else if (Character.isLowerCase(token))
				sb.append(Character.toString(token).toUpperCase());
			else
				sb.append(Character.toString(token));
		}
		System.out.println(sb);
	}
}
