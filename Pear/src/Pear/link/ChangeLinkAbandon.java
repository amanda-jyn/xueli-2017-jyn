package Pear.link;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import Pear.login.PearLogin;
public class ChangeLinkAbandon extends BaseTest{
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
	public void change() throws Exception{
		webtest.click("xpath=//span[contains(.,' 友情链接 ')]");
		webtest.click("xpath=//a[contains(.,'友情链接列表')]");
		webtest.click("xpath=//*[@id='sample-table-1']/tbody/tr[1]/td[8]/div/a[1]");
		webtest.type("xpath=//input[@name='linkname']","changeabandon");
		webtest.type("xpath=//input[@name='linkaddress']", "www.change.com");
		webtest.type("xpath=//input[@name='pic']", "E:\\xueli-2017-jyn\\cat.png");
		webtest.click("xpath=//input[@value='3']");
		webtest.type("xpath=//input[@name='order']", "2");
		webtest.click("xpath=//button[@type='submit']");
		webtest.isTextPresent("修改成功");
;	}
}


