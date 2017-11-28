package Pear.news;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import com.webtest.testlistener.TestListener;

import Pear.login.PearLogin;
@Listeners(TestListener.class)
public class PublishMessage extends BaseTest{
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
		webtest.click("xpath=//span[contains(.,' ���Ź��� ')]");
		webtest.click("xpath=//a[contains(.,'��Ϣ�б�')]");
		webtest.click("xpath=//a[contains(.,'������Ϣ')]");
		webtest.type("xpath=//input[@name='admin_id']", "2");
		webtest.type("xpath=//input[@name='title']", "������");
		webtest.type("xpath=//textarea[@name='content']","hahahaha");
		webtest.click("xpath=//button[@type='submit']");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//a[contains(.,'������Ϣ')]", "������Ϣ");
	}
}
