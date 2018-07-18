/*
Algorithm JOBS Extra course 2

1. 최댓값
문제 : 최대값이 같을 경우에는 출력할 최소X,Y 좌표값 갱신 안한다. 왜냐면
어짜피 최소 행/ 열만 구하면 되는거니까 갱신할 필요 없음 ! 
*/
import java.util.Scanner;

public class maxofarr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int N = 9;
		int[][] a = new int[N][N];
		int x = 0;
		int y = 0;
		int minX = 11;
		int minY = 11;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = sc.nextInt();
				// 최대값끼리같을 때는 Count안한다. 어짜피 최소 행/  최소 열 구하는거니까 
				if (max < a[i][j]) { // 최대값 찾기 
					max = a[i][j];
					x = i+1;
					y = j+1;
					minX = x;
					minY = y;
					if (minX > x) {
						minX = x;
						if (minY >= y)
							minY = y;
					}
				}
			}
		}
		System.out.println(max);
		System.out.println(minX + " " + minY);
	}
}
