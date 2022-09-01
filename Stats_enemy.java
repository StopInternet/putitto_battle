public class Stats_enemy {
  public static String name;
  public static int HP;
  public static int damage;
  //敵のステータスを決定。
  public Stats_enemy(String name,int hP, int Damage) {
    Stats_enemy.name = name;
    HP = hP;
    damage = Damage;
  }
  public static String getName() {
    return name;
  }
  
  public static int getHP() {
    return HP;
  }
  public void setName(String name) {
    Stats_enemy.name = name;
  }
  public static void setHP(int hP) {
    HP = hP;
  }
  public static int getDamage() {
    return damage;
  }
  
}
