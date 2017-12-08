package Pear.market;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import Pear.login.PearLogin;

public class PictureListSearch extends BaseTest{
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
		webtest.click("xpath=//span[contains(.,' �̳����� ')]");
		webtest.click("xpath=//a[contains(.,'չʾͼ�б�')]");
		webtest.type("xpath=//input[@id='nav-search-input']", "4");
		webtest.click("xpath=//button[contains(.,'����')]");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//a[contains(.,'4')]", "4");
	}
}
