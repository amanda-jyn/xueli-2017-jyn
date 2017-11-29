package Pear.market;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import com.webtest.dataprovider.NSDataProvicer;
import com.webtest.testlistener.TestListener;

import Pear.login.PearLogin;
@Listeners(TestListener.class)
public class AddPicture extends BaseTest{
	@Test
	public void Login() throws InterruptedException{
		PearLogin lg=new PearLogin(webtest);
		try {
			lg.login();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		webtest.click("xpath=//span[contains(.,' 商城设置 ')]");
		webtest.click("xpath=//a[contains(.,'展示图列表')]");
		webtest.click("xpath=//a[contains(.,'添加展示图')]");
	}
	@Test(dependsOnMethods="Login",dataProvider="s2",dataProviderClass=NSDataProvicer.class)
	public void add(String title,String link,String file) throws Exception{

		webtest.type("xpath=//input[@name='title']", title);
		webtest.type("xpath=//input[@name='link']", link);
		webtest.type("xpath=//input[@type='file']", file);
		webtest.click("xpath=//button[@type='submit']");
	}
}
