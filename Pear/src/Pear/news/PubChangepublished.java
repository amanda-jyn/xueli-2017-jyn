package Pear.news;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import Pear.login.PearLogin;

public class PubChangepublished extends BaseTest{
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
		webtest.type("xpath=//input[@name='title']","�����˼䣬�����ֵ�ø���");
		//��ѡ��-����
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[3]/input[1]");
		//����
		webtest.type("xpath=//textarea[@name='content']", "Ҳ����Ϊ����Ż����ֺ��");
		//��ѡ��-�ѷ���״̬
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[5]/input[2]");
		//�ύ�޸�
		webtest.click("xpath=//button[@type='submit']");
	}
}