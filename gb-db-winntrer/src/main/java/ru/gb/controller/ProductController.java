package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.entity.Product;
import ru.gb.services.ProductService;


@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public String showProductList(Model morel, @RequestParam(name = "order",
                                                            required = false,
                                                            defaultValue = "") String sort){
        switch (sort) {
            case "asc":
                morel.addAttribute("products",
                        productService.getActiveProducts(Sort.by(Sort.Direction.ASC, "cost")));
                break;
            case "desc":
                morel.addAttribute("products",
                        productService.getActiveProducts(Sort.by(Sort.Direction.DESC, "cost")));
                break;
            default:
                morel.addAttribute("products", productService.getActiveProducts());
        }
        return "productList";
    }

    @GetMapping("/create")
    public String showSimpleForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "create-product";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String editProduct(Model model, @RequestParam Long id) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "create-product";
    }
    @PostMapping("/create")
    public String processForm(Product product){
        productService.save(product);
        return "redirect:/products/all";
    }

   @RequestMapping(path = "/product/{id}", method = RequestMethod.GET)
    public String showSingleProduct(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.getProductById(id));
        return "product";
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam Long id) {
        productService.disableById(id);
        return "redirect:/products/all";
    }
}
