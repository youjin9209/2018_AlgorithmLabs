/* Course 4-5
dessert.java
<문제>
농부 존은 소들의 저녁식사 줄 세우는 새로운 방법을 개발 했다. 
N(1~15)마리의 소들을 순서대로 세 워놓은 후, 각 소들 사이에 +, - , . 셋 중 1가지가 써져있는 냅킨을 배치해서 최종 결과가 0 이 되게 해야 하는 것이다. 
점(.)이 써져있는 냅킨을 통해 더 큰 수를 만들 수 있게 된다. 아래와 같은 경우를 보자. (ps .이 써져있는 냅킨은 '공백'이라고 생각하면 된다.)
1-2.3-4.5+6.7
이와 같은 배치는 1-23-45+67 을 나타낸다. 결과는 0 이다.
(주의!!!) 10.11은 1011 로 해석된다.

<입력>
첫 째 줄에는 소들의 수 N이 입력된다.

<출력>
처음 20줄에 대해 가능한 20가지 답을 출력하는데, 사전 순으로 앞선 것을 출력한다. 
순서는 +가 가장 앞서고 -와 . 이 순서대로 뒤따른다. 답이 20개 미만이면 가능한 답을 각 숫자와 문자 사이에 공백을 두고 출력한다. 
모두 출력한다. 마지막 줄에는 가능한 답의 총 가지수를 출력한다.

<예제 입력>
7
<예제 출력>
1 + 2 - 3 + 4 - 5 - 6 + 7
1 + 2 - 3 - 4 + 5 + 6 - 7
1 - 2 + 3 + 4 - 5 + 6 - 7
1 - 2 - 3 - 4 - 5 + 6 + 7 
1 - 2 . 3 + 4 + 5 + 6 + 7 
1 - 2 . 3 - 4 . 5 + 6 . 7
6
*/
import java.util.Scanner;

public class dessert {
	static long[] arr;
    static int N;
	static int totalCnt;
    static char[] op;
    static char[] resultOp;
    public static void print (char[] resultOp) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N-1; i++) {
            sb.append(i+1).append(' ').append(resultOp[i]).append(' ');
        }
        sb.append(N);
        if (totalCnt <= 19)
        	System.out.println(sb);
        totalCnt++;
    }
    public static long dot (char[] result, int idx) { //3) dot 으로 되어있는거 일괄 계산 
    	long ans = 0;
    	long[] dotArr = new long[N];
    	int i = 0;
    	dotArr[i] = idx+1;
    	idx++;
    	while (idx <= N-1) {
    		if (result[idx-1] != '.') {
    			break;
    		}
    		i++;
    		dotArr[i] = idx+1;
    		idx++;
    	}
    	if ((N == 15) && (i >= 13)) {
    		return -111111111;
    	}
    	String s = "";
    	// 10, 11 -> 1011 이 되어야한다 !! 
    	if (i <= 14) {
	    	for (int k = 0; k <= i; k++) {
	    		s += Long.toString(dotArr[k]);
	    	}
	    	ans = Long.parseLong(s);
    	}
    	
    	return ans;
    }
    public static long cal (char[] result) {
    	long ans = 1;
    	for (int i = 0; i < N-1; i++) {
    		if (result[i] == '+') {
    			if (i < N-2) {
	    			if (result[i+1] == '.') {
	    				ans += dot(result, i+1);
	    			}
	    			else
	    				ans += (i+2);
    			}
    			else
    				ans += (i+2);
    		}
    		if (result[i] == '-') {
    			if (i < N-2) {
	    			if (result[i+1] == '.') {
	    				int dotIdx = i+1;
	    				ans -= dot(result, dotIdx);
	    			}
	    			else
	    				ans -= (i+2);
    			}
    			else
    				ans -= (i+2);
    		}
    		if (i == 0 && result[i] == '.') {
    			ans = 0;
    			ans += dot(result, i);
    		}
    	}
    	return ans;
    } 
    public static void div (int opIdx) {
        if (opIdx > N-2) {
        	// 2 ) 연산자 다 채운 후 계산 
        	if (cal(resultOp) == 0) {
        		print(resultOp);
        	}
            return;
        }
        // 1 ) 연산자 다 채우기  
        for (int i = 0; i < 3; i++) { 
        	resultOp[opIdx] = op[i];
        	div(opIdx+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new long[N+1];
        op = new char[]{'+', '-', '.'};
        resultOp = new char[N-1];
        for (int i = 1; i <= N; i++) {
        	arr[i] = i;
        }
        div(0);
        System.out.println(totalCnt);
    }
}
