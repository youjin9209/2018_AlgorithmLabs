/*
띄어쓰기를 모두 제거
<예제 입력>
Please do not touch anything
<예제 출력>
Pleasedonottouchanything
*/
import java.util.Scanner;

public class course_7_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] token = sc.nextLine().split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < token.length; i++) {
			sb.append(token[i]);
		}
		System.out.println(sb);
	}
}
