package com.wsy.iframe;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import com.wsy.JComPz.MapPz;
import com.wsy.dao.Dao;
import com.wsy.model.BookInfo;
import com.wsy.model.BookType;
import com.wsy.model.Operater;
import com.wsy.model.Reader;
import com.wsy.util.MyDocument;

public class BookBorrowIFrame extends JInternalFrame {
	private Operater user = BookLoginIFrame.getUser(); 
	
	private final JTextField operator;


	private JTextField todaydate;

	private JTable table;

	private JTextField price;

	private JTextField bookType;

	private JTextField bookName;

	private JTextField bookISBN;

	private JTextField keepMoney;

	private JTextField number;

	private JTextField readerName;

	private JTextField readerISBN;

	private String[] columnNames = { "书籍编号", "借书日期", "应还日期", "读者编号" };

	private Map map = MapPz.getMap();

	//private static int i = 1;

	DefaultTableModel model = new DefaultTableModel();
	SimpleDateFormat myfmt=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	/**
	 * Create the frame
	 */
	public final void add() {
		String str[] = new String[4];
		str[0] = bookISBN.getText().trim();
		str[1] = String.valueOf(myfmt.format(new java.util.Date()));
		str[2] = getBackTime().toLocaleString();
		str[3] = readerISBN.getText().trim();
		model.addRow(str);
	}
	public Date getBackTime() {	//取还书时间
		String days = "0";
		List list2 = Dao.selectBookCategory(bookType.getText().trim());
		for (int j = 0; j < list2.size(); j++) {
			BookType type = (BookType) list2.get(j);
			days = type.getDays();
		}
		java.util.Date date = new java.util.Date();
		date.setDate(date.getDate() + Integer.parseInt(days));
		return date;
	}
	public BookBorrowIFrame() {
		super();
//		addInternalFrameListener(new InternalFrameAdapter() {
//			public void internalFrameClosing(InternalFrameEvent e) {
//			}
//		});//关闭窗口时候引发的事件
		System.out.println(user.getName());
		setTitle("图书借阅管理");
		setIconifiable(true); // 设置窗体可最小化－－－必须
		setClosable(true); // 设置窗体可关闭－－－必须
		setBounds(100, 100, 500, 400);

		final JPanel panel = new JPanel();
		getContentPane().add(panel);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(400, 100));
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		model.setColumnIdentifiers(columnNames);

		table.setModel(model);

