package kr.ac.hansung.cse.hw2.controller;

import kr.ac.hansung.cse.hw2.entity.Product;
import kr.ac.hansung.cse.hw2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping({"", "/"})
    public String viewHomePage(Model model) {
        List<Product> listProducts = productService.listAll();
        model.addAttribute("listProducts", listProducts);
        return "index";
    }

    @GetMapping("/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductPage(@PathVariable(name = "id") Long id, Model model) {
        Product product = productService.get(id);
        model.addAttribute("product", product);
        return "edit_product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product,
                              Model model) {
        boolean hasError = false;

        if (product.getPrice() < 0) {
            model.addAttribute("priceError", "가격은 0 이상이어야 합니다.");
            hasError = true;
        }

        if (product.getName() == null || product.getName().trim().isEmpty()) {
            model.addAttribute("nameError", "상품 이름이 입력되지 않았습니다.");
            hasError = true;
        }

        if (product.getBrand() == null || product.getBrand().trim().isEmpty()) {
            model.addAttribute("brandError", "브랜드 이름이 입력되지 않았습니다.");
            hasError = true;
        }

        if (product.getMadeIn() == null || product.getMadeIn().trim().isEmpty()) {
            model.addAttribute("madeinError", "원산지 이름이 입력되지 않았습니다.");
            hasError = true;
        }

        if (hasError) {
            model.addAttribute("product", product);
            return "edit_product";
        }

        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        productService.delete(id);
        return "redirect:/products";
    }
}
