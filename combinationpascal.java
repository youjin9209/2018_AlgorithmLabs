import java.util.Scanner;

public class combinationpascal {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long m = sc.nextInt();
		// nCm = n!/(m!*(n-m)!)
		long num2 = 0;
		long num5 = 0;
		for (long i = 2; i <= n; i *= 2) {
			num2 += n/i;
		}
		for (long i = 2; i <= m; i *= 2) {
			num2 -= m/i;
		}
		for (long i = 2; i <= n-m; i *= 2) {
			num2 -= (n-m)/i;
		}
		for (long i = 5; i <= n; i *= 5) {
			num5 += n/i;
		}
		for (long i = 5; i <= m; i *= 5) {
			num5 -= m/i;
		}
		for (long i = 5; i <= n-m; i *= 5) {
			num5 -= (n-m)/i;
		}
		long min = num2;
		if (min > num5)
			min = num5;
		System.out.println(min);
	}
}
