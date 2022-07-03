package com.haksik.haksikapi.item.controller;

import com.haksik.haksikapi.item.model.ItemEntity;
import com.haksik.haksikapi.item.model.ItemRequest;
import com.haksik.haksikapi.item.model.ItemResponse;
import com.haksik.haksikapi.item.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/admin/item")
    @Transactional
    public ResponseEntity<ItemResponse> create(@RequestBody ItemRequest itemRequest) {
        ItemResponse itemResponse = new ItemResponse();

        ItemEntity itemEntity = this.itemService.add(itemRequest);
        List<ItemEntity> itemEntities = new ArrayList<>();
        itemEntities.add(itemEntity);

        itemResponse.setStatus("200");
        itemResponse.setError("success");
        itemResponse.setItemEntities(itemEntities);

        return ResponseEntity.ok(itemResponse);
    }

    @PutMapping("/admin/item/{id}")
    public ResponseEntity<ItemResponse> update(
            @PathVariable Long id,
            @RequestBody ItemRequest itemRequest)
    {
        ItemEntity itemEntity = this.itemService.updateById(id, itemRequest);

        List<ItemEntity> itemEntities = new ArrayList<>();
        itemEntities.add(itemEntity);

        ItemResponse itemResponse = new ItemResponse();
        itemResponse.setStatus("200");
        itemResponse.setError("success");
        itemResponse.setItemEntities(itemEntities);

        return ResponseEntity.ok(itemResponse);
    }

    @DeleteMapping("/admin/item/{id}")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ItemResponse> deleteOne(@PathVariable Long id) {
        this.itemService.deleteById(id);

        ItemResponse itemResponse = new ItemResponse();
        itemResponse.setStatus("200");
        itemResponse.setError("success");

        return ResponseEntity.ok(itemResponse);
    }

    @GetMapping("/admin/item/browse")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ItemResponse> readAllByMenuId(@RequestParam Long menuid)
    {
        List<ItemEntity> itemEntities = this.itemService.searchAllByMenuId(menuid);

        ItemResponse itemResponse = new ItemResponse();
        itemResponse.setStatus("200");
        itemResponse.setError("success");
        itemResponse.setItemEntities(itemEntities);

        return ResponseEntity.ok(itemResponse);
    }

    @GetMapping("/mobileapp/item")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ItemResponse> readAll()
    {
        List<ItemEntity> itemEntities = this.itemService.searchAll();

        ItemResponse itemResponse = new ItemResponse();
        itemResponse.setStatus("200");
        itemResponse.setError("success");
        itemResponse.setItemEntities(itemEntities);

        return ResponseEntity.ok(itemResponse);
    }

    @GetMapping("/mobileapp/item/{id}")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ItemResponse> readOne(@PathVariable Long id) {
        ItemEntity itemEntity = this.itemService.searchByItemId(id);

        List<ItemEntity> menuEntities = new ArrayList<>();
        menuEntities.add(itemEntity);

        ItemResponse itemResponse = new ItemResponse();
        itemResponse.setStatus("200");
        itemResponse.setError("success");
        itemResponse.setItemEntities(menuEntities);

        return ResponseEntity.ok(itemResponse);
    }

}
