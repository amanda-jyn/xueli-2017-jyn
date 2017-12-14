package Pear.authority;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import Pear.login.PearLogin;
public class ViewAuthorityClick extends BaseTest{
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
		webtest.click("xpath=//span[contains(.,' Ȩ�޹��� ')]");
		webtest.click("xpath=//a[contains(.,'�������Ȩ��')]");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//li[contains(.,'����Ȩ��')]", "����Ȩ��");
	}
}
