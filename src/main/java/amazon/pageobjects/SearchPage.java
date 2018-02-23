package amazon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static amazon.driver.DriverManager.*;




public class SearchPage {

	private Select select;

	public static WebElement resultLine() {
		return driver.findElement(By.cssSelector("#s-result-count .a-color-state"));
	}

	public static WebElement searchDropDownMenu() {
		return driver.findElement(By.xpath("//option[@value='search-alias=fashion-mens']"));
	}

	public static WebElement resultLabel() {
		return driver.findElement(By.xpath("//a[contains(text(),'Clothing, Shoes & Jewelry')]"));
	}

	public static WebElement unknounItemSearch() {
		return driver.findElement(By.id("noResultsTitle"));
	}

	public static WebElement buttonSelect(){
		return driver.findElement(By.id("a-dropdown-prompt"));
	}
	public static List<WebElement> results() {
		return driver.findElements(By.cssSelector("#s-results-list-atf>li"));
	}


	public static WebElement searchResultTitle(int i) {
		return results().get(i).findElement(By.className("a-size-base"));
	}

	public static String itemPagePrice() {

		return driver.findElement(By.xpath(".//*[@id='priceblock_ourprice']")).getText();
	}

	public static String searchResultPrice(int i) {
		return results().get(i).findElement(By.className("sx-price-whole")).getText()

				+ "," + results().get(i).findElement(By.className("sx-price-fractional")).getText();
	}


	public static String searchResultPrice(String name) {

		List<WebElement> results = results();

		WebElement el = null;

		for (WebElement result : results)

			if (result.findElement(By.className("a-size-base")).getText().equals(name)) {
				el = result;
				break;
			}
		if (el == null) return "";
		return el.findElement(By.className("sx-price-whole")).getText()
				+ "," + el.findElement(By.className("sx-price-fractional")).getText();
	}


	public static WebElement itemNameLabel() {
		return driver.findElement(By.xpath(".//*[@id='productTitle']"));
	}

	public static WebElement addToCartButton() {
		return driver.findElement(By.id("add-to-cart-button"));
	}



}