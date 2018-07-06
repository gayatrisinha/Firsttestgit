package org.cucumber.org.newcucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public  class Base1 {
public static WebDriver driver;

public static WebDriver getDriver(String url) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Akashanand2015\\eclipse-workspace\\org.newcucumber\\driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
	return driver;
	
}
public String  getTextByAttriute(WebElement element) {
	
return element.getAttribute("value");
}
public static void setText(WebElement element,String Name) {
	if(verifyElementHidden(element)&& verifyEnable(element)) {
		element.clear();
		element.sendKeys(Name);
		
	}
}
public static boolean verifyEnable(WebElement element) {

	return element.isDisplayed();
}
public static boolean verifyElementHidden(WebElement element) {
	
	return element.isEnabled();
}
public static void click(WebElement element) {
	element.click();
}
	public static void qutiBrowser(WebDriver driver) {
	driver.quit();
}
	
}
	




