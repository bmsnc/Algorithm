package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_5212 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] data = new char[R][C];
        char[][] newData = new char[R][C];
        String line;
        for (int i = 0; i < R; i++) {
            line = br.readLine();
            for (int j = 0; j < C; j++) {
                data[i][j] = line.charAt(j);
            }
        }

        int maxX = -1, maxY = -1, minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (data[i][j] == '.') {
                    newData[i][j] = '.';
                    continue;
                }
                int nx, ny, count = 0;
                for (int k = 0; k < 4; k++) {
                    nx = i + dx[k];
                    ny = j + dy[k];
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C || data[nx][ny] == '.') count++;
                }
                newData[i][j] = count >= 3 ? '.' : 'X';
                if (count < 3){
                    maxX = Math.max(maxX, i);
                    minX = Math.min(minX, i);

                    maxY = Math.max(maxY, j);
                    minY = Math.min(minY, j);
                }
            }
        }
        for (int i = minX; i < maxX + 1; i++) {
            for (int j = minY; j < maxY + 1; j++) {
                sb.append(newData[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
