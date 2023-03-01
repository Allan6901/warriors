import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

 /*
   * Bienvenue dans mon jeu.
   * Le jeu est simple , chaque joueur possède un terrain carré dans l'un des côté
   * vaut 10;
   * Il existe 4 types de personne (1/2/3/4).
   * Chaque case sont représnté par des coordonnées tel que coordonnées = ( X, Y )
   * .
   * Chaque joueur possède 2 actions, Attack et Move.
   * A chaque tour, vous avez le droit à une seule action .
   * Attack sert à attaquer en précisant les coordoonées où l'on veut tiré .
   * Move sert à changer de case ( Pratique si l'adversaire à repéré votre
   * position ) .
   * Pardon pour les fautes d'orthograhes ( s'il y en a xD ) un peu la flemme de
   * verifier .
   * Attention ( MERCI DE RESPECTER LA CONVENTION D'ECRITURE DES COMMANDES ) >>
   * Attack <<, >> Move << .
   * Une faute de frappe sur la commande fait passer son tour. ( Prenez votre
   * temps ;) ).
   *
   * Se joue à 2 .
   *
   * POUR LANCER LE JEU =========> EXECUTER
   */


class Main {

  static List<Warrior> players = createWarriors();

  public static void main(String[] args) {
    runGame();
  }

  public static void runGame() {

    init();

    game();

  }

  public static void init() {

    System.out.println();

    displayWarriors(players);
  }

  public static void game() {
    
    boolean On = true;

    int s = 1;

    while (On)

    {
      switch (s) {
        case 1:

          Scanner sc = new Scanner(System.in);

          Scanner scp = new Scanner(System.in);

          System.out.print("Joueur 1 / Attack or Move? : ");

          String reply = sc.nextLine();

          if (reply.equals("Attack")) {
            Scanner x = new Scanner(System.in);

            Scanner y = new Scanner(System.in);

            System.out.print("Coordonée X (entre 0 et 10 ) : ");

            int locX = x.nextInt();

            System.out.print("Coordonée Y (entre 0 et 10 ) : ");

            int locY = y.nextInt();

            players.get(0).attack(players.get(1), locX, locY);
          } else if (reply.equals("Move")) {
            System.out.print("Coordonée X (entre 0 et 10 ) : ");

            int replyX1 = scp.nextInt();

            System.out.print("Coordonée Y (entre 0 et 10 ) : ");

            int replyY1 = scp.nextInt();

            players.get(0).move(replyX1, replyY1);
          }
          s = 0;

          break;

        case 0:
          Scanner scy = new Scanner(System.in);

          Scanner sc2 = new Scanner(System.in);

          System.out.print("Joueur 2 / Attack or Move? : ");

          String reply2 = sc2.next();

          if (reply2.equals("Attack")) {
            Scanner x2 = new Scanner(System.in);

            Scanner y2 = new Scanner(System.in);

            System.out.println("Coordonée X (entre 0 et 10 ) : ");

            int locX2 = x2.nextInt();

            System.out.println("Coordonée Y (entre 0 et 10 ) : ");

            int locY2 = y2.nextInt();

            players.get(1).attack(players.get(0), locX2, locY2);
          }

          else if (reply2.equals("Move")) {
            System.out.print("Coordonée X (entre 0 et 10 ) :");

            int replyX = sc2.nextInt();

            System.out.print("Coordonée Y (entre 0 et 10 ) : ");

            int replyY = scy.nextInt();

            players.get(1).move(replyX, replyY);
          }

          s = 1;

          break;
      }

      if (players.get(0).getHealth() <= 0) {
        System.out.println("Victoire de " + players.get(1).getUserName());

        On = false;
      } else if (players.get(1).getHealth() <= 0) {
        System.out.println("Victoire de " + players.get(0).getUserName());

        On = false;
      }

    }

  }

  public static List<Warrior> createWarriors() {
    String name;

    int catClass;

    List<Warrior> player = new ArrayList<>();

    ArrayList<Integer> location = randomLocation();

    int count = 0;

    do {

      Scanner scLoop = new Scanner(System.in);

      System.out.print("Entrer un nom : ");

      name = scLoop.next();

      System.out.print("Entrer une classe (1/2/3/4) :");

      catClass = scLoop.nextInt();

      player.add(new Warrior(name, catClass, location.get(count), location.get(count + 4)));

      count++;

    } while (player.size() < 2);

    return player;
  }

  public static ArrayList<Integer> randomLocation() {
    ArrayList<Integer> points = new ArrayList<>();

    for (int i = 0; i < 9; i++) {
      points.add(i);
    }

    Collections.shuffle(points);

    return points;
  }

  public static void displayWarriors(List<Warrior> warriors) {
    for (Warrior warrior : warriors) {
      warrior.displaySkills();

      System.out.println();
    }
  }

}
