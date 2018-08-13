import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class inequel {
	static int N;
    static char[] op = new char[20];
    static boolean[] check;
    static ArrayList<String> result;
    
    static boolean validate(String num) {
    	for (int i = 0; i < N; i++) {
    		if (op[i] == '<') {
    			if (num.charAt(i) > num.charAt(i+1))
    				return false;
    		} else if (op[i] == '>') {
    			if (num.charAt(i) < num.charAt(i+1))
    				return false;
    		}
    	}
    	return true;
    }
    static void dfs(int index, String num) {
    	if (index == N+1) {
    		if (validate(num)) { // 숫자 다 채우고나서 validate 만족했으면 넣어주기 
    			result.add(num);
    		}
    		return;
    	}
    	for (int i = 0; i <= 9; i++) {
    		if (check[i]) // 방문한건지 check 
    			continue;
    		check[i] = true;
    		dfs(index + 1, num + Integer.toString(i));
    		check[i] = false;
    	}
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            op[i] = sc.next().charAt(0);
        }
        check = new boolean[10]; // 0 ~ 9 까지 한번 탐색했음 check  
        result = new ArrayList<>(); 
        dfs(0, "");
        Collections.sort(result);
        int length = result.size();
        System.out.println(result.get(length-1)); //  max 
        System.out.println(result.get(0)); // min
    }
}
