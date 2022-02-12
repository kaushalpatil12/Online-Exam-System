package com.oes.pages;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Point center = new Point(dim.width/2 - frame.getSize().width/2, dim.height/2 - frame.getSize().height/2);
        frame.setLocation(center);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setVisible(true);
	}
	
	public void close() {
		frame.setVisible(false);
	}

	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(panel, msg);
	}
}
