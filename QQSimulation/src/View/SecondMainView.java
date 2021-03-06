package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Service.UserClientService;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.List;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.Label;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SecondMainView extends JFrame {
	
	private JList<String> list;
	private UserClientService UserClientService;
	private JPanel contentPane;
	private JLabel IDlabel;
	private long clickTime = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondMainView frame = new SecondMainView();
					frame.setVisible(true);
//					ShowOnlineUser();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SecondMainView() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				LogOut();
			}
		});
		setTitle("\u4E8C\u7EA7\u83DC\u5355");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		IDlabel = new JLabel("\u7528\u6237ID\uFF1A ");
		IDlabel.setFont(new Font("????", Font.PLAIN, 20));
		
		JButton button = new JButton("\u663E\u793A\u5728\u7EBF\u7528\u6237\u5217\u8868");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showOnlineUsers();
			}
		});
		button.setFont(new Font("????", Font.PLAIN, 20));
		
		list = new JList<String>();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ThirdMainView(arg0);
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("????", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(130)
							.addComponent(IDlabel)))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(IDlabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(76)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	private void ThirdMainView(MouseEvent listener) {
		// TODO Auto-generated method stub
		if(checkClickTime()) {
			String somebody = list.getSelectedValue();
			if(somebody.equals(UserClientService.getU())) {
				JOptionPane.showMessageDialog(null, "????????????");
			}else {
				//????????????????????
				ThirdMainView dialogue = new ThirdMainView();
				dialogue.setInit(UserClientService.getU(), somebody, UserClientService);
				dialogue.setVisible(true);
				
				
				
			}
		}
			
	
	}
	
	public boolean checkClickTime() {
		
		long nowTime = (new Date()).getTime();
		if ( (nowTime - clickTime) < 300) {
		clickTime = nowTime;
		return true;
		}
		clickTime = nowTime;
		return false;
	}
	

	private void showOnlineUsers() {
		// TODO Auto-generated method stub
		
		String[] friends = UserClientService.showOnlineUser();
		if(friends!=null)
			list.setListData(friends);
		
	}
	
	
	

	public void setUserClientService(UserClientService UserClientService) {
		this.UserClientService = UserClientService;
		IDlabel.setText("????ID??"+UserClientService.getU());
	}
	
	/**
	 * 1 ???????? ??????????????
	 */
	private void LogOut() {
		// TODO Auto-generated method stub
		UserClientService.LogOut();
		System.exit(0);
	}
	
	
}
