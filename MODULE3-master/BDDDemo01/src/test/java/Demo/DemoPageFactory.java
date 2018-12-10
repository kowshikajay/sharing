package Demo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DemoPageFactory {

	WebDriver wd;
	
	public DemoPageFactory(WebDriver driver) {
		this.wd = driver;
		PageFactory.initElements(driver, this);
	}


	public DemoPageFactory() {
		super();
	}
	
	@FindBy(id="fname")
	WebElement name;
	
	@FindBy(name="mobile")
	WebElement phone;
	
	@FindBy(name="mail")
	WebElement email;
	
	@FindBy(name="gender")
	List<WebElement> gender;
	
	@FindBy(name="address")
	WebElement address;
	
	@FindBy(className="btn")
	WebElement button;

	@FindBy(how = How.NAME,using = "city")
	WebElement drop;

	@FindBy(className="course")
	List<WebElement> course;
	
	public WebElement getName() {
		return name;
	}


	public void setName(String ename) {
		name.sendKeys(ename);;
	}


	public WebElement getPhone() {
		return phone;
	}


	public void setPhone(String ephone) {
		phone.sendKeys(ephone);
	}


	public WebElement getEmail() {
		return email;
	}


	public void setEmail(String eemail) {
		email.sendKeys(eemail);;
	}


	public List<WebElement> getGender() {
		return gender;
	}


	public void setGender(int gen) {
		gender.get(gen).click();
	}


	public WebElement getAddress() {
		return address;
	}


	public void setAddress(String eaddress) {
		address.sendKeys(eaddress);;
	}


	public WebElement getDrop() {
		return drop;
	}


	public void setDrop(String city) {
		Select cityData = new Select(drop);
		cityData.selectByVisibleText(city);
	}


	public List<WebElement> getCourse() {
		return course;
	}


	public void setCourse(int cou) {
		course.get(cou).click();;
	}


	public WebElement getButton() {
		return button;
	}


	public void setButton() {
		button.click();
	}
	
}
