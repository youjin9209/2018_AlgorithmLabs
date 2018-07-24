/*
Algorithm JOBS Extra course 3
13. 소인수분해 
문제 : 소인수분해하기
풀이 : 소수 리스트 굳이 구할 필요 없음 
*/
import java.util.Scanner;

public class pfactorization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int tempN = N;
		for (int i = 2; i <= tempN; i++) {
			while(N % i == 0) {
				N /= i;
				System.out.println(i);
			}
		}
	}
}
