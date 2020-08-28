package sylius.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	@FindBy(css = "[name='full-name']")
	private WebElement namefield;
	@FindBy(css = "[name='phone']")
	private WebElement phonefield;
	@FindBy(css = "[name='your-email']")
	private WebElement emailfield;
	@FindBy(css = "[name='message']")
	private WebElement messagefield;
	@FindBy(css = ".cc-dismiss")
	private WebElement cookies;
	@FindBy(css = "[type='checkbox']")
	private WebElement termsandconditions;
	@FindBy(css = ".wpcf7-form-control.wpcf7-submit.btn.btn-green.contact-submit-wpcf-button")
	private WebElement scheduleacallBtn;
	@FindBy(css = ".wpcf7-response-output.wpcf7-display-none.wpcf7-mail-sent-ok")
	private WebElement msgSuccessLogin;
	@FindBy(css = ".wpcf7-response-output.wpcf7-display-none.wpcf7-validation-errors")
	private WebElement msgFailureLogin;
	@FindBy(css = ".wpcf7-not-valid-tip")
	private WebElement msgFailureMail;
	@FindBy(css = ".wpcf7-not-valid-tip")
	private WebElement msgFailurePhone;
	@FindBy(css = "div > p:nth-child(6) > a")
	private WebElement adminLink;
	@FindBy(css = "div > p:nth-child(9) > a")
	private WebElement shopLink;
	@FindBy(css = "li:nth-child(8) > a > i")
	private WebElement aboutLink;
	@FindBy(css = "li:nth-child(8) >div > a:nth-child(2)")
	private WebElement teamLink;
	@FindBy(css = ".btn.btn-border-white.const")
	private WebElement learnNowBtn;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	//insert the details and click to "Schedule a call" button
	public void scheduleaCall(String name, String phone, String email, String msg) {
		fillText(namefield, name);
		fillText(phonefield, phone);
		fillText(emailfield, email);
		fillText(messagefield, msg);
		try {
			click(cookies);
		} catch (Exception e) {
		}
		click(termsandconditions);
		click(scheduleacallBtn);
	}

	//confirmation message about the previous test
	public String getMessage() {
		return getText(msgSuccessLogin);
	}

	//insert the details and leave field empty
	public void scheduleMissingField(String phone, String email, String msg) {
		fillText(phonefield, phone);
		fillText(emailfield, email);
		fillText(messagefield, msg);
		try {
			click(cookies);
		} catch (Exception e) {
		}
		click(termsandconditions);
		click(scheduleacallBtn);
		sleep(5000);
	}

	//error message about the previous test
	public String getMessageFailure() {
		return getText(msgFailureLogin);
	}

	//error message about wrong format mail
	public String getMsgFailureMail() {
		sleep(2000);
		return getText(msgFailureMail);
	}

	//error message about wrong format phone
	public String getMsgFailurePhone() {
		return getText(msgFailurePhone);
	}

	//click to "learn course" button
	public void learnCourse() {
		try {
			click(cookies);
		} catch (Exception e) {
		}
		click(learnNowBtn);
	}

	//click to "view admin" link
	public void viewAdmin() {
		try {
			click(cookies);
		} catch (Exception e) {
		}
		click(adminLink);
	}

	//click to "view shop" link
	public void viewShop() {
		try {
			click(cookies);
		} catch (Exception e) {
		}
		click(shopLink);
	}
	
	//click to "view team" link
	public void viewTeam() {
		try {
			click(cookies);
		} catch (Exception e) {
		}
		click(aboutLink);
		click(teamLink);
	}

}
