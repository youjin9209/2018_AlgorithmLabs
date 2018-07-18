/*
Algorithm JOBS Extra course 1
4. 테트리미니
문제 요약 : 1*4로 채울 수 있는 최대점수
주의 : 1) 하.. 밑에 빵꾸 뚫려 있는 경우도 있음 ㅅㅂ
풀이 : 1의개수가 C-1 인 줄의 개수 카운트 (1*4를 심기 시작한 순간부터 4개까지 ) + 1의 개수가 C 인 줄의 개수 (맨밑에서부터 쭉)
*/
import java.util.Arrays;
import java.util.Scanner;

public class tetris {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();
		int[][] a = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		int[] d = new int[C];
		int X = -1;
		int Y = -1;
		int maxJ = -1;
		boolean flag = false;
		for (int j = 0; j < C; j++) {
			int height = 0;
			for (int i = 0; i < R; i++) {
				if (a[i][j] == 1) {
					break;
				}
				if (a[i][j] == 0)
					height++;
			}
			d[j] = height;
			if (maxJ < d[j]) {
				maxJ = d[j];
				X = j+1;
			}
		}
		Arrays.sort(d);
		Y = R-d[C-2];
		if (maxJ < 4) // game over 
			X = -1;
		if (maxJ-d[C-2] > 4) {
			Y = (R-maxJ) + 4;
		}
		
			
		if (X != -1) {
			int resultC = 0;
			for (int i = maxJ-1; i >= (maxJ-4); i--) {
				int c = 0;
				for (int j = 0; j < C; j++) {
					if (a[i][j] == 1)
						c++;
				}
				if (c == C-1)
					resultC++;
			}
			int addResult = 0;
			for (int i = R-1; i >= 0; i--) {
				int ct = 0;
				for (int j = 0; j < C; j++) {
					if (a[i][j] == 1)
						ct++;
				}
				if (ct == C)
					addResult++;
			}
			 Y = resultC + addResult;
		}
		if (X == -1 || Y <= 0)
			System.out.println(0 + " " + 0);
		else 
			System.out.print(X+ " " + Y);
	}
}
