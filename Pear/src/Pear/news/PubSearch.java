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
		webtest.click("xpath=//span[contains(.,' ���Ź��� ')]");
		webtest.click("xpath=//a[contains(.,'�����б�')]");
		webtest.type("xpath=//input[@id='nav-search-input']", "С�׵���Я����ߵ���פ����");
		webtest.click("xpath=//button[contains(.,'����')]");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//td[contains(.,'С�׵���Я����ߵ���פ����  ')]", "С�׵���Я����ߵ���פ����");
	}
}
