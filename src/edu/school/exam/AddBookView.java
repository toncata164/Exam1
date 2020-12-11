package edu.school.exam;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AddBookView extends JFrame{
	final int width=70;
	final int height=25;
	
	public AddBookView() {
		this.setBounds(0,0,500,550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		JLabel lblTitle=new JLabel();
		lblTitle.setBounds(0,0,width,height);
		lblTitle.setText("Title");
		this.add(lblTitle);
		
		JLabel lblAuthor=new JLabel();
		lblAuthor.setBounds(0,100,width, height);
		lblAuthor.setText("Author");
		this.add(lblAuthor);
		
		
	}

}
