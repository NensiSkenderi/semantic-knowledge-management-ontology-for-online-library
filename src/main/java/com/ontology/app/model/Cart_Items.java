package com.ontology.app.model;


public class Cart_Items {

   
    private Book b;
    private int quantity;
    private double total;

    public Book getB() {
        return b;
    }

    public void setB(Book b) {
        this.b = b;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    

    public Cart_Items(Book b, int quantity) {
        this.total = 0.0;
        this.quantity = 0;
        this.b = b;
        this.setQuantity(quantity);
    }

    public Book getBook() {
        return b;
    }

    public void setBook(Book b) {
        this.b = b;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
           this.quantity = quantity;
          
    }
              
    public Cart_Items() {
    	
    }

    
    
   
    
}
