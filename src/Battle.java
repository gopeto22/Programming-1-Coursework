import bugs.Bug;
import building.Building;
import students.Student;
import students.Team;

public class Battle {//creating the class Battle
  Student student;
  Team team;//creating instance of the Team class called team
  Building building;//creating instance of the Building class called building
  Battle(Team team,
      Building building) {//creating constructor of the class Battle taking instances of the Team and the Building classes as parameters
    this.team = team;//initialising the variable team with the parameter created in the constructor
    this.building = building;//initialising the variable building with the parameter created in the constructor
  }
  public void manageTeam() {//creating a method called manageTeam
    if (team.getStudents().length == 0) {//creating an if statement which checks if the getStudents method length is equal to 0
      try {
        team.recruitNewStudent();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    } else {//creating an else statement
      if (team.getKnowledgePoints() >= team.getNewStudentCost()) {//creating an if statement which checks if the knowledge points in the team instance are enough for the cost of getting a new student
        try {//try statement
          team.recruitNewStudent();//if they are sufficient recruit this student to the team
        } catch (Exception insufficientKnowledgePoints) {//catch statement
          System.out.println("Insufficient Knowledge Points for recruiting new student");//if they are not sufficient output this message
        }
      } //for (Student student:team.getStudents()){
       else if (team.getKnowledgePoints() >= team.getNewStudentCost()) {//creating an if else statement which checks if the knowledge points in the team instance are enough to upgrade a current student
         try {//try statement
           team.upgrade(student);//if they are sufficient upgrade an existing student
         } catch (Exception insufficientKnowledgePoints) {//catch statement
           System.out.println("Insufficient Knowledge Points for upgrading an existing student");//if they are not sufficient output this message
         }
       }
      //}
    }
  }
  public void step() {//creating method called step
    try {
      Thread.sleep(500);//slowing down the process
      manageTeam();//using manageTeam method
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    this.building.bugsMove();//moving all the bugs.txt in the building
    team.studentsAct(this.building);//using the studentsAct method on the building by the team instance
    System.out.println("The knowledge points of the student are: " + team.getKnowledgePoints());
    System.out.println("The student cost is: " + team.getNewStudentCost());
   // for (Student student : team.getStudents()) {
     // System.out.println("The student level is: " + student.getLevel());
   // }
    System.out.println(
        "The construction points of the building are: " + building.getConstructionPoints());
    for (Bug bug : building.getAllBugs()) {
      System.out.println(
          "The name is: " + bug.getName() + "The current HP is: " + bug.getCurrentHp());
    }
  }
}
