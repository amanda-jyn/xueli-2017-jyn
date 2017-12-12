package Pear.authority;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import Pear.login.PearLogin;
public class AuthorityListClick extends BaseTest{
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
		webtest.click("xpath=//span[contains(.,' 权限管理 ')]");
		webtest.click("xpath=//a[contains(.,'权限组列表')]");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//a[contains(.,'权限组管理')]", "权限组管理");
	}
}


