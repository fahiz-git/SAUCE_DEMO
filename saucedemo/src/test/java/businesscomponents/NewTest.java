package businesscomponents;

import org.testng.annotations.Test;

import base.CartBase;
import base.HomeBase;
import base.LoginBase;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class NewTest {
	public static WebDriver driver;
  @BeforeClass
  public void setUp() {
	  //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Faiz\\Desktop\\chromedriver_win32\\chromedriver.exe");
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://www.saucedemo.com/");
  }
  
  @Test
  public void loginSwagLabs() {
	  LoginBase.login();
  }
  
  
  @Test(dependsOnMethods = "loginSwagLabs")
  public void sortPriceLowToHigh() {
	  HomeBase.sortLowToHigh();
	  
  }
  
  @Test(dependsOnMethods = "sortPriceLowToHigh")
  public void addAllItemsToCart() {
	  HomeBase.addCart();
	  
  }
  
  @Test(dependsOnMethods = "addAllItemsToCart")
  public void gotoCart() {
	  HomeBase.toCart();
	  
  }
  
  @Test(dependsOnMethods = "gotoCart")
  public void removeItems() {
	  CartBase.remove();
	  
  }
  @Test(dependsOnMethods = "removeItems")
  public void confirmOrder() throws InterruptedException {
	  CartBase.addDetails();
	  
  }
  
  @Test(dependsOnMethods = "confirmOrder")
  public void logoutFromSauceDemo() throws InterruptedException  {
	 HomeBase.logout();
	  
  }
  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
