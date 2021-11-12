package com.peter.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.peter.dao.BookTypeDaoImpl;
import com.peter.model.BookType;
import com.peter.services.BookServiceImpl;
import com.peter.services.BookTypeServiceImpl;
import com.peter.util.StringUtil;

import javax.swing.JSpinner;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookAddFrame extends JInternalFrame {
	private JTextField bookName;
	private JTextField bookAuthor;
	private JComboBox<String> bookTypesBox; 
	private JTextField ISBN;
	private JTextPane bookDespTxt;
	private BookServiceImpl bookService = new BookServiceImpl();
	private BookTypeServiceImpl bookTypeService = new BookTypeServiceImpl();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddFrame frame = new BookAddFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookAddFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setBounds(100, 100, 787, 577);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		bookName = new JTextField();
		bookName.setFont(new Font("宋体", Font.PLAIN, 20));
		bookName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		bookAuthor = new JTextField();
		bookAuthor.setFont(new Font("宋体", Font.PLAIN, 20));
		bookAuthor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("\u56FE\u4E66ISBN\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		
		ISBN = new JTextField();
		ISBN.setFont(new Font("宋体", Font.PLAIN, 20));
		ISBN.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));
		
		bookDespTxt = new JTextPane();
		bookDespTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		bookDespTxt.setBackground(Color.LIGHT_GRAY);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddBookActionPerformed(arg0);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookAddFrame.class.getResource("/images/add.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClearAllPerformed(arg0);
			}
		});
		button.setIcon(new ImageIcon(BookAddFrame.class.getResource("/images/reset.png")));
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		
		bookTypesBox = new JComboBox();
		bookTypesBox.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookName, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookTypesBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addGap(91)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookAuthor, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(ISBN))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookDespTxt, GroupLayout.PREFERRED_SIZE, 576, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(162)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button)
							.addGap(67)))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(98)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(bookAuthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(ISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookTypesBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4)
						.addComponent(bookDespTxt, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		fillTypes();
	}
	
	protected void AddBookActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String title = bookName.getText();
		String Author = bookAuthor.getText();
		String desp = bookDespTxt.getText();
		String bookISBN = ISBN.getText();
		String Type = (String)bookTypesBox.getSelectedItem();
		if(StringUtil.isempty(title) ||StringUtil.isempty(Author) ||StringUtil.isempty(Type)) {
			JOptionPane.showMessageDialog(null, "书名、作者、类型不能为空");
			return;
		}

//		bookService.add(title, Author, desp, bookISBN, Type);
		if(bookService.add(title, Author, desp, bookISBN, Type)) {
			JOptionPane.showMessageDialog(null, "添加成功");
			ClearAllPerformed(arg0);
		}else {
			JOptionPane.showMessageDialog(null, "此书已存在");
		}
		
		
	}

	protected void ClearAllPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		bookName.setText("");
		bookAuthor.setText("");
		ISBN.setText("");
		bookDespTxt.setText("");
		if(bookTypesBox.getItemCount()>0)
			bookTypesBox.setSelectedIndex(0);
		
	}

	private void fillTypes() {
		LinkedList<BookType> booktypes = bookTypeService.showAll();
		for(BookType type:booktypes) {
			bookTypesBox.addItem(type.getType());
		}
		
	}
	
	
}
