/*
Algorithm JOBS Extra course 4
11. bfs와 dfs
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
	public static ArrayList<Integer>[] a;
	public static boolean[] check;
	public static void dfs(int x) {
		if (check[x])
			return;
		check[x] = true;
		System.out.print((char)(x+'A'));
		for (int y : a[x]) {
			if (!check[y]) {
				dfs(y);
			}
		}
	}
	public static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(x);
		check[x] = true;
		
		while (!queue.isEmpty()) {
			int nx = queue.remove();
			System.out.print((char)(nx+'A'));
			for (int y : a[nx]) {
				if (!check[y]) {
					check[y] = true;
					queue.add(y);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int E = sc.nextInt();
		a = new ArrayList[26];
		for (int i = 0; i < 26; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < E; i++) {
			int x = sc.next().charAt(0) - 'A';
			int y = sc.next().charAt(0) - 'A';
			a[x].add(y);
			a[y].add(x);
		}
		int start = sc.next().charAt(0) - 'A';
		for (int i = 0; i < 26; i++) {
			Collections.sort(a[i]);
		}
		check = new boolean[26];
		dfs(start);
		System.out.println();
		check = new boolean[26];
		bfs(start);
	}
}
