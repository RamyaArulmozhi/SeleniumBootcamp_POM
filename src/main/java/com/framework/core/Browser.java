package com.framework.core;

public interface Browser {
	
	void disableNotifications();
	
	void browserInstantiate();
	
	void browserMaximize();
	
	void implicitWait(int seconds);
	
	void goToUrl(String url);
	
	void closeWindow();
	
	void quitBrowser();
 

}
