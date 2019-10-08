package Singleton;

/** Created by haisen on 2019/10/7. */
public class Singleton1 {
  private static Singleton1 singleton1 = null;

  private Singleton1() {}

  public static synchronized Singleton1 getSingleton() {
    if (singleton1 == null) {
      singleton1 = new Singleton1();
    }
    return singleton1;
  }
}
