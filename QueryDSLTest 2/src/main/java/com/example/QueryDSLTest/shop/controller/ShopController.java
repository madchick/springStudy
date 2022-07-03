package com.haksik.haksikapi.shop.controller;

import com.haksik.haksikapi._comm_.codeenum.codedata.CustomerType;
import com.haksik.haksikapi._comm_.codeenum.codedata.MealType;
import com.haksik.haksikapi.item.model.ItemEntity;
import com.haksik.haksikapi.shop.model.ShopEntity;
import com.haksik.haksikapi.shop.model.ShopItemCountView;
import com.haksik.haksikapi.shop.model.ShopRequest;
import com.haksik.haksikapi.shop.model.ShopResponse;
import com.haksik.haksikapi.shop.service.ShopService;
import com.haksik.haksikapi.user.model.UserEntity;
import com.haksik.haksikapi.user.model.UserRequest;
import com.haksik.haksikapi.user.service.UserAuthService;
import com.haksik.haksikapi.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
public class ShopController {

    private final ShopService shopService;
    private final UserService userService;
    private final UserAuthService userAuthService;

    @PostMapping("/admin/shop")
    @Transactional
    public ResponseEntity<ShopResponse> create(@RequestBody ShopRequest shopRequest) {
        ShopResponse shopResponse = new ShopResponse();
        List<UserEntity> userEntities = this.userService.searchByEmail(shopRequest.getShopAccount());
        if(userEntities.stream().count() != 0) {
            shopResponse.setStatus("400");
            shopResponse.setError("이미 등록된 계정 입니다.");
            return ResponseEntity.ok(shopResponse);
        }

        ShopEntity shopEntity = this.shopService.add(shopRequest);
        List<ShopEntity> shopEntities = new ArrayList<>();
        shopEntities.add(shopEntity);

        UserRequest userRequest = new UserRequest();
        userRequest.setEmail(shopRequest.getShopAccount());
        userRequest.setPassword(shopRequest.getShopAccountPw());
        userRequest.setName(shopRequest.getShopName() + " 관리자");
        userRequest.setPhone("");
        userRequest.setCustomerType(CustomerType.SHOPADMIN);
        userRequest.setSchoolId(shopEntity.getSchoolId());
        userRequest.setShopId(shopEntity.getShopId());
        userRequest.setIdNumber("");
        UserEntity userEntity = this.userService.add(userRequest);
        this.userAuthService.addAuthority(userEntity.getUserId(),"ROLE_SHOP");

        shopResponse.setStatus("200");
        shopResponse.setError("success");
        shopResponse.setShopEntities(shopEntities);

        return ResponseEntity.ok(shopResponse);
    }

    @GetMapping("/mobileapp/shop/{id}")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ShopResponse> readOne(@PathVariable Long id) {
        ShopEntity shopEntity = this.shopService.searchById(id);

        List<ShopEntity> shopEntities = new ArrayList<>();
        shopEntities.add(shopEntity);

        ShopResponse shopResponse = new ShopResponse();
        shopResponse.setStatus("200");
        shopResponse.setError("success");
        shopResponse.setShopEntities(shopEntities);

        return ResponseEntity.ok(shopResponse);
    }

    @PutMapping("/admin/shop/{id}")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ShopResponse> update(
            @PathVariable Long id,
            @RequestBody ShopRequest shopRequest)
    {
        ShopEntity shopEntity = this.shopService.updateById(id, shopRequest);

        List<ShopEntity> shopEntities = new ArrayList<>();
        shopEntities.add(shopEntity);

        ShopResponse shopResponse = new ShopResponse();
        shopResponse.setStatus("200");
        shopResponse.setError("success");
        shopResponse.setShopEntities(shopEntities);

        return ResponseEntity.ok(shopResponse);
    }

    @DeleteMapping("/admin/shop/{id}")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ShopResponse> deleteOne(@PathVariable Long id) {
        this.shopService.deleteById(id);

        ShopResponse shopResponse = new ShopResponse();
        shopResponse.setStatus("200");
        shopResponse.setError("success");

        return ResponseEntity.ok(shopResponse);
    }

    @GetMapping("/mobileapp/shop/browse")
    public ResponseEntity<ShopResponse> browse(@RequestParam Long schoolid) {
        List<ShopEntity> shopEntities = this.shopService.searchBySchoolId(schoolid);

        ShopResponse shopResponse = new ShopResponse();
        shopResponse.setStatus("200");
        shopResponse.setError("success");
        shopResponse.setShopEntities(shopEntities);

        return ResponseEntity.ok(shopResponse);
    }

    @GetMapping("/mobileapp/shop/item/browse")
    public ResponseEntity<ShopResponse> queryBySchoolId(@RequestParam Long shopid, @RequestParam MealType mealtype) {
        List<ItemEntity> itemEntities = this.shopService.searchItem(shopid,mealtype);
        List<ShopItemCountView> shopItemCountViews = this.shopService.countShopItem(shopid);

        ShopResponse shopResponse = new ShopResponse();
        shopResponse.setStatus("200");
        shopResponse.setError("success");
        shopResponse.setItemEntities(itemEntities);
        shopResponse.setShopItemCountViews(shopItemCountViews);

        return ResponseEntity.ok(shopResponse);
    }

}
