package Pear.authority;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import Pear.login.PearLogin;
public class DetailsClick extends BaseTest{
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
		webtest.click("xpath=//span[contains(.,' 权限管理 ')]");
		webtest.click("xpath=//a[contains(.,'权限组列表')]");
		webtest.click("xpath=//*[@id='sample-table-1']/tbody/tr[1]/td[5]/div/a[1]");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//p[contains(.,'删除员工')]", "删除员工");
	}
}


