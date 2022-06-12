package com.example.deaii_sbp_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private ProductService service;
    @Autowired
    private UserRepository userRepo;

    // handler methods...

    @GetMapping("")
    public String viewHomePage() {
        return "home";
    }
//    @RequestMapping("/")
//    public String viewHomePage() {
//        return "home";
//    }
    @RequestMapping("/stafflogin")
    public String viewlogin() {
        return "stafflogin";
    }


    @RequestMapping("/Login_Service")
    public String StaffLoginService() {
        return "success";}

    @RequestMapping("/aboutview")
    public String viewAbout() {
        return "about";
    }

    @RequestMapping("/allproducts")
    public String viewAllproducts(Model model, @Param("keyword") String keyword) {
        List<Product> listProducts = service.listAll(keyword);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("keyword", keyword);

        return "products";
    }

    @RequestMapping("/viewproducts")
    public String viewProducts(Model model, @Param("keyword") String keyword) {
        List<Product> listProducts = service.listAll(keyword);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("keyword", keyword);

        return "index";
    }
    @RequestMapping("/vieworders")
    public String viewusers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        return "order";

    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);

        return "redirect:/viewproducts";
    }

//
//    @GetMapping("/edit/{id}")
//    public String showEditProductPage(Model model,@PathVariable(name = "id") int id) {
//
//
//        Product product = service.get(id);
//        model.addAttribute("product", product);
//        return "edit_product";
//    }


   @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = service.get(id);
        mav.addObject("product", product);

        return mav;
    }
    @RequestMapping("/buy/{id}")
    public String  BuyProductPage(Model model,@PathVariable(name = "id") int id) {

        User user = new User();
        user.setId(id);
        model.addAttribute("user", user);
       return "buy_product";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/viewproducts";
    }

    @PostMapping("/buy_success")
    public String processRegister(User user) {
        userRepo.save(user);

        return "buy_success";
    }
}

