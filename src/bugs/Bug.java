package bugs;

public class Bug {

  public int level;//declaring the baseHP,baseSteps and level of type int
  String name;//declaring the name of type String
  int baseHp, baseSteps;
  int currentSteps;
  int currentFloor;
  int currentHp;
  int damageToBuilding;

  public Bug(String name, int baseHp, int baseSteps,
      int level) {//creating a constructor which takes variables as parameters
    this.name = name;//initializing the variable name with the constructor parameter
    this.baseHp = baseHp;//initializing the variable baseHP with the constructor parameter
    this.baseSteps = baseSteps;//initializing the variable baseSteps with the constructor parameter
    this.level = level;//initializing the variable level with the constructor parameter
    this.currentHp = (int) Math.round(this.baseHp * (Math.pow(level, 1.5)));
    currentFloor = -1;
    currentSteps = baseSteps;
  }

  public Bug(String name, int baseHp, int baseSteps, int level, int initialSteps) {
    this.name = name;//initializing the variable name with the constructor parameter
    this.baseHp = baseHp;//initializing the variable baseHP with the constructor parameter
    this.baseSteps = baseSteps;//initializing the variable baseSteps with the constructor parameter
    this.level = level;//initializing the variable level with the constructor parameter
    this.currentSteps = initialSteps;//initializing the variable current steps with constructor parameter
    this.currentHp = (int) Math.round(
        this.baseHp * (Math.pow(level, 1.5)));//initialising the current HP
    currentFloor = -1;//initialising the floor from which every bug start
    if (currentSteps == 0) {//creating an if-statement to compare the current steps to 0
    }
  }

  public static void main(String[] args) {
  }

  public String getName() {
    return this.name;
  }

  public int getBaseSteps() {//creating the method called getBaseSteps
    return this.baseSteps;//returning the steps of the bug in the body of the method
  }

  public int getLevel() {//creating the method called getLevel
    return this.level;//returning the level of the bug in the body of the method
  }

  public int getCurrentHp() {//creating the getter getCurrentHP
    return this.currentHp;//returning the currentHP in this method
  }

  public int getCurrentSteps() {//creating the getter getCurrentSteps
    return this.currentSteps;//returning of the current steps
  }

  public int getCurrentFloor() {//creating the getter getCurrentFloor
    return this.currentFloor;//returning of the current floor
  }

  public void move() {//creating the method move
    if (currentSteps > 0) {//checking if the current steps are more than 0
      currentSteps = currentSteps - 1;//decreasing the steps by 1
      // declaring if statement if current steps need are positive at every time
    } else {//creating the else statement
      currentFloor = currentFloor + 1;//increases the floor by 1
      currentSteps = baseSteps - 1;//current steps are reset to base steps minus 1
    }
  }

  public void damage(int amount) {
    currentHp = currentHp - amount;//decreases the currentHP of the bug by the input amount
    if (currentHp < 0) {//creating if-statement which does not allow the current Hp go below 0
      currentHp = 0;
    }
  }

  public int getDamage() {
    return this.damageToBuilding;
  }//creating method for the damage done to the building by the bug

  public void slowDown(int steps) {//creating the method slowDown whih takes intger as parameter
    currentSteps = steps + currentSteps;//slowing down
  }//creating method which assigns more steps to the current and slows the bug
}
