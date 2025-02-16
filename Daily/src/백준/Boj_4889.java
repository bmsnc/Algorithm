package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_4889 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        List<String> input = new ArrayList<>();

        String s;
        while (true) {
            s = br.readLine();
            if (s.contains("-")) break;
            input.add(s);
        }

        Stack<Character> stack;
        int size, index = 0;
        for (String line : input) {
            index++;
            stack = new Stack<>();
            stack.add(line.charAt(0));
            char cur;
            for (int i = 1; i < line.length(); i++) {
                cur = line.charAt(i);
                if (!stack.isEmpty() && stack.peek() == '{' && cur == '}') {
                    stack.pop();
                    continue;
                }
                stack.push(cur);
            }
            size = stack.size();
            char pop, before = '-';
            while (!stack.isEmpty()) {
                pop = stack.pop();
                if (pop == before) {
                    size--;
                    before = '-';
                    continue;
                }
                before = pop;
            }
            sb.append(index).append(". ").append(size).append("\n");
        }
        System.out.println(sb);
    }
}
