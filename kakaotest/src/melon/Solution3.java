package melon;
import java.io.*;
import java.util.*;
import java.util.regex.*;
public class Solution3 {
    private static final Scanner scan = new Scanner(System.in);
    private static Set<String> result = new HashSet<>();

    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename;
        filename = scan.nextLine();
        File inFile = new File("C:\\Users\\XNOTE\\Documents\\Samples\\kakaotest\\src\\melon", filename);

        String fileGIf = "gifs_"+filename;
        File output = new File(fileGIf);
        FileOutputStream fos = new FileOutputStream(output);
        PrintStream ps = new PrintStream(fos);
        System.setOut(ps);

        BufferedReader br = new BufferedReader(new FileReader(inFile));
        while(true) {
            String line = br.readLine();
            if (line==null) break;
            readLog(line);
        }
        br.close();

        for(String s : result) {
            System.out.println(s);
        }

    }

    static void readLog(String log) {
        // " 배열 나누기
        String[] record = log.split("\"");
        //gif 요청 건
        if(record.length > 3) {
            if (record[1].contains(".gif")) {
                //GET으로 요청했는지 확인
                if (record[1].contains("GET")) {
                    //200 respone 확인
                    if (record[2].contains("200")) {
                        String gif = "";
                        //gif 파일명 추출
                        String pattern = "/\\S+.(?i)(gif)";
                        Matcher m = Pattern.compile(pattern).matcher(record[1]);
                        while (m.find()) {
                            gif = m.group(0);
                        }
                        String[] file = gif.split("/");
                        result.add(file[file.length - 1]);
                    }
                }
            }
        }
    }

}
