package amazon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static amazon.driver.DriverManager.*;

public class HomePage {
	public static WebElement searchButton() {
		return driver.findElement(By.cssSelector(".nav-input[value=\"Go\"]"));
	}
	public static WebElement searchField() {
		return driver.findElement(By.id("twotabsearchtextbox"));
	}

}
