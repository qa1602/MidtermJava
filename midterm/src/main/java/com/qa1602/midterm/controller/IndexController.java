package com.qa1602.midterm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qa1602.midterm.model.Cart;
import com.qa1602.midterm.model.Product;
import com.qa1602.midterm.model.Receipt;
import com.qa1602.midterm.services.CartService;
import com.qa1602.midterm.services.ProductService;
import com.qa1602.midterm.services.ReceiptService;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;
   
    @Autowired
    private ReceiptService receiptService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/product")
    public String product(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product";
    }

    @GetMapping("/product/{id}")
    public String getProductById(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        // model.addAttribute("cart", new Cart());

        return "detail";
    }

    @GetMapping("/cart")
    public String getCart(Model model, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        // Cart cart = cartService.getCartInfo();
        System.out.println("-------------------------------------mlem" + cart.toString());
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Long productId, @RequestParam Integer amountP, HttpSession session) {
        // lấy thông tin sản phẩm từ cơ sở dữ liệu
        Product product = productService.getProductById(productId);

        // lấy giỏ hàng hiện tại từ session hoặc tạo mới nếu chưa có
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        // thêm sản phẩm vào giỏ hàng
        List<Product> listProduct = cart.getListProduct();
        if (listProduct == null) {
            listProduct = new ArrayList<>();
        }
        listProduct.add(product);
        cart.setListProduct(listProduct);

        List<Integer> amountP2 = cart.getAmountP();
        if (amountP2 == null) {
            amountP2 = new ArrayList<>();
        }
        amountP2.add(amountP);
        cart.setAmountP(amountP2);
        double sum = 0;
        for (int i = 0; i < amountP2.size(); i++) {
            sum += listProduct.get(i).getPrice() * amountP2.get(i);
        }
        cart.setTotal(sum);
        // lưu
        cartService.addProduct(cart);
        session.setAttribute("cart", cart);
        // chuyển hướng đến trang giỏ hàng
        return "redirect:/cart";

    }

    @PostMapping("/cart/checkout")
    public String cartToCheckout(@RequestParam Long cartId,
            @RequestParam String username,
            @RequestParam String phone,
            @RequestParam String address,
            @RequestParam String description,
            HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");

        Receipt receipt = new Receipt();
        receipt.setListProduct(cart.getListProduct());
        receipt.setTotal(cart.getTotal());
        receipt.setAmountP(cart.getAmountP());
        receipt.setUsername(username);
        receipt.setPhone(phone);
        receipt.setAddress(address);
        receipt.setDescription(description);
        System.out.println("-------------------------"+receipt.toString());
        receiptService.addReceipt(receipt);
        session.setAttribute("cart", new Cart());
        return "redirect:/product";
    }

}
