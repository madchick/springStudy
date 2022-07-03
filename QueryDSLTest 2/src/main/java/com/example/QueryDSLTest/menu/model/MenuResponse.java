package com.haksik.haksikapi.menu.model;

import com.haksik.haksikapi._comm_.model.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MenuResponse extends BaseResponse {

    public MenuResponse() {
        super();
        this.setPath("/pos/menu");
    }

    private List<MenuEntity> menuEntities;
    private List<MenuGroupView> menuGroupViews;

}
