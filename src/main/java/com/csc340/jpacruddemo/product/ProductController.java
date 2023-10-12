package com.csc340.jpacruddemo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author csc340-f23
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("productList",
                productService.getAllProducts());
        return "product/list-products";
    }

    @GetMapping("/search")
    public String getProducts(Model model, @Param("keyword") String keyword) {
        model.addAttribute("productList",
                productService.getAllProducts(keyword));
        model.addAttribute("keyword", keyword);
        return "product/list-products";
    }

    @GetMapping("/id={productId}")
    public String getProduct(@PathVariable long productId, Model model) {
        model.addAttribute("product",
                productService.getProduct(productId));
        return "product/product-detail";
    }

    @GetMapping("/delete/id={productId}")
    public String deleteProduct(@PathVariable long productId, Model model) {
        productService.deleteProduct(productId);
        return "redirect:/product/all";
    }

    @PostMapping("/create")
    public String createProduct(Product product) {

        productService.saveProduct(product);
        return "redirect:/product/all";
    }

    @PostMapping("/update")
    public String upateProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/product/all";
    }

    @GetMapping("/new-product")
    public String newProductForm(Model model) {
        return "product/new-product";
    }

    @GetMapping("/update/id={productId}")
    public String updateProductForm(@PathVariable long productId, Model model) {
        model.addAttribute("product",
                productService.getProduct(productId));
        return "product/update-product";
    }
}
