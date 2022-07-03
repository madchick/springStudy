package com.haksik.haksikapi.shop.service;

import com.haksik.haksikapi._comm_.codeenum.codedata.MealType;
import com.haksik.haksikapi.item.model.ItemEntity;
import com.haksik.haksikapi.item.repository.ItemRepository;
import com.haksik.haksikapi.shop.model.ShopEntity;
import com.haksik.haksikapi.shop.model.ShopItemCountView;
import com.haksik.haksikapi.shop.model.ShopRequest;
import com.haksik.haksikapi.shop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ItemRepository itemRepository;

    public ShopEntity add(ShopRequest shopRequest) {
        ShopEntity shopEntity = new ShopEntity();

        shopEntity.setSchoolId(shopRequest.getSchoolId());
        shopEntity.setShopName(shopRequest.getShopName());
        shopEntity.setShopLocation(shopRequest.getShopLocation());
        shopEntity.setShopHoliday(shopRequest.getShopHoliday());
        shopEntity.setMenulistUrl(shopRequest.getMenulistUrl());
        shopEntity.setEnabled(true);

        return this.shopRepository.save(shopEntity);
    }

    public List<ShopEntity> searchAll() {
        return this.shopRepository.findAll();
    }

    public ShopEntity searchById(Long id) {
        return this.shopRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<ShopEntity> searchBySchoolId(Long schoolId) { return this.shopRepository.findBySchoolId(schoolId); }

    public List<ItemEntity> searchItem(Long shopId, MealType mealType) {
        return this.itemRepository.findByShopIdAndMealType(shopId,mealType);
    }

    public List<ShopItemCountView> countShopItem(Long shopId) {
        return this.shopRepository.countShopItem(shopId);
    }

    public ShopEntity updateById(Long id, ShopRequest shopRequest) {
        ShopEntity shopEntity = this.searchById(id);

        shopEntity.setShopName(shopRequest.getShopName());
        shopEntity.setShopHoliday(shopRequest.getShopHoliday());
        shopEntity.setShopLocation(shopRequest.getShopLocation());
        shopEntity.setMenulistUrl(shopRequest.getMenulistUrl());
        shopEntity.setEnabled(shopRequest.getShopEnabled());

        shopEntity.setModifiedDate(LocalDateTime.now());

        return this.shopRepository.save(shopEntity);
    }

    public void deleteById(Long id) {
        ShopEntity shopEntity = this.searchById(id);
        shopEntity.setEnabled(false);

        this.shopRepository.save(shopEntity);
    }

}
