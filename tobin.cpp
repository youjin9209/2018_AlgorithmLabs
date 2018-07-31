/*
 Algorithm JOBS Extra course 4
 3. tobin
 문제 : 두 정수 n, k를 입력받아 k개의 1을 가진 n자리 이진 패턴을 출력
 풀이 : 재귀함수
 */
#include <iostream>
#include <stack>
#include <string>
using namespace std;

int arr[32];
int n;
int k;
void bin(int index, int cnt) {
    if (index >= n) {
        if (cnt == k) {
            for (int i = 0; i < n; i++) {
                cout << arr[i];
            }
            cout << '\n';
        }
        return;
    }
    if (cnt < k) {
        arr[index] = 1;
        bin(index+1, cnt+1);
    }
    arr[index] = 0;
    bin(index+1, cnt);
}
int main() {
    cin >> n >> k;
    
    bin(0, 0);
    
    return 0;
}
