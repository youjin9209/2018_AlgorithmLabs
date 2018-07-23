import java.util.Scanner;

public class fractionsum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		long c = sc.nextInt();
		long d = sc.nextInt();
		long A = a*d + b*c;
		long B = b*d;
		for (int i = 2; (i <= A || i <= B); i++) {
			while (B%i == 0 && A%i == 0) {
				A /= i;
				B /= i;
			}
		}
		System.out.print(A + " " + B);
	}
}
