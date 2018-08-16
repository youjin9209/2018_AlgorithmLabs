/*
미로 찾기
*/
#include <iostream>
#include <queue>
using namespace std;

int N,M;
int a[1001][1001];
bool check[1001][1001];
int dist[1001][1001];
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};

void bfs() {
    queue<pair<int,int> > q;
    q.push(make_pair(N-1, 0));
    check[N-1][0] = true;
    
    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                if (check[nx][ny] == false && a[nx][ny] == 0) {
                    q.push(make_pair(nx, ny));
                    dist[nx][ny] = dist[x][y] + 1;
                    check[nx][ny] = true;
                }
            }
        }
    }
}

int main() {
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> a[i][j];
        }
    }

    bfs();
    
    cout << dist[0][M-1] << '\n';
    return 0;
}
