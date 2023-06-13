package base;

import java.sql.Driver;

import org.testng.Assert;

import businesscomponents.NewTest;
import common.Utils;
import pageelements.Login;

public class LoginBase extends NewTest {

	public static void login() {
		Utils.enterText(Login.INPUT_USER_NAME, "standard_user");
		Utils.enterText(Login.INPUT_PASSWORD, "secret_sauce");
		Utils.clickElemnt(Login.BTN_LOGIN);
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

	}

}
