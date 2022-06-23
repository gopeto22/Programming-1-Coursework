package building;

import bugs.Bug;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Building {//creating a public class called Building
  int constructionPoints;//creating variable called constructionPoints
  int topFloor;//creating variable called topFloor
  ArrayList<Bug> bugs = new ArrayList<Bug>();//creating new ArrayList of bugs.txt called bugs.txt and its type Bug

  public Building(int topFloor,
      int constructionPoints) {//creating constructor for building taking topFloor and constructionPoints as parameters
    this.topFloor = topFloor;//assigning the topFloor variable with parameter topFloor
    this.constructionPoints = constructionPoints;//assigning the constructionPoints variable with parameter topFloor
  }

  public int getTopFloor() {
    return topFloor;
  }//creating the method getTopFloor of type int which returns the top Floor

  public int getConstructionPoints() {
    return this.constructionPoints;
  }//creating the method getConstructionPoints of type int which returns the construction Points

  public Bug[] getAllBugs() { //creating method getAllBugs of type Array of Bug
    ArrayList<Bug> arrayBugs = new ArrayList<Bug>();//creating a new ArrayList of type Bug which is called arrayBugs
    for (Bug bug : bugs) {//creating a for-each loop which loops through all the bugs.txt in the previously declared arrayList called bugs.txt
      if (bug.getCurrentFloor() >= 0) {//creating an if statement in which see if the bugs.txt currentFloor is equal or bigger than 0 adds a new bug to the arrayLisst called arrayOfBugs
        arrayBugs.add(bug);
      }
    }
    Collections.sort(arrayBugs,
        new Comparator<Bug>() {//creating a new Comparator and sorting the arrayList with the keyword sort
          @Override
          public int compare(Bug o1,
              Bug o2) {//overriding the comparison of 2 bugs.txt which are instantly created and are called o1 and o2
            if (o1.getCurrentFloor()
                > o2.getCurrentFloor()) {//creating an if statement which compares if the first bugs.txt floor is higher than the second one
              return -1;//returns -1 which sorts the bug closer to the topFloor and the start of the array than the second bug
            } else if (o1.getCurrentFloor()
                == o2.getCurrentFloor()) {//creating an else if statement which compares if the first bugs.txt floor is equal to the second bugs.txt floor
              if (o1.getCurrentSteps()
                  < o2.getCurrentSteps()) {//creating an if statement which compares if the first bugs.txt current steps are less  to the second bugs.txt current steps
                return -1;//returns -1 which means the first bug is closer to the topFloor having the fact that he got fewer steps left to make until he reaches the top floor
              } else if (o1.getCurrentSteps()
                  > o2.getCurrentSteps()) {//creating an else if statement which compares if the first bugs.txt current steps are more than the second bugs.txt current steps
                return 1;//returns 1 which means the first bug is more distant to the top floor than the second one and has more steps to make in order to get to it
              } else {//creating an else statement which represents if the first bug current steps are equal to the second bug current steps
                return 0;//returns 0 saying that they are on the same distance from the top floor
              }
            } else {//creating an else statement which represents if the first bug current floor is smaller than the second bugs.txt current floor
              return 1;//return 1 meaning that the first bug is further to the top floor than the second bug and the second bug is on higher floor
            }
          }
        });
    return arrayBugs.toArray(
        new Bug[0]);//returning the arraylist of bugs.txt to array because of the declaration of the method and creating new array of Bug type which is empty
  }

  public int addBug(Bug bug) {//creating a method of int type which takes instantly declared bug as parameter
    if (bugs.contains(bug)) {//creating an if statement which checks if the arrayList bugs.txt contain this bug that we declared in the method above
      return -1;//returns -1 which means that this bug won't be added to the arrayList
    } else {//creating an else statement which represents if the arraylist doesn't contain this instantly created bug
      bugs.add(bug);//add this bug to the arraylist
      return bugs.size();//returning the size of the arraylist bugs.txt containing all of the bugs.txt
    }
  }

  public void removeBug(Bug bug) {
    bugs.remove(bug);
  }//creating a method called removeBug which takes instantly created bug as parameter and removes it from the arraylist called bugs.txt

  public void bugsMove() {//creating a method called bugsMove
    for (Bug bug : bugs.toArray(
        new Bug[0])) {//looping through the arraylist bugs.txt which is transformed into array of type Bug which is empty and sees if there are any bugs.txt into it declared from the instant created variable bug of type Bug
      bug.move();//using the bugs.txt move method which moves the bug 1 step and decreases the current steps by 1
      if (bug.getCurrentFloor()
          == topFloor) {//creating an if statement to check if the bugs.txt current floor is the top floor
        constructionPoints = constructionPoints
            - bug.getDamage();//if it is it subtracts the construction points of the building with the damage that the bug does to the building
        bugs.remove(bug);//it removes the bug from the building
        if (constructionPoints
            == 0) {//creating an else statement which checks if the construction points are equal to 0
          break;//if they are equal to 0 breaks the for loop
        }
      }
    }
  }
}
