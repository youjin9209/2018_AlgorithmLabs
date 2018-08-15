/*
전염병
주의 ) bfs 돌때 좌표의 범위 조심 !!!!!!! 
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class course_6_8 {
	static int cnt;
	static boolean[] check;
	static int K;
	static int N;
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		check[start] = true;
		cnt++;
		
		while(!queue.isEmpty()) {
			int x = queue.remove();
			if (x <= N) { // 범위 조심 !!
				if (x/3 >= 1 && !check[x/3]) {
					queue.add(x/3);
					check[x/3] = true;
					cnt++;
				}
				if (x*2 <= N && !check[x*2]) {
					queue.add(x*2);
					check[x*2] = true;
					cnt++;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		check = new boolean[100001];
		bfs(K);
		System.out.println(N-cnt);
	}
}
