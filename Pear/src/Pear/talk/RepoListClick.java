package Pear.talk;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import com.webtest.testlistener.TestListener;

import Pear.login.PearLogin;
@Listeners(TestListener.class)
public class RepoListClick extends BaseTest{
	@Test
	public void Login() throws InterruptedException{
		PearLogin lg=new PearLogin(webtest);
		lg.login();
	}
	@Test(dependsOnMethods="Login")
	public void Click() throws Exception{
		webtest.click("xpath=//span[contains(.,' 留言管理 ')]");
		webtest.click("xpath=//a[contains(.,'回复列表')]");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//th[contains(.,'回复内容')]", "回复内容");
	}
}

