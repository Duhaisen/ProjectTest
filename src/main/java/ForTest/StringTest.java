package ForTest;

/** Created by haisen on 2019/10/15. */
public class StringTest {
  private static String ss = "sss";
  public StringTest(){
    System.out.println("Test");
  }

  public static void test1(String s) {
    System.out.println(ss == s);
  }

  public static void main(String[] args) {
    String s= "sss";
    test1(s);
  }
}
