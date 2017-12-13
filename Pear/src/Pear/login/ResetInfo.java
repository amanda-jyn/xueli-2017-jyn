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
		//����
		webtest.type("xpath=//input[@id='name']", "amanda");
		//��ʵ����
		webtest.type("xpath=//input[@id='realname']", "��Ȼ");
		//�ֻ���
		webtest.type("xpath=//input[@id='phone']", "13315115057");
		//��������
		webtest.type("xpath=//input[@id='email']", "13315115057@163.com");
		//ʡ��
		//webtest.getSelect("xpath=//select[@id='province']");
		//webtest.click("xpath=//select[@id='province']");
		webtest.selectByValue("xpath=//select[@id='province']", "������");
		//����
		//webtest.getSelect("xpath=//select[@id='province']");
		//webtest.click("xpath=//select[@id='city']");
		webtest.selectByValue("xpath=//select[@id='city']", "������");
		//����
		//webtest.getSelect("xpath=//select[@id='province']");
		//webtest.click("xpath=//select[@id='county']");
		webtest.selectByValue("xpath=//select[@id='county']", "������");
		//��ַ
		webtest.type("xpath=//input[@id='address']", "����");
		//�Ա�
		webtest.click("xpath=//input[@value='Ů']");
		//״̬
		webtest.click("xpath=//input[@value='2']");
		//�û���
		webtest.click("xpath=//input[@value='0']");
		//�ύ
		webtest.click("xpath=//button[@type='reset']");
		
		Checker ck=new Checker(webtest);
		ck.verifyText("xpath=//select[@id='city']", "null");
	}
}
