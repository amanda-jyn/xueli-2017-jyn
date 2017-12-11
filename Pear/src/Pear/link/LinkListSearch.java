package Pear.link;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import Pear.login.PearLogin;
public class LinkListSearch extends BaseTest{
	@Test
	public void Login() throws InterruptedException{
		PearLogin lg=new PearLogin(webtest);
		try {
			lg.login();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(dependsOnMethods="Login")
	public void Search() throws Exception{
		webtest.click("xpath=//span[contains(.,' 友情链接 ')]");
		webtest.click("xpath=//a[contains(.,'友情链接列表')]");
		webtest.type("xpath=//input[@placeholder='链接名称']","淘宝");
		webtest.click("xpath=//button[@type='submit']");
		webtest.isTextPresent("淘宝");
	}
}
