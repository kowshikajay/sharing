package Demo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepdefDemo {

	DemoPageFactory dpf = null;
	WebDriver driver = null;
    String name= null;
	
    @Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HARI VARUN\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		dpf = new DemoPageFactory(driver);
		driver.get("C:\\Users\\HARI VARUN\\Documents\\Form-master\\Form-master\\FormDemo.html");
	}

	@When("^user is in the demo page$")
	public void user_is_in_the_demo_page() throws Throwable {
	   name=driver.getTitle();
	}

	@Then("^get home page  title$")
	public void get_home_page_title() throws Throwable {
	   System.out.println(name);
	   driver.close();
	}

	@When("^user enter invalid name and click submit$")
	public void user_enter_invalid_name_and_click_submit() throws Throwable {

		dpf.setName("");
		dpf.setButton();

	}

	@Then("^display error message$")
	public void display_error_message() throws Throwable {

		String error = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		System.out.println(error);
		driver.close();
	}

	@When("^user enter invalid mobile number and  click submit$")
	public void user_enter_invalid_mobile_number_and_click_submit(DataTable data) throws Throwable {

		dpf.setName("Hari");
		// String phone = null;
		List<String> phones = data.asList(String.class);

		for (String phone1 : phones) {

			if (phone1.matches("^[6-9]{1}[0-9]{9}$")) {
				dpf.getPhone().clear();
				dpf.setPhone(phone1);
				dpf.setEmail("mshvarun@gmail.com");
				dpf.setGender(0);
				dpf.setAddress("chennai");
				dpf.setDrop("Pune");
				dpf.setCourse(0);
				dpf.setCourse(1);
				dpf.setButton();
				System.out.println("Matches");
			} else {
				dpf.getPhone().clear();
				dpf.setPhone(phone1);
				dpf.setButton();
				String error = driver.switchTo().alert().getText();
				Thread.sleep(1000);
				driver.switchTo().alert().accept();
				System.out.println(error);

			}
		}
		driver.close();
	}

	@Then("^display phone error message$")
	public void display_phone_error_message() throws Throwable {
		
	}

	@When("^user enter invalid email and click submit$")
	public void user_enter_invalid_email_and_click_submit(DataTable data) throws Throwable {
		
		dpf.setName("Hari");
		dpf.setPhone("9874563210");
		
		List<String> emails = data.asList(String.class);

		for (String email : emails) {

			if (email.matches("")) {
				dpf.getEmail().clear();
				dpf.setEmail(email);
				dpf.setGender(0);
				Thread.sleep(1000);
				dpf.setGender(1);
				Thread.sleep(1000);
				dpf.setAddress("chennai");
				dpf.setDrop("Pune");
				dpf.setCourse(0);
				dpf.setButton();
				System.out.println("Matches");
			} else {
				dpf.getEmail().clear();
				dpf.setEmail(email);
				dpf.setButton();
				String error = driver.switchTo().alert().getText();
				Thread.sleep(1000);
				driver.switchTo().alert().accept();
				System.out.println(error);
			}
		}
		driver.close();
	}

	@Then("^display email error message$")
	public void display_email_error_message() throws Throwable {
		
	}
	
	@When("^user click submit with out entering address$")
	public void user_click_submit_with_out_entering_address() throws Throwable {
		dpf.setName("Hari");
		dpf.setPhone("9874563210");
		dpf.setGender(0);
		dpf.setEmail("mshvarun@gmail.com");
		dpf.setAddress("");
		dpf.setButton();
	}

	@Then("^display address error message$")
	public void display_address_error_message() throws Throwable {
		String error = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		System.out.println(error);
		driver.close();
	}
}
