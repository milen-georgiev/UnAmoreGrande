package com.example.unamoregrande.model.binding;

import com.example.unamoregrande.model.entity.enums.StyleNameEnum;

public class FilterBindingModel {

    private StyleNameEnum categoryStyle;

    public FilterBindingModel() {
    }

    public StyleNameEnum getCategoryStyle() {
        return categoryStyle;
    }

    public FilterBindingModel setCategoryStyle(StyleNameEnum categoryStyle) {
        this.categoryStyle = categoryStyle;
        return this;
    }
}
