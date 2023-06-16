package com.selenium.Cse1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class D7C4 {
	WebDriver driver;
  @Test
  public void Test1() throws Exception {
	  WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
	  driver.findElement(By.name("username")).sendKeys("Admin"); // username
	  driver.findElement(By.name("password")).sendKeys("admin123"); //pwd
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();//click login
	  Thread.sleep(3000);
	  String u1=driver.getCurrentUrl();
	  System.out.println(u1);
	  String u2="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	  Assert.assertEquals(u1, u2);
  }
  @Test(dependsOnMethods = "Test1")
  public void Test2() throws Exception {
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
	
  }
}
