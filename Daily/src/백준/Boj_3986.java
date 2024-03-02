package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_3986 {

    static boolean check(String line){

        Stack<Character> s = new Stack<>();
        s.push(line.charAt(0));

        for (int i = 1; i < line.length(); i++) {
            if (!s.isEmpty() && s.peek() == line.charAt(i)){
                s.pop();
            }else{
                s.push(line.charAt(i));
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String line;
        int count = 0;
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            if (check(line)) count++;
        }
        System.out.println(count);
    }
}
