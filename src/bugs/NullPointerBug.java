package bugs;

public class NullPointerBug extends Bug {//creating a subclass of Bug called NullPointerBug

  public NullPointerBug(String name, int level,
      int initialSteps) {//creating the constructor of NullPointerBug
    super(name, 10, 2, level,
        initialSteps);//assigning value to the base NullPointerBug in the Bug constructor
    this.name = name;//initialising variable name from Bug to parameter name
    this.level = level;//initialising variable level from Bug to parameter name
  }

  @Override
  public int getDamage() {//overriding the method declared in Bug and assigning it with some values
    damageToBuilding = 1;//assigning the value of 1 as damage which this bug does to the building
    return super.getDamage();//returning getDamage from the Bug class
  }
}
