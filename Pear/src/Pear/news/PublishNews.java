package Pear.news;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;
import Pear.login.PearLogin;

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
		webtest.click("xpath=//span[contains(.,' ���Ź��� ')]");
		webtest.click("xpath=//a[contains(.,'�����б�')]");
	}

	@Test(dependsOnMethods="Login",dataProvider="s1",dataProviderClass=NSDataProvicer.class)
	public void publish(String title,String content) throws Exception{	
		webtest.click("xpath=//a[contains(.,'��������')]");
		webtest.type("xpath=//input[@placeholder='���������ű���']", title);
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[3]/div/input[1]");
		webtest.type("xpath=//textarea[@name='content']", content);
		webtest.click("xpath=//button[@type='submit']");
	}
}
