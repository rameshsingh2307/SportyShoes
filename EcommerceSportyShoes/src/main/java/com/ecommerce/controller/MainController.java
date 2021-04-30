package com.ecommerce.controller;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.entity.Customer;
import com.ecommerce.entity.OrderDetail;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;
import com.ecommerce.service.CustomerNotFoundException;
import com.ecommerce.service.CustomerService;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.PurchaseService;
import com.ecommerce.service.UserPasswordUpdateService;

@Controller
public class MainController {
	
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	PurchaseService purchaseService;
	
	
	@Autowired
	UserPasswordUpdateService userPasswordUpdateService;
	
	
	@InitBinder
	public void InitBinder(WebDataBinder binder)
	{
		StringTrimmerEditor trim = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, trim);		
	}
	
	@RequestMapping("/signUp")
	public String signUp(Model model)
	{		
		Customer customer = new Customer();
		model.addAttribute("customer", customer);		 
		return "headerfooter/signUp";
	}
	
	@RequestMapping("/Welcome")
	public String Welcome()
	{
		return "headerfooter/Welcome";
	}
	
	
	@RequestMapping("/Home")
	public String adminHome(@ModelAttribute("customer") Customer customer,HttpSession session)
	{
		String username =null;
		LocalDate date = null;
		
		username =null;
		if (customer.getFirstName()!=null)
		{
			username = customer.getFirstName();
			customerService.save(customer);
		}
		else
		{
			username= (String)session.getAttribute("username");
			System.out.println("Home = "+username);
		}
		
		System.out.println("Home = "+username);
		System.out.println(session.getAttribute("orderDetail"));
		
		//username= (String)session.getAttribute("username");
			
		OrderDetail orderDetails= (OrderDetail) session.getAttribute("orderDetail");
		
		if (orderDetails != null)
		{
			date=LocalDate.now();
			orderDetails.setPurchaseDate(date);
			orderDetails.setUserName(username);
			purchaseService.save(orderDetails);			
		}
		
		System.out.println("date="+date);
		System.out.println("orderDetails "+orderDetails);

		session.setAttribute("username", username);
		//return "redirect:/productList";
		return "headerfooter/Succesfull";
	}
	
	@RequestMapping("/login")
	public String loginForm(HttpSession session)
	{
		System.out.println("product :"+session.getAttribute("product"));
		return "headerfooter/login";
	}

	
	@RequestMapping("/buyProduct")
	public String buyProduct(@Param("productId") Long productId, HttpSession session)
	{
		
		Product product= productService.findByProductId(productId);
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setProductName(product.getProductName());
		orderDetail.setCategory(product.getProductCategory());
		
		session.setAttribute("orderDetail", orderDetail);
		
		System.out.println("inside by user = "+session.getAttribute("username"));
		if (session.getAttribute("username") != null)
		{
			
			return "redirect:/Home";
			
			//return "redirect:/Succesfull";
			
			
		}
		return "redirect:/signUp";
	}
	
	
	@RequestMapping("/productList")
	public String productList(Model model)
	{		
		Iterable<Product> productList = productService.findAll();
		System.out.println(productList);
		model.addAttribute("product", productList);
		
		return "headerfooter/productList";
	}
	
	@RequestMapping("/admin/searchByCategory")
	public String searchByCategory(Model model, @Param("categoryName") String categoryName)
	{
		Iterable<OrderDetail> orderList = purchaseService.searchByCategory(categoryName.toLowerCase());
		//System.out.println(productList);	
		model.addAttribute("orderdetail", orderList);
		return "headerfooter/purchase-report";
	}
	
	@RequestMapping("/admin/searchByDate")
	public String searchByDate(Model model, @Param("searchDate") String searchDate) throws ParseException
	{
		
		LocalDate localDate = LocalDate.parse(searchDate);
	        
		//System.out.println("ac"searchDate);
		//System.out.println("toString ="+searchDate.toString());
		
		System.out.println("searchDate "+localDate);
		Iterable<OrderDetail> orderList = purchaseService.searchByDate(localDate);
		//System.out.println(productList);	
		model.addAttribute("orderdetail", orderList);
		return "headerfooter/purchase-report";
	}
	
	
	
	@RequestMapping("/admin/list")
	public String getProductList(Model model)
	{
		Iterable<Product> productList = productService.findAll();
		System.out.println(productList);
		model.addAttribute("product", productList);
		
		return "headerfooter/product-list";
	}
	
	@RequestMapping("/admin/purchaseReport")
	public String getPurchaseReport(Model model)
	{
		Iterable<OrderDetail> orderDetailList = purchaseService.findAll();		
		model.addAttribute("orderdetail", orderDetailList);			
		return "headerfooter/purchase-report";
	}
	
	
	@RequestMapping("/admin/userList")
	public String getCustomerList(Model model)
	{
		Iterable<Customer> customerList = customerService.findAll();		
		model.addAttribute("customer", customerList);			
		return "headerfooter/customer-list";
	}
	
	
	////Need to work on it.
	@RequestMapping("/admin/searchCustomer")
	public String searchCustomer(Model model, @Param("customerName") String customerName)
	{
		Iterable<Customer> customerList = customerService.searchByName(customerName.toLowerCase());
		System.out.println(customerList);	
		model.addAttribute("customer", customerList);
		return "headerfooter/customer-list";
	}
	
	@RequestMapping("/admin/addproduct")
	public String addProduct(Model model)
	{
		Product product = new Product(); 		
		model.addAttribute("product",product);
		return "headerfooter/addproduct";
	}
	
	
	 //@RequestMapping("/SaveProduct")
	@RequestMapping("/admin/SaveProduct")
	 public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model)
	 { 
			
		if (result.hasErrors()) { return "redirect:/admin/addproduct"; }
			 
		 
		 productService.save(product);	
		// System.out.println("Product id add=" +product.getProductId());
		 model.addAttribute("product", product);
		 return "redirect:/admin/list";
	 }
	 
	 @RequestMapping("/admin/delete") 
	 public String deleteProduct(@RequestParam("productId") Long id, Model model)
	 { 
		 productService.deleteByProductId(id);
		 return "redirect:/admin/list";
	 }
	 
	 @RequestMapping("/admin/update")
	 public String updateProduct(@RequestParam("productId") Long id, Model model) {
		//ModelAndView mav = new ModelAndView("edit_product");
		
		Product product = productService.findByProductId(id);
		//System.out.println("Product id update=" +product.getProductId());
		model.addAttribute("product", product);		
		return "headerfooter/edit_product";
	}	
	
	@RequestMapping("/admin/UpdateProduct")
	public String updatet(@ModelAttribute("product") Product product, Model model) {
		
		productService.update(product.getProductId(),product.getProductName(),product.getProductCategory());
		return "redirect:/admin/list";
	}	
	
	@RequestMapping("/admin/passwordForm")
	public String passwordForm()
	{
		return "headerfooter/passwordForm";
	}
	
	@RequestMapping("/admin/updatePassword")
	 public String updatePassword(@RequestParam("userName") String userName,@RequestParam("userPassword") String userPassword, Model model) {
		//ModelAndView mav = new ModelAndView("edit_product");
		
		
		try {
			User user = userPasswordUpdateService.getUserByUsername(userName);
		} catch (CustomerNotFoundException e) {
			return "headerfooter/passwordError";
		}
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String newPassword = passwordEncoder.encode(userPassword);
		userPasswordUpdateService.updatePassword(userName,newPassword);
			
		return "headerfooter/passwordUpdated";
	}	
	 
}
