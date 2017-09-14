package com.wsy;

import java.awt.BorderLayout;
import java.awt.Dimension;
//import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import com.wsy.iframe.BookLoginIFrame;
import com.wsy.util.CreatecdIcon;;

/**
 * ������
 * 
 */
public class Library extends JFrame {
	private static final JDesktopPane DESKTOP_PANE = new JDesktopPane();
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager
					.getSystemLookAndFeelClassName());
			new BookLoginIFrame();//��¼����
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void addIFame(JInternalFrame iframe) { // ����Ӵ���ķ���
		DESKTOP_PANE.add(iframe);
	}
	public Library() {
		super();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setLocationByPlatform(true);
		setSize(800, 600);
		setTitle("ͼ��ݹ���ϵͳ");
		JMenuBar menuBar = createMenu(); // ���ô����˵����ķ���
		setJMenuBar(menuBar);
		JToolBar toolBar = createToolBar(); // ���ô����������ķ���
		getContentPane().add(toolBar, BorderLayout.NORTH);
		final JLabel label = new JLabel();
		label.setBounds(0, 0, 0, 0);
		label.setIcon(null); // ���屳��

		DESKTOP_PANE.addComponentListener(new ComponentAdapter() {
			public void componentResized(final ComponentEvent e) {
				Dimension size = e.getComponent().getSize();
				label.setSize(e.getComponent().getSize());
				label.setText("<html><img width=" + size.width + " height="
						+ size.height + " src='"
						+ this.getClass().getResource("/backImg.jpg")
						+ "'></html>");
			}
		});
		DESKTOP_PANE.add(label,new Integer(Integer.MIN_VALUE));
		getContentPane().add(DESKTOP_PANE);
	}
	/**
	 * ����������
	 * 
	 * @return JToolBar
	 */
	private JToolBar createToolBar() { // �����������ķ���
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		JButton bookAddButton=new JButton(MenuActions.BOOK_ADD);
		//ImageIcon icon=CreatecdIcon.add("bookAdd.bmp");//����ͼ�귽��
		ImageIcon icon=new ImageIcon(Library.class.getResource("/bookAddtb.jpg"));//��Ӳ˵���ͼ��	
		bookAddButton.setIcon(icon);
		bookAddButton.setHideActionText(true);
		
		//bookAddButton.setToolTipText("fjdkjfk");//ͼƬ����ʾ��
		toolBar.add(bookAddButton);
		//toolBar.add(MenuActions.BOOK_MODIFY);
		
		//�ڹ����������ͼ���޸���ɾ��ͼ��
		JButton bookModiAndDelButton=new JButton(MenuActions.BOOK_MODIFY);
		ImageIcon bookmodiicon=CreatecdIcon.add("bookModiAndDeltb.jpg");//����ͼ�귽��
		bookModiAndDelButton.setIcon(bookmodiicon);
		bookModiAndDelButton.setHideActionText(true);
		toolBar.add(bookModiAndDelButton);
		
		
		
		
		JButton bookTypeAddButton=new JButton(MenuActions.BOOKTYPE_ADD);
		ImageIcon bookTypeAddicon=CreatecdIcon.add("bookTypeAddtb.jpg");//����ͼ�귽��
		bookTypeAddButton.setIcon(bookTypeAddicon);
		bookTypeAddButton.setHideActionText(true);
		toolBar.add(bookTypeAddButton);
		
		
		JButton bookBorrowButton=new JButton(MenuActions.BORROW);
		ImageIcon bookBorrowicon=CreatecdIcon.add("bookBorrowtb.jpg");//����ͼ�귽��
		bookBorrowButton.setIcon(bookBorrowicon);
		bookBorrowButton.setHideActionText(true);
		toolBar.add(bookBorrowButton);
		
		JButton bookOrderButton=new JButton(MenuActions.NEWBOOK_ORDER);
		ImageIcon bookOrdericon=CreatecdIcon.add("bookOrdertb.jpg");//����ͼ�귽��
		bookOrderButton.setIcon(bookOrdericon);
		bookOrderButton.setHideActionText(true);
		toolBar.add(bookOrderButton);
		
		JButton bookCheckButton=new JButton(MenuActions.NEWBOOK_CHECK_ACCEPT);
		ImageIcon bookCheckicon=CreatecdIcon.add("newbookChecktb.jpg");//����ͼ�귽��
		bookCheckButton.setIcon(bookCheckicon);
		bookCheckButton.setHideActionText(true);
		toolBar.add(bookCheckButton);
		
		JButton readerAddButton=new JButton(MenuActions.READER_ADD);
		ImageIcon readerAddicon=CreatecdIcon.add("readerAddtb.jpg");//����ͼ�귽��
		readerAddButton.setIcon(readerAddicon);
		readerAddButton.setHideActionText(true);
		toolBar.add(readerAddButton);
		
		JButton readerModiAndDelButton=new JButton(MenuActions.READER_MODIFY);
		ImageIcon readerModiAndDelicon=CreatecdIcon.add("readerModiAndDeltb.jpg");//����ͼ�귽��
		readerModiAndDelButton.setIcon(readerModiAndDelicon);
		readerModiAndDelButton.setHideActionText(true);
		toolBar.add(readerModiAndDelButton);
		
		JButton ExitButton=new JButton(MenuActions.EXIT);
		ImageIcon Exiticon=CreatecdIcon.add("exittb.jpg");//����ͼ�귽��
		ExitButton.setIcon(Exiticon);
		ExitButton.setHideActionText(true);
		toolBar.add(ExitButton);
		return toolBar;
	}
	/**
	 * �����˵���
	 */
	private JMenuBar createMenu() { // �����˵����ķ���
		JMenuBar menuBar = new JMenuBar();

		JMenu bookOrderMenu = new JMenu(); // ��ʼ�����鶩������˵�
		bookOrderMenu.setIcon(CreatecdIcon.add("xsdgcd.jpg"));
		bookOrderMenu.add(MenuActions.NEWBOOK_ORDER);
		bookOrderMenu.add(MenuActions.NEWBOOK_CHECK_ACCEPT);

		 
		JMenu baseMenu = new JMenu();// ��ʼ����������ά���˵�
		baseMenu.setIcon(CreatecdIcon.add("jcsjcd.jpg"));
		{
			JMenu readerManagerMItem = new JMenu("������Ϣ����");
			readerManagerMItem.add(MenuActions.READER_ADD);
			readerManagerMItem.add(MenuActions.READER_MODIFY);

			JMenu bookTypeManageMItem = new JMenu("ͼ��������");
			bookTypeManageMItem.add(MenuActions.BOOKTYPE_ADD);
			bookTypeManageMItem.add(MenuActions.BOOKTYPE_MODIFY);

			JMenu menu = new JMenu("ͼ����Ϣ����");
			menu.add(MenuActions.BOOK_ADD);
			menu.add(MenuActions.BOOK_MODIFY);

			baseMenu.add(readerManagerMItem);
			baseMenu.add(bookTypeManageMItem);
			baseMenu.add(menu);
			baseMenu.addSeparator();
			baseMenu.add(MenuActions.EXIT);
		}
		JMenu borrowManageMenu = new JMenu(); // ���Ĺ���
		borrowManageMenu.setIcon(CreatecdIcon.add("jyglcd.jpg"));
		borrowManageMenu.add(MenuActions.BORROW); // ����
		borrowManageMenu.add(MenuActions.GIVE_BACK); // �黹
		borrowManageMenu.add(MenuActions.BOOK_SEARCH); // ����

		JMenu sysManageMenu = new JMenu(); // ϵͳά��
		sysManageMenu.setIcon(CreatecdIcon.add("jcwhcd.jpg"));
		JMenu userManageMItem = new JMenu("�û�����"); // �û�����
		userManageMItem.add(MenuActions.USER_ADD);
		userManageMItem.add(MenuActions.USER_MODIFY);
		sysManageMenu.add(MenuActions.MODIFY_PASSWORD);
		sysManageMenu.add(userManageMItem);

		menuBar.add(baseMenu); // ��ӻ�������ά���˵����˵���
		menuBar.add(bookOrderMenu); // ������鶩������˵����˵���
		menuBar.add(borrowManageMenu); // ��ӽ��Ĺ���˵����˵���
		menuBar.add(sysManageMenu); // ���ϵͳά���˵����˵���
		return menuBar;
	}
}
