package Pear.news;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import com.webtest.testlistener.TestListener;

import Pear.login.PearLogin;
@Listeners(TestListener.class)
public class PubChange extends BaseTest{
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
	public void change() throws Exception{
		webtest.click("xpath=//span[contains(.,' 新闻管理 ')]");
		webtest.click("xpath=//a[contains(.,'公告列表')]"); 
		//点击“修改”
		webtest.click("xpath=//*[@id='sample-table-1']/tbody/tr[1]/td[9]/div/a[1]");
		//标题
		webtest.type("xpath=//input[@name='title']","123");
		//单选框-类型
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[3]/input[1]");
		//内容
		webtest.type("xpath=//textarea[@name='content']", "456");
		//单选框-状态
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[5]/input[1]");
		//提交修改
		webtest.click("xpath=//button[@type='submit']");
		//进入修改后页面
		webtest.click("xpath=//a[@class='num']");
		
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//span[contains(.,'新添加')]", "新添加");
	}
}