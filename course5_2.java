/*
가장 가까운 공통 조상 찾기
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class course5_2 {
	static int n;
	static ArrayList<Integer>[] a;
	static int[] parent;
	static int[] depth;
	
	public static void dfs(int x, int dep, int par) {
		depth[x] = dep;
		parent[x] = par;
		for (int y : a[x]) {
			if (y != par) {
				dfs(y, dep+1, x);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();
		a = new ArrayList[n];
		parent = new int[n];
		depth = new int[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= n-1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		for (int i = 0; i < n; i++) {
			Collections.sort(a[i]);
		}
		dfs(0, 1, -1);
		int xDepth = depth[X];
		int yDepth = depth[Y];
		// 1) 높이가 똑같아 질때까지 위로 이동 
		while (xDepth > yDepth) { // X가 더깊을경우 
			X = parent[X];// X를 계속 위로 이동시켜 
			xDepth--;
		}
		while (xDepth < yDepth) {
			Y = parent[Y];
			yDepth--;
		}
		// 2) 높이 똑같아 진 후, 공통 조상만날때 까지 위로같이 올라감 
		while (X != Y) {
			X = parent[X];
			Y = parent[Y];
		}
		System.out.println(X);
	}
}
