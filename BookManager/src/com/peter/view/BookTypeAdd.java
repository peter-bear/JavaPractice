package com.peter.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.peter.services.BookTypeService;
import com.peter.services.BookTypeServiceImpl;
import com.peter.util.StringUtil;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.awt.event.ActionEvent;

public class BookTypeAdd extends JInternalFrame {
	private JTextField type;
	private JTextArea DespArea; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAdd frame = new BookTypeAdd();
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
	public BookTypeAdd() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setBounds(100, 100, 611, 425);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		type = new JTextField();
		type.setFont(new Font("宋体", Font.PLAIN, 20));
		type.setColumns(10);
		
		DespArea= new JTextArea();
		DespArea.setFont(new Font("宋体", Font.PLAIN, 20));
		DespArea.setBackground(Color.LIGHT_GRAY);
//		DespArea.setMaximumSize(new Dimension(200, 30));
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addTypeAction(arg0);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookTypeAdd.class.getResource("/images/add.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClearAllAction(arg0);
			}
			
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setIcon(new ImageIcon(BookTypeAdd.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(81)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(DespArea)
								.addComponent(type, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(87, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(134)
							.addComponent(btnNewButton_1)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(DespArea, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void ClearAllAction(ActionEvent arg0) {
		// TODO Auto-generated method stub
		type.setText("");
		DespArea.setText("");
		
	}

	private void addTypeAction(ActionEvent event) {
		// TODO Auto-generated method stub
		String type = this.type.getText();
		String desp = this.DespArea.getText();
		if(StringUtil.isempty(type)) {
			JOptionPane.showMessageDialog(null, "图书类别不能为空");
			return;
		}
		
		
		BookTypeServiceImpl typeService = new BookTypeServiceImpl();
		boolean rst=false; //表示是否添加成功
		if(StringUtil.isempty(desp)) {
			rst = typeService.add(type);
			
		}else {
			rst = typeService.add(type, desp);
		}
		
		if(!rst) {
			JOptionPane.showMessageDialog(null, "图书类别已存在，添加失败");
		}else {
			JOptionPane.showMessageDialog(null, "添加成功");
			ClearAllAction(event);
		}
		
		
	}

	
}
