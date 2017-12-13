package Pear.login;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;

public class PearLogout extends BaseTest{
	@Test
	public void login() throws Exception{
		PearLogin lg=new PearLogin(webtest);
		lg.login();
	}
	@Test(dependsOnMethods="login")
	public void logout() throws Exception{
		webtest.click("xpath=//*[@id='navbar-container']/div[2]/ul/li/a");
		webtest.click("xpath=//i[@class='icon-off']");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//h4[contains(.,'京东商城后台登陆')]", "京东商城后台登陆");
	}
}
