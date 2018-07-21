import java.util.Scanner;

public class beehive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 1;
		int range = 1;
		int num = 1;
		while(true) {
			if (range >= N) {
				System.out.println(cnt);
				break;
			}
			num = cnt*6;
			cnt++;
			range += num;
		}	
	}
}
