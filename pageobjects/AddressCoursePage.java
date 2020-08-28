package sylius.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddressCoursePage extends BasePage {
	@FindBy(css = ".confirm")
	private WebElement cookies;
	@FindBy(css = "#sylius_checkout_address_customer_email")
	private WebElement emailfield;
	@FindBy(css = "#sylius_checkout_address_shippingAddress_firstName")
	private WebElement firstnamefield;
	@FindBy(css = "#sylius_checkout_address_shippingAddress_lastName")
	private WebElement lastnamefield;
	@FindBy(css = "#sylius_checkout_address_shippingAddress_street")
	private WebElement streetaddressfield;
	@FindBy(css = "#sylius_checkout_address_shippingAddress_countryCode")
	private WebElement mycountry;
	@FindBy(css = ".confirm")
	private WebElement acceptcookies;
	@FindBy(css = "#sylius_checkout_address_shippingAddress_city")
	private WebElement cityfield;
	@FindBy(css = "#sylius_checkout_address_shippingAddress_postcode")
	private WebElement postcodefield;
	@FindBy(css = "#next-step")
	private WebElement nextBtn;
	@FindBy(css = ".ui.red.pointing.label.sylius-validation-error")
	private WebElement msgError;

	public AddressCoursePage(WebDriver driver) {
		super(driver);
	}

	// fill the fields with wrong format mail
	public void fillWrongFormatMail(String email, String firstname, String lastname, String streetaddress, String city,
			String postcode) {
		try {
			click(acceptcookies);
		} catch (Exception e) {
		}
		fillText(emailfield, email);
		fillText(firstnamefield, firstname);
		fillText(lastnamefield, lastname);
		fillText(streetaddressfield, streetaddress);
		Select selectCountry = new Select(mycountry);
		selectCountry.selectByValue("US");
		try {
			click(acceptcookies);
		} catch (Exception e) {
		}
		fillText(cityfield, city);
		fillText(postcodefield, postcode);
		click(nextBtn);
	}

	// get error message about the previous test
	public String getMsgFailure() {
		return getText(msgError);
	}

    //fill the fields
	public void fillAddress(String email, String firstname, String lastname, String streetaddress, String city,
			String postcode) {
		try {
			click(acceptcookies);
		} catch (Exception e) {
		}
		fillText(emailfield, email);
		fillText(firstnamefield, firstname);
		fillText(lastnamefield, lastname);
		fillText(streetaddressfield, streetaddress);
		Select selectCountry = new Select(mycountry);
		selectCountry.selectByValue("US");
		try {
			click(acceptcookies);
		} catch (Exception e) {
		}
		fillText(cityfield, city);
		fillText(postcodefield, postcode);
		click(nextBtn);
	}

}
