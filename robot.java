/*
회전판과 로봇
1) 시계 / 반시계 - -> , <- 방향 처리 !!! 
2) 장애물 만났을 때 처리 - 이전좌표 저장하고 (빼줌)
*/
//package algorithm_main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 0;
		while (T-- > 0) {
			t++;
			int N = sc.nextInt(); // 가
			int M = sc.nextInt(); // 세 
			int X = sc.nextInt(); // 가로 위치 
			int Y = sc.nextInt(); // 세로 위치 
			int[][] map = new int[M+2][N+2];
			for (int i = 1; i <= M; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = sc.nextInt(); // 그리드 값들 
				}
			}
			int K = sc.nextInt(); // 회전판 칸 개수 
			int[] a = new int[K]; 
			for (int i = 0; i < K; i++) {
				a[i] = sc.nextInt(); // 회전판 값들 
			}
			int L = sc.nextInt(); // 명령횟수 
			int rotStartIdx = 0; // 회전판 시작 Index 
			int[] dy = {1, -1, 0, 0}; // S N E W
			int[] dx = {0, 0, 1, -1};
			// 시작점 초기화 
			int resultPoint = map[Y][X];
			int ny = Y;
			int nx = X;
			map[Y][X] = 0; 
			for (int i = 1; i <= L; i++) {
				String token = sc.next(); // 이동 방향 
				int rotDir = sc.nextInt();// 회전 방향 
				int rotCnt = sc.nextInt();// 회전시키는칸수 

				if (rotDir == 1) { // 시계 방향 (<- 방향 )
					rotStartIdx -= rotCnt;
					while (rotStartIdx <= 0) {
						if (rotStartIdx > 0)
							break;
						rotStartIdx += K;
					}
					rotStartIdx %= K;
				} else if (rotDir == 2) { // 반 시계 방향  (-> 방향 )
					rotStartIdx += rotCnt;
					rotStartIdx %= K;
				}
				int moveCnt = a[rotStartIdx];
				int dir = 0;
				if (token.equals("S")) { // 남 0
					dir = 0;
				} else if (token.equals("N")) { // 북 1 
					dir = 1;
				} else if (token.equals("E")) { // 동 2 
					dir = 2;
				} else if (token.equals("W")) { // 서 3
					dir = 3;
				}
				for (int k = 1; k <= moveCnt; k++) {
					ny += dy[dir];
					nx += dx[dir];
					
					if (ny >= 1 && ny <= M && nx >= 1 && nx <= N) { // 경계 안에 있어야 하고 
						if (map[ny][nx] == -1) { // 장애물 만났을 때 전에 좌표로 다시 빼주고 나온다 
								ny -= dy[dir];
								nx -= dx[dir];
							  break;
						}
						if (map[ny][nx] != -1) { // 장애물이 없어야함 
							resultPoint += map[ny][nx];
							map[ny][nx] = 0;
						}
					} else {
						ny -= dy[dir];
						nx -= dx[dir];
						break;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#"+t+" ");
			sb.append(resultPoint +" ");
			sb.append(nx + " ");
			sb.append(ny);
			System.out.println(sb);
		}
	}
}
