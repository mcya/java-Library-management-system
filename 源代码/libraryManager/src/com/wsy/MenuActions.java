package com.wsy;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JInternalFrame;

import com.wsy.iframe.BookAddIFrame;
import com.wsy.iframe.BookBackIFrame;
import com.wsy.iframe.BookBorrowIFrame;
import com.wsy.iframe.BookModiAndDelIFrame;
import com.wsy.iframe.BookSearchIFrame;
import com.wsy.iframe.BookTypeAddIFrame;
import com.wsy.iframe.BookTypeModiAndDelIFrame;
import com.wsy.iframe.GengGaiMiMa;
import com.wsy.iframe.ReaderAddIFrame;
import com.wsy.iframe.ReaderModiAndDelIFrame;
import com.wsy.iframe.UserAddIFrame;
import com.wsy.iframe.UserModiAndDelIFrame;
import com.wsy.iframe.newBookCheckIFrame;
import com.wsy.iframe.newBookOrderIFrame;
import com.wsy.util.*;
/**
 * 菜单和按钮的Action对象
 * 
 */
public class MenuActions {
	private static Map<String, JInternalFrame> frames; // 子窗体集合

	public static PasswordModiAction MODIFY_PASSWORD; // 修改密码窗体动作
	public static UserModiAction USER_MODIFY; // 修改用户资料窗体动作
	public static UserAddAction USER_ADD; // 用户添加窗体动作
	public static BookSearchAction BOOK_SEARCH; // 图书搜索窗体动作
	public static GiveBackAction GIVE_BACK; // 图书归还窗体动作
	public static BorrowAction BORROW; // 图书借阅窗体动作
	public static CheckAndAcceptNewBookAction NEWBOOK_CHECK_ACCEPT;// 修改密码动作
	public static BoodOrderAction NEWBOOK_ORDER; // 新书定购窗体动作
	public static BookTypeModiAction BOOKTYPE_MODIFY; // 图书类型修改窗体动作
	public static BookTypeAddAction BOOKTYPE_ADD; // 图书类型添加窗体动作
	public static ReaderModiAction READER_MODIFY; // 读者信息修改窗体动作
	public static ReaderAddAction READER_ADD; // 读者信息添加窗体动作
	public static BookModiAction BOOK_MODIFY; // 图书信息修改窗体动作
	public static BookAddAction BOOK_ADD; // 图书信息添加窗体动作
	public static ExitAction EXIT; // 系统退出动作

	static {
		frames = new HashMap<String, JInternalFrame>();

		MODIFY_PASSWORD = new PasswordModiAction();
		USER_MODIFY = new UserModiAction();
		USER_ADD = new UserAddAction();
		BOOK_SEARCH = new BookSearchAction();
		GIVE_BACK = new GiveBackAction();
		BORROW = new BorrowAction();
		NEWBOOK_CHECK_ACCEPT = new CheckAndAcceptNewBookAction();
		NEWBOOK_ORDER = new BoodOrderAction();
		BOOKTYPE_MODIFY = new BookTypeModiAction();
		BOOKTYPE_ADD = new BookTypeAddAction();
		READER_MODIFY = new ReaderModiAction();
		READER_ADD = new ReaderAddAction();
		BOOK_MODIFY = new BookModiAction();
		BOOK_ADD = new BookAddAction();
		EXIT = new ExitAction();
	}

