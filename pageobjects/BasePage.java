package sylius.com.pageobjects;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;
	JavascriptExecutor js;
	String mainWindow;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void fillText(WebElement el, String text) {
		highlightElement(el, "green");
		el.clear();
		el.sendKeys(text);
	}

	public void click(WebElement el) {
		highlightElement(el, "green");
		el.click();
	}

	public String getText(WebElement el) {
		highlightElement(el, "green");
		return el.getText();
	}

	public void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void highlightElement(WebElement element, String color) {
		String originalStyle = element.getAttribute("style");
		String newStyle = "border:1px solid " + color + ";backgroud-color:yellow;" + originalStyle;
		js = (JavascriptExecutor) driver;
		// Change the style
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style','"
				+ newStyle + "');},0);", element);
		// Change the style back after 400 milliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style','"
				+ originalStyle + "');},400);", element);

	}

	public void moveTo(WebElement el) {
		Actions actions = new Actions(driver);
		actions.moveToElement(el).build().perform();
	}

	public void alertOK() {
		driver.switchTo().alert().accept();
	}

	// move to new window
	public void moveToNewWindow() {
		mainWindow = driver.getWindowHandle();
		Set<String> handels = driver.getWindowHandles();
		for (String h : handels) {
			System.out.println("current handle is : " + h);
			driver.switchTo().window(h);
		}
	}
	
	public void backToMainWindow() {
		driver.close();
		driver.switchTo().window(mainWindow);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}
