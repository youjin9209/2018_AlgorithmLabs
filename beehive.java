
/*
Algorithm JOBS Extra course 3
2. 벌집
문제 풀이 : 군수열 
해결 : 
cnt = 1 / 2 / 3 / 4 
n = 1/ 2~7 / 8~19 / 20~37 
*/
import java.util.Scanner;

public class beehive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 1;
		int range = 1;
		int num = 1;
		while(true) {
			if (range >= N) {
				System.out.println(cnt);
				break;
			}
			num = cnt*6;
			cnt++;
			range += num;
		}	
	}
}
