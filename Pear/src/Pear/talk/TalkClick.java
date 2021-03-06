package Pear.talk;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;

import Pear.login.PearLogin;

public class TalkClick extends BaseTest{
	@Test
	public void Login() throws Exception{
		PearLogin lg=new PearLogin(webtest);
		lg.login();
	}
	@Test(dependsOnMethods="Login")
	public void Click() throws Exception{
		webtest.click("xpath=//span[contains(.,' 留言管理 ')]");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//a[contains(.,'留言列表')]", "留言列表");
	}
}
