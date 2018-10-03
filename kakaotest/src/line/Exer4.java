package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Exer4 {
    private static final String METHOD_POST = "POST";
    private static final String METHOD_GET = "GET";

    private static final int RES_CODE_OK = 200;
    private static final int RES_CODE_CREATED = 201;
    private static final int RES_CODE_FORBIDDEN = 403;
    private static final int RES_CODE_NOT_FOUND = 404;
    private static final int RES_CODE_METHOD_NOT_ALLOWED = 405;

    private static final String RES_MSG_OK = "OK";
    private static final String RES_MSG_CREATED = "CREATED";
    private static final String RES_MSG_FORBIDDEN = "FORBIDDEN";
    private static final String RES_MSG_NOT_FOUND = "NOT_FOUND";
    private static final String RES_MSG_METHOD_NOT_ALLOWED = "METHOD_NOT_ALLOWED";

    //private static Map<String, String> UserData;


    public static void main(String[] args) throws IOException {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int n = Integer.parseInt(br.readLine());

            UserData userData = new UserData();

            for (int i = 0; i < n; i++) {
                final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                String method = tokenizer.nextToken();
                String url = tokenizer.nextToken();
                String body = null;
                if (tokenizer.hasMoreTokens()) {
                    body = tokenizer.nextToken();
                }

                //url 분석
                String[] split = url.split("/");
                if(split.length > 3) {
                    switch (method) {
                        case METHOD_POST:
                            // 사용자 데이터 저장
                            userData.setUserInfo(method, split[2], body);
                            break;
                        case METHOD_GET:
                            // 사용자 데이터 조회
                            userData.getUserInfo(method, split[2]);
                            break;
                    }
                } else {
                    if(split[1].equals("users") && split.length > 2) {
                        userData.createUser(method, split[2]);
                    } else {
                        userData.printResult(RES_CODE_NOT_FOUND, null);
                    }
                }

                // 결과 출력
            }
        }
    }


    static class UserData {
        HashMap<String, String> userStorage = new HashMap<>();

        //사용자 생성 API
        void createUser(String method, String userId) {
            // POST /user/{UserId}
            // 메소드 맞는지 확인
            if (method.equals(METHOD_POST)) {
                // 이미 존재하는 ID 이면 403
                // 존재하지 않는다면 아이디 생성
                if( userStorage.containsKey(userId) ) {
                    printResult(RES_CODE_FORBIDDEN, null);
                } else {
                    userStorage.put(userId, null);
                    printResult(RES_CODE_CREATED, null);
                }

            } else {
                printResult(RES_CODE_METHOD_NOT_ALLOWED, null);
            }

        }

        // 사용자 데이터 저장 API
        void setUserInfo(String method, String userId, String value) {
            // POST /users/{CONY}/data value=TEST_DATA
            // 성공하면 200 코드와 그에 대응되는 메시지를 리턴한다.
            // UserId를 갖는 사용자가 없는 경우, 403 코드와 그에 대응되는 메시지를 리턴한다.
            // GET Method를 이용하여 Request를 보내는 경우, 405 코드와 그에 대응되는 메시지를 리턴한다.

            // 메소드 맞는지 확인
            if (method.equals(METHOD_POST)) {
                // UserId를 갖는 사용자가 없는 경우 403
                // 성공하면 200 코드
                if( userStorage.containsKey(userId) ) {
                    userStorage.replace(userId, value);
                    printResult(RES_CODE_OK, null);
                } else {
                    printResult(RES_CODE_FORBIDDEN, null);
                }

            } else {
                printResult(RES_CODE_METHOD_NOT_ALLOWED, null);
            }
        }

        // 사용자 데이터 조회 API
        void getUserInfo(String method, String userId) {
            // GET /users/CONY/data
            // 전달된 UserId에 해당하는 사용자의 Data를 200 코드 및 메시지와 함께 Message Body에 리턴한다.
            // UserId를 갖는 사용자가 없는 경우, 403 코드와 그에 대응되는 메시지를 리턴한다.
            // 만약 UserId를 갖는 사용자는 존재하지만, 저장된 데이터가 없다면 404 코드 및 메시지를 리턴한다.
            // POST Method를 이용하여 Request를 보내는 경우, 405 코드와 그에 대응되는 메시지를 리턴한다.

            // 메소드 맞는지 확인
            if (method.equals(METHOD_GET)) {
                // UserId를 갖는 사용자가 없는 경우 403
                // 성공하면 200 코드
                if( !userStorage.get(userId).isEmpty() ) {
                    String value = userStorage.get(userId);
                    printResult(RES_CODE_OK, value.substring(6));
                } else {
                    printResult(RES_CODE_FORBIDDEN, null);
                }

            } else {
                printResult(RES_CODE_METHOD_NOT_ALLOWED, null);
            }
        }

        void printResult(int code, String msg) {
            String result = "";
            switch (code) {
                case RES_CODE_OK:
                    if (msg == null) {
                        result = code + " " + RES_MSG_OK;
                    } else {
                        result = code + " " + RES_MSG_OK + " " + msg;
                    }
                    break;

                case RES_CODE_CREATED:
                    result = code + " " + RES_MSG_CREATED;
                    break;

                case RES_CODE_FORBIDDEN:
                    result = code + " " + RES_MSG_FORBIDDEN;
                    break;

                case RES_CODE_NOT_FOUND:
                    result = code + " " + RES_MSG_NOT_FOUND;
                    break;

                case RES_CODE_METHOD_NOT_ALLOWED:
                    result = code + " " + RES_MSG_METHOD_NOT_ALLOWED;
                    break;

            }

            System.out.println(result);

        }
    }

}
