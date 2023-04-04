package com.example.Cursor_HW7.services;

import com.example.Cursor_HW7.models.Shop;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ShopService {
    private final List<Shop> shops = new ArrayList<>();

    public Shop createShop(Shop shop) {
        shop.setId((long) (shops.size() + 1));
        shops.add(shop);
        return shop;
    }

    public void deleteShop(Long id) {
        shops.removeIf(shop -> shop.getId().equals(id));
    }

    public List<Shop> getAllShops() {
        return shops;
    }

    public Shop getShopById(Long id) {
        return shops.stream()
                .filter(shop -> shop.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Shop not found"));
    }

    public Shop updateShop(Long id, Shop shop) {
        Shop existingShop = getShopById(id);
        existingShop.setCity(shop.getCity());
        existingShop.setStreet(shop.getStreet());
        existingShop.setName(shop.getName());
        existingShop.setEmployees(shop.getEmployees());
        existingShop.setHasWebsite(shop.isHasWebsite());
        return existingShop;
    }
}
