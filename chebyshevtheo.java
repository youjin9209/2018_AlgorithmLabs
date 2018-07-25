import java.util.Scanner;

public class chebyshevtheo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int num = sc.nextInt();
			if (num == 0)
				break;
			boolean[] deleted = new boolean[num*2+1];
			deleted[0] = deleted[1] = true;
			for (int i = 2; i*i <= 2*num; i++) {
				if (deleted[i])
					continue;
				for (int j = i+i; j <= 2*num; j += i) {
					deleted[j] = true;
				}
			}
			int cnt = 0;
			for (int i = num+1; i <= 2*num; i++) {
				if (!deleted[i])
					cnt++;
			}
			System.out.println(cnt);
		}
	}
}
