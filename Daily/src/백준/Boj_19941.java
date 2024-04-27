package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_19941 {

    static int find(int A, int B){

        if (B == 0) return A;
        return find(B, A % B);
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] line = br.readLine().split(":");
        int A = Integer.parseInt(line[0]);
        int B = Integer.parseInt(line[1]);

        int AA = A, BB = B;
        if (AA < BB) {
            int temp = AA;
            AA = BB;
            BB = temp;
        }

        int div = find(A, B);
        System.out.println(A/div + ":" + B/div);
    }
}
