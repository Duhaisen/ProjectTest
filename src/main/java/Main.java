import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** Created by haisen on 2019/6/7. */

public class Main {
  public static void main(String[] args) {
   /*String string = "/bacRestaurant/restaurantWarehouse/restaurantWarehouseEntityWarehouseItem/";
    int perIndex = string.indexOf("/", "/bacOrganization/".length());
    int fengeIndex = string.lastIndexOf("/");
    String entity = string.substring(perIndex+1, fengeIndex);
    String permission = string.substring(fengeIndex+1);
    System.out.println(entity);
    System.out.println(permission);*/

      Map<Integer,Integer> map = new HashMap<>();

      map.put(new Integer(22222),new Integer(1));

      map.put(new Integer(22222),new Integer(2));

      System.out.println(map);

  }

}
