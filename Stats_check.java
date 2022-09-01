public class Stats_check{
  public Stats_check() {
    //ステータスを確認する
  }
  static public void Stats_checks(){
    mains.rine();
    System.out.println("敵の名前："+Stats_enemy.getName());
    System.out.println("敵の体力："+Stats_enemy.getHP());
    mains.rine();
    System.out.println("自分の名前："+Stats_player.getName());
    System.out.println("自分の体力:"+Stats_player.getHP());
    mains.rine();
  }
}
