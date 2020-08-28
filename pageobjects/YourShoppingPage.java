package sylius.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourShoppingPage extends BasePage {
	@FindBy(css = ".sylius-flash-message  p")
	WebElement additemmsg;
	@FindBy(css = ".ui.circular.icon.button.sylius-cart-remove-button")
	WebElement deleteBtn;
	@FindBy(css = ".ui.icon.positive.message.sylius-flash-message > div > p")
	WebElement dltitemsmsg;
	@FindBy(css = "#sylius-cart-clear")
	WebElement clearcartBtn;
	@FindBy(css = ".ui.icon.positive.message.sylius-flash-message p")
	WebElement itemscleared;
	@FindBy(css = "#sylius_cart_promotionCoupon")
	WebElement couponcode;
	@FindBy(css = "#sylius-save")
	WebElement applycouponBtn;
	@FindBy(css = ".ui.red.pointing.label.sylius-validation-error")
	WebElement msgerror;
	@FindBy(css = ".ui.huge.primary.fluid.labeled.icon.button")
	WebElement checkoutBtn;
	
	public YourShoppingPage(WebDriver driver) {
		super(driver);
	}
	
	//message confirmation about items added
	public String getMessageAdded() {
		return getText(additemmsg);
	}
	
	//delete item from the cart
	public void deleteItem() {
		click(deleteBtn);
	}
	
	//message confirmation about items deleted
	public String getMessageDeleted() {
		return getText(dltitemsmsg);
	}
	
	//clear all the cart
	public void clearCart() {
		click(clearcartBtn);
	}
	
	//message confirmation about cart cleared
	public String getMessageCleared() {
		return getText(itemscleared);
	}
	
	//enter code coupon randomly
	public void codeCouponRandomly(String code) {
		fillText(couponcode, code);
		click(applycouponBtn);
	}
	
	//error message about wrong code coupon 
	public String getCodeError() {
		return getText(msgerror);
	}
	
    //click on "checkout" button	
	public void clickOnCheckout() {
		click(checkoutBtn);
	}

}
