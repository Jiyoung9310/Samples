package Zoom;

public class Ex2 {

    private static boolean isFinished = false;

    public static void main(String[] args) {
        String S = "ABCABBBA";
        String result = solution(S);

        System.out.println("결과: " + result);

        /*하다보니 알게된건데 B를 모두 제거하고
         *연속된 A나 C를 축소시켜도 값은 결과값이 나옴*/
    }


    private static String solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        // 1,2번째 문자 확인
        int index = 0;
        // 규칙에 있으면 true, 문자를 변경
        String ruled = checkUseful(sb, index);
        // 규칙에 없으면 false, 2,3번째 문자 확인
        // 문자가 변경되면 다시 1,2번째 문자 확인

        // 반복
        do {
            ruled = checkUseful(new StringBuilder(ruled), index);
        } while (!isFinished);

        return ruled;
    }

    private static String checkUseful(StringBuilder sb, int i) {
        if(sb.length() < i+2) {
            isFinished = true;
            return sb.toString();
        }

        String sub = sb.substring(i, i+2);
        if (sub.equals("AB")) {
            sb.replace(i, i+2, "AA");
        } else if(sub.equals("BA")) {
            sb.replace(i, i+2, "AA");
        } else if (sub.equals("CB")) {
            sb.replace(i, i+2, "CC");
        } else if (sub.equals("BC")) {
            sb.replace(i, i+2, "CC");
        } else if (sub.equals("AA")) {
            sb.replace(i, i+2, "A");
        } else if (sub.equals("CC")) {
            sb.replace(i, i+2, "C");
        } else {
            return checkUseful(sb, i+1);
        }
        return sb.toString();
    }
}

