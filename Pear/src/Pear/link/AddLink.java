package Pear.link;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

import Pear.login.PearLogin;
public class AddLink extends BaseTest{
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
	@Test(dependsOnMethods="Login",dataProvider="s4",dataProviderClass=NSDataProvicer.class)
	public void add(String name,String address,String file) throws Exception{
		webtest.click("xpath=//span[contains(.,' �������� ')]");
		webtest.click("xpath=//a[contains(.,'�����������')]");
		webtest.type("xpath=//input[@placeholder='��������������']", name);
		webtest.type("xpath=//input[@name='linkaddress']", address);
		webtest.type("xpath=//input[@type='file']", file);
		webtest.click("xpath=//input[@value='2']");
		webtest.click("xpath=//button[@type='submit']");
	}
}
