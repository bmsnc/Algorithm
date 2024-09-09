package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1094 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int start = 64, count = 0;
        while (N > 0) {
            if (N >= start) {
                N -= start;
                count++;
            }else {
                start /= 2;
            }
        }
        System.out.println(count);
    }
}

