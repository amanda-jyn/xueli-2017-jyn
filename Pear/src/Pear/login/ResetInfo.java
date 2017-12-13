package Pear.login;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;

public class ResetInfo extends BaseTest{
	@Test
	public void login() throws Exception{
		PearLogin lg=new PearLogin(webtest);
		lg.login();
	}
	@Test(dependsOnMethods="login")
	public void reset() throws Exception{
		webtest.click("xpath=//*[@id='navbar-container']/div[2]/ul/li/a");
		webtest.click("xpath=//i[@class='icon-user']");
		//姓名
		webtest.type("xpath=//input[@id='name']", "amanda");
		//真实姓名
		webtest.type("xpath=//input[@id='realname']", "姬然");
		//手机号
		webtest.type("xpath=//input[@id='phone']", "13315115057");
		//电子邮箱
		webtest.type("xpath=//input[@id='email']", "13315115057@163.com");
		//省份
		//webtest.getSelect("xpath=//select[@id='province']");
		//webtest.click("xpath=//select[@id='province']");
		webtest.selectByValue("xpath=//select[@id='province']", "北京市");
		//城市
		//webtest.getSelect("xpath=//select[@id='province']");
		//webtest.click("xpath=//select[@id='city']");
		webtest.selectByValue("xpath=//select[@id='city']", "北京市");
		//区域
		//webtest.getSelect("xpath=//select[@id='province']");
		//webtest.click("xpath=//select[@id='county']");
		webtest.selectByValue("xpath=//select[@id='county']", "东城区");
		//地址
		webtest.type("xpath=//input[@id='address']", "地球");
		//性别
		webtest.click("xpath=//input[@value='女']");
		//状态
		webtest.click("xpath=//input[@value='2']");
		//用户组
		webtest.click("xpath=//input[@value='0']");
		//提交
		webtest.click("xpath=//button[@type='reset']");
		
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//select[@id='city']", "null");
	}
}
