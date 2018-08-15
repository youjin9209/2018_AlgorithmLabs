/*
이상한 계산기
- 범위 안에 해당되는거  완전탐색 ㄱ ㄱ 
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class course_6_7 {
	static int N;
	static int[] dist;
	static boolean[] check;
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		check[start] = true;
		while (!queue.isEmpty()) {
			int x = queue.remove();
			if (x < 100000) {
				if (x/3 >= 1 && !check[x/3]) {
					queue.add(x/3);
					check[x/3] = true;
					dist[x/3] = dist[x] + 1;
				}
				if (x*2 < 100000 && !check[x*2]) {
					queue.add(x*2);
					check[x*2] = true;
					dist[x*2] = dist[x] + 1;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dist = new int[100000];
		check = new boolean[100000];
		bfs(1);
		System.out.println(dist[N]);
	}
}
