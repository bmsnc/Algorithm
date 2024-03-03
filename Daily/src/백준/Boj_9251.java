package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다이나믹 프로그래밍
public class Boj_9251 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String line1 = br.readLine();
        String line2 = br.readLine();

        int[][] d = new int[line1.length() + 1][line2.length() + 1];
        for (int i = 1; i < line1.length() + 1; i++) {
            for (int j = 1; j < line2.length() + 1; j++) {
                if (line1.charAt(i - 1) == line2.charAt(j - 1)){
                    d[i][j] = d[i-1][j-1] + 1;
                }else{
                    d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
                }
            }
        }

        System.out.println(d[line1.length()][line2.length()]);


    }
}
