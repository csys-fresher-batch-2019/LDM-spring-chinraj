package com.chainsys.ldm.bookList;

import java.time.LocalDate;

public class BookList {

	private long isbn;
	private String category;
	private int pages;
	private int price;
	private int rackNo;
	private String bookStatus;
	private String authorName;
	private String publication;
	private String bookName;
	private LocalDate releasedDate;

	public long getISBN() {
		return isbn;
	}

	public void setISBN(long iSBN) {
		isbn = iSBN;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRackNo() {
		return rackNo;
	}

	public void setRackNo(int rackNo) {
		this.rackNo = rackNo;
	}

	public String getBookStatus() {
		return bookStatus;

	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public LocalDate getReleasedDate() {
		return releasedDate;
	}

	public void setReleasedDate(LocalDate releasedDate) {
		this.releasedDate = releasedDate;
	}
}
