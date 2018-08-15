/*
이분 그래프 판별
풀이 : dfs로 색깔 정보 넣어주고 -> arraylist 인접한거 loop돌면서 색깔 같은지 확인 
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class course_6_3 {
	static ArrayList<Integer>[] a;
	static int N;
	static int[] check; // 0: not arrived 1 : blue 2 : yellow
	static boolean[] arrived;
	
	public static void dfs (int x) {
		if (x == 1)
			check[x] = 1;
		for (int y : a[x]) {
			if (check[y] == 0) {
				check[y] = 3 - check[x];
				dfs(y);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		a = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(a[i]);
		}
		check = new int[N+1];
		dfs(1);
		boolean flag = true;
		for (int i = 1; i <= N; i++) {
			for (int j : a[i]) {
				if (check[i] == check[j])
					flag = false;
			}
		}
		if (flag)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
