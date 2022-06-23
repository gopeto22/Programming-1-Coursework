import bugs.Bug;
import bugs.ConcurrentModificationBug;
import bugs.NoneTerminationBug;
import bugs.NullPointerBug;
import building.Building;
import students.Team;

public class EcsBuildingDefence {//creating public class EcsBuildingDefence
  static Battle battle;//creating static variable called battle and is of type int

  public static void main(String[] args) throws Exception {//creating the main method in the class
    int currentSteps = 0;//declaring a new int variable called currentSteps which is equal to 0
    Reader reader = new Reader((args[2]));//creating new instance of the Reader class called reader
    battle = new Battle(new Team(Integer.parseInt(args[3])), new Building(Integer.parseInt(args[0]), Integer.parseInt(args[1])));//create a new Battle between the team and the building which is attacked by the bugs.txt
    String line = reader.getLine();
    while (line != null) {
      creatingWaveOfBugs(line);
      for (int i = 0; i < 8 * battle.building.getTopFloor(); i++) {
        battle.step();
      }
      line = reader.getLine();
    }
  }

  public static void createBug(String[] informationOfBug)
      throws Exception {//creating a method called createBug which takes a parameter of type String array called informationBug
    Bug bug1;//creating a new instance of Bug
    if (informationOfBug[1].equals(
        "CMB")) {//if the first field of the newly created bug is CMB then creating a new concurrentModificationBug
      bug1 = new ConcurrentModificationBug(informationOfBug[0],
          Integer.parseInt(informationOfBug[2]), Integer.parseInt(informationOfBug[3].replace(")",
          "")));//it changes the information from int to String and replaces brackets with abbreviation
    } else if (informationOfBug[1].equals(
        "NPB")) {//if the first field of the newly created bug is NPB then creating a new NullPointerBug
      bug1 = new NullPointerBug(informationOfBug[0], Integer.parseInt(informationOfBug[2]),
          Integer.parseInt(informationOfBug[3].replace(")",
              "")));//it changes the information from int to String and replaces brackets with abbreviation
    } else if (informationOfBug[1].equals(
        "NTB")) {//if the first field of the newly created bug is NTB then creating a new NoneTerminationBug
      bug1 = new NoneTerminationBug(informationOfBug[0], Integer.parseInt(informationOfBug[2]),
          Integer.parseInt(informationOfBug[3].replace(")",
              "")));//it changes the information from int to String and replaces brackets with abbreviation
    } else {//creating an else statement
      throw new Exception("Such bug doesn`t exist : "
          + informationOfBug[1]);//throws an exception if such bug does not exist with the following text
    }
    battle.building.addBug(bug1);//add the type of bug into the building and battle
  }

  public static void creatingWaveOfBugs(String edit)
      throws Exception {//creating a method representing a wave of bugs.txt taking String variable called edit as parameter
    String[] bugs = edit.split(
        ";");//looping through the bug with the variable with the purpose of splitting by the semicolon
      for (String bug : bugs) {
          createBug(bug.replace("(", ",").split(
              ","));//creating a new bug replacing the bracket with a comma and spliting by the comma afterwards
      }

  }
}


