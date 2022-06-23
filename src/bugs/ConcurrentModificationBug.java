package bugs;

public class ConcurrentModificationBug extends
    Bug {//creating a subclass of Bug called ConcurrentModificationBug

  public ConcurrentModificationBug(String name, int level,
      int initialSteps) {//creating the constructor of ConcurrentModificationBug
    super(name, 20, 4, level,
        initialSteps);//assigning value to the base ConcurrentModificationBug in the Bug constructor
    this.name = name;//initialising variable name from Bug to parameter name
    this.level = level;//initialising variable level from Bug to parameter name
  }

  @Override
  public int getDamage() {//overriding the method declared in Bug and assigning it with some values
    damageToBuilding = 2;//assigning the value of 2 as damage which this bug does to the building
    return super.getDamage();//returning getDamage from the Bug class
  }
}
