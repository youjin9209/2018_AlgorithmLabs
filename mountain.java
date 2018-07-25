import java.util.Scanner;

public class mountain {
	public static String sb(int n) {
		String result = "";
		if (n == 1)
			return "1";
		else 
			result = sb(n-1) + Integer.toString(n) + sb(n-1);
		
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(sb(N));		
	}
}
