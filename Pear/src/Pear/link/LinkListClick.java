package Pear.link;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import Pear.login.PearLogin;
public class LinkListClick extends BaseTest{
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
	public void Click() throws Exception{
		webtest.click("xpath=//span[contains(.,' 友情链接 ')]");
		webtest.click("xpath=//a[contains(.,'友情链接列表')]");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//th[contains(.,'链接名称')]", "链接名称");
	}
}
