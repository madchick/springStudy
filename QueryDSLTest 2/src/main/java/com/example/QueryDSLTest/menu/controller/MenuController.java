package com.haksik.haksikapi.menu.controller;

import com.haksik.haksikapi.menu.model.MenuEntity;
import com.haksik.haksikapi.menu.model.MenuGroupView;
import com.haksik.haksikapi.menu.model.MenuRequest;
import com.haksik.haksikapi.menu.model.MenuResponse;
import com.haksik.haksikapi.menu.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/admin/menu")
    @Transactional
    public ResponseEntity<MenuResponse> create(@RequestBody MenuRequest menuRequest) {
        MenuResponse menuResponse = new MenuResponse();

        MenuEntity menuEntity = this.menuService.add(menuRequest);
        List<MenuEntity> menuEntities = new ArrayList<>();
        menuEntities.add(menuEntity);

        menuResponse.setStatus("200");
        menuResponse.setError("success");
        menuResponse.setMenuEntities(menuEntities);

        return ResponseEntity.ok(menuResponse);
    }

    @GetMapping("/admin/menu")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<MenuResponse> readOne() {
/*
        List<MenuEntity> menuEntities = this.menuService.searchAll();

        MenuResponse menuResponse = new MenuResponse();
        menuResponse.setStatus("200");
        menuResponse.setError("success");
        menuResponse.setMenuEntities(menuEntities);

        return ResponseEntity.ok(menuResponse);
*/
        List<MenuGroupView> menuGroupViews = this.menuService.searchAllMenu(Long.valueOf(1));

        MenuResponse menuResponse = new MenuResponse();
        menuResponse.setStatus("200");
        menuResponse.setError("success");
        menuResponse.setMenuGroupViews(menuGroupViews);

        return ResponseEntity.ok(menuResponse);
    }

    @PutMapping("/admin/menu/{id}")
    public ResponseEntity<MenuResponse> update(
            @PathVariable Long id,
            @RequestBody MenuRequest menuRequest)
    {
        MenuEntity menuEntity = this.menuService.updateById(id, menuRequest);

        List<MenuEntity> menuEntities = new ArrayList<>();
        menuEntities.add(menuEntity);

        MenuResponse menuResponse = new MenuResponse();
        menuResponse.setStatus("200");
        menuResponse.setError("success");
        menuResponse.setMenuEntities(menuEntities);

        return ResponseEntity.ok(menuResponse);
    }

    @DeleteMapping("/admin/menu/{id}")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<MenuResponse> deleteOne(@PathVariable Long id) {
        this.menuService.deleteById(id);

        MenuResponse menuResponse = new MenuResponse();
        menuResponse.setStatus("200");
        menuResponse.setError("success");

        return ResponseEntity.ok(menuResponse);
    }

    @GetMapping("/pos/menu/having")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<MenuResponse> menuHaving(@RequestParam Long shopid) {
        List<MenuEntity> menuEntities = this.menuService.searchByShopid(shopid);

        MenuResponse menuResponse = new MenuResponse();
        menuResponse.setStatus("200");
        menuResponse.setError("success");
        menuResponse.setMenuEntities(menuEntities);

        return ResponseEntity.ok(menuResponse);
    }

    @GetMapping("/mobileapp/menu/{id}")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<MenuResponse> readOne(@PathVariable Long id) {
        MenuEntity menuEntity = this.menuService.searchByMenuId(id);

        List<MenuEntity> menuEntities = new ArrayList<>();
        menuEntities.add(menuEntity);

        MenuResponse menuResponse = new MenuResponse();
        menuResponse.setStatus("200");
        menuResponse.setError("success");
        menuResponse.setMenuEntities(menuEntities);

        return ResponseEntity.ok(menuResponse);
    }

}
