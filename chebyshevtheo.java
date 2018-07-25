/*
Algorithm JOBS Extra course 3
14. 베르트랑-체비쇼프 정리
문제 : 에라토스테네스의 체 사용해서 소수 구하기
*/
import java.util.Scanner;

public class chebyshevtheo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int num = sc.nextInt();
			if (num == 0)
				break;
			boolean[] deleted = new boolean[num*2+1];
			deleted[0] = deleted[1] = true;
			for (int i = 2; i*i <= 2*num; i++) {
				if (deleted[i])
					continue;
				for (int j = i+i; j <= 2*num; j += i) {
					deleted[j] = true;
				}
			}
			int cnt = 0;
			for (int i = num+1; i <= 2*num; i++) {
				if (!deleted[i])
					cnt++;
			}
			System.out.println(cnt);
		}
	}
}
