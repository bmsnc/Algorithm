package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_4375 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String line;
        int N;
        while ((line = br.readLine()) != null){
            if (line.length() == 0) break;
            int n = Integer.parseInt(line);
            int base = 1;
            int cnt = 1;
            while ((base=base%n) != 0) {
                cnt++;
                base = base*10+1;
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}
