package Stream;

import java.util.ArrayList;
import java.util.Arrays;

public class StreamTest1 {

    private String[] strs = {"one", "two", "thrie", "four"};

    public void test() {
        Arrays.stream(strs).reduce(new ArrayList<String>(), (list, str) -> {
            list.add(str);
            return list;
        }, (list, list2) -> {
            list.addAll(list2);
            return list;
        }).forEach(System.out::println);
    }

    public static void main(String[] args){
        StreamTest1 streamTest1 = new StreamTest1();
        streamTest1.test();
    }

}
