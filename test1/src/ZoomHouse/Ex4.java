package Zoom;

import java.util.Arrays;

public class Ex4 {


    public static void main(String[] args) {
        int[] A = {10, 2, 5, 1, 8, 20, 7};
        int result = solution(A);

        System.out.println("결과: " + result);
    }


    private static int solution(int[] A) {
        int perimeter = -1;
        Arrays.sort(A);
        int p = 0;
        int q = 1;
        int r = 2;
        for (int i=r; i<A.length; i++) {
            if (A[p] + A[q] > A[r]) {
                //triangle
                perimeter = A[p] + A[q] + A[r];
                break;
            } else {
                p++;
                q++;
                r++;
            }
        }

        return perimeter;
    }


}

