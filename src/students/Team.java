package students;

import building.Building;
import java.util.ArrayList;

public class Team {//creating the team class
  Toolbox probs = new Toolbox();//creating a new variable called probs of type Toolbox
  int costOfRecruitingNewStudent = 100;//creating a new variable called costOfRecruitingNewStudent of type integer and assigning its value with 100
  ArrayList<Student> collectionOfStudents = new ArrayList<Student>();//creating new ArrayList of type Student called collectionOfStudents
  int initialKnowledgePoints ;//creating a variable called initialKnowledgePoints and assigning its value to 0
  int recruitingKnowledgePoints = initialKnowledgePoints + 100;//creating a variable called recruitingKnowledgePoints and assigning its value to initialKnowledgePoints + 100 which is equal to 100

  public Team(int initialKnowledgePoints) {//creating constructor of the Team class which takes variable called initialKnowledgePoints of type int as parameter
    this.initialKnowledgePoints = initialKnowledgePoints;//assigning the value of the variable initialKnowledgePoints declared at the start of the file with the parameter named initialKnowledgePoints
  }

  public int getKnowledgePoints() {
    return initialKnowledgePoints;
  }//creating a method called getKnowledge points which returns the initialKnowledgePoints

  public Student[] getStudents() {
    collectionOfStudents.addAll(this.collectionOfStudents);//add all the students in teh arraylist
    Student[] arrayOfStudents = new Student[collectionOfStudents.size()];//creating a new array called arrayOfStudents which is equal to the size of the arraylist
    arrayOfStudents = collectionOfStudents.toArray(
        arrayOfStudents);//using to array on the arraylist and assigning the changes to the new array of students
    return arrayOfStudents;
  }//creating getStudents method which returns array of Students

  public int studentsAct(
      Building building) {//creating method called studentsAct of type int which takes instance of Building class as parameter
    for (Student student : collectionOfStudents) {//looping through the arraylist of student to see if there is student instance of Student class
      initialKnowledgePoints = initialKnowledgePoints + student.defence(building);//rising the initialKnowledgePoints with the sum of initialKnowledgePoints with the points returned by the students when defencing the building
    }
    return 0;//returns 0
  }

  public int getNewStudentCost() {
    return costOfRecruitingNewStudent;
  }//creating new method called getNewStudentCost which is of type int and returns costOfRecruitingNewStudent

  public void recruitNewStudent() throws Exception {//creating a method called recruitNewStudent which throws exception
    Integer typeOfNewStudent;//creating new variable called typeOfNewStudent which is of type int
    if (initialKnowledgePoints < costOfRecruitingNewStudent) {//creating an if statement which checks if the initialKnowledgePoints is smaller than costOfRecruitingNewStudent
      throw new Exception("Dont have enough points");
    }else {
      initialKnowledgePoints = initialKnowledgePoints - getNewStudentCost();//decreasing the initialKnowledgePoints by the points that getting new student require
      typeOfNewStudent = probs.getRandomInteger(4);//initialising the variable typeOfNewStudent equals the toolbox variable which takes random integer between 0 and 4
      if (typeOfNewStudent == 1) {// creating an if statement which checks if the typeOfNewStudent is equal to 1
        collectionOfStudents.add(
            new AiStudent(1));//add new Aistudent in collectionOfStudent as new student
      }
      if (typeOfNewStudent == 2) {// creating an if statement which checks if the typeOfNewStudent is equal to 2
        collectionOfStudents.add(
            new CsStudent(1));//add new Csstudent in collectionOfStudent as new student
      }
      if (typeOfNewStudent == 3) {// creating an if statement which checks if the typeOfNewStudent is equal to 3
        collectionOfStudents.add(
            new SeStudent(1));//add new Sestudent in collectionOfStudent as new student
      }
      if (typeOfNewStudent == 4) {// creating an if statement which checks if the typeOfNewStudent is equal to 4
        collectionOfStudents.add(
            new CyberStudent(1));//add new Cyberstudent in collectionOfStudent as new student
      }
      if(typeOfNewStudent==5){// creating an if statement which checks if the typeOfNewStudent is equal to 4
        collectionOfStudents.add(new AerospaceElecStudent(1));//add new AerospaceElecStudent in collectionOfStudent as new student
      }
      if(typeOfNewStudent==6){// creating an if statement which checks if the typeOfNewStudent is equal to 4
        collectionOfStudents.add(new BiomedicalEngStudent(1));//add new BiomedicalEngStudent in collectionOfStudent as new student
      }
      if(typeOfNewStudent==7){// creating an if statement which checks if the typeOfNewStudent is equal to 4
        collectionOfStudents.add(new ElectronicEngStudent(1));//add new ElectronicEngStudent in collectionOfStudent as new student
      }
      if(typeOfNewStudent==8){// creating an if statement which checks if the typeOfNewStudent is equal to 4
        collectionOfStudents.add(new ElectricalandElectronicEngStudent(1));//add new ElectricalandElectronicEngStudent in collectionOfStudent as new student
      }
      if(typeOfNewStudent==9){// creating an if statement which checks if the typeOfNewStudent is equal to 4
        collectionOfStudents.add(new ElectricalEngStudent(1));//add new ElectricalEngStudent in collectionOfStudent as new student
      }
      if(typeOfNewStudent==10){// creating an if statement which checks if the typeOfNewStudent is equal to 4
        collectionOfStudents.add(new MechatronicEngStudent(1));//add new MechatronicEngStudent in collectionOfStudent as new student
      }
      costOfRecruitingNewStudent = costOfRecruitingNewStudent + 10;//increasing the costOfRecruitingNewStudent by 10
    }
  }
  public void upgrade(Student student)
      throws Exception {//creating new method called upgrade which takes instanceof Student class as parameter and throws Exception
    if (initialKnowledgePoints
        < student.upgradeCost()) {//checking if initialKnowledgePoints are smaller than the points needed for this particular student to be upgraded
      throw new Exception();//throws new exception
    } else {
      initialKnowledgePoints -= student.upgradeCost();//decreasing the initialKnowledgePoints by the points needed for this particular student to be upgraded
      student.increaseLevel();//increasing the level of this particular student
    }
  }
}
