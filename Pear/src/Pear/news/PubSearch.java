package Pear.news;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import com.webtest.testlistener.TestListener;

import Pear.login.PearLogin;
@Listeners(TestListener.class)
public class PubSearch extends BaseTest{
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
	public void search() throws Exception{
		webtest.click("xpath=//span[contains(.,' 新闻管理 ')]");
		webtest.click("xpath=//a[contains(.,'公告列表')]");
		webtest.type("xpath=//input[@id='nav-search-input']", "小米电视携豪礼高调入驻京东");
		webtest.click("xpath=//button[contains(.,'搜索')]");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//td[contains(.,'小米电视携豪礼高调入驻京东  ')]", "小米电视携豪礼高调入驻京东");
	}
}
