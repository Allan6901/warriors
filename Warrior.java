public class Warrior {
  private final String UserName;
  private int Health;
  private int LocationX;
  private int LocationY;
  private String ClassName;
  private int Damage;

  public Warrior(String userName, int choice, int locationX, int locationY) {
    this.Health = 100;
    this.UserName = userName;
    this.LocationX = locationX;
    this.LocationY = locationY;

    switch (choice) {

      case 1:
        this.ClassName = " Archer ";
        this.Damage = 10;
        this.Health = 125;
        break;

      case 2:
        this.ClassName = " Guerrier ";
        this.Damage = 30;
        this.Health = 80;
        break;

      case 3:
        this.ClassName = " Cavalier ";
        this.Damage = 25;
        break;

      case 4:
        this.ClassName = " Sorcière ";
        this.Damage = 45;
        this.Health = 35;
        break;

    }

  }

  public String getClassName() {
    return ClassName;
  }

  public double getDamage() {
    return this.Damage;
  }

  public double getHealth() {
    return this.Health;
  }

  public String getUserName() {
    return this.UserName;
  }

  public void displaySkills() {
    System.out.println(getUserName());

    System.out.println("Class : " + this.ClassName);

    System.out.println("Damage : " + this.getDamage());

    System.out.println("Health : " + this.getHealth());

  }

  public int getLocationX() {
    return LocationX;
  }

  public int getLocationY() {
    return LocationY;
  }

  public void attack(Warrior ennemy, int x, int y) {
    if (ennemy.LocationX == x && ennemy.LocationY == y) {
      ennemy.Health -= this.Damage;

      System.out.println(this.UserName + " à attaqué " + ennemy.UserName + " il lui reste " + ennemy.Health);

      System.out.println("Touché");

    } else {
      System.out.println("Manqué");
    }

  }

  public void move(int x, int y) {

    this.LocationX = x;

    this.LocationY = y;
    for (int i = 0; i < 250; i++) {
      System.out.println();
    }

    System.out.println("Move effectué avec succès ");
  }
}
