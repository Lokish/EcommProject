package com.ecomm.controller;


import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;


@Controller
public class ProductController 
{
 @Autowired
 CategoryDAO categoryDAO;
 
 @Autowired
 ProductDAO productDAO;


 @RequestMapping("/product")
 public String showProduct(Model m)
 {
	Product product = new Product();
	m.addAttribute(product);
	List<Product> listProducts=productDAO.listProducts();
	m.addAttribute("productList",listProducts);
	m.addAttribute("categoryList", this.GetCategories());
	  return "product";
 }
@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
public String insertProduct(@ModelAttribute("product")Product product,Model m)
{
	productDAO.addProduct(product);
	Product product1=new Product();
	m.addAttribute(product1);
	m.addAttribute("categoryList", this.GetCategories());
	List<Product> listProducts=productDAO.listProducts();
	m.addAttribute("productList",listProducts);
	
	
	
	  return "product";
	  

}
@RequestMapping(value="/deleteProduct/{productId}")
public String deleteProduct(@PathVariable("productId")int productId,Model m)
{
	Product product=productDAO.getProduct(productId);
	productDAO.deleteProduct(product);
	List<Product> listProducts=productDAO.listProducts();
	m.addAttribute("productList",listProducts);
	return "product";
}

@RequestMapping(value="/editProduct/{productId}")
public String editCategory(@PathVariable("productId")int productId,Model m)
{
	Product product1=productDAO.getProduct(productId);
	m.addAttribute(product1);
	return "updateproduct";
}
@RequestMapping(value="/UpdateProduct",method=RequestMethod.POST)
 public String updateCategory(Model m,@RequestParam("proId")int productId,@RequestParam("proName")String productName,@RequestParam("proDesc")String productDesc)
 {
	Product product=productDAO.getProduct(productId);
	product.setProductName(productName);
	product.setProductDesc(productDesc);
	 productDAO.updateProduct(product);
	 List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productList",listProducts);
	 return "product";
 }

public LinkedHashMap<Integer,String> GetCategories()
{
	List<Category> listCategories=categoryDAO.listCategories();
     LinkedHashMap<Integer,String> categoryList=new LinkedHashMap<Integer,String>();
     for(Category category:listCategories)
     {
    	 categoryList.put(category.getCategoryId(),category.getCategoryName());
     }
     return categoryList;
}

 
} 
 



