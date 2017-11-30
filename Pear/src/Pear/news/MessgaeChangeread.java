package Pear.news;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import Pear.login.PearLogin;

public class MessgaeChangeread extends BaseTest{
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
		webtest.click("xpath=//a[contains(.,'消息列表')]"); 
		//点击“修改”         
		webtest.click("xpath=//*[@id='sample-table-1']/tbody/tr[1]/td[10]/div/a[1]");
		//用户ID
		webtest.type("xpath=//input[@placeholder='请输入用户']","2");
		//消息标题
		webtest.type("xpath=//input[@name='title']","旧忆就像一扇窗");
		//内容
		webtest.type("xpath=//textarea[@name='content']", "推开了就再难合上");
		//添加时间
		webtest.type("xpath=//input[@name='addtime']","2017-11-29 09:46:45");
		//单选框-已读状态
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[6]/input[2]");
		//提交修改
		webtest.click("xpath=//button[@type='submit']");				
	}
}