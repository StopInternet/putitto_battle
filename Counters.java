public class Counters {
  //カウンター処理
  /*
   * カウンターに成功するとダメージを防いで、
   * 3倍のダメージを与える
   */
  private static int counters; 
  
  public Counters(int counters) {
    Counters.counters = counters;
  }
  public static int getCounter() {
    return counters;
  }

  public void setCounter(int counter) {
    Counters.counters = counter;
  }
  //処理部分
  public static void Counter(){
    int enemyHP = Stats_enemy.getHP() - Counters.getCounter();
    Stats_enemy.setHP(enemyHP);
    System.out.println("カウンターに成功した！");
    System.out.println(Counters.getCounter()+"ダメージを与えた！");
  }
}
