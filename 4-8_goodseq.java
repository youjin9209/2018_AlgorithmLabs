/*
<문제>
숫자 1, 2, 3으로만 이루어지는 수열이 있다. 임의의 길이의 인접한 두 개의 부분 수열이 동일한 것 이 있으면, 그 수열을 나쁜 수열이라고 부른다. 
그렇지 않은 수열은 좋은 수열이다.
다음은 나쁜 수열의 예이다.
33
32121323
123123213
다음은 좋은 수열의 예이다.
2
32
32123
1232123
길이가 N인 좋은 수열들을 N자리의 정수로 보아 그중 가장 작은 수를 나타내는 수열을 구하는 프로그램 을 작성하라. 
예를 들면, 1213121과 2123212는 모두 좋은 수열이지만 그 중에서 작은 수를 나타내는 수 열 1213121이다.
 
<입력>
입력은 숫자 N하나로 이루어진다. N은 1 이상 80 이하이다.
<출력>
첫 번째 줄에 1, 2, 3으로만 이루어져 있는 길이가 N인 좋은 수열들 중에서 가장 작은 수를 나타내 는 수열만 출력한다. 
수열을 이루는 1, 2, 3들 사이에는 빈칸을 두지 않는다.

<예제 입력>
7
<예제 출력>
1213121
*/
package algorithm_main;
import java.util.*;

public class Main {
	static int N;
	
	public static boolean check (String s) {
	    int len = s.length();
	    int start = len-1;
	    int end = len;
	    for (int width = 1; width <= len/2; width++) { // width : 비교해줄 문자열의 덩어리 길이 
	    	String left = s.substring(start-width, end-width);
	    	String right = s.substring(start, end);
	        if (left.equals(right)) {
	            return false;
	        }
	        start -= 1; //width가 1씩 늘어나니까 오른쪽 덩어리 시작점을 하나씩 왼쪽으로 댕겨야지 ! 
	    }
	    return true;
	}
	public static void goodseq (int length, String str) {
	    if (length == N) {
			System.out.println(str);
			System.exit(0);
	    } else {
			for (int i = 1; i <= 3; i++) { // 1,2,3 넣기 - 완전탐색 : 이전 거에 붙여주면서 ! 
			    if (check(str+i)) {
			    	goodseq(length+1, str+i);
			    }
			}
	    }
	}
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		goodseq(1, "1");
	}
}
