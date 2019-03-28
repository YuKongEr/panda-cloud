import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author: yukong
 * @date: 2018/11/30 16:57
 */
public class TestA {


    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 10000000; i++) {
            linkedList.add(i);
            hashMap.put(i, i);
        }
        long start = System.currentTimeMillis();
        System.out.println(linkedList.get(1000000));
        long end = System.currentTimeMillis();
        System.out.println("linkedList:=" + (end - start));

        start = System.currentTimeMillis();
        System.out.println(hashMap.get(1000000));
        end = System.currentTimeMillis();
        System.out.println("hashMap:=" + (end - start));

    }

}
