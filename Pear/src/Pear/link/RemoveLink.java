package Pear.link;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import Pear.login.PearLogin;
public class RemoveLink extends BaseTest{
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
	public void remove() throws Exception{
		webtest.click("xpath=//span[contains(.,' �������� ')]");
		webtest.click("xpath=//a[contains(.,'���������б�')]");
		webtest.click("xpath=//*[@id='sample-table-1']/tbody/tr[1]/td[8]/div/a[2]");
		webtest.alertAccept();
		webtest.isTextPresent("ɾ���ɹ�");
;	}
}

