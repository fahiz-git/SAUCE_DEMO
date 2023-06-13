package base;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.*;

import businesscomponents.NewTest;
import common.Utils;
import pageelements.Cart;
import pageelements.Home;

public class HomeBase extends NewTest {

	public static int number_of_items_to_cart = 0;

	public static void sortLowToHigh() {
		ArrayList<Double> price_list = new ArrayList<Double>();
		Utils.clickElemnt(Home.SELECT_SORT);
		Select select = new Select(Utils.getElement(Home.SELECT_SORT));
		select.selectByVisibleText("Price (low to high)");
		for (WebElement i : Utils.getElements(Cart.TXT_PRICE)) {
			price_list.add(Double.parseDouble(i.getText().substring(1)));
		}

		for (int i = 0; i < price_list.size() - 1; i++) {
			if (!(price_list.get(i) <= price_list.get(i + 1))) {
				System.out.println("Items are Not sorted");
				break;
			}
		}
	}

	public static void addCart() {

		for (WebElement element : Utils.getElements(Home.BTN_ADD_CART)) {
			element.click();
			number_of_items_to_cart++;
		}
		System.out.println("Total Items Added to Cart :" + number_of_items_to_cart);
	}

	public static void toCart() {
		Utils.clickElemnt(Home.BTN_CART);

	}

	public static void logout() throws InterruptedException {
		Utils.clickElemnt(Home.BTN_MAIN_MENU);
		Thread.sleep(2000);
		Utils.clickElemnt(Home.LNK_LOGOUT);
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
	}

}
