
  package com.ecommerce.entity;
  
  import javax.persistence.Column; import javax.persistence.Entity; import
  javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
  import javax.persistence.Id; import javax.persistence.Table;

import com.sun.istack.NotNull;

  
  @Entity
  @Table(name = "customer") 
  public class Customer 
  {
  
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id") 	  
	    private int id;
	  
	    @NotNull
	    @Column(name = "first_name") 
	    private String firstName;
	    
	    @NotNull
	    @Column(name = "last_name") 
	    private String lastName;

		public int getId() {
			return id;
		}
	
		public void setId(int id) {
			this.id = id;
		}
	
		public String getFirstName() {
			return firstName;
		}
	
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
	
		public String getLastName() {
			return lastName;
		}
	
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		@Override
		public String toString() {
			return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
		}
		
		
  }
 