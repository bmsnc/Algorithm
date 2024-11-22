package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_2257 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line = br.readLine();
        Stack<Integer> s = new Stack<>();

        Character cur;
        for (int i = 0; i < line.length(); i++) {
            cur = line.charAt(i);

            if (cur == ')') {
                int sum = 0;
                while (true) {
                    if (s.peek() == 0) {
                        s.pop();
                        s.push(sum);
                        break;
                    }
                    sum += s.pop();
                }
            } else if(cur == 'C') {
                s.push(12);
            } else if (cur == 'O') {
                s.push(16);
            } else if (cur == 'H') {
                s.push(1);
            } else if (cur >= '0' && cur <= '9') {
                int temp = s.pop();
                s.push(temp * (cur - '0'));
            } else s.push(0);
        }

        int ans = 0;
        while (!s.isEmpty()) {
            ans += s.pop();
        }
        System.out.println(ans);
    }
}
