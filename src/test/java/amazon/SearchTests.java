package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static amazon.driver.DriverManager.driver;
import static amazon.pageobjects.HomePage.searchButton;
import static amazon.pageobjects.HomePage.searchField;
import static amazon.pageobjects.SearchPage.*;
import static amazon.utils.ElementUtils.assertWaitEquals;
import static org.testng.Assert.assertEquals;

public class SearchTests extends TestInit {
	private Select select;

	@AfterMethod
	public void after() {
		searchField().clear();

	}

	@Test
	public void asimpleSearchTest() {

		searchField().sendKeys("jacket");
		searchButton().click();
		assertEquals(resultLine().getText(), "\"jacket\"");

		System.out.println("Your great choice is: " + searchResultTitle(5).getText() + " for the great price of " + searchResultPrice(5));
		searchResultTitle(5).click();

		String choosenItem = itemNameLabel().getText();
		System.out.println("Yes baby that is yours: " + choosenItem);

		String choosenPrice = itemPagePrice();
		System.out.println("Very pricy " + choosenPrice);

		{

			//buttonSelect().click();


			addToCartButton().click();


		}


	}
}
