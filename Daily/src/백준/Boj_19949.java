package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_19949 {
    static int[] data;
    static int count = 0;
    static void recursive(int idx, int[] sel){

        if (idx >= 10){
            int cnt = 0;
            for (int i = 0; i < 10; i++) {
                if (sel[i] == data[i]) cnt++;
            }
            if (cnt >= 5) count++;
            return;
        }
        for (int i = 1; i < 6; i++) {
            if (idx > 1 && sel[idx-1] == i && sel[idx - 2] == i) continue;
            sel[idx] = i;
            recursive(idx + 1, sel);
        }


    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        data = new int[10];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        recursive(0, new int[10]);
        System.out.println(count);
    }
}
