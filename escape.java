import java.util.*;
//逃げる処理
public class escape {
  static public boolean escapes(Boolean get){
    /*
     * 逃げるに成功すると処理を終了する。
     */
    Random rand = new Random();
    final int kakuritu = rand.nextInt(1,100);
    if(50 <= kakuritu){
      System.out.println("逃げることに成功した！");
     get = true;
    } else if(kakuritu > 50){
      get = false;
    }
    return get;
  }
}
