/*
Algorithm JOBS Extra course 2

4. 룩을 피해라
문제 : 2->1 로 가야함 
주의 : 직선만 가능하고, 꺾으면 안된다.
그리고 !!! 장애물이 3과 2도 될 수 있다 !!! (2가 두개 있을 경우에 2끼리도 서로 장애물 가능)
느낀점1 : 시뮬레이션 문제는 예외처리 test case (주의해야 할점들을 모아놓은거) 가지고 마지막에 계속 테스트 해봐야 함 !! 
느낀점2 : break, continue, return 의 중요성 ㅠㅠ ! boolean flag 도 !! 
*/
import java.util.Scanner;

public class rook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[8][8];
		int kingX = 0;
		int kingY = 0;
		int[] rookX = new int[2];
		int[] rookY = new int[2];
		int idx1 = 0;
		int idx2 = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					kingX = i;
					kingY = j;
				} else if (map[i][j] == 2) {
					rookX[idx1++] = i;
					rookY[idx2++] = j;
				}
			}
		}
		int idx;
		boolean chance = false;
		boolean finalFlag = false;
		if (idx1 == 0) { // 상대방의 룩이 하나도 없는 경우 
			System.out.println(0);
		} else {
			for (idx = 0; idx < 2; idx++) {
				//chance = false;
				// 1. 같은 행일 때 : 열만 움직여 주면 됨 
				int rX = rookX[idx];
				int rY = rookY[idx];
				if (kingX == rX) {
					if (kingY < rY) { // 왕이 더 왼쪽에 있을 때 
						while(kingY <= rY) {
							rY--;
							if (map[rX][rY] == 3 || map[rX][rY] == 2) {
								if (idx == 0) {
									chance = true;
									break;
								} else if (idx == 1 && map[rX][rY] == 2) {
									//chance = true;
									System.out.println(0);
									return;
								} else {
									System.out.println(0);
									return;
								}
							}
							else if (map[rX][rY] == 1) {
								System.out.println(1);
								finalFlag = true;
								return;
							}
						}
						if (chance)
							continue;
					} else if (kingY > rY) { // 왕이 더 오른쪽에 있을 때 
						while(kingY >= rY) {
							rY++;
							if (map[rX][rY] == 3 || map[rX][rY] == 2) {
								if (idx == 0) {
									chance = true;
									break;
								} else if (idx == 1 && map[rX][rY] == 2) {
									//chance = true;
									System.out.println(0);
									return;
								} else {
									System.out.println(0);
									return;
								}
							}
							else if (map[rX][rY] == 1) {
								System.out.println(1);
								finalFlag = true;
								return;
							}
						}
						if (chance)
							continue;
					}
				} // 2. 같은 열일  때 : 행 만 움직여 주면 됨 
				else if (kingY == rY) {
					if (kingX < rX) { // 왕이 더 위 쪽에 있을 때 
						while(kingX <= rX) {
							rX--;
							if (map[rX][rY] == 3 || map[rX][rY] == 2) {
								if (idx == 0) {
									chance = true;
									break;
								} else if (idx == 1 && map[rX][rY] == 2) {
									//chance = true;
									System.out.println(0);
									return;
								} else {
									System.out.println(0);
									return;
								}
							}
							else if (map[rX][rY] == 1) {
								System.out.println(1);
								finalFlag = true;
								return;
							}
						}
						if (chance)
							continue;
					} else if (kingX > rX) { // 왕이 더 아래 쪽에 있을 때 
						while(kingX >= rX) {
							rX++;
							if (map[rX][rY] == 3 || map[rX][rY] == 2) {
								if (idx == 0) {
									chance = true;
									break;
								} else if (idx == 1 && map[rX][rY] == 2) {
									//chance = true;
									System.out.println(0);
									return;
								} else {
									System.out.println(0);
									return;
								}
							}
							else if (map[rX][rY] == 1) {
								System.out.println(1);
								finalFlag = true;
								return;
							}
						}
						if (chance)
							continue;
					}
				}
			}
		}
		if (idx1 == 2) {
			if (chance) {
				System.out.println(0);
				return;
			}
			if (!finalFlag) {
				System.out.println(0);
				return;
			}
		} else if (idx1 >= 1) {
			if (!finalFlag) {
				System.out.println(0);
				return;
			}
		}
	}
}
