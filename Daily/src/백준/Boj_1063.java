package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_1063 {

    static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[][] data = new int[8][8];
        HashMap<Character, Integer> h = new HashMap<>();
        HashMap<Integer, Character> reverseH = new HashMap<>();
        HashMap<String, Integer> index = new HashMap<>();

        for (int i = 0; i < 8; i++) {
            h.put((char) ('A' + i), i);
            reverseH.put(i, (char) ('A' + i));
        }
        index.put("R", 0);
        index.put("L", 1);
        index.put("B", 2);
        index.put("T", 3);
        index.put("RT", 4);
        index.put("LT", 5);
        index.put("RB", 6);
        index.put("LB", 7);

        st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String stone = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int stoneX = stone.charAt(1) - '1';
        int stoneY = h.get(stone.charAt(0));
        data[stoneX][stoneY] = -1;
        int x = king.charAt(1) - '1';
        int y = h.get(king.charAt(0));

        String order;
        int idx;
        int nx, ny;
        for (int i = 0; i < N; i++) {

            order = br.readLine();
            idx = index.get(order);

            nx = x + dx[idx];
            ny = y + dy[idx];

            if (!check(nx, ny)) continue;
            if (data[nx][ny] == -1){
                int stoneNx = nx + dx[idx];
                int stoneNy = ny + dy[idx];
                if (!check(stoneNx, stoneNy)) continue;
                else{
                    data[nx][ny] = 0;
                    data[stoneNx][stoneNy] = -1;
                    stoneX = stoneNx;
                    stoneY = stoneNy;
                }
            }
            x = nx;
            y = ny;
        }
        sb.append(reverseH.get(y)).append(x + 1).append("\n");
        sb.append(reverseH.get(stoneY)).append(stoneX + 1);

        System.out.println(sb);
    }

    static boolean check(int x, int y){
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }


}
