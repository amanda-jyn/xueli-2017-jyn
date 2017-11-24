package Pear.news;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
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
	@Test(dependsOnMethods="Login")
	public void Click() throws Exception{
		webtest.click("xpath=//span[contains(.,' 新闻管理 ')]");
		webtest.click("xpath=//a[contains(.,'公告列表')]");
		webtest.click("xpath=//a[contains(.,'发布新闻')]");
		webtest.type("xpath=//input[@placeholder='请输入新闻标题']", "《明星大侦探》第三季预告");
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[3]/div/input[1]");
		webtest.type("xpath=//textarea[@name='content']", "撒贝宁、何炅、鬼鬼再次携手上演侦探传奇");
		webtest.click("xpath=//button[@type='submit']");
		webtest.click("xpath=//a[contains(.,'2')]");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//span[contains(.,'新添加')]", "新添加");
	}
}
