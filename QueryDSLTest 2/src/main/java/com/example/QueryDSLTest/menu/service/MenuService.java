package com.haksik.haksikapi.menu.service;

import com.haksik.haksikapi._comm_.codeenum.codedata.MealType;
import com.haksik.haksikapi.item.model.ItemEntity;
import com.haksik.haksikapi.item.repository.ItemRepository;
import com.haksik.haksikapi.menu.model.MenuEntity;
import com.haksik.haksikapi.menu.model.MenuGroupView;
import com.haksik.haksikapi.menu.model.MenuRequest;
import com.haksik.haksikapi.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ItemRepository itemRepository;

    public MenuEntity add(MenuRequest menuRequest) {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setShopId(menuRequest.getShopId());
        menuEntity.setMenuName(menuRequest.getMenuName());
        menuEntity.setMenuDesc(menuRequest.getMenuDesc());
        menuEntity.setMenuDetailDesc(menuRequest.getMenuDetailDesc());
        menuEntity.setMenuPrice(menuRequest.getMenuPrice());
        menuEntity.setGopublicType(menuRequest.getGopublicType());
        menuEntity.setSalesStartDate(menuRequest.getSalesStartDate());
        menuEntity.setSalesStopDate(menuRequest.getSalesStopDate());
        menuEntity.setSalesStatusType(menuRequest.getSalesStatusType());
        menuEntity.setTicketType(menuRequest.getTicketType());
        menuEntity.setMealType(MealType.GENERAL);
        menuEntity.setMenuPicture("/images/00.jpg");
        menuEntity.setEnabled(true);

        MenuEntity savedMenuEntity = this.menuRepository.save(menuEntity);

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setShopId(savedMenuEntity.getShopId());
        itemEntity.setMenuId(savedMenuEntity.getMenuId());
        itemEntity.setMenuPicture(savedMenuEntity.getMenuPicture());
        itemEntity.setItemName(savedMenuEntity.getMenuName());
        itemEntity.setItemBundleCount(Long.valueOf(1));
        itemEntity.setItemPrice(savedMenuEntity.getMenuPrice());
        itemEntity.setMealType(savedMenuEntity.getMealType());
        itemEntity.setItemDesc(savedMenuEntity.getMenuDesc());
        itemEntity.setItemDetailDesc(savedMenuEntity.getMenuDetailDesc());
        itemEntity.setEnabled(true);

        this.itemRepository.save(itemEntity);

        return savedMenuEntity;
    }

    public MenuEntity updateById(Long id, MenuRequest menuRequest) {
        MenuEntity menuEntity = this.searchById(id);

        menuEntity.setShopId(menuRequest.getShopId());
        menuEntity.setMenuName(menuRequest.getMenuName());
        menuEntity.setMenuDesc(menuRequest.getMenuDesc());
        menuEntity.setMenuDetailDesc(menuRequest.getMenuDetailDesc());
        menuEntity.setMealType(menuRequest.getMealType());
        menuEntity.setMenuPrice(menuRequest.getMenuPrice());

        menuEntity.setTicketType(menuRequest.getTicketType());
        menuEntity.setSalesStatusType(menuRequest.getSalesStatusType());
        menuEntity.setGopublicType(menuRequest.getGopublicType());
        menuEntity.setSalesStartDate(menuRequest.getSalesStartDate());
        menuEntity.setSalesStopDate(menuRequest.getSalesStopDate());
        menuEntity.setEnabled(menuRequest.getMenuEnabled());

        menuEntity.setModifiedDate(LocalDateTime.now());

        return this.menuRepository.save(menuEntity);
    }

    public void deleteById(Long id) {
        MenuEntity menuEntity = this.searchById(id);
        menuEntity.setEnabled(false);

        this.menuRepository.save(menuEntity);
    }

    public MenuEntity searchById(Long id) {
        return this.menuRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<MenuEntity> searchByShopid(Long shopId) { return this.menuRepository.findByShopId(shopId); }

    public MenuEntity searchByMenuId(Long menuId) { return this.menuRepository.findByMenuId(menuId); }

    public List<MenuEntity> searchAll() {
        return this.menuRepository.findAll();
    }

    public List<MenuGroupView> searchAllMenu(Long schoolId) { return this.menuRepository.findAllMenu(schoolId); }

}
