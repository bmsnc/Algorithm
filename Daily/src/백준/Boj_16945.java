package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16945 {
    static boolean[] v;
    static int count = Integer.MAX_VALUE;
    static int[][] data;

    static boolean check(){

        int a = data[0][0] + data[0][1] + data[0][2];
        int b = data[1][0] + data[1][1] + data[1][2];
        int c = data[2][0] + data[2][1] + data[2][2];

        int d = data[0][0] + data[1][0] + data[2][0];
        int e = data[0][1] + data[1][1] + data[2][1];
        int f = data[0][2] + data[1][2] + data[2][2];

        int g = data[0][0] + data[1][1] + data[2][2];
        int h = data[0][2] + data[1][1] + data[2][0];

        if (a != 15 || b != 15 || c != 15 || d != 15 || e != 15 || f != 15 || g != 15 || h != 15) return false;
        return true;

    }

    static void recursive(int idx, int value){

        if (idx >= 9 && check()){
            count = Math.min(count, value);
            return;
        }
        int x = idx / 3;
        int y = idx % 3;

        int temp;
        for (int i = 1; i < 10; i++) {
            if (v[i]) continue;
            v[i] = true;
            temp = data[x][y];
            data[x][y] = i;
            recursive(idx + 1, value + Math.abs(temp - i));
            v[i] = false;
            data[x][y] = temp;
        }


    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        data = new int[3][3];
        v = new boolean[10];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, 0);
        System.out.println(count);
    }
}
