package 백준;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_31589 {
    static final String word = "wolf";
    static final char[] words = {'w', 'o', 'l', 'f'};
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> up = new ArrayList<>();
        List<Integer> down = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int num;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            up.add(num);
            down.add(num);
        }
        Collections.sort(up);
        down.sort(Collections.reverseOrder());

        int uIdx = 0, dIdx = 1, idx = 1;
        long temp = 0, sum = down.get(0);
        while (idx < K) {
            if (idx % 2 == 1) {
                temp += up.get(uIdx++);
            }else {
                sum += Math.abs(down.get(dIdx++) - temp);
                temp = 0;
            }
            idx++;
        }
        System.out.println(sum);
    }
}

