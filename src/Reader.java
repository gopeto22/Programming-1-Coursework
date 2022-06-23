import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {//creating public class called reader
  BufferedReader reader;//creating instance of Buffered reader

  public Reader(
      String fileName) {//creating a constructor of the reader class which takes String variable called fileName as parameter
    try {//try statement
      reader = new BufferedReader(new FileReader(
          fileName));//initialising the reader variable of type buffered reader as a new variable of tpe fileReader
    } catch (Exception e) {//catch statement
      System.out.println(
          "Can`t find the error: " + e);//printing an exception with the following text
    }
  }

  public String getLine() {//creating method of type String called getLine
    try {//try statement
      return reader.readLine();//returning a single line at a time that the reader reads
    } catch (Exception e) {//catch statement
      return null;//return nothing
    }
  }

  public boolean fileIsReady() {//creating method of type boolean called fileIsReady
    try {//try statement
      return (reader.ready());//returning the state that the file is ready to be read
    } catch (IOException e) {//catch statement
      return false;//returning that the file is not ready to be read as false
    }
  }
}


