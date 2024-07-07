package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_11899 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line = br.readLine();
        Stack<Character> dq = new Stack<>();

        char now, peak;
        for (int i = line.length() - 1; i > -1; i--) {
            now = line.charAt(i);
            if (dq.isEmpty()) {
                dq.push(now);
                continue;
            }
            peak = dq.peek();
            if (now == peak || (peak == '(' && now == ')')) {
                dq.add(now);
                continue;
            }
            dq.pop();
        }
        System.out.println(dq.size());
    }
}
