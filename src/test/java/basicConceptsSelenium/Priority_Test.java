package basicConceptsSelenium;

import org.testng.annotations.Test;

public class Priority_Test {
	@Test(priority=2)
	 public void createUser(){
	 System.out.println("createUser...");
	 }
	@Test(priority=3)
	 public void LoginUser(){
	 System.out.println("loginUser...");
	 }
	@Test(priority=1)
	 public void DeleteUser(){
	 System.out.println("deleteUser...");
	 }
	
	
	
}
