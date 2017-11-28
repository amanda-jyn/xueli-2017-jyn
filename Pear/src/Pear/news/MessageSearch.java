package Pear.news;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import com.webtest.testlistener.TestListener;

import Pear.login.PearLogin;
@Listeners(TestListener.class)
public class MessageSearch extends BaseTest{
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
		webtest.click("xpath=//a[contains(.,'��Ϣ�б�')]");
		webtest.type("xpath=//input[@id='nav-search-input']", "123");
		webtest.click("xpath=//button[contains(.,'����')]");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//th[contains(.,'��Ϣ����')]", "��Ϣ����");
	}
}
