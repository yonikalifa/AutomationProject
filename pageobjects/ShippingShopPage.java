package sylius.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingShopPage extends BasePage {
	@FindBy(css = "div.ui.fluid.stackable.items > div:nth-child(3)")
	private WebElement fedexBtn;
	@FindBy(css = "#next-step")
	private WebElement nextBtn;

	public ShippingShopPage(WebDriver driver) {
		super(driver);
	}
	
	//select the "fedex" option
	public void selectFedex() {
		click(fedexBtn);
		sleep(2000);
		click(nextBtn);
	}
	
	

}
