package Pear.news;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import com.webtest.dataprovider.NSDataProvicer;
import com.webtest.testlistener.TestListener;

import Pear.login.PearLogin;
@Listeners(TestListener.class)
public class PublishNews extends BaseTest{
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

	@Test(dependsOnMethods="Login",dataProvider="s1",dataProviderClass=NSDataProvicer.class)
	public void publish(String title,String content) throws Exception{
		webtest.click("xpath=//span[contains(.,' 新闻管理 ')]");
		webtest.click("xpath=//a[contains(.,'公告列表')]");
		webtest.click("xpath=//a[contains(.,'发布新闻')]");
		webtest.type("xpath=//input[@placeholder='请输入新闻标题']", title);
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[3]/div/input[1]");
		webtest.type("xpath=//textarea[@name='content']", content);
		webtest.click("xpath=//button[@type='submit']");
		webtest.click("xpath=//a[contains(.,'2')]");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//span[contains(.,'新添加')]", "新添加");
	}
}
