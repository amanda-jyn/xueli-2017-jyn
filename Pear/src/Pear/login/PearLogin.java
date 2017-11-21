package Pear.login;

import com.webtest.core.WebDriverEngine;

public class PearLogin {
	WebDriverEngine webtest=null;
	public PearLogin(WebDriverEngine webtest){
		this.webtest=webtest;
	}
	public void login(){
		webtest.open("http://10.7.10.7/accounts/login/");
		webtest.type("name=username", "12345@a.com");
		webtest.type("name=password", "111111");
		webtest.click("xpath=//input[@value='µÇÂ¼']");
	}
}
