import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer>[] a;
	static boolean[] check;
	static int cnt = 0;
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		check[start] = true;
		
		while (!queue.isEmpty()) {
			int x = queue.remove();
			for (int y : a[x]) {
				if (!check[y]) {
					check[y] = true;
					queue.add(y);
					cnt++;
				}
			}
 		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		a = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			a[x].add(y);
			a[y].add(x);
		}
		for (int i = 1; i <= n; i++) {
			Collections.sort(a[i]);
		}
		check = new boolean[n+1];
		bfs(1);
		System.out.println(cnt);
	}
}
