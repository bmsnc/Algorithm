package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_2210 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static String[][] data;
    static HashSet<String> h;
    static void recursive(int x, int y, int k, String val){

        if (k > 5) {
            h.add(val);
            return;
        }

        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
            recursive(nx, ny, k + 1, val + data[nx][ny]);
        }

    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        data = new String[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                data[i][j] = st.nextToken();
            }
        }
        h = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                recursive(i, j, 1, data[i][j]);
            }
        }
        System.out.println(h.size());
    }
}
