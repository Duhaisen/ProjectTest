package Singleton;

/**
 * Created by haisen on 2019/10/7.
 */
public class Singleton2 {
  private static Singleton2 singleton2 = new Singleton2();
  private Singleton2(){}
  public static Singleton2 getSingleton2(){
    return singleton2;
  }
}
