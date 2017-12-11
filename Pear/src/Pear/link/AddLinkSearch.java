package Pear.link;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import Pear.login.PearLogin;
public class AddLinkSearch extends BaseTest{
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
		webtest.click("xpath=//span[contains(.,' ”—«È¡¥Ω” ')]");
		webtest.click("xpath=//a[contains(.,'ÃÌº””—«È¡¥Ω”')]");
		webtest.type("xpath=//input[@autocomplete='off']", "Ã‘±¶4");
		webtest.enterClick();
		webtest.isTextPresent("Ã‘±¶4");
	}
}
