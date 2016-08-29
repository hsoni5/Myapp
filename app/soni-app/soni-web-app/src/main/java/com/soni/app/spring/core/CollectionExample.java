package com.soni.app.spring.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionExample {
	public static void main(String[] args) {
		Order order1=new Order(105, 100, "ram");
		Order order2=new Order(101, 200, "soni");
		Order order3=new Order(103, 50, "amit");
		Order order4=new Order(102, 600, "ravi");
		/*
  putting object value in collection to sort
      */
	List<Order> orders=new ArrayList<Order>();
	orders.add(order1);
	orders.add(order2);
	orders.add(order3);
	orders.add(order4);
	System.out.println("Unsorted collections orders="+orders);
	Collections.sort(orders);
	System.out.println("Sorting collections object by natural:"+orders);
	/*
	 * Sorting collection object in reverse orders
	*/
	Collections.sort(orders,Collections.reverseOrder());
	System.out.println("Decending orders"+orders);
	
	/*
	 * Sorting Object amount based on Comparator

	*/	
	Collections.sort(orders,new Order.OrderByAmount());
	
	System.out.println("Sorting object amount based on comparator"+orders);
	
	/*
	 * Sorting object based on customer name
	*/	
	Collections.sort(orders,new Order.OrderByCustomer());
	
	System.out.println("Sorting collection object by customer name"+orders);
	
	}
}
class Order implements Comparable<Order>{
		private int orderId;
		
		private int amount;
		
		private String customer;
		
		 public Order(int orderId,int amount,String customer){
			 this.orderId=orderId;
			 this.amount=amount;
			 this.customer=customer;
			  
		  }
	
		public int getOrderId(){
			return orderId;
		}
		public void setOrderId(int orderId){
			this.orderId=orderId;
		}
		/*
	 Comparator implements to sort order object based on amount 	
        */
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public String getCustomer() {
			return customer;
		}
		public void setCustomer(String customer) {
			this.customer = customer;
		}
		@Override
		public int compareTo(Order o){
			return this.orderId>o.orderId?1:(this.orderId<o.orderId?-1:0);
		}
		
		 static class OrderByAmount implements Comparator<Order>{
				
				@Override
				public int compare(Order o1,Order o2){
					return o1.amount>o2.amount?1:(o1.amount<o2.amount?-1:0);
				}	
			    }
			    static class OrderByCustomer implements Comparator<Order>{
				   @Override
				   public int compare(Order o1,Order o2){
					   return o1.customer.compareTo(o2.customer); 
					   
				   }
				   
				  
				 	   
			   }
		 /*
		    * Implementing toString to print orderId of order;
		    * 
		   */
		   @Override
		   public String toString()
		   {
			   return String.valueOf(orderId)+" : "+String.valueOf(amount)+" : "+String.valueOf(customer);
			   
		   }  
	}
  
  
   
	
