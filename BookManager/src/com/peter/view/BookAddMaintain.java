package com.peter.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.peter.model.Book;
import com.peter.model.BookType;
import com.peter.services.BookServiceImpl;
import com.peter.services.BookTypeServiceImpl;
import com.peter.util.StringUtil;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookAddMaintain extends JInternalFrame {
	private JTextField BookNameSearch;
	private JTextField BookAuthorSearch;
	private JTextField BookISBNSearch;
	private JTable BookTable;
	private JTextField NewBookISBN;
	private JTextField NewBookName;
	private JTextField NewBookAuthor;
	private JTextPane NewBookDesp;
	private JComboBox<String> BookTypeSearch; 
	private JComboBox<String> NewBookType;
	private BookServiceImpl bookService = new BookServiceImpl();
	private BookTypeServiceImpl bookTypeService = new BookTypeServiceImpl();
	private JTextField BookID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddMaintain frame = new BookAddMaintain();
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
	public BookAddMaintain() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7BA1\u7406");
		setBounds(100, 100, 833, 674);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u4FEE\u6539\u56FE\u4E66", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel NewName = new JLabel("\u4E66\u540D\uFF1A");
		NewName.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel NewISBN = new JLabel("ISBN\uFF1A");
		NewISBN.setFont(new Font("宋体", Font.PLAIN, 20));
		
		NewBookISBN = new JTextField();
		NewBookISBN.setFont(new Font("宋体", Font.PLAIN, 20));
		NewBookISBN.setColumns(10);
		
		NewBookName = new JTextField();
		NewBookName.setFont(new Font("宋体", Font.PLAIN, 20));
		NewBookName.setColumns(10);
		
		JLabel NewAuthor = new JLabel("\u4F5C\u8005\uFF1A");
		NewAuthor.setFont(new Font("宋体", Font.PLAIN, 20));
		
		NewBookAuthor = new JTextField();
		NewBookAuthor.setFont(new Font("宋体", Font.PLAIN, 20));
		NewBookAuthor.setColumns(10);
		
		JLabel BookType = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		BookType.setFont(new Font("宋体", Font.PLAIN, 20));
		
		NewBookType = new JComboBox();
		NewBookType.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel NewDesp = new JLabel("\u63CF\u8FF0\uFF1A");
		NewDesp.setFont(new Font("宋体", Font.PLAIN, 20));
		
		NewBookDesp = new JTextPane();
		NewBookDesp.setBackground(Color.LIGHT_GRAY);
		NewBookDesp.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblId = new JLabel("ID\uFF1A");
		lblId.setFont(new Font("宋体", Font.PLAIN, 20));
		
		BookID = new JTextField();
		BookID.setEditable(false);
		BookID.setFont(new Font("宋体", Font.PLAIN, 20));
		BookID.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateBookInfo();
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookAddMaintain.class.getResource("/images/modify.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton button = new JButton("\u5220\u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteBook();
			}
		});
		button.setIcon(new ImageIcon(BookAddMaintain.class.getResource("/images/delete.png")));
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(76)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(BookID, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(NewName))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(NewISBN)
									.addGap(18)
									.addComponent(NewBookISBN, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(NewBookName, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
								.addComponent(BookType))
							.addGap(40)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(NewAuthor)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(NewBookAuthor, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
								.addComponent(NewBookType, 0, 205, Short.MAX_VALUE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(NewDesp, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(NewBookDesp, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED, 373, Short.MAX_VALUE)
									.addComponent(button)
									.addGap(49)))))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(NewBookName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(BookID, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addComponent(NewName)
							.addComponent(NewBookAuthor, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(NewAuthor))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(NewISBN)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(NewBookISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(BookType, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(NewBookType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(NewDesp, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(NewBookDesp, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(button))
					.addGap(16))
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 784, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		BookTable = new JTable();
		BookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ClickChosenBook();
			}
		});
		BookTable.setRowHeight(25);
		BookTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Title", "Author", "ISBN", "Type", "Desp"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		BookTable.getColumnModel().getColumn(0).setPreferredWidth(28);
		BookTable.getColumnModel().getColumn(1).setPreferredWidth(114);
		BookTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		BookTable.getColumnModel().getColumn(3).setPreferredWidth(91);
		BookTable.getColumnModel().getColumn(4).setPreferredWidth(93);
		BookTable.getColumnModel().getColumn(5).setPreferredWidth(209);
		BookTable.setFont(new Font("宋体", Font.PLAIN, 20));
		scrollPane.setViewportView(BookTable);
		
		JLabel title = new JLabel("\u4E66\u540D\uFF1A");
		title.setFont(new Font("宋体", Font.PLAIN, 20));
		
		BookNameSearch = new JTextField();
		BookNameSearch.setFont(new Font("宋体", Font.PLAIN, 20));
		BookNameSearch.setColumns(10);
		
		JLabel author = new JLabel("\u4F5C\u8005\uFF1A");
		author.setFont(new Font("宋体", Font.PLAIN, 20));
		
		BookAuthorSearch = new JTextField();
		BookAuthorSearch.setFont(new Font("宋体", Font.PLAIN, 20));
		BookAuthorSearch.setColumns(10);
		
		JLabel Type = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		Type.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel ISBN = new JLabel("ISBN\uFF1A");
		ISBN.setFont(new Font("宋体", Font.PLAIN, 20));
		
		BookISBNSearch = new JTextField();
		BookISBNSearch.setFont(new Font("宋体", Font.PLAIN, 20));
		BookISBNSearch.setColumns(10);
		
		BookTypeSearch = new JComboBox();
		BookTypeSearch.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btnNewButton_1 = new JButton("\u641C\u7D22");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fillResultTable();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookAddMaintain.class.getResource("/images/search.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(52)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(title)
						.addComponent(ISBN))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(BookISBNSearch)
						.addComponent(BookNameSearch, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
					.addGap(68)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(author)
						.addComponent(Type))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(BookAuthorSearch, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
						.addComponent(BookTypeSearch, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(BookNameSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(title)
						.addComponent(author)
						.addComponent(BookAuthorSearch, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(BookISBNSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ISBN)
						.addComponent(Type, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(BookTypeSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(27)
					.addComponent(btnNewButton_1)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		fillTypes();
		fillResultTable();
	}
	
	/**
	 * 选中特定的一行，进行删除
	 */
	private void DeleteBook() {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(BookID.getText());
		if(bookService.delete(id)) {
			JOptionPane.showMessageDialog(null, "删除成功");
		}else {
			JOptionPane.showMessageDialog(null, "删除失败");
		}
		//更新界面
		fillResultTable();
			
	}
	
	private void UpdateBookInfo() {
		if(bookService.update(NewBookName.getText(), NewBookAuthor.getText(), NewBookDesp.getText(), 
				NewBookISBN.getText(), (String)NewBookType.getSelectedItem(),Integer.valueOf(BookID.getText()))) {
			JOptionPane.showMessageDialog(null, "修改成功");
		}else {
			JOptionPane.showMessageDialog(null, "修改失败，ISBN不能重复");
		}
		fillResultTable();
	}
	

	/**
	 * 在选项框中填充选项
	 */
	private void fillTypes() {
		LinkedList<BookType> booktypes = bookTypeService.showAll();
		BookTypeSearch.addItem(null);
		for(BookType type:booktypes) {
			BookTypeSearch.addItem(type.getType());
			NewBookType.addItem(type.getType());
		}
		
	}
	
	/**
	 * 点击Table，将信息传入到下方框中
	 */
	private void ClickChosenBook() {
		// TODO Auto-generated method stub
		int row = BookTable.getSelectedRow();
		BookID.setText(BookTable.getValueAt(row, 0).toString());
		NewBookName.setText((String)BookTable.getValueAt(row, 1));
		NewBookAuthor.setText((String)BookTable.getValueAt(row, 2));
		NewBookISBN.setText((String)BookTable.getValueAt(row, 3));
		NewBookType.setSelectedItem((String)BookTable.getValueAt(row, 4));
		NewBookDesp.setText((String)BookTable.getValueAt(row, 5));
		
	}

	
	
	/**
	 * 根据提供的信息进行搜索
	 */
	private void fillResultTable() {
		// TODO Auto-generated method stub
		String bookName = BookNameSearch.getText();
		String bookISBN = BookISBNSearch.getText();
		String bookAuthor = BookAuthorSearch.getText();
		String bookType = (String)BookTypeSearch.getSelectedItem();

		DefaultTableModel dtm = (DefaultTableModel) BookTable.getModel();
		dtm.setRowCount(0);
		LinkedList<Book> books =new LinkedList<>();
		Book book = null;
		
		Object[] temp=new Object[6];
		/**
		 * 根据优先级，先查询ISBN再查询书籍名称，最后查询作者和种类
		 */
		if(!StringUtil.isempty(bookISBN)) {
			
			book = bookService.getBook2(bookISBN);
		}
		
		else if(!StringUtil.isempty(bookName)) {
			
			book = bookService.getBook(bookName);

		}
			
		else if(!StringUtil.isempty(bookAuthor)) {
			
			books = bookService.getBooks(bookAuthor);
			
		}else if(!StringUtil.isempty(bookType)) {
			
			books = bookService.getBooks2(bookType);
			
			
		}else {
			
			books = bookService.getAllBooks();
		}
		
		
		if(book != null) {
			
			temp[0] = book.getID();
			temp[1] = book.getTitle(); 
			temp[2] = book.getAuthor();
			temp[3] = book.getISBN();
			temp[4] = book.getType();
			temp[5] = book.getDesp();
			dtm.addRow(temp);
			
		}else if(!books.isEmpty()) {
			
			for(Book tempBook:books) {
				temp[0] = tempBook.getID();
				temp[1] = tempBook.getTitle(); 
				temp[2] = tempBook.getAuthor();
				temp[3] = tempBook.getISBN();
				temp[4] = tempBook.getType();
				temp[5] = tempBook.getDesp();
				dtm.addRow(temp);
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "未找到相关信息");
//			fillAllResult();
			
		}
		
		
		
	}
}
