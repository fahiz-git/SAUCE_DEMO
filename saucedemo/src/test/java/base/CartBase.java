package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import common.Utils;
import pageelements.Cart;

public class CartBase {
	public static void remove() {

		List<WebElement> items = Utils.getElements(Cart.TXT_PRICE);
		Assert.assertEquals(items.size(), HomeBase.number_of_items_to_cart);

		for (int j = 1; j <= items.size(); j++) {
			int count = 0;
			for (WebElement i : Utils.getElements(Cart.TXT_PRICE)) {
				count++;
				if (Double.parseDouble(i.getText().substring(1)) < 15) {
					System.out.println("Removed the item with price " + i.getText());
					Utils.clickElemnt(By.xpath(String.format(Cart.BTN_REMOVE.toString(), count)));
					break;
				}
			}

		}
		System.out.println("Total Number of items in cart " + Utils.getElements(Cart.TXT_PRICE).size());
		Utils.clickElemnt(Cart.BTN_CHECKOUT);
	}

	public static void addDetails() throws InterruptedException {
		Thread.sleep(3000);
		Utils.enterText(Cart.INPUT_FIRSTNAME, "Manu");
		Utils.enterText(Cart.INPUT_LASTNAME, "K");
		Utils.enterText(Cart.INPUT_ZIPCODE, "611091");
		Utils.clickElemnt(Cart.BTN_CONTINUE);
		Utils.clickElemnt(Cart.BTN_FINISH);
		Assert.assertEquals(Utils.getElement(Cart.TXT_ORDER_SUCCESS_MSG).getText().trim(), "Thank you for your order!");
		Utils.clickElemnt(Cart.BTN_HOME);

	}

}
