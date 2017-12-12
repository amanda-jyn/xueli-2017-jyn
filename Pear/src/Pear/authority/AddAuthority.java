package Pear.authority;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

import Pear.login.PearLogin;
public class AddAuthority extends BaseTest{
	@Test
	public void Login() throws InterruptedException{
		PearLogin lg=new PearLogin(webtest);
		try {
			lg.login();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		webtest.click("xpath=//span[contains(.,' Ȩ�޹��� ')]");
		webtest.click("xpath=//a[contains(.,'���Ȩ����')]");
	}
	@Test(dependsOnMethods="Login",dataProvider="s5",dataProviderClass=NSDataProvicer.class)
	public void add(String title) throws Exception{
		webtest.type("xpath=//input[@name='title']", title);
		webtest.click("xpath=//input[@value='15']");
		webtest.click("xpath=//input[@value='18']");
		webtest.click("xpath=//input[@value='34']");
		webtest.click("xpath=//input[@value='�ύ']");
		webtest.isTextPresent("��ӳɹ�");
	}
}


