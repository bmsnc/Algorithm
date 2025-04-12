package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1780 {
    static int[][] data;
    static int[] answer;
    static int N;

    static void recursive(int x, int y, int d) {

        if (check(x, y, d)) {
            answer[data[x][y] + 1]++;
            return;
        }

        int size = d/3;

        recursive(x, y, size); //1
        recursive(x, y+size, size);//2
        recursive(x, y+size*2, size);//3

        recursive(x+size, y, size);//4
        recursive(x+size, y+size, size);//5
        recursive(x+size, y+size*2, size);//6

        recursive(x+size*2, y, size);  // 7
        recursive(x+size*2, y+size, size); //8
        recursive(x+size*2, y+size*2, size); //9

    }
    static boolean check(int x, int y, int size) {
        int first = data[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (data[i][j] != first) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        data = new int[N][N];
        answer = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0 ,0, N);
        sb.append(answer[0]).append("\n");
        sb.append(answer[1]).append("\n");
        sb.append(answer[2]).append("\n");

        System.out.println(sb);
    }
}
