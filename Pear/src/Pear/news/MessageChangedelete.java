package Pear.news;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import Pear.login.PearLogin;

public class MessageChangedelete extends BaseTest{
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
		webtest.click("xpath=//a[contains(.,'��Ϣ�б�')]"); 
		//������޸ġ�         
		webtest.click("xpath=//*[@id='sample-table-1']/tbody/tr[1]/td[10]/div/a[1]");
		//�û�ID
		webtest.type("xpath=//input[@placeholder='�������û�']","666");
		//��Ϣ����
		webtest.type("xpath=//input[@name='title']","һ������ѽ");
		//����
		webtest.type("xpath=//textarea[@name='content']", "�����ҿ���");
		//���ʱ��
		webtest.type("xpath=//input[@name='addtime']","2017-11-29 09:46:45");
		//��ѡ��-ɾ��״̬
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[6]/input[3]");
		//�ύ�޸�
		webtest.click("xpath=//button[@type='submit']");				
	}
}