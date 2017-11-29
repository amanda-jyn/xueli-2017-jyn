package Pear.news;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import com.webtest.core.ElementFinder;
import com.webtest.table.Table;
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
		webtest.click("xpath=//span[contains(.,' ���Ź��� ')]");
		webtest.click("xpath=//a[contains(.,'��Ϣ�б�')]"); 
		//������޸ġ�         
		webtest.click("xpath=//*[@id='sample-table-1']/tbody/tr[1]/td[10]/div/a[1]");
		//�û�ID
		webtest.type("xpath=//input[@placeholder='�������û�']","2");
		//��Ϣ����
		webtest.type("xpath=//input[@name='title']","����������");
		//����
		webtest.type("xpath=//textarea[@name='content']", "��������");
		//���ʱ��
		webtest.type("xpath=//input[@name='addtime']","2017-11-29 09:46:45");
		//��ѡ��-δ��״̬
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[6]/input[1]");
		//��ѡ��-�Ѷ�״̬
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[6]/input[2]");
		//��ѡ��-ɾ��״̬
		webtest.click("xpath=//*[@id='main-container']/div/div[2]/div[2]/div[2]/div/form/div[6]/input[3]");
		//�ύ�޸�
		webtest.click("xpath=//button[@type='submit']");
		
//		ElementFinder ef=new ElementFinder(driver);
//		Table table=(Table) ef.findElement("xpath=//*[@id='sample-table-1']");
//		int rowcount=table.getRowCount()-1;
//		table.getCell(rowcount, 2);
		
		
	}
}