		final JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(0, 120));
		getContentPane().add(panel_1, BorderLayout.NORTH);

		final JSplitPane splitPane = new JSplitPane();
		panel_1.add(splitPane);

		final JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(240, 110));
		splitPane.setLeftComponent(panel_3);

		final JPanel panel_5 = new JPanel();
		final GridLayout gridLayout = new GridLayout(0, 2);
		gridLayout.setHgap(2);
		gridLayout.setVgap(10);
		panel_5.setLayout(gridLayout);
		panel_5.setPreferredSize(new Dimension(150, 100));
		panel_3.add(panel_5);

		final JLabel label = new JLabel();
		label.setText("读者编号：");
		panel_5.add(label);

		readerISBN = new JTextField();
		readerISBN.setDocument(new MyDocument(13));
		readerISBN.addKeyListener(new ISBNListenerlostFocus());
		panel_5.add(readerISBN);

		final JLabel label_1 = new JLabel();
		label_1.setText("读者姓名：");
		panel_5.add(label_1);

		readerName = new JTextField();
		readerName.setEditable(false);
		panel_5.add(readerName);

		final JLabel label_2 = new JLabel();
		label_2.setText("可借数量：");
		panel_5.add(label_2);

		number = new JTextField();
		number.setEditable(false);
		panel_5.add(number);

		final JLabel label_4 = new JLabel();
		label_4.setText("押    金：");
		panel_5.add(label_4);

		keepMoney = new JTextField();
		keepMoney.setEditable(false);
		panel_5.add(keepMoney);
		Icon icon = new ImageIcon("1.gif");

		final JPanel panel_4 = new JPanel();
		final GridLayout gridLayout_1 = new GridLayout(0, 2);
		gridLayout_1.setVgap(10);
		panel_4.setLayout(gridLayout_1);
		panel_4.setPreferredSize(new Dimension(240, 110));
		splitPane.setRightComponent(panel_4);

		final JLabel label_5 = new JLabel();
		label_5.setText("书籍编号：");
		panel_4.add(label_5);

		bookISBN = new JTextField();
		bookISBN.setDocument(new MyDocument(13));
		bookISBN.addKeyListener(new bookISBNListenerlostFocus());
		panel_4.add(bookISBN);

		final JLabel label_6 = new JLabel();
		label_6.setText("书籍名称：");
		panel_4.add(label_6);

		bookName = new JTextField();
		bookName.setEditable(false);
		panel_4.add(bookName);

		final JLabel label_7 = new JLabel();
		label_7.setText("书籍类别：");
		panel_4.add(label_7);

		bookType = new JTextField();
		bookType.setEditable(false);
		panel_4.add(bookType);

		final JLabel label_8 = new JLabel();
		label_8.setText("书籍价格：");
		panel_4.add(label_8);

		price = new JTextField();
		price.setEditable(false);
		panel_4.add(price);

		final JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(0, 120));
		getContentPane().add(panel_2, BorderLayout.SOUTH);

		final JPanel panel_7 = new JPanel();
		final GridLayout gridLayout_2 = new GridLayout(0, 2);
		gridLayout_2.setVgap(10);
		panel_7.setLayout(gridLayout_2);
		panel_7.setPreferredSize(new Dimension(280, 50));
		panel_2.add(panel_7);

		final JLabel label_9 = new JLabel();
		label_9.setText("当前时间：");
		panel_7.add(label_9);

		todaydate = new JTextField();
		todaydate.setEditable(false);
		todaydate.setPreferredSize(new Dimension(0, 0));
		todaydate.addActionListener(new TimeActionListener());
		todaydate.setFocusable(false);
		panel_7.add(todaydate);

		final JLabel label_11 = new JLabel();
		label_11.setText("操作员：");
		panel_7.add(label_11);

		operator  =new JTextField(user.getName());
		operator.setEditable(false);
		panel_7.add(operator);

		final JPanel panel_8 = new JPanel();
		panel_8.setLayout(new FlowLayout());
		panel_8.setPreferredSize(new Dimension(200, 100));
		panel_2.add(panel_8);

		final JButton buttonBorrow = new JButton();
		buttonBorrow.setText("借出当前图书");
		buttonBorrow.addActionListener(new BorrowActionListener());
		panel_8.add(buttonBorrow);

		final JButton buttonClear = new JButton();
		buttonClear.setText("清除所有记录");
		buttonClear.addActionListener(new ClearActionListener(model));
		panel_8.add(buttonClear);

		setVisible(true);
		//
	}

	class bookISBNListenerlostFocus extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			if (e.getKeyChar() == '\n') { // 判断在文本框是否输入回车。
				if (readerISBN.getText().trim().length()!=0
						&& bookISBN.getText().trim().length()!=0) {
					String ISBNs = bookISBN.getText().trim();
					List list = Dao.selectBookInfo(ISBNs);
					for (int i = 0; i < list.size(); i++) {
						BookInfo book = (BookInfo) list.get(i);
						bookName.setText(book.getBookname());
						bookType.setText(String.valueOf(map.get(book
								.getTypeid())));
						price.setText(String.valueOf(book.getPrice()));
					}
					String days = "0";
					List list2 = Dao.selectBookCategory(bookType.getText()
							.trim());
					for (int j = 0; j < list2.size(); j++) {
						BookType type = (BookType) list2.get(j);
						days = type.getDays();
					}
					String readerISBNs = readerISBN.getText().trim();
					List list5 = Dao.selectReader(readerISBNs);// 此读者是否在tb_reader表中
					List list4 = Dao.selectBookInfo(ISBNs);// 此书是否在tb_bookInfo表中
					if (!readerISBNs.isEmpty() && list5.isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"此读者编号没有注册，查询输入读者编号是否有误！");
						return;
					}
					if (list4.isEmpty() && !ISBNs.isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"本图书馆没有此书，查询输入图书编号是否有误！");
						return;
					}
					if (Integer.parseInt(number.getText().trim()) <= 0) {
						JOptionPane.showMessageDialog(null, "借书量已经超过最大借书量！");
						return;
					}

					add();
					number.setText(String.valueOf(Integer.parseInt(number
							.getText().trim()) - 1));
				}

				else
					JOptionPane.showMessageDialog(null, "请输入读者条形码！");
			}

		}
	}

	class ISBNListenerlostFocus extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			if (e.getKeyChar() == '\n') { // 判断在文本框是否输入回车。
				String ISBNs = readerISBN.getText().trim();

				List list = Dao.selectReader(ISBNs);
				if (list.isEmpty() && !ISBNs.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"此读者编号没有注册，查询输入读者编号是否有误！");
				}
				for (int i = 0; i < list.size(); i++) {
					Reader reader = (Reader) list.get(i);
					readerName.setText(reader.getName());
					number.setText(reader.getMaxNum());
					keepMoney.setText(reader.getKeepMoney() + "");
					System.out.println("读者可借书量" + number.getText().trim());
				}
			}
		}
	}

	class BorrowActionListener implements ActionListener { 
		public void actionPerformed(final ActionEvent e) {

			String bookISBNs=bookISBN.getText().trim();
			String readerISBNs=readerISBN.getText().trim();
			String bookNames=bookName.getText().trim();
			String operatorId=user.getId();
			//String num=table.getRowCount()+"";
			String borrowDate=myfmt.format(new java.util.Date());
			String backDate=myfmt.format(getBackTime());
			//System.out.println(borrowDate);
			//System.out.println(java.sql.Timestamp.valueOf(backDate));
			int i=Dao.InsertBookBorrow(bookISBNs, readerISBNs, operatorId, java.sql.Timestamp.valueOf(borrowDate), java.sql.Timestamp.valueOf(backDate));
			if(i==1){
				JOptionPane.showMessageDialog(null, "图书借阅完成！");
				doDefaultCloseAction();
			}
		}
	}

	class ClearActionListener implements ActionListener {
		private final DefaultTableModel model;

		ClearActionListener(DefaultTableModel model) {
			this.model = model;
		}
		
		public void actionPerformed(final ActionEvent e) {
			System.out.println(table.getRowCount());
			if(table.getRowCount()!=0){
				model.removeRow(table.getRowCount()-1);
				bookISBN.setText("");
				bookType.setText("");
				bookName.setText("");
				price.setText("");
				readerISBN.setText("");
				readerName.setText("");
				number.setText("");
				keepMoney.setText("");
			}
			else {
				JOptionPane.showMessageDialog(null, "表格中暂时没有数据，请进行借阅操作");
			}
		}
	}
	class TimeActionListener implements ActionListener{
		public TimeActionListener(){
			Timer t=new Timer(1000,this);
			t.start();
		}
		public void actionPerformed(ActionEvent ae){
			todaydate.setText(myfmt.format(new java.util.Date()).toString());
		}
	}
}
