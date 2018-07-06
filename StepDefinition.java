package org.cucumber.org.newcucumber;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinition {
	static WebDriver driver;

	

@Given("^The user navigates to demo page$")
public void the_user_navigates_to_demo_page() throws Throwable {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Akashanand2015\\eclipse-workspace\\org.newcucumber\\driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://demoqa.com/registration/");
	}

    @When("^The user enters firstname\"([^\"]*)\" and lastname\"([^\"]*)\"and phonenumber\"([^\"]*)\"and username\"([^\"]*)\" and email\"([^\"]*)\"and password \"([^\"]*)\"and conpassword\"([^\"]*)\"$")

    public void the_user_enters_firstname_and_lastname_and_phonenumber_and_username_and_email_and_password_and_conpassword(String fname , String lname, String pnumber, String uname, String email, String password, String conpassword) throws Throwable {
			WebElement firstname=driver.findElement(By.id("name_3_firstname"));
			firstname.sendKeys(fname);
			WebElement lastname=driver.findElement(By.id("name_3_lastname"));
			lastname.sendKeys(lname);
			WebElement phonenumber=driver.findElement(By.xpath("//input[@id='phone_9']"));
			phonenumber.sendKeys(pnumber);
			WebElement username=driver.findElement(By.id("username"));
			username.sendKeys(uname);
			WebElement eemail=driver.findElement(By.id("email_1"));
			eemail.sendKeys(email);	
			WebElement password1=driver.findElement(By.id("password_2"));
			password1.sendKeys(password);	
			WebElement password2=driver.findElement(By.id("confirm_password_password_2"));
			password2.sendKeys(conpassword);	
		}



@Then("^The user verify first name\"([^\"]*)\" andlast name\"([^\"]*)\" and phonenumber \"([^\"]*)\"and username \"([^\"]*)\" and email \"([^\"]*)\" and password \"([^\"]*)\"and conpassword\"([^\"]*)\"$")

   public void the_user_verify_first_name_andlast_name_and_phonenumber_and_username_and_email_and_password_and_conpassword(String fname , String lname, String pnumber, String uname, String email, String password, String conpassword) throws Throwable {
			Assert.assertEquals(driver.findElement(By.id("name_3_firstname")).getAttribute("value"), fname);
			Assert.assertEquals(driver.findElement(By.id("name_3_lastname")).getAttribute("value"), lname);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='phone_9']")).getAttribute("value"), pnumber);
			Assert.assertEquals(driver.findElement(By.id("username")).getAttribute("value"), uname);
			Assert.assertEquals(driver.findElement(By.id("email_1")).getAttribute("value"), email);
			Assert.assertEquals(driver.findElement(By.id("password_2")).getAttribute("value"),password);
			Assert.assertEquals(driver.findElement(By.id("confirm_password_password_2")).getAttribute("value"), conpassword);
			
		}


@Then("^the user click staus button$")
public void the_user_click_staus_button(DataTable name) throws Throwable {
	List<Map<String, String>> asMaps = name.asMaps(String.class, String.class);
	

	if(asMaps.equals("single")) {
		driver.findElement(By.xpath("//input[@value='single']")).click();   
	}else {  
		driver.findElement(By.xpath("//input[@value='married']")).click();    

	} 
}

@When("^the user click check box$")
public void the_user_click_check_box(DataTable checkbox) throws Throwable {
	List<List<String>> asLists = checkbox.asLists(String.class);
	if(asLists.equals("dance")) {
		driver.findElement(By.xpath("//input[@value='dance']")).click();
	}
	if(asLists.equals("reading")) {
		driver.findElement(By.xpath("//input[@value='reading']")).click();
	}
	if(asLists.equals("cricket ")) {
		driver.findElement(By.xpath("//input[@value='cricket']")).click();
	}
    
}

@Then("^the user select the country$")
public void the_user_select_the_country(DataTable drop) throws Throwable {
	 List<Map<String, String>> asMaps = drop.asMaps(String.class, String.class);
		for (int i = 0; i < asMaps.size(); i++) {
			
		
		 WebElement dtn = driver.findElement(By.id("dropdown_7"));
	  Select s1= new Select(dtn);
		 s1.selectByValue(asMaps.get(i).get("country"));
	}
}
    


@When("^the user select the DOoB$")
public void the_user_select_the_DOoB(DataTable date) throws Throwable {
	for(Map<String, String> c : date.asMaps(String.class, String.class)) {
		
		   WebElement month = driver.findElement(By.id("mm_date_8"));
		    Select mnth= new Select(month);
		   mnth.selectByValue(c.get("month"));
		   WebElement date2 = driver.findElement(By.id("dd_date_8"));
		    Select date1= new Select(date2);
	   date1.selectByValue(c.get("day"));
		   WebElement year1 = driver.findElement(By.id("yy_date_8"));
		   Select year= new Select(year1);
		   year.selectByValue(c.get("year"));
		   
    
}
}
}


