/*
Algorithm JOBS Extra course 1

3. 숫자야구
문제요약 : 가능성있는 수의 개수를 구하기
풀이 : 123~987 (서로다른 세자리 수) 와 input값을 다 비교한다
주의 : 서로 다른 세수여야 하니까 걸러내야함 !! 특히 0 있는것도 걸러내야함 
*/
import java.util.Scanner;

public class baseball {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] resultArr = new int[3]; // 가능성이 있는 수를 담을
		int[] inputArr = new int[3]; // 민혁이가 말한수를 담을 거 
		int resultCnt = 0;
		
		int N = sc.nextInt();
		int[] ip = new int[N];
		int[] iS = new int[N];
		int[] iB = new int[N];
		for (int i = 0; i < N; i++) {
			ip[i] = sc.nextInt();
			iS[i] = sc.nextInt();
			iB[i] = sc.nextInt();
		}
		for (int i = 123; i <= 987; i++) {
			// 1. 서로 다른 수 만 걸러내기 + 0 걸러내기 
			resultArr[0] = i/100; 
			resultArr[1] = (i%100)/10;
			resultArr[2] = (i%100)%10;
			if (resultArr[0] == resultArr[1] || resultArr[0] == resultArr[2] || resultArr[1] == resultArr[2])
				continue;
			if (resultArr[0] == 0 || resultArr[1] == 0 || resultArr[2] == 0)
				continue;
			// 2. 걸러낸 수와 input값과 비교하여 S, B 일치하는지 확인 -> cnt++;
			// cnt == N -> 최종 resultCnt++;
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				int inputNum = ip[j];
				int S1 = iS[j];
				int B1 = iB[j];
				inputArr[0] = inputNum/100; 
				inputArr[1] = (inputNum%100)/10;
				inputArr[2] = (inputNum%100)%10;
				int S2 = 0;
				int B2 = 0;
				// Strike 
				for (int p = 0; p < 3; p++) {
					if (inputArr[p] == resultArr[p])
						S2++;
				}
				// Ball
				//if (inputArr[0] != resultArr[0] && inputArr[1] != resultArr[1] && inputArr[2] != resultArr[2]) {
					if (inputArr[0] == resultArr[1] || inputArr[0] == resultArr[2])
						B2++;
					if (inputArr[1] == resultArr[2] || inputArr[1] == resultArr[0])
						B2++;
					if (inputArr[2] == resultArr[0] || inputArr[2] == resultArr[1])
						B2++;
				//}
				if (S1 == S2 && B1 == B2)
					cnt++;
			}
			if (cnt == N)
				resultCnt++;
		}
		System.out.println(resultCnt);
	}
}
