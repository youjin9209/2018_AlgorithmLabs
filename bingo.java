/*
Algorithm JOBS Extra course 1

빙고
문제요약 : 가로, 세로, 왼쪽 대각선, 오른쪽 대각선
개수의 합이 3이 먼저 될경우 이김
주의 : 하나의 수를 체크했을 때 (색칠?) 줄이 2개가 동시에 뺌 !!!! 하고 생길 수 있음 !! ㅠㅠ 이거때메 디지는줄 ㅎㅎ 
*/
import java.util.Scanner;
 
public class bingo {
    public static int checkBingo(int[][] a, int x, int y) {
        int rstCount = 0;
        // 1 ) i
        for (int i = 0; i < 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (a[i][j] == 0)
                    cnt++;
            }
            if (cnt == 5)
                rstCount++;
        }
        // 2 ) j
        for (int j = 0; j < 5; j++) {
            int cnt = 0;
            for (int i = 0; i < 5; i++) {
                if (a[i][j] == 0)
                    cnt++;
            }
            if (cnt == 5)
                rstCount++;
        }
        // 3 ) i+j = 4
        for (int i = 0; i < 1; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (a[4-j][j] == 0)
                    cnt++;
            }
            if (cnt == 5)
                rstCount++;
        }
        // 4 ) i == j
        for (int i = 0; i < 1; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (a[j][j] == 0)
                    cnt++;
            }
            if (cnt == 5)
                rstCount++;
        }
        
        return rstCount;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int num = 0;
        int i = 1;
        while (i <= 25) {
            num = sc.nextInt();
            for (int k = 0; k < 5; k++) {
                for (int p = 0; p < 5; p++) {
                    if (a[k][p] == num) {
                        a[k][p] = 0;
                    }
                    // 한번체크했을때 2줄이 빙고될수도 있으니까 ! 3보다 크거나 같아야함 
                    if (checkBingo(a, k, p) >= 3) {
                        System.out.println(i);
                        return;
                    }
                }
            }
            i++;
        }
    }
}
