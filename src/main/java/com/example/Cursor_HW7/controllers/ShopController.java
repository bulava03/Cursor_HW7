package com.example.Cursor_HW7.controllers;

import com.example.Cursor_HW7.models.Shop;
import com.example.Cursor_HW7.services.ShopService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/shops")
public class ShopController {
    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Shop createShop(@RequestBody Shop shop) {
        return shopService.createShop(shop);
    }

    @DeleteMapping("/{id}")
    public void deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
    }

    @GetMapping
    public List<Shop> getAllShops() {
        return shopService.getAllShops();
    }

    @GetMapping("/{id}")
    public Shop getShopById(@PathVariable Long id) {
        return shopService.getShopById(id);
    }

    @PutMapping("/{id}")
    public Shop updateShop(@PathVariable Long id, @RequestBody Shop shop) {
        return shopService.updateShop(id, shop);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleResponseStatusException(ResponseStatusException ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
    }
}
