package Pear.market;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import Pear.login.PearLogin;

public class ShopTipsClick extends BaseTest{
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
		webtest.click("xpath=//span[contains(.,' 商城设置 ')]");
		webtest.click("xpath=//a[contains(.,'商城信息')]");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//li[contains(.,'商城信息列表')]", "商城信息列表");
	}
}
