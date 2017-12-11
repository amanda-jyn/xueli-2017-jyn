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
		webtest.click("xpath=//span[contains(.,' �������� ')]");
		webtest.click("xpath=//a[contains(.,'���������б�')]");
		webtest.type("xpath=//input[@placeholder='��������']","�Ա�");
		webtest.click("xpath=//button[@type='submit']");
		webtest.isTextPresent("�Ա�");
	}
}
