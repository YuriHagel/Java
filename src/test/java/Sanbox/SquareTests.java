package Sanbox;


import Sandbox.Square;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class SquareTests {

  public void testArea() {
    Square s = new Square(5);
//    assert s.area() == 25;
    Assert.assertEquals(s.area(),25.0);
  }



}
