package ZoomHouse;

public class Ex3 {


    public static void main(String[] args) {
        int[] A = {5, 4, 4, 5, 0, 12, 0, 1, 2, 2, 1, 2, 1, 3};
        int result = solution(A);

        System.out.println("결과: " + result);
    }


    private static int solution(int[] A) {
        int max = 0;
        //서로 다른 첫번째, 두번째 값을 P, Q로
        int start = 0;
        int end = 1;
        int P = A[start];
        int Q = A[end];

        while ( P == Q ) {
            end++;
            Q = A[end];
        }
        //인덱스를 하나씩 늘려서
        //같은 값이면 ++, 다른 값이면 stop
        //배열 끝까지 도달할 때까지 반복
        int size;
        for(int i = end+1; i<A.length; i++) {
            if ( A[i] == P || A[i] == Q ) {
                continue;
            } else {
                size = i - start;
                if( max < size) {
                    max = size;
                }
                start = i-1;
                P = A[i-1];
                Q = A[i];
            }
        }

        //size가 가장 큰 값을 출력
        size = (A.length-1) - start + 1;
        if( max < size) {
            max = size;
        }


        return max;
    }


}

