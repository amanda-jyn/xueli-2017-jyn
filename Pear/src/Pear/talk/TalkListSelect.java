package Pear.talk;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import com.webtest.testlistener.TestListener;

import Pear.login.PearLogin;
@Listeners(TestListener.class)
public class TalkListSelect extends BaseTest{
	@Test
	public void Login() throws InterruptedException{
		PearLogin lg=new PearLogin(webtest);
		lg.login();
	}
	@Test(dependsOnMethods="Login")
	public void Click() throws Exception{
		webtest.click("xpath=//span[contains(.,' ÁôÑÔ¹ÜÀí ')]");
		webtest.click("xpath=//a[contains(.,'ÁôÑÔÁĞ±í')]");
		webtest.type("xpath=//input[@id='nav-search-input']", "132");
		webtest.click("xpath=//button[contains(.,'ËÑË÷')]");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//th[contains(.,'ÁôÑÔÄÚÈİ')]", "ÁôÑÔÄÚÈİ");
	}
}

