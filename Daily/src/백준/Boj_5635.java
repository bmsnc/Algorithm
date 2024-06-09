package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_5635 {

    static class Person{
        String name;
        int dd, mm, yy;
        public Person(String name, int dd, int mm, int yy) {
            this.name = name;
            this.dd = dd;
            this.mm = mm;
            this.yy = yy;
        }
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", dd=" + dd +
                    ", mm=" + mm +
                    ", yy=" + yy +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        List<Person> persons = new ArrayList<Person>();
        int N = Integer.parseInt(br.readLine());
        String name;
        int dd, mm, yy;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            dd = Integer.parseInt(st.nextToken());
            mm = Integer.parseInt(st.nextToken());
            yy = Integer.parseInt(st.nextToken());
            persons.add(new Person(name, dd, mm, yy));
        }

        Collections.sort(persons, ((o1, o2) -> {
            if (o1.yy != o2.yy) return Integer.compare(o1.yy, o2.yy);
            if (o1.mm != o2.mm) return Integer.compare(o1.mm, o2.mm);
            return Integer.compare(o1.dd, o2.dd);
        }));
        sb.append(persons.get(persons.size() - 1).name).append("\n");
        sb.append(persons.get(0).name).append("\n");

        System.out.println(sb);
    }
}