/*
팰린드롬 조사

예제 입력
abcba
예제 출력
YES

예제 입력
abcbd
예제 출력
NO
*/
import java.util.Scanner;

public class course_7_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int len = line.length();
		boolean flag = true;
		for (int i = 0; i < len/2; i++) {
			if (line.charAt(i) != line.charAt(len-i-1)) {
				flag = false;
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println("YES");
	}
}
