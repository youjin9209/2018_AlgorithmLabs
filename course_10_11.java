/*
팰린드롬 만들기 
- 최소 개수로 추가 

예제 입력
adcba
예제 출력
2

예제 입력
abccbdbac
예제 출력
3
*/
import java.util.Arrays;
import java.util.Scanner;

public class course_10_11 {
	static char[] a;
	static int[][] d;
	public static int palindrome(int start, int end) {
		// 1) 종료 
		if (start >= end)
			return 0;
		// 2) 저장된거 가져오기 : memorization 
		if (d[start][end] != -1)
			return d[start][end];
		// 3) 같을 때 
		if (a[start] == a[end])
			return palindrome(start + 1, end - 1);
		else // **4) 다를 때 - 최소의 개수로 추가 : start+1 만 했을 때와 end - 1만 했을 때와 최소 비교 해야함 
			return d[start][end] = 1 + Math.min(palindrome(start + 1, end), palindrome(start, end - 1));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int len = line.length();
		a = new char[len];
		a = line.toCharArray();
		d = new int[len][len];
		for (int i = 0; i < len; i++) {
			Arrays.fill(d[i], -1);
		}
		int cnt = 0;
		cnt = palindrome(0, len - 1);
		System.out.println(cnt);
	}
}
