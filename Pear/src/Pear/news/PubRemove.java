package Pear.news;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import Pear.login.PearLogin;

public class PubRemove extends BaseTest{
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
	public void delete() throws Exception{
		webtest.click("xpath=//span[contains(.,' 新闻管理 ')]");
		webtest.click("xpath=//a[contains(.,'公告列表')]"); 
		//点击“删除”
		webtest.click("xpath=//*[@id='sample-table-1']/tbody/tr[1]/td[9]/div/a[2]");
		webtest.getAlert().accept();
	}
}