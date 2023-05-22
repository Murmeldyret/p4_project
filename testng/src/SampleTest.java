package testng.src;


import org.testng.annotations.*;
import org.testng.Assert;

public class SampleTest {

   String message = "Hello World";
   MessageUtil messageUtil = new MessageUtil(message);

   @Test
   public void testPrintMessage() {
      Assert.assertEquals(message, messageUtil.printMessage());
   }
}