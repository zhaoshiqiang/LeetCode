import java.io.*;
import java.util.*;

public class test {
    Map<String, Integer> hashMap = new HashMap<>();

    public int count(String src) throws FileNotFoundException {
        File f = new File(src);
        Set<String> set = new HashSet<>();
//        if (f.exists() && f.isFile()) {
//            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
//            String line = null;
//            try {
//
//                while ((line = br.readLine()) != null) {
//                    if (!set.contains(line)) {
//                        set.add(line);
//                    }
//                }
//                br.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return set.size();
        Scanner scanner = new Scanner(f);
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            if (! set.contains(line)){
                set.add(line);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        try {
            System.out.println(new test().count("/Users/zhaoshiqiang/JavaProject/LeetCode/src/a.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
