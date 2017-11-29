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
		webtest.click("xpath=//span[contains(.,' ���Ź��� ')]");
		webtest.click("xpath=//a[contains(.,'�����б�')]"); 
		//������޸ġ�
		webtest.click("xpath=//*[@id='sample-table-1']/tbody/tr[1]/td[9]/div/a[1]");
		//����
		webtest.type("xpath=//input[@name='title']","123");
		//��ѡ��-����
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[3]/input[1]");
		//����
		webtest.type("xpath=//textarea[@name='content']", "456");
		//��ѡ��-״̬
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[5]/input[1]");
		//�ύ�޸�
		webtest.click("xpath=//button[@type='submit']");
		//�����޸ĺ�ҳ��
		webtest.click("xpath=//a[@class='num']");
		
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//span[contains(.,'�����')]", "�����");
	}
}