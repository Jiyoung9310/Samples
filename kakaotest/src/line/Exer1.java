package line;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Exer1 {

    public static void main(String... args) {
        String input = new Scanner(System.in).nextLine().trim();
        final StringTokenizer tokenizer = new StringTokenizer(input);

        int remain = 20000;
        int cost;

        while (tokenizer.hasMoreTokens()) {
            int distance = Integer.parseInt(tokenizer.nextToken());
            // 기본요금 거리인지, 추가요금도 적용되는 거리인지 구분
            if(distance <= 40 && distance >= 4) {
                cost = 720;
            } else if(distance >= 41 && distance <= 178) {
                // 거리에 해당하는 요금 계산
                int extraDistance = distance - 40;
                int extraCost = (((extraDistance-1) / 8) + 1) * 80;
                cost = 720 + extraCost;
            } else {
                // 현재 잔액을 출력하고 종료
                break;
            }

            // 남은 금액에서 계산된 요금을 차감
            if(cost <= remain) {
                // 금액이 남으면 다음 거리를 계산
                remain -= cost;
            } else {
                // 금액이 모자라면 현재 남은 금액을 표시하고 종료
                break;
            }

        }
        System.out.println(remain);
    }


}
