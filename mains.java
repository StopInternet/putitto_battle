import java.util.*;
public class mains extends battle{
  public mains() {
  }
  public static void rine(){
    //ラインの生成
    System.out.println("------------------");
  }
  public static List<String> namelists = new ArrayList<>();
  public static void main(String[] args) {
    /*
     * 自分のHPをランダムで生成。
     * 攻撃手段によって攻撃力の変化
     * 相手のHPもランダムで生成
     * HPは100~130で生成する。
     * HPと名前はクラス化
     */

    //敵の名前をランダムで決定
    namelists.add("Yamato");
    namelists.add("Kazu");
    namelists.add("Tarou");
    namelists.add("Pika");
    namelists.add("Shion");

    try (Scanner stdIn = new Scanner(System.in)) {
      Random rand = new Random();
      
      //初期設定
      int enemyHP = rand.nextInt(100,200);
      int enemyNames = rand.nextInt(namelists.size());
      String enemyName = namelists.get(enemyNames);
      int enemyDamage = rand.nextInt(10,20);
      new Stats_enemy(enemyName,enemyHP,enemyDamage);

      //自分のステータスを設定
      int check =0;
      int myHP =0;
      String myName = "";
      new attack(0);
      
      //逃げる動作の判定
      Boolean escapes = false;
      rine();
      System.out.println("プチっとバトル");
      rine();
      
      while(true){
          //プチモン選択
          System.out.println("プチモンを選んでね！");
          //自分のステータスを設定。
          myHP = rand.nextInt(100,200);
          int playerDamage = rand.nextInt(10,20);
          new Counters(Stats_enemy.getDamage()*3);
          rine();
          System.out.println("1..ソーランス / 2..ディイダ / 3..ヨクバラナイ");
          String choices = stdIn.next();

          //選択処理
          switch(choices){
          case "1": 
            monster.soonansu();
            myName = "ソーランス";
            break;
          case "2":
            monster.degda();
            myName = "ディイダ";
            break;
          case "3":
            monster.yokubarisu();
            myName = "ヨクバラナイ";
            break;
          default:
            System.out.println("１か２か３を選んでね！");
            continue;
        }
      //ステータスの決定
      try{
      new Stats_player(myName, myHP,playerDamage);
      rine();
      System.out.println("名前:"+Stats_player.getName()+"\n"+
                         "体力:"+Stats_player.getHP()+"\n"+
                         "攻撃力："+Stats_player.getDamage());
      rine();
      //判定
      System.out.println("これでいいですか？ \n"
      +"1..決定 / 2..決めなおす");
      check = stdIn.nextInt();
      if(check == 1){
        rine();
        System.out.println("バトルスタート！");
        rine();
      } else if(check == 2){
        System.out.println("決めなおします！");
        continue;
      }
      }catch(InputMismatchException e){
        //数値以外を入力した時の処理。
        System.out.println("エラー発生："+e);
        System.out.println("正しい値で入力して！");
        continue;
    }

      //相手のステータス
      rine();
      System.out.println("対戦相手がきまりました！");
      System.out.println("名前："+Stats_enemy.getName());
      System.out.println("体力："+Stats_enemy.getHP());
      System.out.println("攻撃力:"+Stats_enemy.getDamage());
      rine();


    while(true){
      //勝敗判定
      if(Stats_enemy.getHP() <= 0 &&
         Stats_player.getHP() > 0){//勝利時の判定
          Stats_check.Stats_checks();
          System.out.println(Stats_player.getName()+"は勝利した！");
        System.exit(1);
      }else if(Stats_player.getHP() <= 0 && //敗北時の判定
         Stats_enemy.getHP() > 0){
          Stats_check.Stats_checks();
          System.out.println(Stats_player.getName()+"は負けた！");
        System.exit(1);
        break;
      }else if(Stats_enemy.getHP() == 0 &&
               Stats_player.getHP() == 0){//引き分け時の判定
        System.out.println("引き分け！！");
        System.exit(1);
      }

    //ステータス確認
      Stats_check.Stats_checks();
      //自分の行動
      System.out.println(Stats_player.getName()+"はどうする？");
      System.out.println("た た か う 1 / に げ る 2 / カ ウ ン タ ー 3");
      String choice = stdIn.next();
      /*
       * 1,闘う　攻撃力をそのまま与える。
       * 2,逃げる　50%の確立で逃げることを成功。
       * 3,カウンター 25%の確立で相手からのダメージを防いで、3倍のダメージを与える。
       */
      rine();
      //equalsで判定処理
      if(choice.equals("1")){
        Attacks(true,Stats_enemy.getHP(),Stats_player.getDamage(),Stats_enemy.getName());
      }else if(choice.equals("2")){//逃げる処理
        if(escape.escapes(escapes) == true){
          System.exit(1);
        }else{
          System.out.println("逃げることに失敗した！");
        }
      } else if(choice.equals("3")){//カウンター処理
        //カウンターの確立を生成 25%の確立でカウンター成功
        int kaku = rand.nextInt(1,100);
        if(kaku < 25){
          Counters.Counter();
          System.out.println("相手の攻撃を防いだぞ！");
          monster.yaruo();
          continue;
        } else if(25 <= kaku){
          System.out.println("カウンターに失敗した");
        }
      }
      //1~3以外の入力が来た場合。
      else {
        System.out.println("たたかうか逃げるか選べ！");
      }
      //相手の行動
      monster.yaruo();
      Attacks(false, Stats_player.getHP(),Stats_enemy.getDamage(),Stats_player.getName());
     }
    }
  }
  }
}