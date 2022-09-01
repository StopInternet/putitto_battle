public class battle{
  public battle() {
  }
  /*
   * ダメージを受けた or 与えた時のメッセージ処理（急所時も含める）
   */
  public static void message1(int damages){
    System.out.println("残り体力："+Stats_player.getHP()+"\n"+
                         Stats_player.getName() + "は" + Stats_enemy.getName()+"に"+
                         damages+"ダメージを与えた！\n");
  }
  public static void message2(int damages){
    System.out.println("残り体力："+Stats_player.getHP()+"\n"+
                         Stats_player.getName()+"は"+Stats_enemy.getName()+"から"+
                         damages+"ダメージを受けた！\n");
  }
  //攻撃処理
  public static void Attacks(Boolean PorE,int health,int damage, String message){
    /*
     * PorEで攻撃を判定する
     */
    //true == 自分から相手, false == 相手から自分
    if(PorE == true){//自分から相手時
    Stats_enemy.setHP(attack.attacks(health,damage,message)); 
     if(Stats_enemy.getHP() <=0 ){
      //0以下のダメージを食らったとき0にする。
      Stats_enemy.setHP(0);
    }
      message1(attack.getBaiDamage());
    }else if (PorE == false){//相手から自分
      Stats_player.setHP(attack.attacks(health,damage,message));
      if(Stats_player.getHP() <= 0 ){
        //0以下のダメージを食らったとき0にする。
        Stats_player.setHP(0);
      }
      message2(attack.getBaiDamage());
    }
  }
}
