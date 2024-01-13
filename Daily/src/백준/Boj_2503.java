package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_2503 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] data = new int[N][3];

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
            data[i][2] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> h = new HashSet<>();
        int a, b, c, count = 0;
        for (int i = 123; i < 1000; i++) {

            h.clear();
            c = i % 10;
            b = (i / 10) % 10;
            a = (i / 100) % 10;
            h.add(a);
            h.add(b);
            h.add(c);

            if (h.size() < 3 || a == 0 || b == 0 || c == 0) continue;
            int first, second, third, strike = 0, ball = 0;
            boolean flag = true;
            for (int j = 0; j < N; j++) {

                third = data[j][0] % 10;
                second = (data[j][0] / 10) % 10;
                first = (data[j][0] / 100) % 10;

                if (a == first) strike++;
                else if (h.contains(first)) ball++;

                if (b == second) strike++;
                else if (h.contains(second)) ball++;

                if (c == third) strike++;
                else if (h.contains(third)) ball++;

                if (!(data[j][1] == strike && data[j][2] == ball)) {
                    flag = false;
                    break;
                }
                strike = 0;
                ball = 0;
            }
            if (flag) {
                count++;
            }
        }
        System.out.println(count);
    }
}
