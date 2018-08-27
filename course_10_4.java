/*
해결 
최대한 초기화시킬수 있을 만큼 초기화 시키기 !!! 
문제
N개의 카드가 주어지고, 각각은 자연수의 점수를 가진다. 철수는 이제 이 카드를 가져감으로써 카드에 적혀있는 수 만큼의 점수를 얻는다. 
단, 카드를 가져갈 때 한가지 규칙이 있는데, 이는 연속하여 3개의 카드는 가져갈 수 없다는 것이다. 
예를 들어, 6개의 카드 “1 3 5 2 7 3”가 주어질 경우, 3+5+7+3 = 18 만큼의 점수를 얻는 것이 최대이다. 
N개의 카드가 주어질 때, 얻을 수 있는 점수의 최댓값을 출력하는 프로그램을 작성하시오.

예제 입력
6
1 3 5 2 7 3

예제 출력
18
*/
import java.util.Scanner;

public class course_10_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] a = new long[N+1];
		for (int i = 1; i <= N; i++) {
			a[i] = sc.nextLong();
		}
		long[] d = new long[N+1];
		d[1] = a[1];
		d[2] = Math.max(a[1], Math.max(a[2], a[1] + a[2]));
		for (int i = 3; i <= N; i++) {
			d[i] = a[i];
			if (i-1 >= 0 && d[i] < d[i-1])
				d[i] = d[i-1];
			if (i-2 >= 0 && d[i] < d[i-2] + a[i])
				d[i] = d[i-2] + a[i];
			if (i-3 >= 0 && d[i] < d[i-3] + a[i-1] + a[i])
				d[i] = d[i-3] + a[i-1] + a[i];
		}
		System.out.println(d[N]);
	}
}
