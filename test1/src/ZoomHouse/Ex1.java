package Zoom;

import java.util.Arrays;

public class Ex1 {


    public static void main(String[] args) {
        int[] A = {1, 3, 5, 3, 4};
        boolean result = solution(A);

        System.out.println("결과: " + result);
    }


    private static boolean solution(int[] A) {
        // 정렬되었는지 확인
        // 정렬되었으면 true
        if ( sortCheck(A) ) {
            return true;
        } else {
            // 가장 큰 값 위치 확인
            int[] B = findMax(A, A.length);
            // 정렬되었는지 확인
            // 정렬되었으면 true, 아니면 false 리턴
            if( sortCheck(B) ) {
                return true;
            } else {
                return false;
            }

        }

    }

    private static boolean sortCheck(int[] A) {
        boolean isSorted = false;
        int[] sortedArray = A.clone();
        Arrays.sort(sortedArray);
        if (Arrays.equals(sortedArray, A)) {
            isSorted = true;
        }
        return isSorted;
    }

    private static int[] findMax(int[] A, int last) {
        // 가장 큰 값 위치 확인
        // 1. 맨 뒤와 swap
        // 2. 이미 맨 뒤에 있으면 그 다음으로 큰 값 위치 확인
        int max = 0;
        int maxIndex = 0;
        for ( int i=0 ; i<last ; i++) {
            if (A[i] > max) {
                max = A[i];
                maxIndex = i;
            }
        }
        if (maxIndex == last - 1) {
            return findMax(A, last - 1);
        } else {
            return swap(A, maxIndex, last-1);
        }

    }

    private static int[] swap(int[] A, int i, int j) {
        int temp = 0;
        temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        return A;
    }

}

