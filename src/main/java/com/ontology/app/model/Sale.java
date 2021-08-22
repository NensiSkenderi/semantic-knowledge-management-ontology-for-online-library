package com.ontology.app.model;


/**
 *
 * @author edris
 */
public class Sale {
    
    private Integer productQuantity;
    private Book book;

    public Sale(Integer productQuantity, Book book) {
        this.productQuantity = productQuantity;
        this.book = book;
    }
    
    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Book getProduct() {
        return book;
    }

    public void setProduct(Book book) {
        this.book = book;
    }
    
    
    
    
}
