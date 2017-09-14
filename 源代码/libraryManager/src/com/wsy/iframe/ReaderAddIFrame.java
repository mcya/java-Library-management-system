package com.wsy.iframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.wsy.dao.Dao;
import com.wsy.util.CreatecdIcon;
import com.wsy.util.MyDocument;

public class ReaderAddIFrame extends JInternalFrame {

	private JTextField ISBN;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JFormattedTextField keepmoney;
	private JTextField tel;
	private JFormattedTextField date;
	private JFormattedTextField maxnumber;
	private JFormattedTextField bztime;
	private JTextField zjnumber;
	private JComboBox comboBox;
	private JTextField zy;
	private JTextField age;
	private JTextField readername;
	DefaultComboBoxModel comboBoxModel;
	String [] array;
	
	

	/**
	 * Create the frame
	 */
	public ReaderAddIFrame() {
		super();
		setTitle("���������Ϣ���");
		setIconifiable(true);							// ���ô������С������������
		setClosable(true);								// ���ô���ɹرգ���������
														// ���ô�����⣭��������
		setBounds(100, 100, 500, 350);

		final JLabel logoLabel = new JLabel();
		ImageIcon readerAddIcon=CreatecdIcon.add("readerAdd.jpg");
		logoLabel.setIcon(readerAddIcon);
		logoLabel.setOpaque(true);
		logoLabel.setBackground(Color.CYAN);
		logoLabel.setPreferredSize(new Dimension(400, 60));
		getContentPane().add(logoLabel, BorderLayout.NORTH);

		final JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		getContentPane().add(panel);

		final JPanel panel_1 = new JPanel();
		final GridLayout gridLayout = new GridLayout(0, 4);
		gridLayout.setVgap(15);
		gridLayout.setHgap(10);
		panel_1.setLayout(gridLayout);
		panel_1.setPreferredSize(new Dimension(450, 200));
		panel.add(panel_1);

		final JLabel label_2 = new JLabel();
		label_2.setText("��    ����");
		panel_1.add(label_2);

		readername = new JTextField();
		readername.setDocument(new MyDocument(10));
		panel_1.add(readername);

		final JLabel label_3 = new JLabel();
		label_3.setText("��    ��");
		panel_1.add(label_3);

		final JPanel label_13 = new JPanel();
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setHgap(0);
		flowLayout.setVgap(0);
		label_13.setLayout(flowLayout);
		panel_1.add(label_13);

		final JRadioButton radioButton1 = new JRadioButton();
		label_13.add(radioButton1);
		radioButton1.setSelected(true);
		buttonGroup.add(radioButton1);
		radioButton1.setText("��");

		final JRadioButton radioButton2 = new JRadioButton();
		label_13.add(radioButton2);
		buttonGroup.add(radioButton2);
		radioButton2.setText("Ů");
		


		final JLabel label_4 = new JLabel();
		label_4.setText("��    �䣺");
		panel_1.add(label_4);

		age = new JTextField();
		age.setDocument(new MyDocument(2));//��������ı����������ֵΪ2
		age.addKeyListener(new NumberListener());
		panel_1.add(age);

		final JLabel label_5 = new JLabel();
		label_5.setText("ְ    ҵ��");
		panel_1.add(label_5);

		zy = new JTextField();
		zy.setDocument(new MyDocument(30));
		panel_1.add(zy);

		final JLabel label_6 = new JLabel();
		label_6.setText("��Ч֤����");
		panel_1.add(label_6);

		comboBox = new JComboBox();
		//comboBoxModel=(DefaultComboBoxModel)comboBox.getModel();
		array=new String[]{"���֤","����֤","ѧ��֤","����֤"};
		comboBox.setModel(new DefaultComboBoxModel(array));
		for(int i=1;i<array.length;i++){
			comboBox.setSelectedIndex(i);
			comboBox.setSelectedItem(array);
		}
		

		
		
		
		
		panel_1.add(comboBox);

		final JLabel label_7 = new JLabel();
		label_7.setText("֤�����룺");
		panel_1.add(label_7);

		zjnumber = new JTextField();
		zjnumber.setDocument(new MyDocument(13));
		zjnumber.addKeyListener(new NumberListener());
		panel_1.add(zjnumber);



		final JLabel label_9 = new JLabel();
		label_9.setText("����������");
		panel_1.add(label_9);
		
		maxnumber = new JFormattedTextField();
		maxnumber.setDocument(new MyDocument(2));
		maxnumber.addKeyListener(new NumberListener());
		panel_1.add(maxnumber);

		final JLabel label_10 = new JLabel();
		label_10.setText("��Ա֤��Ч���ڣ�");
		panel_1.add(label_10);

		SimpleDateFormat myfmt=new SimpleDateFormat("yyyy-MM-dd");

		date = new JFormattedTextField(myfmt.getDateInstance());
		java.util.Date date2 = new java.util.Date();
		date2.setDate(date2.getDate() + 365);
		date.setValue(date2);
		date.addKeyListener(new DateListener());
		panel_1.add(date);

		final JLabel label_11 = new JLabel();
		label_11.setText("��    ����");
		panel_1.add(label_11);
		

		tel = new JTextField();
		tel.addKeyListener(new TelListener());
		tel.setDocument(new MyDocument(11));

		panel_1.add(tel);

		final JLabel label_12 = new JLabel();
		label_12.setText("Ѻ    ��");
		panel_1.add(label_12);
		
		keepmoney = new JFormattedTextField();
		keepmoney.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String numStr="0123456789"+(char)8;//ֻ���������������˸��
				if(numStr.indexOf(e.getKeyChar())<0){
					e.consume();
				}
				if(keepmoney.getText().length()>2||keepmoney.getText().length()<0){
					e.consume();
				}
			}
		});
		panel_1.add(keepmoney);

		final JLabel label = new JLabel();
		label.setText("��֤���ڣ�");
		panel_1.add(label);

		
		bztime = new JFormattedTextField(myfmt.getDateInstance());
		bztime.setValue(new java.util.Date());
		bztime.addKeyListener(new DateListener());
		panel_1.add(bztime);

		final JLabel label_1 = new JLabel();
		label_1.setText("���߱�ţ�");
		panel_1.add(label_1);

		ISBN = new JTextField();
		ISBN.setDocument(new MyDocument(13));
		panel_1.add(ISBN);

		final JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(450, 100));
		panel.add(panel_2);

		final JButton save = new JButton();
		panel_2.add(save);
		save.setText("����");
		save.addActionListener(new ButtonAddListener(radioButton1));
		

		final JButton back = new JButton();
		panel_2.add(back);
		back.setText("����");
		back.addActionListener(new CloseActionListener());
		setVisible(true);
		//
	}
	class DateListener extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			if(bztime.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "ʱ���ʽ��ʹ��\"2007-05-10\"��ʽ");
			}
		}
	}
	class NumberListener extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			String numStr="0123456789"+(char)8;
			if(numStr.indexOf(e.getKeyChar())<0){
				e.consume();
			}
		}
	}
	class ButtonAddListener implements ActionListener {
		private final JRadioButton button1;

		ButtonAddListener(JRadioButton button1) {
			this.button1 = button1;
		}

		public void actionPerformed(final ActionEvent e) {
			
			if(readername.getText().length()==0){
				JOptionPane.showMessageDialog(null, "���������ı��򲻿�Ϊ��");
				return;
			}
			if(age.getText().length()==0){
				JOptionPane.showMessageDialog(null, "���������ı��򲻿�Ϊ��");
				return;
			}
			
			if(zjnumber.getText().length()==0){
				JOptionPane.showMessageDialog(null, "֤�������ı��򲻿�Ϊ��");
				return;
			}
			if(zjnumber.getText().length()!=13){
				JOptionPane.showMessageDialog(null, "֤������λ��Ϊ13");
				return;
			}
			if(keepmoney.getText().length()==0){
				JOptionPane.showMessageDialog(null, "Ѻ���ı��򲻿�Ϊ��");
				return;
			}
			if(zy.getText().length()==0){
				JOptionPane.showMessageDialog(null, "ְҵ�ı��򲻿�Ϊ��");
				return;
			}
			if(zy.getText().length()>20){
				JOptionPane.showMessageDialog(null, "ְҵ�ı���λ��Ϊ20");
				return;
			}
			if(ISBN.getText().length()==0){
				JOptionPane.showMessageDialog(null, "�����������ı��򲻿�Ϊ��");
				return;
			}
			if(ISBN.getText().length()!=13){
				JOptionPane.showMessageDialog(null, "�����������ı���Ϊ13λ");
				return;
			}
			if(tel.getText().length()==0){
				JOptionPane.showMessageDialog(null, "�绰�����ı��򲻿�Ϊ��");
				return;
			}
			if(tel.getText().length()>11||tel.getText().length()<0){
				JOptionPane.showMessageDialog(null, "�绰����λ��С��11λ");
				return;
			}
			if(maxnumber.getText().length()==0){
				JOptionPane.showMessageDialog(null, "���������ı��򲻿�Ϊ��");
				return;
			}
			if(maxnumber.getText().length()>2||tel.getText().length()<0){
				JOptionPane.showMessageDialog(null, "��������Ϊ��λ����");
				return;
			}
			if(bztime.getText().isEmpty()||date.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "ʱ���ʽ��ʹ��\"2007-05-10\"��ʽ");
				return;
			}
		
			String sex="1";
			if(!button1.isSelected()){
				sex="2";}
			String zj=String.valueOf(comboBox.getSelectedIndex());
			System.out.println(comboBox.getSelectedIndex());
			
			
			int i=Dao.InsertReader(readername.getText().trim(), sex.trim(), age.getText().trim(),zjnumber.getText().trim(), Date.valueOf(date.getText().trim()), maxnumber.getText().trim(),tel.getText().trim(), Double.valueOf(keepmoney.getText().trim()),zj,zy.getText().trim(),Date.valueOf(bztime.getText().trim()),ISBN.getText().trim());
			System.out.println(i);
			if(i==1){
				JOptionPane.showMessageDialog(null, "��ӳɹ���");
				doDefaultCloseAction();
			}
			
		}
	}
	class TelListener extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			String numStr="0123456789-"+(char)8;
			if(numStr.indexOf(e.getKeyChar())<0){
				e.consume();
			}
		}
	}
	class CloseActionListener implements ActionListener {			// ��ӹرհ�ť���¼�������
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}

}
