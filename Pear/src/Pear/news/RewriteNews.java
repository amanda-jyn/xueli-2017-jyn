package Pear.news;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;

import Pear.login.PearLogin;

public class RewriteNews extends BaseTest{
	@Test
	public void Login() throws InterruptedException{
		PearLogin lg=new PearLogin(webtest);
		try {
			lg.login();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		webtest.click("xpath=//span[contains(.,' 新闻管理 ')]");
		webtest.click("xpath=//a[contains(.,'公告列表')]");
	}

	@Test(dependsOnMethods="Login")
	public void rewrite() throws Exception{	
		webtest.click("xpath=//a[contains(.,'发布新闻')]");
		webtest.type("xpath=//input[@placeholder='请输入新闻标题']", "双十二引发新一轮购物狂潮");
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[3]/div/input[1]");
		webtest.type("xpath=//textarea[@name='content']", "今天，你剁手了吗？\n今天，你变成小叮当了吗？");
		webtest.click("xpath=//button[@type='reset']");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//textarea[@name='content']", "");
	}
}
