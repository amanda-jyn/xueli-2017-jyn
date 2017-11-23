package Pear.login;

import com.webtest.core.WebDriverEngine;

public class PearLogin {
	WebDriverEngine webtest=null;
	public PearLogin(WebDriverEngine webtest){
		this.webtest=webtest;
	}
	public void login() throws InterruptedException{
		webtest.open("http://localhost:8032/zl_shop/admin.php/Login/index.html");
		Thread.sleep(5000);
		webtest.type("xpath=//input[@name='name']","admin");
		webtest.type("xpath=//input[@name='password']","admin");
		webtest.click("xpath=//button[@type='submit']");
	}
}
