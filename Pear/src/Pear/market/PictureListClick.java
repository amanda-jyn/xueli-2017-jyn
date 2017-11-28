package Pear.market;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import com.webtest.testlistener.TestListener;

import Pear.login.PearLogin;
@Listeners(TestListener.class)
public class PictureListClick extends BaseTest{
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
		webtest.click("xpath=//span[contains(.,' �̳����� ')]");
		webtest.click("xpath=//a[contains(.,'չʾͼ�б�')]");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//a[contains(.,'���չʾͼ')]", "���չʾͼ");
	}
}
