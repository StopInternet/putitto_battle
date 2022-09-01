import java.util.*;
public class attack implements Stats_waza{
  /*
   * ダメージ処理
   * BaiDamageは急所時の処理判定
   * 
   */
  public static int BaiDamage;

  //コンストラクタ
    public attack(int baiDamage) {
    BaiDamage = baiDamage;
  }

  //セッター、ゲッター
  public static void setBaiDamage(int baiDamage) {
    BaiDamage = baiDamage;
  }

  public static int getBaiDamage() {
    return BaiDamage;
  }
  //ダメージ処理（25%で急所に入る）
  static public int attacks(int partnerPokeHealth ,int damage, String message){
    Random rand = new Random();
    int kyusyo = rand.nextInt(1,100);
    if(25 < kyusyo){
      partnerPokeHealth -= damage;
      attack.setBaiDamage(damage);
    } else if(25 >= kyusyo){
      //急所ダメージ
      partnerPokeHealth -= damage*2;
      System.out.println("急所に当たった!2倍のダメージ!");
      attack.setBaiDamage(damage*2);
    }
    return partnerPokeHealth;
}
}
