package sylius.com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import sylius.com.pageobjects.AddressShopPage;
import sylius.com.pageobjects.HomePage;
import sylius.com.pageobjects.PaymentShopPage;
import sylius.com.pageobjects.ShippingShopPage;
import sylius.com.pageobjects.ShopPage;
import sylius.com.pageobjects.SummaryShopPage;
import sylius.com.pageobjects.YourShoppingPage;

public class ShopTest extends BaseTest {
	@Test(description = "add T-SHIRT item for men to the cart")
	public void tc01_addItemsToCart() {
		// Add T-SHIRT item for MEN to the cart
		HomePage hp = new HomePage(driver);
		hp.viewShop();
		hp.moveToNewWindow();

		ShopPage sp = new ShopPage(driver);
		sp.addTshirtMenItems("2");
		YourShoppingPage ysp = new YourShoppingPage(driver);

		String actual = ysp.getMessageAdded();
		String expected = "Item has been added to cart";
		Assert.assertEquals(expected, actual);
	}

	@Test(description = "delete item from the cart")
	public void tc02_addAndDeleteItems() {
		// Delete item of the cart
		YourShoppingPage ysp = new YourShoppingPage(driver);
		ysp.deleteItem();

		String actual = ysp.getMessageDeleted();
		String expected = "Item has been removed from cart";
		Assert.assertEquals(expected, actual);
	}

	@Test(description = "add item to the cart and clear the cart")
	public void tc03_clearCart() {
		// Clear the cart
		ShopPage sp = new ShopPage(driver);
		sp.addTshirtMenItems("2");

		YourShoppingPage ysp = new YourShoppingPage(driver);
		ysp.clearCart();

		String actual = ysp.getMessageCleared();
		String expected = "Order has been successfully deleted.";
		Assert.assertEquals(expected, actual);
	}

	@Test(description = "insert coupon code randomly, login should failed")
	public void tc04_enterCouponRandom() {
		// Enter coupon code randomly
		ShopPage sp = new ShopPage(driver);
		sp.addTshirtMenItems("2");

		YourShoppingPage ysp = new YourShoppingPage(driver);
		ysp.codeCouponRandomly("98652");

		String actual = ysp.getCodeError();
		String expected = "Coupon code is invalid.";
		Assert.assertEquals(expected, actual);
	}

	@Test(description = "complete purchase process, login should succeeded")
	public void tc05_buyItems() {
		// Purchase process
		YourShoppingPage ysp = new YourShoppingPage(driver);
		ysp.clickOnCheckout();

		AddressShopPage asp = new AddressShopPage(driver);
		asp.fillAddress("yoni@outlook.com", "Yoni", "Niyo", "Mystreet", "New York", "12345");
		
		ShippingShopPage ssp = new ShippingShopPage(driver);
		ssp.selectFedex();

		PaymentShopPage psp = new PaymentShopPage(driver);
		psp.selectCashPayment();

		SummaryShopPage sumsp = new SummaryShopPage(driver);
		sumsp.completePurchase();

		String actual = sumsp.getMessageConfirmation();
		String expected = "Thank you!" + "\nYou have successfully placed an order.";
		Assert.assertEquals(expected, actual);
	}

}
