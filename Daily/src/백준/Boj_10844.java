package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10844 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long[][] data = new long[N + 1][10];

        for (int i = 1; i < 10; i++) {
            data[1][i] = 1;
        }
        Long mod = 1000000000L;
        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0){
                    data[i][0] = data[i - 1][1] % mod;
                }else if (j == 9){
                    data[i][9] = data[i - 1][8] % mod;
                }else{
                    data[i][j] = (data[i - 1][j - 1] + data[i - 1][j + 1]) % mod;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += data[N][i];
        }
        System.out.println(sum % mod);
    }
}
