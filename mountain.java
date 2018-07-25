/*
Algorithm JOBS Extra course 4
2. mountain 
문제 : 봉우리 수열 출력
풀이 : 재귀함수 - 반복되는거 찾고 / 반등하는 지점: 맨 
*/
import java.util.Scanner;

public class mountain {
	public static String sb(int n) {
		String result = "";
		if (n == 1)
			return "1";
		else 
			result = sb(n-1) + Integer.toString(n) + sb(n-1);
		
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(sb(N));		
	}
}
