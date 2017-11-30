package Pear.news;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import Pear.login.PearLogin;

public class NewsClick extends BaseTest{
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
		webtest.click("xpath=//span[contains(.,' 新闻管理 ')]");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//a[contains(.,'公告列表')]", "公告列表");
	}
}
