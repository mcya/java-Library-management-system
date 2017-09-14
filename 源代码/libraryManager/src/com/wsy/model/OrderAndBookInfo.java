package com.wsy.model;

import java.util.Date;
public class OrderAndBookInfo {
	private String ISBN;
	private Date orderdate;
	private String number;
	private String operator;
	private String checkAndAccept;
	private Double zk;
	private String typeId;
	private String bookname;
	private String writer;
	private String traslator;
	private String publisher;
	private Date date;
	private Double price;
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getCheckAndAccept() {
		return checkAndAccept;
	}
	public void setCheckAndAccept(String checkAndAccept) {
		this.checkAndAccept = checkAndAccept;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String isbn) {
		ISBN = isbn;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getTraslator() {
		return traslator;
	}
	public void setTraslator(String traslator) {
		this.traslator = traslator;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Double getZk() {
		return zk;
	}
	public void setZk(Double zk) {
		this.zk = zk;
	}
	
}
