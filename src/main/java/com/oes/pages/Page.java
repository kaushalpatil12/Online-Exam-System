package com.oes.pages;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Page {
	
	protected JFrame frame;
	protected int width;
	protected int height;
	protected String name;
	protected JPanel panel;
	
	public Page() {
	}
	
	public void open() {
		frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocation(400, 230);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setVisible(true);
	}
	
	public void close() {
		frame.setVisible(false);
	}

}
