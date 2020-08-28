package sylius.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddressShopPage extends BasePage {
	@FindBy(css = "#sylius_checkout_address_customer_email")
	private WebElement emailfield;
	@FindBy(css = "#sylius_checkout_address_billingAddress_firstName")
	private WebElement firstnamefield;
	@FindBy(css = "#sylius_checkout_address_billingAddress_lastName")
	private WebElement lastnamefield;
	@FindBy(css = "#sylius_checkout_address_billingAddress_street")
	private WebElement streetaddressfield;
	@FindBy(css = "#sylius_checkout_address_billingAddress_countryCode")
	private WebElement mycountry;
	@FindBy(css = "#sylius_checkout_address_billingAddress_city")
	private WebElement cityfield;
	@FindBy(css = "#sylius_checkout_address_billingAddress_postcode")
	private WebElement postcodefield;
	@FindBy(css = "#next-step")
	private WebElement nextBtn;

	public AddressShopPage(WebDriver driver) {
		super(driver);
	}
    
	//insert the details of address
	public void fillAddress(String email, String firstname, String lastname, String streetaddress, String city,
			String postcode) {
		fillText(emailfield, email);
		fillText(firstnamefield, firstname);
		fillText(lastnamefield, lastname);
		fillText(streetaddressfield, streetaddress);
		fillText(cityfield, city);
		Select selectCountry = new Select(mycountry);
		selectCountry.selectByValue("US");
		sleep(3000);
		fillText(cityfield, city);
		fillText(postcodefield, postcode);
		click(nextBtn);
	}

}
