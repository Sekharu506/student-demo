import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class HashMapTest {

    public static void main(String args[]) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Name");
        String name = scanner.next();

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (hashMap.containsKey(c)) {
                int count = hashMap.get(c);
                count++;
                hashMap.put(c, count);


            } else {
                hashMap.put(c, 1);
            }


        }

        System.out.println("Frequency Of Characters In Your Name " + name);

        Iterator<Map.Entry<Character, Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> set = (Map.Entry<Character, Integer>) iterator.next();
            System.out.println(set.getKey() + " = " + set.getValue());
        }
    }

}






