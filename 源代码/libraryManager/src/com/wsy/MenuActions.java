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
 * �˵��Ͱ�ť��Action����
 * 
 */
public class MenuActions {
	private static Map<String, JInternalFrame> frames; // �Ӵ��弯��

	public static PasswordModiAction MODIFY_PASSWORD; // �޸����봰�嶯��
	public static UserModiAction USER_MODIFY; // �޸��û����ϴ��嶯��
	public static UserAddAction USER_ADD; // �û���Ӵ��嶯��
	public static BookSearchAction BOOK_SEARCH; // ͼ���������嶯��
	public static GiveBackAction GIVE_BACK; // ͼ��黹���嶯��
	public static BorrowAction BORROW; // ͼ����Ĵ��嶯��
	public static CheckAndAcceptNewBookAction NEWBOOK_CHECK_ACCEPT;// �޸����붯��
	public static BoodOrderAction NEWBOOK_ORDER; // ���鶨�����嶯��
	public static BookTypeModiAction BOOKTYPE_MODIFY; // ͼ�������޸Ĵ��嶯��
	public static BookTypeAddAction BOOKTYPE_ADD; // ͼ��������Ӵ��嶯��
	public static ReaderModiAction READER_MODIFY; // ������Ϣ�޸Ĵ��嶯��
	public static ReaderAddAction READER_ADD; // ������Ϣ��Ӵ��嶯��
	public static BookModiAction BOOK_MODIFY; // ͼ����Ϣ�޸Ĵ��嶯��
	public static BookAddAction BOOK_ADD; // ͼ����Ϣ��Ӵ��嶯��
	public static ExitAction EXIT; // ϵͳ�˳�����

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
			putValue(Action.NAME,"���Ŀ���");
			putValue(Action.LONG_DESCRIPTION, "�޸ĵ�ǰ�û�����");
			putValue(Action.SHORT_DESCRIPTION, "��������");//�ڡ����Ŀ����ʾ����ʾ������
			//putValue(Action.SMALL_ICON,CreatecdIcon.add("bookAddtb.jpg"));
			//��ͼ��洢������������
			//setEnabled(false);//ʹ��������
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("��������")||frames.get("��������").isClosed()) {
				GengGaiMiMa iframe=new GengGaiMiMa();
				frames.put("��������", iframe);
				Library.addIFame(frames.get("��������"));
			}
		}
	}

	private static class UserModiAction extends AbstractAction {
		UserModiAction() {
			super("�û��޸���ɾ��", null);
			putValue(Action.LONG_DESCRIPTION, "�޸ĺ�ɾ���û���Ϣ");
			putValue(Action.SHORT_DESCRIPTION, "�û��޸���ɾ��");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("�û���Ϣ�޸���ɾ��")||frames.get("�û���Ϣ�޸���ɾ��").isClosed()) {
				UserModiAndDelIFrame iframe=new UserModiAndDelIFrame();
				frames.put("�û���Ϣ�޸���ɾ��", iframe);
				Library.addIFame(frames.get("�û���Ϣ�޸���ɾ��"));
			}
		}
	}

	private static class UserAddAction extends AbstractAction {
		UserAddAction() {
			super("�û����", null);
			putValue(Action.LONG_DESCRIPTION, "����µ��û�");
			putValue(Action.SHORT_DESCRIPTION, "�û����");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("�û���Ϣ���")||frames.get("�û���Ϣ���").isClosed()) {
				UserAddIFrame iframe=new UserAddIFrame();
				frames.put("�û���Ϣ���", iframe);
				Library.addIFame(frames.get("�û���Ϣ���"));
			}
			
		}
	}

	private static class BookSearchAction extends AbstractAction {
		BookSearchAction() {
			super("ͼ������", null);
			putValue(Action.LONG_DESCRIPTION, "��������ͼ����Ϣ");
			putValue(Action.SHORT_DESCRIPTION, "ͼ������");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("ͼ���ѯ")||frames.get("ͼ���ѯ").isClosed()) {
				BookSearchIFrame iframe=new BookSearchIFrame();
				frames.put("ͼ���ѯ", iframe);
				Library.addIFame(frames.get("ͼ���ѯ"));
			}
		}
	}

	private static class GiveBackAction extends AbstractAction {
		GiveBackAction() {
			super("ͼ��黹", null);
			putValue(Action.LONG_DESCRIPTION, "�黹���ĵ�ͼ��");
			putValue(Action.SHORT_DESCRIPTION, "ͼ��黹");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("ͼ��黹����")||frames.get("ͼ��黹����").isClosed()) {
				BookBackIFrame iframe=new BookBackIFrame();
				frames.put("ͼ��黹����", iframe);
				Library.addIFame(frames.get("ͼ��黹����"));
			}
		}
	}

	private static class BorrowAction extends AbstractAction {
		BorrowAction() {
			super("ͼ�����", null);
			putValue(Action.LONG_DESCRIPTION, "��ͼ��ݽ���ͼ��");
			putValue(Action.SHORT_DESCRIPTION, "ͼ�����");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("ͼ����Ĺ���")||frames.get("ͼ����Ĺ���").isClosed()) {
				BookBorrowIFrame iframe=new BookBorrowIFrame();
				frames.put("ͼ����Ĺ���", iframe);
				Library.addIFame(frames.get("ͼ����Ĺ���"));
			}
		}
	}

	private static class CheckAndAcceptNewBookAction extends AbstractAction {
		CheckAndAcceptNewBookAction() {
			super("��������", null);
			putValue(Action.LONG_DESCRIPTION, "���ն��ĵ���ͼ��");
			putValue(Action.SHORT_DESCRIPTION, "��������");
		}
		public void actionPerformed(ActionEvent e) {
			
			if (!frames.containsKey("ͼ������")||frames.get("ͼ������").isClosed()) {
				newBookCheckIFrame iframe=new newBookCheckIFrame();
				frames.put("ͼ������", iframe);
				Library.addIFame(frames.get("ͼ������"));
			}
		}
	}

	private static class BoodOrderAction extends AbstractAction {
		BoodOrderAction() {
			super("���鶨��", null);
			putValue(Action.LONG_DESCRIPTION, "�����µ�ͼ��");
			putValue(Action.SHORT_DESCRIPTION, "���鶨��");
		}
		public void actionPerformed(ActionEvent e) {
			
			if (!frames.containsKey("���鶩������")||frames.get("���鶩������").isClosed()) {
				newBookOrderIFrame iframe=new newBookOrderIFrame();
				frames.put("���鶩������", iframe);
				Library.addIFame(frames.get("���鶩������"));
			}
		}
	}

	private static class BookTypeModiAction extends AbstractAction {
		BookTypeModiAction() {
			super("ͼ������޸�", null);
			putValue(Action.LONG_DESCRIPTION, "�޸�ͼ��������Ϣ");
			putValue(Action.SHORT_DESCRIPTION, "ͼ������޸�");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("ͼ������޸�")||frames.get("ͼ������޸�").isClosed()) {
				BookTypeModiAndDelIFrame iframe=new BookTypeModiAndDelIFrame();
				frames.put("ͼ������޸�", iframe);
				Library.addIFame(frames.get("ͼ������޸�"));
			}
		}
	}

	private static class BookTypeAddAction extends AbstractAction {
		BookTypeAddAction() {
			super("ͼ��������", null);
			putValue(Action.LONG_DESCRIPTION, "Ϊͼ�������µ�ͼ�����");
			putValue(Action.SHORT_DESCRIPTION, "ͼ��������");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("ͼ��������")||frames.get("ͼ��������").isClosed()) {
				BookTypeAddIFrame iframe=new BookTypeAddIFrame();
				frames.put("ͼ��������", iframe);
				Library.addIFame(frames.get("ͼ��������"));
			}
		}
	}
	private static class ReaderModiAction extends AbstractAction {
		ReaderModiAction() {
			super("�����޸���ɾ��", null);
			putValue(Action.LONG_DESCRIPTION, "�޸ĺ�ɾ�����ߵĻ�����Ϣ");
			putValue(Action.SHORT_DESCRIPTION, "�����޸���ɾ��");
		}
		public void actionPerformed(ActionEvent e) {
			
			if (!frames.containsKey("������Ϣ�޸���ɾ��")||frames.get("������Ϣ�޸���ɾ��").isClosed()) {
				ReaderModiAndDelIFrame iframe=new ReaderModiAndDelIFrame();
				frames.put("������Ϣ�޸���ɾ��", iframe);
				Library.addIFame(frames.get("������Ϣ�޸���ɾ��"));
			}
		}
	}

	private static class ReaderAddAction extends AbstractAction {
		ReaderAddAction() {
			super("������Ϣ���", null);
			putValue(Action.LONG_DESCRIPTION, "Ϊͼ�������µĶ��߻�Ա��Ϣ");
			putValue(Action.SHORT_DESCRIPTION, "������Ϣ���");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("���������Ϣ���")||frames.get("���������Ϣ���").isClosed()) {
				ReaderAddIFrame iframe=new ReaderAddIFrame();
				frames.put("���������Ϣ���", iframe);
				Library.addIFame(frames.get("���������Ϣ���"));
			}
		}
	}
	//ͼ���޸���ɾ��
	private static class BookModiAction extends AbstractAction {
		BookModiAction() {
			super("ͼ���޸�", null);
			putValue(Action.LONG_DESCRIPTION, "�޸ĺ�ɾ��ͼ����Ϣ");
			putValue(Action.SHORT_DESCRIPTION, "ͼ���޸�");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("ͼ���޸�")||frames.get("ͼ���޸�").isClosed()) {
				BookModiAndDelIFrame iframe=new BookModiAndDelIFrame();
				frames.put("ͼ���޸�", iframe);
				Library.addIFame(frames.get("ͼ���޸�"));
			}
		}
	}
	private static class BookAddAction extends AbstractAction {				// ͼ����Ϣ��ӣ������Ѿ�ʵ�֣������
		BookAddAction() {

			super("ͼ����Ϣ���", null);
			//super();
			putValue(Action.LONG_DESCRIPTION, "Ϊͼ�������µ�ͼ����Ϣ");
			putValue(Action.SHORT_DESCRIPTION, "ͼ����Ϣ���");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("ͼ����Ϣ���")||frames.get("ͼ����Ϣ���").isClosed()) {
				BookAddIFrame iframe = new BookAddIFrame();
				frames.put("ͼ����Ϣ���", iframe);
				Library.addIFame(frames.get("ͼ����Ϣ���"));
			}
		}
	}
	private static class ExitAction extends AbstractAction { // �˳�ϵͳ����
		public ExitAction() {
			super("�˳�ϵͳ", null);
			putValue(Action.LONG_DESCRIPTION, "�˳�ͼ��ݹ���ϵͳ");
			putValue(Action.SHORT_DESCRIPTION, "�˳�ϵͳ");
		}
		public void actionPerformed(final ActionEvent e) {
			System.exit(0);
		}
	}

	private MenuActions() {
		super();
	}

}
