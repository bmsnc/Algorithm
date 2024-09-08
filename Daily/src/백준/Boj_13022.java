package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_13022 {
        static final String word = "wolf";
        static final char[] words = {'w', 'o', 'l', 'f'};
        public static void main(String[] args) throws Exception{

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();

            String line = br.readLine();
            if (line.length() <= 4) sb.append(word.equals(line) ? 1 : 0);
            else {
                line = line.replaceAll(word, " ");
                String[] data = line.split(" ");
                boolean flag = true;
                for (int i = 0; i < data.length; i++) {
                    if (data[i].isEmpty()) continue;
                    if (!find(data[i])){
                        flag = false;
                        break;
                    }
                }
                sb.append(flag ? 1 : 0);
            }
            System.out.println(sb);
        }


        static boolean find (String line) {
            if (line.charAt(0) != 'w') return false;
            int idx = 0;
            while (idx < line.length() && 'w' == line.charAt(idx)) idx++;
            StringBuilder correct = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < idx; j++) {
                    correct.append(words[i]);
                }
            }
            if (line.length() < 4 * idx) return false;
            String cmp = line.substring(0, 4 * idx);
            if (!correct.toString().equals(cmp)) return false;
            if (line.length() > idx * 4) return find(line.substring(idx * 4, line.length()));
            else return  true;
        }
    }


