package com.wsy.iframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.wsy.JComPz.Item;
import com.wsy.JComPz.MapPz;
import com.wsy.dao.Dao;
import com.wsy.model.BookInfo;

import java.awt.*;

public class BookSearchIFrame extends JInternalFrame {

	private JTextField textField_1;

	private JComboBox comboBox_1;

	private JTable table_1, table_2;

	private JComboBox choice;

	private JTextField textField_2;

	private JScrollPane scrollPane, scrollPane_1;
	private Map m=MapPz.getMap();


	/**
	 * Launch the application
	 * 
	 * @param args
	 */

	/**
	 * Create the frame
	 */
	String booksearch[] = { "编号", "分类", "名称", "作者", "译者","出版社",  "出版日期", "单价" };

	private Object[][] getselect(List list) {
		Object[][] s = new Object[list.size()][8];
		for (int i = 0; i < list.size(); i++) {
			BookInfo book = (BookInfo) list.get(i);
			s[i][0] = book.getISBN();
			String booktypename=String.valueOf(MapPz.getMap().get(book.getTypeid()));
			s[i][1] = booktypename;
			s[i][2] = book.getBookname();
			s[i][3] = book.getWriter();
			s[i][4] = book.getTranslator();
			s[i][5] = book.getPublisher();
			s[i][6] = book.getDate();
			s[i][7] = book.getPrice();

		}
		return s;

	}

	private Object[] getselectid(List list) {
		Object[] ids = new Object[list.size()];
		for (int i = 0; i < list.size(); i++) {
			BookInfo book = new BookInfo();
			ids[i] = book.getISBN();
		}
		return ids;
	}

	public BookSearchIFrame() {
		super();
		setIconifiable(true);
		setClosable(true);
		setTitle("图书查询");
		setBounds(100, 100, 500, 400);

		
		setVisible(true);

		final JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setPreferredSize(new Dimension(0, 50));
		getContentPane().add(tabbedPane);

		final JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout());
		tabbedPane.addTab("条件查询", null, panel_1, null);

		final JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new TitledBorder(null, "请选择查询项目", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		panel_1_1.setPreferredSize(new Dimension(0, 50));
		panel_1.add(panel_1_1, BorderLayout.NORTH);
         choice=new JComboBox();
		String[] array={"图书名称","图书作者"};
		for(int i=0;i<array.length;i++){
			choice.addItem(array[i]);
			
		}
		panel_1_1.add(choice);
		textField_1 = new JTextField();
		textField_1.setColumns(20);
		panel_1_1.add(textField_1);
        
		final JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "查询结果显示", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		panel_1.add(panel);

		
		 scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(400, 200));
		panel.add(scrollPane_1);

		final JPanel panel_2_1 = new JPanel();
		panel_2_1.setPreferredSize(new Dimension(0, 50));
		panel_1.add(panel_2_1, BorderLayout.SOUTH);

		final JButton button = new JButton();
		button.setText("查询");
		panel_2_1.add(button);

		 button.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
					String name=(String)choice.getSelectedItem();
					if(name.equals("图书名称")){
						
						Object[][] results=getselect(Dao.selectbookmohu(textField_1.getText()));
						table_2 = new JTable(results,booksearch);
						
						scrollPane_1.setViewportView(table_2);
					}
					else if(name.equals("图书作者")){
						
						Object[][] results=getselect(Dao.selectbookmohuwriter(textField_1.getText()));
						table_2 = new JTable(results,booksearch);
						
						scrollPane_1.setViewportView(table_2);
					}
				}
	        	
	        	
	        });
		
		
		final JButton button_1 = new JButton();
		button_1.setText("退出");
		panel_2_1.add(button_1);
		button_1.addActionListener(new CloseActionListener());
		
		setVisible(true);
		
		final JPanel panel_2 = new JPanel();
		tabbedPane.addTab("显示图书全部信息", null, panel_2, null);
         
		 scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(450, 250));
		panel_2.add(scrollPane);
		
		Object[][] results=getselect(Dao.selectbookserch());
		String [] booksearch = { "编号", "分类", "名称", "作者", "译者","出版社",  "出版日期", "单价" };
		table_1 = new JTable(results,booksearch);
		
		scrollPane.setViewportView(table_1);
		
		}
	class CloseActionListener implements ActionListener {			// 添加关闭按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}
}
