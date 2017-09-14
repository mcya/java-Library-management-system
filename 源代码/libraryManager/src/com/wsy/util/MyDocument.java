package com.wsy.util;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class MyDocument extends PlainDocument{ 
	   int maxLength =10; 
	   public MyDocument(int newMaxLength){ 
	      super(); 
	      maxLength = newMaxLength; 
	   } 
	   public MyDocument(){ 
	      this(10); 
	   } 

	   //重载父类的insertString函数 
	    public void insertString(int offset, String str, AttributeSet a)
			throws BadLocationException {
		if (getLength() + str.length() > maxLength) {//这里假定你的限制长度为10 
			return;
		} else {
			super.insertString(offset, str, a);

		}
	} 

	} 
