public class Stats_player {
  public static String name;
  public static int HP;
  public static int Damage;
  //自分のステータスを決定
  public Stats_player(String name, int hP,int damage) {
    Stats_player.name = name;
    HP = hP;
    Damage = damage;
  }

  public static String getName() {
    return name;
  }

  public static int getHP() {
    return HP;
  }

  public void setName(String name) {
    Stats_player.name = name;
  }

  public static void setHP(int hP) {
    HP = hP;
  }

  public static int getDamage() {
    return Damage;
  }

  
}
