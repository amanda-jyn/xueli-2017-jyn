package Pear.market;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import Pear.login.PearLogin;

public class PictureRemove extends BaseTest{
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
		webtest.click("xpath=//span[contains(.,' 商城设置 ')]");
		webtest.click("xpath=//a[contains(.,'展示图列表')]");
		webtest.click("xpath=//*[@id='sample-table-1']/tbody/tr[1]/td[9]/div/p[1]/a");
		webtest.getAlert().accept();
	}
}
