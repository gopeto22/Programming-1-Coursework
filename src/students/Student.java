package students;

import building.Building;

public interface Student {//creating the interface student

  int increaseLevel();//creating the public method increaseLevel which is of type int

  int getLevel();//creating the public method getLevel which is of type int

  int upgradeCost();//creating the public method upgradeCost which is of type int

  int defence(
      Building building);//creating the public method defence which is of type int and takes instance of Building class as parameter
}
