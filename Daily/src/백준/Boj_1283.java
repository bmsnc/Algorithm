package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1283 {
    static boolean[] data;
    static boolean flag;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        data = new boolean[26];

        String[] line, newLine;
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            flag = false;
            newLine = findFirst(line, line.length);
            if (flag) {
                for (int j = 0; j < newLine.length; j++) {
                    sb.append(newLine[j]).append(" ");
                }
                sb.append("\n");
                continue;
            }
            newLine = find(line, line.length);
            for (int j = 0; j < newLine.length; j++) {
                sb.append(newLine[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static String[] find(String[] line, int size) {

        String word;
        boolean wordFlag = false;
        for (int i = 0; i < size; i++) {
            word = line[i];
            for (int j = 1; j < word.length(); j++) {
                if (data[word.toLowerCase().charAt(j) - 'a']) continue;
                data[word.toLowerCase().charAt(j) - 'a'] = true;
                wordFlag = true;
                line[i] = word.substring(0, j) + "[" + word.charAt(j) + "]" + word.substring(j + 1);
                break;
            }
            if (wordFlag) break;
        }
        return line;
    }

    static String[] findFirst(String[] line, int size) {

        int idx = 0;
        char first, org;
        for (int i = 0; i < size; i++) {
            first = line[i].toLowerCase().charAt(idx);
            if (data[first - 'a']) continue;
            data[first - 'a'] = true;
            org = line[i].charAt(idx);
            line[i] = "[" + org + "]" + line[i].substring(1);
            flag = true;
            break;
        }
        return line;
    }
}
