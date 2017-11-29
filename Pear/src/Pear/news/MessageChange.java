package Pear.news;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.testlistener.TestListener;

import Pear.login.PearLogin;
@Listeners(TestListener.class)
public class MessageChange extends BaseTest{
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
		webtest.type("xpath=//input[@name='title']","嘻嘻嘻嘻嘻");
		//内容
		webtest.type("xpath=//textarea[@name='content']", "哈哈哈哈");
		//添加时间
		webtest.type("xpath=//input[@name='addtime']","2017-11-29 09:46:45");
		//单选框-未读状态
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[6]/input[1]");
		//单选框-已读状态
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[6]/input[2]");
		//单选框-删除状态
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[6]/input[3]");
		//提交修改
		webtest.click("xpath=//button[@type='submit']");				
	}
}