package com.ontology.app.model;

 
import java.util.ArrayList;
import java.util.List;


public class Cart {

    private double total;
    private int numberOfItems;
    private List<Cart_Items> items;

    public Cart() {
        items = new ArrayList<Cart_Items>();
        numberOfItems = 0;
        total = 0.0;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public List<Cart_Items> getItems() {
        return items;
    }

    public void setItems(List<Cart_Items> items) {
        this.items = items;
    }

    public synchronized void addItem(Cart_Items b) {
        boolean flag = false;
        if (!items.isEmpty()) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getBook().getBook_id().equals(b.getBook().getBook_id())) {
                    if (b.getQuantity() != 0) {
                    	System.out.println("hyre ktu");
                        total += Double.parseDouble(b.getBook().getPrice()) * b.getQuantity();
                        int tempCurrentQuantity = items.get(i).getQuantity();
                        int totalQuantity = tempCurrentQuantity + b.getQuantity();
                        items.get(i).setTotal(totalQuantity * Double.parseDouble(b.getBook().getPrice()));
                        items.get(i).setQuantity(totalQuantity);
                        numberOfItems += b.getQuantity();
                    } else {
                        this.removeItem(b.getBook().getBook_id());
                    }
                    flag = true;
                }
            }

            if (flag == false) {
                b.setTotal(b.getQuantity() * Double.parseDouble(b.getBook().getPrice()));
                items.add(b);
                total += Double.parseDouble(b.getBook().getPrice()) * b.getQuantity();
                numberOfItems += b.getQuantity();

            }

        } else {
        	
            b.setTotal(b.getQuantity() * Double.parseDouble(b.getBook().getPrice()));
            items.add(b);
            total += Double.parseDouble(b.getBook().getPrice()) * b.getQuantity();
            numberOfItems += b.getQuantity();

        }

    }

    
    public synchronized void update_cart(Cart_Items b) {
        boolean flag = false;
        if (!items.isEmpty()) {
            for (int i = 0; i < items.size(); i++) {
            	if (items.get(i).getBook().getBook_id().equals(b.getBook().getBook_id())) {
                   
                	if (b.getQuantity() != 0) {
                        if (b.getQuantity() > items.get(i).getQuantity()) {
                            //add the differnce of update total to all cost
                            total += Double.parseDouble(b.getBook().getPrice()) * b.getQuantity()
                                    - items.get(i).getTotal();
                            int totalQuantity = b.getQuantity();
                            numberOfItems += totalQuantity - items.get(i).getQuantity();

                            items.get(i).setTotal(totalQuantity * Double.parseDouble(b.getBook().getPrice()) );
                            items.get(i).setQuantity(totalQuantity);

                        } else {
                            total -= items.get(i).getTotal();
                            total += Double.parseDouble(b.getBook().getPrice()) * b.getQuantity();

                            int totalQuantity = b.getQuantity();
                            numberOfItems -= items.get(i).getQuantity();
                            numberOfItems += totalQuantity;

                            items.get(i).setTotal(Double.parseDouble(b.getBook().getPrice()) * b.getQuantity());
                            items.get(i).setQuantity(totalQuantity);

                        }

                    } else {
                        this.removeItem(b.getBook().getBook_id());
                    }
                    flag = true;
                }
            }

            if (flag == false) {
                b.setTotal(Double.parseDouble(b.getBook().getPrice()) * b.getQuantity());
                items.add(b);
                total += Double.parseDouble(b.getBook().getPrice()) * b.getQuantity();
                numberOfItems += 1;

            }

        } else {
            b.setTotal(Double.parseDouble(b.getBook().getPrice()) * b.getQuantity());
            items.add(b);
            total += Double.parseDouble(b.getBook().getPrice()) * b.getQuantity();
            numberOfItems += 1;

        }

    }
    
    

    public void removeItem(String productNumber) {
        if (!items.isEmpty()) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getBook().getBook_id() == (productNumber)) {
                    numberOfItems -= items.get(i).getQuantity();
                    total -= items.get(i).getTotal();
                    items.remove(i);
                }
            }

        }
    }

    public void removeAllItems() {
        if (!items.isEmpty()) {
            for (int i = 0; i < items.size(); i++) {
                this.removeItem(items.get(i).getBook().getBook_id());
            }
        }
    }


    public List<Sale> getSalesList(){
        List<Sale> sales = new ArrayList<Sale>();
        if (!items.isEmpty()) {
           for (int i = 0; i < items.size(); i++) {
               Sale tempsale = new Sale(items.get(i).getQuantity(),items.get(i).getBook());
               sales.add(tempsale);
           }
        }       
        return sales;       
   }
   

}
