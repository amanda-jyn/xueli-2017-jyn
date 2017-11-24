package Pear.talk;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import com.webtest.testlistener.TestListener;

import Pear.login.PearLogin;
@Listeners(TestListener.class)
public class RepoListSelect extends BaseTest{
	@Test
	public void Login() throws Exception{
		PearLogin lg=new PearLogin(webtest);
		lg.login();
	}
	@Test(dependsOnMethods="Login")
	public void search() throws Exception{
		webtest.click("xpath=//span[contains(.,' ���Թ��� ')]");
		webtest.click("xpath=//a[contains(.,'�ظ��б�')]");
		webtest.type("xpath=//input[@id='nav-search-input']", "567");
		webtest.click("xpath=//button[contains(.,'����')]");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//th[contains(.,'�ظ�����')]", "�ظ�����");
	}
}

