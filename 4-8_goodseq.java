/*
최적화 시키기 ! 
*/
import java.util.Scanner;

public class goodseq {
	static int[] arr;
	static int[] num;
	static int min = 4;
	static int N;
	public static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]);
		}
		System.out.println(sb);
	}
	public static boolean check(int index) { 
		if (index <= 20 || N <= 3) {
			for (int i = 1; i <= index; i++) {
				if (arr[i] == arr[i-1])
					return false;
			}
		}
		if (N >= 4) { // 자리수 1 ~ N/2 인접안하는지 확인 
			for (int length = 1; length <= (N/2); length++) { // 덩어리 길이 
				for (int i = 0; i <= N - 2*length; i++) { // 시작점 : 가장 큰 i 를 x 라고 했을 때  ( x + length + length - 1 = N - 1 )
					int flag = 0;
					for (int j = i; j <= i + length-1; j++) { // 비교
						if (arr[j] == arr[j+length]) {
							flag++;
						}
					}
					if (flag == length)
						return false;
				}
			}
		}
		return true;
	}
	public static void goodseq(int index) {
		if (index > N-1) {
			if (check(index-1)) {
				print();
				System.exit(0);
        	}
            return;
        }
		for (int i = 0; i < 3; i++) { // 1,2,3 순서대로 하니까 먼저 check 에서 통과됐으면 break  
        	arr[index] = num[i];
        	goodseq(index+1);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		num = new int[]{1,2,3};
		goodseq(0);
	}
}
