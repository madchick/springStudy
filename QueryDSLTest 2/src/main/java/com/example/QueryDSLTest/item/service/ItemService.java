package com.haksik.haksikapi.item.service;

import com.haksik.haksikapi._comm_.codeenum.codedata.MealType;
import com.haksik.haksikapi.item.model.ItemEntity;
import com.haksik.haksikapi.item.model.ItemRequest;
import com.haksik.haksikapi.item.repository.ItemRepository;
import com.haksik.haksikapi.menu.model.MenuEntity;
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
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private MenuRepository menuRepository;

    public ItemEntity add(ItemRequest itemRequest) {
        MenuEntity savedMenuEntity = this.menuRepository.findByMenuId(itemRequest.getMenuId());

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setShopId(savedMenuEntity.getShopId());
        itemEntity.setMenuId(savedMenuEntity.getMenuId());
        itemEntity.setMenuPicture(savedMenuEntity.getMenuPicture());
        itemEntity.setItemName(savedMenuEntity.getMenuName());
        itemEntity.setItemBundleCount(itemRequest.getItemBundleCount());
        itemEntity.setItemPrice(itemRequest.getItemPrice());
        itemEntity.setMealType(savedMenuEntity.getMealType());
        itemEntity.setItemDesc(savedMenuEntity.getMenuDesc());
        itemEntity.setItemDetailDesc(savedMenuEntity.getMenuDetailDesc());
        itemEntity.setEnabled(true);

        return this.itemRepository.save(itemEntity);
    }

    public ItemEntity updateById(Long id, ItemRequest itemRequest) {
        ItemEntity itemEntity = this.searchById(id);

        itemEntity.setItemBundleCount(itemRequest.getItemBundleCount());
        itemEntity.setItemPrice(itemRequest.getItemPrice());
        itemEntity.setEnabled(itemRequest.getItemEnabled());

        itemEntity.setModifiedDate(LocalDateTime.now());

        return this.itemRepository.save(itemEntity);
    }

    public void deleteById(Long id) {
        ItemEntity itemEntity = this.searchById(id);
        itemEntity.setEnabled(false);

        this.itemRepository.save(itemEntity);
    }

    public ItemEntity searchById(Long id) {
        return this.itemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<ItemEntity> searchAllByMenuId(Long menuId) {
        return this.itemRepository.findAllByMenuIdOrderByCreatedDateDesc(menuId);
    }

    public List<ItemEntity> searchAll() {
        return this.itemRepository.findAll();
    }

    public ItemEntity searchByItemId(Long itemId) { return this.itemRepository.findByItemIdOrderByCreatedDateDesc(itemId); }
}
