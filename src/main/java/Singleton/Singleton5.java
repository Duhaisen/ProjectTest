package Singleton;

/**
 * Created by haisen on 2019/10/7.
 */
public class Singleton5 {
  private static Singleton5 singleton5 = null;

  private Singleton5(){}
  public static Singleton5 getSingleton5(){
    if (null==singleton5){
      synchronized (Singleton5.class){
        if (null==singleton5){
          singleton5 = new Singleton5();
        }
      }
    }
    return singleton5;
  }
}
