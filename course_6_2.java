/*
2색 칠하기
bfs로 한번 칠해주고 그 다음 dfs로 인접한애들끼리 똑같은 색인지 확인 
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class course_6_2 {
	static ArrayList<Integer>[] a;
	static int N;
	static int[] check; // 0: not arrived 1 : blue 2 : yellow
	static boolean[] arrived;
	static boolean flag = false;
	public static void dfs (int x) {
		if (arrived[x]) return;
		arrived[x] = true;
		for (int y : a[x]) {
			if (!arrived[y]) {
				if (check[x] == check[y]) {
					flag = true;
				}
				dfs(y);
			}
		}
	}
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		check[start] = 1;
		
		while (!queue.isEmpty()) {
			int x = queue.remove();
			for (int y : a[x]) {
				if (check[y] == 0) {
					queue.add(y);
					check[y] = 3 - check[x];
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		a = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		for (int i = 0; i < N; i++) {
			Collections.sort(a[i]);
		}
		check = new int[N];
		bfs(0);
		arrived = new boolean[N];
		dfs(0);
		if (flag)
			System.out.println("NO");
		else
			System.out.println("YES");
	}
}
