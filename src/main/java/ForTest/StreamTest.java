package ForTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/** Created by haisen on 2019/10/18. */
public class StreamTest {

  public static void main(String[] args) {
    String[] ss = {"11", "22", "33", "44"};
    Arrays.stream(ss).forEach(System.out::println);
    // 最后得到的Integer类型的数据不能输出，搞不懂？？？
    System.out.println(
        Arrays.stream(ss)
            .map(Integer::valueOf)
            .reduce(0, (i, s) -> Integer.sum(i, Integer.valueOf(s)), Integer::sum)
            .toString());
    System.out.println(Arrays.stream(ss).map(Integer::valueOf).reduce(0, Integer::sum));
    Arrays.stream(ss)
        .map(Integer::valueOf)
        .collect(Collectors.toList())
        .forEach(System.out::println);
    Arrays.stream(ss)
        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll)
        .forEach(System.out::println);
  }
}
