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
		webtest.click("xpath=//span[contains(.,' ���Ź��� ')]");
		webtest.click("xpath=//a[contains(.,'��Ϣ�б�')]"); 
		//������޸ġ�         
		webtest.click("xpath=//*[@id='sample-table-1']/tbody/tr[1]/td[10]/div/a[1]");
		//�û�ID
		webtest.type("xpath=//input[@placeholder='�������û�']","2");
		//��Ϣ����
		webtest.type("xpath=//input[@name='title']","�������һ�ȴ�");
		//����
		webtest.type("xpath=//textarea[@name='content']", "�ƿ��˾����Ѻ���");
		//���ʱ��
		webtest.type("xpath=//input[@name='addtime']","2017-11-29 09:46:45");
		//��ѡ��-�Ѷ�״̬
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[6]/input[2]");
		//�ύ�޸�
		webtest.click("xpath=//button[@type='submit']");				
	}
}