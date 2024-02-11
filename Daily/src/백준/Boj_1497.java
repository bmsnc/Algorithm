package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1497 {
    static String[] data;
    static int N, K, result, cnt;
    static boolean[] v;

    public static void recursive(int idx, int yCount, int count){

        if (yCount >= cnt){
            if (yCount == cnt) result = Math.min(result, count);
            else {
                cnt = yCount;
                result = count;
            }
        }

        List<Integer> list;
        int check = 0;
        for (int i = idx; i < N; i++) {

            list = new ArrayList<>();
            for (int j = 0; j < K; j++) {
                if (data[i].charAt(j) == 'N') continue;
                if (v[j]){
                    list.add(j);
                    continue;
                }
                v[j] = true;
                check++;
            }
            recursive(i + 1, yCount + check, count + 1);
            for (int j = 0; j < K; j++) {
                if (data[i].charAt(j) == 'N') continue;
                if (list.contains(j)) continue;
                v[j] = false;
                check--;
            }
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        data = new String[N];
        v = new boolean[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            data[i] = st.nextToken();
        }

        result = N;
        cnt = -1;
        for (int i = 0; i < N; i++) {
            recursive(i, 0, 0);
        }

        System.out.println(result == 0 ? -1 : result);
    }
}
