package edu.school.exam;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LibraryView extends JFrame{
	
	private JButton btnAdd;
	private JLabel lblAuthor;
	private JTextField txtAuthor;
	private JLabel lblTitle;
	private JTextField txtTitle;
	private JLabel lblPublisher;
	private JTextField txtPublisher;
	private JLabel lblIsbn;
	private JTextField txtIsbn;
	private JTextArea txtArea;
	private JButton btnClear;
	private JButton btnSearch;
	private JLabel lblEnterAuthor;
	private JTextField txtEnterAuthor;
	
	public LibraryView() {
		this.setBounds(0, 0, 500, 750);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		btnSearch = new JButton();
		btnSearch.setBounds(300, 500, 100, 30);
		btnSearch.setText("Search");
		this.add(btnSearch);
		btnSearch.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				txtAuthor.setText("");
				txtTitle.setText("");
				txtPublisher.setText("");
				txtIsbn.setText("");
				Book[] b = Library.getInstance().getAllBooksByAuthor(txtEnterAuthor.getText());
				txtArea.setText("");
				for(int i = 0; i < b.length; i++)
				{
					txtArea.append(b[i].toString());
				}
			}
			
		});
		
		lblEnterAuthor = new JLabel();
		lblEnterAuthor.setText("Enter author");
		lblEnterAuthor.setBounds(10, 500, 100, 30);
		txtEnterAuthor = new JTextField();
		txtEnterAuthor.setBounds(80, 500, 100, 30);
		this.add(lblEnterAuthor);
		this.add(txtEnterAuthor);
		
		btnAdd=new JButton();
		btnAdd.setBounds(250,30,100,30);
		btnAdd.setText("Add");
		this.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				Library.getInstance().addBook(txtTitle.getText(), txtAuthor.getText(), txtPublisher.getText(), txtIsbn.getText());
				
				String book = txtAuthor.getText() + " " + txtTitle.getText()+ " " + txtPublisher.getText() + " " + txtIsbn.getText() + "\n";
				txtArea.append(book);
				
				txtAuthor.setText("");
				txtTitle.setText("");
				txtPublisher.setText("");
				txtIsbn.setText("");
			}
			
		} );
		
		btnClear = new JButton();
		btnClear.setBounds(350, 30, 100, 30);
		btnClear.setText("Clear");
		this.add(btnClear);
		btnClear.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				Library.getInstance().removeBooks();
				txtArea.setText("");
			}
			
		});
		
		lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(20, 20, 100, 30);
		this.add(lblAuthor);
		lblAuthor.setBackground(Color.red);
		lblAuthor.setOpaque(true);
		
		txtAuthor = new JTextField();
		txtAuthor.setBounds(80, 20, 50, 30);
		this.add(txtAuthor);
		
		lblTitle = new JLabel("Title:");
		lblTitle.setBounds(20,60, 100, 30);
		this.add(lblTitle);
		lblTitle.setBackground(Color.red);
		lblTitle.setOpaque(true);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(80, 60, 50, 30);
		this.add(txtTitle);
		
		lblPublisher = new JLabel("Publisher:");
		lblPublisher.setBounds(20, 100, 100, 30);
		this.add(lblPublisher);
		lblPublisher.setBackground(Color.red);
		lblPublisher.setOpaque(true);
		
		txtPublisher = new JTextField();
		txtPublisher.setBounds(80, 100, 50, 30);
		this.add(txtPublisher);
		
		lblIsbn = new JLabel("ISBN::");
		lblIsbn.setBounds(20, 140, 100, 30);
		this.add(lblIsbn);
		lblIsbn.setBackground(Color.red);
		lblIsbn.setOpaque(true);
		
		txtIsbn = new JTextField();
		txtIsbn.setBounds(80, 140, 50, 30);
		this.add(txtIsbn);
		
		txtArea = new JTextArea();
		txtArea.setBounds(10, 180, 300, 300);
		txtArea.setVisible(true);
		this.add(txtArea);
	}

}
