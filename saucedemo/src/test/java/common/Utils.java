package common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import businesscomponents.NewTest;
import pageelements.Login;

public class Utils extends NewTest{
	public static void enterText(By element,String str) {
		driver.findElement(element).sendKeys(str);
		
	}
	
	public static void clickElemnt(By element) {
		driver.findElement(element).click();
		
	}
	
	public static WebElement getElement(By element) {
		return driver.findElement(element);
		
		
	}
	public static List<WebElement> getElements(By element) {
		return driver.findElements(element);
		
		
	}
}
