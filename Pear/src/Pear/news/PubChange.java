package Pear.news;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import Pear.login.PearLogin;

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
		webtest.type("xpath=//input[@name='title']","为了你我用了半年的积蓄");
		//单选框-类型
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[3]/input[1]");
		//内容
		webtest.type("xpath=//textarea[@name='content']", "漂洋过海来看你");
		//单选框-新添加状态
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[5]/input[1]");
		//单选框-已发布状态
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[5]/input[2]");
		//单选框-已过期状态
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[5]/input[3]");
		//提交修改
		webtest.click("xpath=//button[@type='submit']");
	}
}