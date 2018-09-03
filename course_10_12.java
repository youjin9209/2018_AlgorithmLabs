/* 
최소비용 팰린드롬 
팰린드롬은 추가나 삭제나 똑같다. 

문제
팰린드롬이란, 앞으로 읽으나 뒤로 읽으나 똑같은 문자열을 말한다. 예를 들어, “abcba”, “abccba” 등이 있을 수 있다. 
문자열이 주어질 때, 이를 팰린드롬으로 만들기 위하여 우리는 두 가지 연산을 할 수 있다. 첫 째로는, 하나의 문자를 삽입하는 것이며, 
둘 째로는 기존에 문자열 내에 존재하는 하나의 문자를 삭제하는 것이다. 이 두가지 연산을 통하여 주어진 문자열을 팰린드롬으로 만들 수 있다. 
하나의 문자를 삽입 또는 삭제하기 위해서는 비용이 들어가며, 이는 각 알파벳마다 다르다. 문자열이 주어지고, 각 알파벳을 삽입할 때의 비용, 삭제할 때의 비용이 주어질 때, 
주어진 문자열을 팰린드롬으로 만들기 위한 최소 비용을 출력하는 프로그램을 작성하시오.

입력
첫 번째 줄에 문자열의 길이 N, 문자열 내에 존재하는 문자의 개수 M이 주어진다. (1 ≤ N, M ≤ 1,000)
두 번째 줄에는 문자열이 주어진다. 세 번째 줄부터 각 문자를 삽입, 삭제하는데 드는 비용이 주어진다. 이는 “a b c” 형식으로 주어지며, 
그 뜻은 알파벳 a를 삽입하는데는 b, 삭제하는데는 c 만큼의 비용이 든다는 것을 의미한다. (문자열은 알파벳 소문자로만 구성되어있다.)  

출력
주어진 문자열을 팰린드롬으로 만들기 위한 최소 비용을 출력한다.

예제 입력
4 3
abcb
a 1000 1100
b 350 700
c 200 800

예제 출력
900
*/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class course_10_12 {
	static char[] a;
	static int[][] d;
	static HashMap<Character, Integer> map;
	public static int palindrome(int start, int end) {
		// 1) 종료 
		if (start >= end)
			return 0;
		// 2) 저장된거 가져오기 : memorization 
		if (d[start][end] != -1)
			return d[start][end];
		// 3) 같을 때 
		if (a[start] == a[end])
			return palindrome(start + 1, end - 1);
		else // **4) 다를 때 - 최소의 개수로 추가 : start+1 만 했을 때와 end - 1만 했을 때와 최소 비교 해야함 
			return d[start][end] = Math.min(palindrome(start + 1, end) + map.get(a[start]), palindrome(start, end - 1) + map.get(a[end]));
	}
	
	  public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    int M = sc.nextInt();
	    sc.nextLine();
	    String line = sc.nextLine();
		int len = line.length();
		a = new char[len];
		a = line.toCharArray();
		d = new int[len][len];
		for (int i = 0; i < len; i++) {
			Arrays.fill(d[i], -1);
		}
		map = new HashMap<Character, Integer>();
	    for (int i = 1; i <= M; i++) {
	    	String[] token = sc.nextLine().split(" ");
	    	char c = token[0].charAt(0);
	    	int a = Integer.parseInt(token[1]);
	    	int b = Integer.parseInt(token[2]);
	    	int min = (a > b) ? b : a;
	    	map.put(c, min);
	    }
	    int cnt = 0;
		cnt = palindrome(0, len - 1);
		System.out.println(cnt);
	  }
}
