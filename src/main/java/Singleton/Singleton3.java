package Singleton;

/**
 * Created by haisen on 2019/10/7.
 */
public class Singleton3 {
  private Singleton3(){}
  private static class Single extends Singleton3{
    public static Singleton3 singleton3 = new Singleton3();
  }

  public static Singleton3 getSinleton3(){
    return Single.singleton3;
  }

}
