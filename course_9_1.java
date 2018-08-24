import java.util.Arrays;
import java.util.Scanner;

public class course_9_1 {
	static int[] a;
	static int N;
	public static String binarySearch(int num) {
		int left = 0;
		int right = a.length - 1;
		int mid;
		while (left <= right) {
			mid = (left + right)/2;
			if (num == a[mid])
				return "1";
			else if (num < a[mid]) {
				right = mid - 1;
			} else if (num > a[mid]) {
				left = mid + 1;
			}
		}
		return "0";
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= M; i++) {
			int num = sc.nextInt();
			sb.append(binarySearch(num)).append("\n");
		}
		System.out.println(sb);
	}

}
