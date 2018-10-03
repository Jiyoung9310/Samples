package nhn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exer1 {


    public static void main(String[] args) throws Exception {

        List<Integer> cardList = new ArrayList<>();
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int c = Integer.parseInt(br.readLine());
            for (int i = 1; i < c+1; i++) {
                cardList.add(i);
            }
            final int p = Integer.parseInt(br.readLine());

            for (int i = 0; i < p; i++) {
                final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                final int n = Integer.parseInt(tokenizer.nextToken());

                // 섞을 카드들 중, 위에서 N장과 아래에서 N장을 제외한 나머지 카드들을 순서를 유지한 채 가장 위쪽으로 올립니다.
                List<Integer> mixList = mixRestCard(cardList, n, c);
                //System.out.println(mixList);

            }
            for(int i =0; i <5; i++) {
                System.out.println(cardList.get(i));
            }
        }
    }


    private static List<Integer> mixRestCard(List<Integer> cardList, int n, int c) {
        int start = n;
        int end = c-n;
        List<Integer> tempList = new ArrayList<>();
        for(int i=start; i<end; i++) {
            int value = cardList.get(i);
            tempList.add(value);
        }
        int restCard = tempList.size();
        for(int i=0; i<restCard; i++) {
            cardList.remove(start);
        }

        //위로 올라온 카드들의 수가 2 * N을 초과하면, 그 카드들에 대해서만 카드 섞기를 처음부터 반복합니다.
        if (restCard > 2*n) {
            tempList = mixRestCard(tempList, n, restCard);
        }
        cardList.addAll(0, tempList);

        return cardList;
    }
}
