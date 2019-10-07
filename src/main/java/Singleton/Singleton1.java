package Singleton;

/**
 * Created by haisen on 2019/10/7.
 */
public class Singleton1 {
  private Singleton1(){}
  public static synchronized Singleton1 getSingleton(){
    Singleton1 singleton1 = new Singleton1();
    return singleton1;
  }
}
