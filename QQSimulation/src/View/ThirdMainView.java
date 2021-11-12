package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Service.UserClientService;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThirdMainView extends JFrame {

	private JPanel contentPane;
	private JTextPane textPane;
	private JTable DialogueTable;
	private String user;
	private String getter;
	private UserClientService service;
	private DefaultTableModel dtm;
	private boolean close = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThirdMainView frame = new ThirdMainView();
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
	public ThirdMainView() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				close = true;
			}
		});
		setTitle("\u5BF9\u8BDD\u6846");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
		);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("宋体", Font.PLAIN, 20));
		textPane.setBackground(Color.LIGHT_GRAY);
		
		JButton btnNewButton = new JButton("\u6E05\u7A7A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClearMessage();
			}
			
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btnNewButton_1 = new JButton("\u53D1\u9001");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SendMessage();
				ClearMessage();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton_2 = new JButton("\u5237\u65B0");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GetMessage();
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(93)
					.addComponent(btnNewButton)
					.addGap(158)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addGap(94))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap())
		);
		
		DialogueTable = new JTable();
		DialogueTable.setFillsViewportHeight(true);
		DialogueTable.setShowGrid(false);
		DialogueTable.setEnabled(false);
		DialogueTable.setRowSelectionAllowed(false);
		DialogueTable.setFont(new Font("宋体", Font.PLAIN, 20));
		DialogueTable.setBorder(null);
		scrollPane.setViewportView(DialogueTable);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	private void SendMessage() {
		// TODO Auto-generated method stub
		Date time =new Date();
		String date = time.getHours()+":"+time.getMinutes()+"："+time.getSeconds();
		service.TalkWithOther(user, getter, textPane.getText(), date);

		Object[] temp = new Object[2];
		
		temp[0]=textPane.getText();
		temp[1] = "";
	
		dtm.addRow(temp);
		
	}
	
	private void GetMessage() {
		String content = service.GetTheContent();
//		System.out.println(content);
		if(content != null) {
			Object[] temp = new Object[2];
			
			temp[0]="";
			temp[1] = content;
			
			
			dtm.addRow(temp);
		}

	}

	public void setInit(String id, String other, UserClientService s) {
		this.user = id;
		this.getter = other;
		this.service = s;
		
		DialogueTable.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
				},
				new String[] {
					user, getter
				}
			));
		dtm = (DefaultTableModel) DialogueTable.getModel();
		dtm.setRowCount(0);
		DialogueTable.setRowHeight(22);
		
	}
	
	public boolean getClose() {
		return close;
	}

	private void ClearMessage() {
		// TODO Auto-generated method stub
		textPane.setText("");
	}
	

}
