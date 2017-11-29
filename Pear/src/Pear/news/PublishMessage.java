package Pear.news;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import com.webtest.dataprovider.NSDataProvicer;
import com.webtest.testlistener.TestListener;

import Pear.login.PearLogin;
@Listeners(TestListener.class)
public class PublishMessage extends BaseTest{
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
	@Test(dependsOnMethods="Login",dataProvider="s3",dataProviderClass=NSDataProvicer.class)
	public void publish(String id,String title,String content) throws Exception{
		webtest.click("xpath=//span[contains(.,' 新闻管理 ')]");
		webtest.click("xpath=//a[contains(.,'消息列表')]");
		webtest.click("xpath=//a[contains(.,'发布消息')]");
		webtest.type("xpath=//input[@name='admin_id']", id);
		webtest.type("xpath=//input[@name='title']", title);
		webtest.type("xpath=//textarea[@name='content']",content);
		webtest.click("xpath=//button[@type='submit']");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//a[contains(.,'发布消息')]", "发布消息");
	}
}
