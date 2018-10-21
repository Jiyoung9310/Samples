package melon;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result2 {

    /*
     * Complete the 'customSort' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void customSort(List<Integer> arr) {
        // countmap을 생성
        // arr를 검색하여 해당 인덱스에 ++
        Map<Integer, Integer> countmap = new HashMap<>();
        for(Integer a : arr) {
            if (countmap.containsKey(a)) {
                countmap.replace(a, countmap.get(a)+1);
            } else {
                countmap.put(a, 1);
            }
        }

        TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>(countmap);
        tm.keySet( ).iterator( );   //키값 오름차순 정렬(기본)
        //value로 오름차순 정렬
        Iterator it = sortByValue(tm).iterator();
        while(it.hasNext()){
            int temp = (int) it.next();
            System.out.println(temp + "=" + countmap.get(temp));
        }

        //key를 value값 만큼 차례대로 출력
        while(it.hasNext()){
            int temp = (int) it.next();
            int count = countmap.get(temp);
            for(int i=0; i<count; i++) {
                System.out.println(temp);
            }
        }

    }



    public static List sortByValue(final Map map){
        List<Integer> list = new ArrayList<Integer>(map.keySet());

        Collections.sort(list, (Comparator) (o1, o2) -> {
            Object v1 = map.get(o1);
            Object v2 = map.get(o2);

            return ((Comparable) v1).compareTo(v2);
        });


        return list;
    }

}


public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        Result2.customSort(arr);

        bufferedReader.close();
    }
}