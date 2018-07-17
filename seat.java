/*
Algorithm JOBS Extra course 1

5. 자리배정
문제 요약 : 나선형배열 
어떤게 줄어들고, 늘어나는지 파악 ! 
*/
import java.util.Scanner;

public class seat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();
		int num = sc.nextInt();
		
        int A[][] = new int[R][C];
        int k = 1;
        int c1 = 0, c2 = C-1, r1 = 0, r2 = R-1;

        while (k <= C*R) {
        	for(int j = r2; j >= r1+1; j--) // up
                A[j][c1] = k++;
        	
			for(int i = c1; i <= c2; i++)  // ->
			    A[r1][i] = k++;
            
            for(int j = r1+1; j <= r2; j++) // down
                A[j][c2] = k++;

            for(int i = c2-1; i >= c1+1; i--) // <- 
                A[r2][i] = k++;

			c1++;
			c2--;
			r1++;
			r2--;
        }

        boolean flag = false;
        for (int i = 0; i < R; i++) {
        	for (int j = 0; j < C; j++) {
        		if (A[i][j] == num) {
        			//System.out.println(j + " " + i);
        			System.out.println((j+1)+ " " + (R-(i)));
        			flag = true;
        		}
        	}
        }
        if (!flag)
        	System.out.println(0);
	}
}
