import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_8979 {
    static class Country {
        int idx;
        int gold;
        int silver;
        int bronze;
        public Country(int idx, int gold, int silver, int bronze) {
            this.idx = idx;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public String toString() {
            return "Country{" +
                    "idx=" + idx +
                    ", gold=" + gold +
                    ", silver=" + silver +
                    ", bronze=" + bronze +
                    '}';
        }

        public boolean compare(Country country) {
            return this.gold == country.gold && this.silver == country.silver && this.bronze == country.bronze;
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Country> list = new ArrayList<>();

        int a,b,c,d;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            list.add(new Country(a,b,c,d));
        }

        list.sort((o1, o2) -> o1.gold == o2.gold ? o1.silver == o2.silver ? o1.bronze == o2.bronze ? Integer.compare(o1.idx, o2.idx)
                : Integer.compare(o2.bronze, o1.bronze)
                : Integer.compare(o2.silver, o1.silver)
                : Integer.compare(o2.gold, o1.gold));

        Country country, before;
        int rank = 1;
        for (int i = 0; i < list.size(); i++) {
            country = list.get(i);
            if (country.idx != K) {
                rank++;
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                before = list.get(j);
                if (!country.compare(before)) break;
                rank--;
            }
            break;
        }
        System.out.println(rank);
    }
}
