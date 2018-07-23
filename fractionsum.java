/*
Algorithm JOBS Extra course 3
11. 분수합
문제 : 두 분수의 합을 기약분수로 만들기
풀이 : if 가 아니라 while
주의할 예제
1 2
1 2
*/
import java.util.Scanner;

public class fractionsum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		long c = sc.nextInt();
		long d = sc.nextInt();
		long A = a*d + b*c;
		long B = b*d;
		for (int i = 2; (i <= A || i <= B); i++) {
			while (B%i == 0 && A%i == 0) {
				A /= i;
				B /= i;
			}
		}
		System.out.print(A + " " + B);
	}
}
