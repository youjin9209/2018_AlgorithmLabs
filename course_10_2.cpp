/*
c++ 로 풀때는 배열 크기 넉넉하게 
*/
#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    int N = 0, M = 0, Q = 0;

    scanf("%d", &N);
    scanf("%d", &M);
    scanf("%d", &Q);

    long long sum[1012][1012];

    for (int i = 0; i <= N; i++) {
        for (int j = 0; j <= M; j++) {
            if (i == 0 || j == 0)
                sum[i][j] = 0;
            else {
                long long num = 0;
                scanf("%lld", &num);
                sum[i][j] = num - sum[i-1][j-1] + sum[i][j-1] + sum[i-1][j];
            }
        }
    }

    for (int i = 1; i <= Q; i++) {
        int a = 0, b = 0, c = 0, d = 0;
        scanf("%d", &a);
        scanf("%d", &b);
        scanf("%d", &c);
        scanf("%d", &d);
        a++;
        b++;
        c++;
        d++;
        long long result = 0;
        result = sum[c][d] - sum[c][b-1] + sum[a-1][b-1] - sum[a-1][d];
        
        printf("%lld\n", result);
    }

    return 0;
}
