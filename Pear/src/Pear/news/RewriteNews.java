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
		webtest.click("xpath=//span[contains(.,' ���Ź��� ')]");
		webtest.click("xpath=//a[contains(.,'�����б�')]");
	}

	@Test(dependsOnMethods="Login")
	public void rewrite() throws Exception{	
		webtest.click("xpath=//a[contains(.,'��������')]");
		webtest.type("xpath=//input[@placeholder='���������ű���']", "˫ʮ��������һ�ֹ����");
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[3]/div/input[1]");
		webtest.type("xpath=//textarea[@name='content']", "���죬���������\n���죬����С��������");
		webtest.click("xpath=//button[@type='reset']");
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//textarea[@name='content']", "");
	}
}
