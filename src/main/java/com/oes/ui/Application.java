package com.oes.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.oes.pages.LoginPage;

public class Application {
	
	private static Application app;

	private Application() {
	}
	
	public static Application getInstance() {
		if(app == null) {
			app = new Application();
		}
		return app;
	}
	
	public void lauchApp() {
		LoginPage.getInstance().open();
	}
	
	
	
	

}
