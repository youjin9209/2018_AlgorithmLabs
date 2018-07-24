import java.util.Scanner;

public class pfactorization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int tempN = N;
		for (int i = 2; i <= tempN; i++) {
			while(N % i == 0) {
				N /= i;
				System.out.println(i);
			}
		}
	}
}
