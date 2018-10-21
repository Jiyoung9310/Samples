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


class Result {

    /*
     * Complete the 'getShiftedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER leftShifts
     *  3. INTEGER rightShifts
     */

    public static String getShiftedString(String s, int leftShifts, int rightShifts) {
        // left에서 right를 뺀 수 move
        // move > 0 => move만큼 left이동
        // move < 0 => move만큼 right이동
        int move = leftShifts - rightShifts;
        if (move > 0) {
            return shifting(s, move, 1);
        } else if (move < 0) {
            return shifting(s, move*-1, -1);
        } else {
            return s;
        }


    }

    static String shifting(String s, int move, int way) {
        // s의 길이 구함
        // move를 length와 나눈 나머지만큼 left로 이동
        int length = s.length();
        move = move % length;
        if(way < 0) {
            move = length - move;
        }
        String shifted = s.substring(move)+s.substring(0,move);

        return shifted;
    }

}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int leftShifts = Integer.parseInt(bufferedReader.readLine().trim());

        int rightShifts = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.getShiftedString(s, leftShifts, rightShifts);

        System.out.println("result : "+ result);
        //bufferedWriter.write(result);
       // bufferedWriter.newLine();

        bufferedReader.close();
       // bufferedWriter.close();
    }
}