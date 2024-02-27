package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13413 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        int len;
        String a, b;
        for (int t = 0; t < tc; t++) {

            len = Integer.parseInt(br.readLine());
            a = br.readLine();
            b = br.readLine();

            int total = 0;
            int aWhite = 0, aBlack = 0;
            int bWhite = 0, bBlack = 0;
            for (int i = 0; i < len; i++) {
                if (a.charAt(i) == b.charAt(i)) continue;
                if (a.charAt(i) == 'B'){
                    aBlack++;
                    bWhite++;
                }else{
                    aWhite++;
                    bBlack++;
                }
                total++;
            }
            int tmp = Math.min(aWhite, aBlack);
            sb.append(tmp + (total - tmp * 2)).append("\n");
        }
        System.out.println(sb);
    }
}