	private static class PasswordModiAction extends AbstractAction {
		PasswordModiAction() {
			putValue(Action.NAME,"更改口令");
			putValue(Action.LONG_DESCRIPTION, "修改当前用户密码");
			putValue(Action.SHORT_DESCRIPTION, "更换口令");//在“更改口令”提示中显示的文字
			//putValue(Action.SMALL_ICON,CreatecdIcon.add("bookAddtb.jpg"));
			//将图标存储到动作对象中
			//setEnabled(false);//使动作禁用
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("更改密码")||frames.get("更改密码").isClosed()) {
				GengGaiMiMa iframe=new GengGaiMiMa();
				frames.put("更改密码", iframe);
				Library.addIFame(frames.get("更改密码"));
			}
		}
	}

	private static class UserModiAction extends AbstractAction {
		UserModiAction() {
			super("用户修改与删除", null);
			putValue(Action.LONG_DESCRIPTION, "修改和删除用户信息");
			putValue(Action.SHORT_DESCRIPTION, "用户修改与删除");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("用户信息修改与删除")||frames.get("用户信息修改与删除").isClosed()) {
				UserModiAndDelIFrame iframe=new UserModiAndDelIFrame();
				frames.put("用户信息修改与删除", iframe);
				Library.addIFame(frames.get("用户信息修改与删除"));
			}
		}
	}

	private static class UserAddAction extends AbstractAction {
		UserAddAction() {
			super("用户添加", null);
			putValue(Action.LONG_DESCRIPTION, "添加新的用户");
			putValue(Action.SHORT_DESCRIPTION, "用户添加");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("用户信息添加")||frames.get("用户信息添加").isClosed()) {
				UserAddIFrame iframe=new UserAddIFrame();
				frames.put("用户信息添加", iframe);
				Library.addIFame(frames.get("用户信息添加"));
			}
			
		}
	}

	private static class BookSearchAction extends AbstractAction {
		BookSearchAction() {
			super("图书搜索", null);
			putValue(Action.LONG_DESCRIPTION, "搜索入库的图书信息");
			putValue(Action.SHORT_DESCRIPTION, "图书搜索");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("图书查询")||frames.get("图书查询").isClosed()) {
				BookSearchIFrame iframe=new BookSearchIFrame();
				frames.put("图书查询", iframe);
				Library.addIFame(frames.get("图书查询"));
			}
		}
	}

	private static class GiveBackAction extends AbstractAction {
		GiveBackAction() {
			super("图书归还", null);
			putValue(Action.LONG_DESCRIPTION, "归还借阅的图书");
			putValue(Action.SHORT_DESCRIPTION, "图书归还");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("图书归还管理")||frames.get("图书归还管理").isClosed()) {
				BookBackIFrame iframe=new BookBackIFrame();
				frames.put("图书归还管理", iframe);
				Library.addIFame(frames.get("图书归还管理"));
			}
		}
	}

	private static class BorrowAction extends AbstractAction {
		BorrowAction() {
			super("图书借阅", null);
			putValue(Action.LONG_DESCRIPTION, "从图书馆借阅图书");
			putValue(Action.SHORT_DESCRIPTION, "图书借阅");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("图书借阅管理")||frames.get("图书借阅管理").isClosed()) {
				BookBorrowIFrame iframe=new BookBorrowIFrame();
				frames.put("图书借阅管理", iframe);
				Library.addIFame(frames.get("图书借阅管理"));
			}
		}
	}

	private static class CheckAndAcceptNewBookAction extends AbstractAction {
		CheckAndAcceptNewBookAction() {
			super("验收新书", null);
			putValue(Action.LONG_DESCRIPTION, "验收订阅的新图书");
			putValue(Action.SHORT_DESCRIPTION, "验收新书");
		}
		public void actionPerformed(ActionEvent e) {
			
			if (!frames.containsKey("图书验收")||frames.get("图书验收").isClosed()) {
				newBookCheckIFrame iframe=new newBookCheckIFrame();
				frames.put("图书验收", iframe);
				Library.addIFame(frames.get("图书验收"));
			}
		}
	}

	private static class BoodOrderAction extends AbstractAction {
		BoodOrderAction() {
			super("新书定购", null);
			putValue(Action.LONG_DESCRIPTION, "定购新的图书");
			putValue(Action.SHORT_DESCRIPTION, "新书定购");
		}
		public void actionPerformed(ActionEvent e) {
			
			if (!frames.containsKey("新书订购管理")||frames.get("新书订购管理").isClosed()) {
				newBookOrderIFrame iframe=new newBookOrderIFrame();
				frames.put("新书订购管理", iframe);
				Library.addIFame(frames.get("新书订购管理"));
			}
		}
	}

	private static class BookTypeModiAction extends AbstractAction {
		BookTypeModiAction() {
			super("图书类别修改", null);
			putValue(Action.LONG_DESCRIPTION, "修改图书的类别信息");
			putValue(Action.SHORT_DESCRIPTION, "图书类别修改");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("图书类别修改")||frames.get("图书类别修改").isClosed()) {
				BookTypeModiAndDelIFrame iframe=new BookTypeModiAndDelIFrame();
				frames.put("图书类别修改", iframe);
				Library.addIFame(frames.get("图书类别修改"));
			}
		}
	}

	private static class BookTypeAddAction extends AbstractAction {
		BookTypeAddAction() {
			super("图书类别添加", null);
			putValue(Action.LONG_DESCRIPTION, "为图书馆添加新的图书类别");
			putValue(Action.SHORT_DESCRIPTION, "图书类别添加");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("图书类别添加")||frames.get("图书类别添加").isClosed()) {
				BookTypeAddIFrame iframe=new BookTypeAddIFrame();
				frames.put("图书类别添加", iframe);
				Library.addIFame(frames.get("图书类别添加"));
			}
		}
	}
	private static class ReaderModiAction extends AbstractAction {
		ReaderModiAction() {
			super("读者修改与删除", null);
			putValue(Action.LONG_DESCRIPTION, "修改和删除读者的基本信息");
			putValue(Action.SHORT_DESCRIPTION, "读者修改与删除");
		}
		public void actionPerformed(ActionEvent e) {
			
			if (!frames.containsKey("读者信息修改与删除")||frames.get("读者信息修改与删除").isClosed()) {
				ReaderModiAndDelIFrame iframe=new ReaderModiAndDelIFrame();
				frames.put("读者信息修改与删除", iframe);
				Library.addIFame(frames.get("读者信息修改与删除"));
			}
		}
	}

	private static class ReaderAddAction extends AbstractAction {
		ReaderAddAction() {
			super("读者信息添加", null);
			putValue(Action.LONG_DESCRIPTION, "为图书馆添加新的读者会员信息");
			putValue(Action.SHORT_DESCRIPTION, "读者信息添加");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("读者相关信息添加")||frames.get("读者相关信息添加").isClosed()) {
				ReaderAddIFrame iframe=new ReaderAddIFrame();
				frames.put("读者相关信息添加", iframe);
				Library.addIFame(frames.get("读者相关信息添加"));
			}
		}
	}
	//图书修改与删除
	private static class BookModiAction extends AbstractAction {
		BookModiAction() {
			super("图书修改", null);
			putValue(Action.LONG_DESCRIPTION, "修改和删除图书信息");
			putValue(Action.SHORT_DESCRIPTION, "图书修改");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("图书修改")||frames.get("图书修改").isClosed()) {
				BookModiAndDelIFrame iframe=new BookModiAndDelIFrame();
				frames.put("图书修改", iframe);
				Library.addIFame(frames.get("图书修改"));
			}
		}
	}
	private static class BookAddAction extends AbstractAction {				// 图书信息添加－－－已经实现，请参照
		BookAddAction() {

			super("图书信息添加", null);
			//super();
			putValue(Action.LONG_DESCRIPTION, "为图书馆添加新的图书信息");
			putValue(Action.SHORT_DESCRIPTION, "图书信息添加");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("图书信息添加")||frames.get("图书信息添加").isClosed()) {
				BookAddIFrame iframe = new BookAddIFrame();
				frames.put("图书信息添加", iframe);
				Library.addIFame(frames.get("图书信息添加"));
			}
		}
	}
	private static class ExitAction extends AbstractAction { // 退出系统动作
		public ExitAction() {
			super("退出系统", null);
			putValue(Action.LONG_DESCRIPTION, "退出图书馆管理系统");
			putValue(Action.SHORT_DESCRIPTION, "退出系统");
		}
		public void actionPerformed(final ActionEvent e) {
			System.exit(0);
		}
	}

	private MenuActions() {
		super();
	}

}
