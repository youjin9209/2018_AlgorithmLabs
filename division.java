import java.util.Scanner;

public class division {
	static int[] arr;
    static int N;
	static int totalCnt;
    
    public static void print (int index) {
        StringBuilder sb = new StringBuilder(N);
        for (int i = 0; i < index; i++) {
            sb.append(arr[i]).append('+');
        }
        sb.append(arr[index]);
        System.out.println(sb);
        totalCnt++;
    }
    
    public static void div (int n, int index) {
        if (n < 1 || index >= N || index > 0 && n > arr[index-1]) {
            return;
        }
        arr[index] = n;
        int sum = 0;
        for (int i = 0; i < index + 1; i++) {
            sum += arr[i];
        }

        if (sum == N) {
            print(index);
            for (int i = index; i >= 0; i--)
            	div(arr[i]-1, i);
        } else if (sum > N) {
        	div(n-1, index);
        } else {
        	div(n, index+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        div(N-1, 0);
        System.out.println(totalCnt);
    }
}
