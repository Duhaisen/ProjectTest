package Singleton;

/**
 * Created by haisen on 2019/10/7.
 */
public class Singleton4 {

  private Singleton4(){}

  private enum Single{
    SINGLE(new Singleton4());
    private Singleton4 singleton4;
    Single(Singleton4 singleton4){
      this.singleton4 = singleton4;
    }

    public Singleton4 getSingleton4(){
      return singleton4;
    }
  }

  public static Singleton4 getSingleton4(){
    return Single.SINGLE.getSingleton4();
  }

}
