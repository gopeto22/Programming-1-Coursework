package students;

import bugs.Bug;
import building.Building;

public class BiomedicalEngStudent implements
    Student { //creating the public class Biomedical Engineering student which implements the interface Student

  int level = 1;//creating a variable called level and assigning it with the value of 1
  int cost;//creating a variable called cost
  int counter = 1;//creating a variable called counter and assigning it with the value of 1
  int attack = 5;//creating a variable called attack which represents the attack power of the student and assigning it with the value of 5
  int delay = 8;//creating a variable called delay which represents the delay steps of the student and assigning it with the value of 8

  public BiomedicalEngStudent(
      int level) {//creating the constructor of Biomedical student which takes int variable called level as parameter
    this.level = level;//assigning the variable declared at the start of the class with the parameter declared in the constructor
    this.cost = 100 * (int) Math.pow(2,
        level);//assigning the value of the variable cost declared in the start of the class using the math documentation and have the square of level times 100
  }

  @Override
  public int increaseLevel() {//overriding the increaseLevel method declared in the Student interface
    level++;//increasing the level accordingly
    return level;//returning the level
  }

  @Override
  public int getLevel() {
    return this.level;
  }//overriding the getLevel method declared in the Student interface and returning the current level of the student

  @Override
  public int upgradeCost() {
    return cost;
  }//overriding the upgradeCost method declared in the Student interface and return the cost which we have assigned above in the constructor

  @Override
  public int defence(
      Building building) {//overriding the defence method declared in the Student interface
    if (building.getAllBugs().length
        == 0) {//checking if the getAllBugs method contains in bugs.txt in itself
    } else {//creating an else statement if it contains bugs.txt in itself
      Bug bug = building.getAllBugs()[0];//creating a new bug and assigning its place as the first in the array created by getAllBugs method in building class
      Bug bug1 = building.getAllBugs()[1];//creating a new bug and assigning its place as the second in the array created by getAllBugs method in building class
      Bug bug2 = building.getAllBugs()[2];//creating a new bug and assigning its place as the third in the array created by getAllBugs method in building class
      int knowledgePoints = 0;//creating variable of type int called knowledgePoints and assigning its value to 0
      int normalAttack = (int) Math.round(this.attack * (Math.pow(level,
          1.2)));//creating a variable of type int called normal attack,introducing the math documentation and have the level squared 1.2 summed with the attack
      int specialAttack =
          normalAttack + knowledgePoints + 20;//creating int variable called special attack
      if (counter
          < delay) {//creating an if statement comparing the variable called counter with the value of the delay variable
        bug.damage(
            normalAttack);//the student doing a normal attack and causing damage to the first bug
        if (bug.getCurrentHp()
            == 0) {//creating an if statement which checks whether the HP of the bug after the normal attack are equal to 0
          building.removeBug(bug);//removing the bug if the building in case the HP are equal to 0
          knowledgePoints = (bug.level)
              * 20;//rising the knowledge points with the level times the bug and times 20
        }
        counter++;//increase the counter accordingly
      } else {//creating an else statement if the counter is equal to delay
        bug.damage(
            specialAttack);//the student doing a special attack and causing damage to the first bug
        bug1.damage(
            specialAttack);//the student doing a special attack and causing damage to the first bug
        bug2.damage(
            specialAttack);//the student doing a special attack and causing damage to the first bug
        if (bug.getCurrentHp() == 0) {//checking if the bug current HP are equal to 0
          building.removeBug(bug);//removing the bug if the building in case the HP are equal to 0
          building.removeBug(bug1);//removing the bug if the building in case the HP are equal to 0
          building.removeBug(bug2);//removing the bug if the building in case the HP are equal to 0
          knowledgePoints = (bug.level)
              * 20;//rising the knowledge points with the level times the bug and times 20
        }
        counter = 1;//assigning the counter to 1 in order for the student to start again with the normal attacks
      }
      return knowledgePoints;//returning the knowledge points
    }
    return 0;//returning 0
  }
}