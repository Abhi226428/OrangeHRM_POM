package Orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage 
{
    
	@FindBy(id ="txtUsername")
	WebElement uid_element;
	
	
	@FindBy(name ="txtPassword")
	WebElement pwd_element;
	
	
	@FindBy(xpath ="//*[@value='LOGIN']")
	WebElement login;
	
	@FindBy(linkText="Admin")
	WebElement adminlink;
		
	@FindBy(partialLinkText ="Welcome")
	WebElement Welcome;
	
	@FindBy(linkText ="Logout")
	WebElement logout;
	
	
	@FindBy(id = "spanMessage")
	WebElement msg_element;
	
	public void login(String uid, String pwd)
	{
		
		uid_element.sendKeys(uid);
		pwd_element.sendKeys(pwd);
		login.click();
	}
	
	public boolean isAdminModuledisplayed()
	{
		if(adminlink.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
		
	}
	
	public void logout()
	{
		Welcome.click();
		logout.click();
	}
	
	public boolean isErrMsgdisplayed()
	{
		String errmsg = msg_element.getText();
		if(errmsg.toLowerCase().contains("invalid"))
		{
			return true;
		}else
		{
			return false;
		}
		
	}
}
