package sylius.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShopPage extends BasePage {

	@FindBy(css = ".ui.dropdown.item:nth-child(1) > .text")
	private WebElement tshirtBtn;
	@FindBy(css = ".menu.transition.visible > a:nth-child(1)")
	private WebElement menBtn;
	@FindBy(css = " #products > div:nth-child(1)")
	WebElement image;
	@FindBy(css = ".center>.ui.inverted.button")
	WebElement viewmoreBtn;
	@FindBy(css = "#sylius_add_to_cart_cartItem_variant_t_shirt_size")
	WebElement mysize;
	@FindBy(css = "#sylius_add_to_cart_cartItem_quantity")
	WebElement quantityfield;
	@FindBy(css = ".ui.huge.primary.icon.labeled.button")
	WebElement addtocartBtn;
	

	public ShopPage(WebDriver driver) {
		super(driver);
	}
    
	//add item to the cart
	public void addTshirtMenItems(String quantity) {
		click(tshirtBtn);
		click(menBtn);
		moveTo(image);
		sleep(1000);
		click(viewmoreBtn);
		Select selectSize = new Select(mysize);
		selectSize.selectByVisibleText("L");
		fillText(quantityfield, quantity);
		click(addtocartBtn);
	}
}
