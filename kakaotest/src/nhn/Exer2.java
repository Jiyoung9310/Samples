package nhn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exer2 {
    public static void main(String[] args) throws Exception {

        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                final int n = Integer.parseInt(br.readLine());
                int w = Integer.parseInt(br.readLine());

                String[][] matrix = new String[n][n];

                for (int i = 0; i < n; i++) {
                    final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                    for(int j=0; j < n; j++) {
                        matrix[i][j] = tokenizer.nextToken();
                    }
                }

            // 횟수 후려치기
            int clock = (n*n) - ((n-1)*(n-1));
            int move;
            if( w<0 ) {
                w *= -1;
                move = w % clock;
                move *= -1;
            } else {
                move = w % clock;
            }

            // 시계방향 이동
            for (int i = 0; i < n; i++) {
                for(int j=0; j < n; j++) {
                    String temp = matrix[i][j];

                }
            }
            // 반시계방향 이동

        }
    }
}
