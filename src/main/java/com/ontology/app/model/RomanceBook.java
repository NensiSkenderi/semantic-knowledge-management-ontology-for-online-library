package com.ontology.app.model;

public class RomanceBook extends Book{

	private String category;
	
	public RomanceBook() {
		
	}
	
	public void copyBook(Book b) {
		this.setTitulli(b.getTitulli());
		this.setPershkrimi(b.getPershkrimi());
		this.setImage_path(b.getImage_path());
		this.setAuthor_name(b.getAuthor_name());
		this.setPublished_year(b.getPublished_year());
		this.setIsbn(b.getIsbn());
		this.setPrice(b.getPrice());
		this.setBook_id(b.getBook_id());
		this.setQuantity(b.getQuantity());
	}
	
	public String getCategory() {
	        return category;
	}

	public void setCategory(String category) {
	        this.category = category;
	}
}
