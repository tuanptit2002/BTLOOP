package com.example.shop.Controller;

import com.example.shop.DTO.ItemDTO;
import com.example.shop.Entity.Category;
import com.example.shop.Entity.DescriptionItem;
import com.example.shop.Entity.Discount;
import com.example.shop.Entity.Item;
import com.example.shop.Service.CategoryService;
import com.example.shop.Service.DescriptionItemService;
import com.example.shop.Service.DiscountService;
import com.example.shop.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    DiscountService discountService;

    @Autowired
    DescriptionItemService descriptionItemService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ItemDTO itemDTO) {
        return itemService.create(mapper(itemDTO));
    }

    @GetMapping("/items/cart/{idCart}")
    public List<ItemDTO> getAllInCart(@PathVariable Long idCart) {
        List<ItemDTO> itemDTOS = new ArrayList<>();
        List<Item> items = itemService.getAllItemInCart(idCart);
        for (Item item : items) {
            itemDTOS.add(mapperDTO(item));
        }
        return itemDTOS;
    }

    @GetMapping("get/all/{idCategory}")
    public List<ItemDTO> getAllItem(@PathVariable Long idCategory) {
        List<ItemDTO> itemDTOS = new ArrayList<>();
        List<Item> items = itemService.getAllItemWithCategory(idCategory);
        for (Item item : items) {
            itemDTOS.add(mapperDTO(item));
        }
        return itemDTOS;
    }

    @GetMapping("/get/all")
    public List<ItemDTO> getAllItem() {
        List<ItemDTO> itemDTOS = new ArrayList<>();
        List<Item> items = itemService.getAll();
        for (Item item : items) {
            itemDTOS.add(mapperDTO(item));
        }
        return itemDTOS;
    }

    private Item mapper(ItemDTO itemDTO) {
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setColor(itemDTO.getColor());
        item.setSize(itemDTO.getSize());
        item.setCount(itemDTO.getCount());
        item.setImage(itemDTO.getImage());
        if (itemDTO.getCategoryDTO() != null && itemDTO.getCategoryDTO().getId() != null) {
            Category category = categoryService.getById(itemDTO.getCategoryDTO().getId());
            item.setCategory(category);
        }
        if (itemDTO.getDiscountDTO() != null && itemDTO.getDiscountDTO().getId() != null) {
            Discount discount = discountService.getById(itemDTO.getDiscountDTO().getId());
            item.setDiscount(discount);
        }
        if (itemDTO.getDescriptionItemDTO() != null && itemDTO.getDescriptionItemDTO().getId() != null) {
            DescriptionItem descriptionItem = descriptionItemService.getById(itemDTO.getDescriptionItemDTO().getId());
            item.setDescriptionItem(descriptionItem);
        }

        return item;
    }

    private ItemDTO mapperDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setName(item.getName());
        itemDTO.setColor(item.getColor());
        itemDTO.setImage(item.getImage());
        itemDTO.setPrice(item.getPrice());
        itemDTO.setSize(item.getSize());
        itemDTO.setCount(item.getCount());
        return itemDTO;
    }
}
