package Pear.authority;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import Pear.login.PearLogin;
public class RemoveMember extends BaseTest{
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
		webtest.click("xpath=//span[contains(.,' 权限管理 ')]");
		webtest.click("xpath=//a[contains(.,'权限组列表')]");
		webtest.click("xpath=//span[contains(.,'3')]");
		webtest.click("xpath=//*[@id='sample-table-1']/tbody/tr[2]/td[5]/div/a[2]");
		webtest.alertAccept();
	}
}


