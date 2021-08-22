package com.ontology.app.model;



public class Book {
	
	private String titulli;
	private String pershkrimi;
	private String image_path;
	private String author_name;
	private String published_year;
	private String isbn;
	private String book_id, price, quantity,category;
	
	public Book() {
		
	}
	
	
	
//	public Book(String titulli, String pershkrimi, String image_path,Date published_year, String isbn) {
//		this.titulli = titulli;
//		this.pershkrimi = pershkrimi;
//		this.image_path = image_path;
//		this.published_year = published_year;
//		this.isbn = isbn;
//	}

	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getTitulli() {
		return titulli;
	}

	public void setTitulli(String titulli) {
		this.titulli = titulli;
	}

	public String getPershkrimi() {
		return pershkrimi;
	}

	public void setPershkrimi(String pershkrimi) {
		this.pershkrimi = pershkrimi;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}


	
	public String getPublished_year() {
		return published_year;
	}

	public void setPublished_year(String published_year) {
		this.published_year = published_year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	
	
}