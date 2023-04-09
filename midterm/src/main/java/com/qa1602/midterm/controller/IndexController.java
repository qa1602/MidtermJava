package com.qa1602.midterm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String index(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
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
        model.addAttribute("cart", new Cart());
        return "detail";
    }

    @GetMapping("/cart")
    public String getCart(Model model, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
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

        List<Integer> amountP2 = cart.getAmountP();
        if (amountP2 == null) {
            amountP2 = new ArrayList<>();
        }
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId() == productId) {
                amountP2.set(i, amountP2.get(i) + amountP);
                cart.setListProduct(listProduct);
                cart.setAmountP(amountP2);
                cartService.addProduct(cart);

                double sum = 0;
                for (int j = 0; j < amountP2.size(); j++) {
                    sum += listProduct.get(j).getPrice() * amountP2.get(j);
                }
                cart.setTotal(sum);
                session.setAttribute("cart", cart);
                return "redirect:/cart";
            }
        }

        amountP2.add(amountP);
        cart.setAmountP(amountP2);

        listProduct.add(product);
        cart.setListProduct(listProduct);

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
        receipt = receiptService.addReceipt(receipt);
        Map<Long, Product> map = new HashMap<>();
        for (Product product : cart.getListProduct()) {
            map.put(receipt.getId(), product);
        }
        receipt.setListProduct(map);
        receipt.setTotal(cart.getTotal());
        receipt.setAmountP(cart.getAmountP());
        receipt.setUsername(username);
        receipt.setPhone(phone);
        receipt.setAddress(address);
        receipt.setDescription(description);
        receiptService.addReceipt(receipt);
        cartService.remove(cart);
        // hoàn tất thanh toán và xóa item trong cart, tạo cái cart trống mới
        session.setAttribute("cart", new Cart());
        // chuyển hướng đến trang sản phẩm
        return "redirect:/product";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
