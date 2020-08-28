package sylius.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginAdminPage extends BasePage {
	@FindBy(css = "#_username")
	WebElement userfield;
	@FindBy(css = "#_password")
	WebElement passwordfield;
	@FindBy(css = ".ui.fluid.large.primary.submit.button")
	WebElement loginBtn;
	@FindBy(css = ".column > div.ui .content p")
	WebElement msgFailure;
	@FindBy(css = ".header")
	WebElement titleLabel;

	public LoginAdminPage(WebDriver driver) {
		super(driver);
	}

	//insert the credentials login
	public void LoginAdmin(String user, String password) {
		fillText(userfield, user);
		fillText(passwordfield, password);
		click(loginBtn);

	}

	//error message about the login failed
	public String getMessageFail() {
		return getText(msgFailure);

	}

	//move to new window after login
	public void moveToNewWindow() {
		super.moveToNewWindow();
	}
	
	//check if the test succeeded if go back to the "admin page"
	public boolean isAdminPage() {
		if (getText(titleLabel).toLowerCase().equalsIgnoreCase("test credentials")) {
			return true;
		}return false;
	}

}
