/*
숫자 탐색
- HashSet으로 숫자 저장 및 검색
- 왠만해서는 출력할때 StringBuilder 쓰자
예제)
입력
5
6 3 2 10 -10
8
10 9 -5 2 3 4 5 -10
출력
1
0
0
1
1
0
0
1
*/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class course_8_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashSet<Integer> h = new HashSet<Integer>();
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			h.add(num);
		}
		StringBuilder sb = new StringBuilder();
		int M = sc.nextInt();
		while (M-- > 0) {
			int m = sc.nextInt();
			sb.append(h.contains(m) ? 1 : 0).append("\n");
		}
		System.out.println(sb);
	}
}
