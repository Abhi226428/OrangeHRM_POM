package Orangehrm.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Orangehrm.pages.Loginpage;
import utils.AppUtils;

public class AdminLoginTest extends AppUtils
{
	@Parameters({"adminuid","adminpwd"})
	@Test
	public void checkAdminLogin(String uid, String pwd)
	{
		
		Loginpage lp = PageFactory.initElements(driver, Loginpage.class);
		lp.login(uid, pwd);
		boolean res = lp.isAdminModuledisplayed();
		Assert.assertTrue(res);
		lp.logout();
	}

}
