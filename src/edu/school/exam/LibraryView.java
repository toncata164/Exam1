package edu.school.exam;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LibraryView extends JFrame{
	
	public LibraryView() {
		this.setBounds(0, 0, 500, 750);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		JButton btnAdd=new JButton();
		btnAdd.setBounds(15,15,100,30);
		btnAdd.setText("Add");
		this.add(btnAdd);
	}

}
