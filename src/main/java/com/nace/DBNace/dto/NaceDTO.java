package com.nace.DBNace.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

public class NaceDTO {
    private Long naceId;
    private String level;
    private String code;
    private String parent;
    private String description;
    private String itemIncludes;
    private String itemAlsoIncludes;
    private String rulings;
    private String itemExcludes;
    private String refToISIC;

    public Long getNaceId() {
        return naceId;
    }

    public void setNaceId(Long naceId) {
        this.naceId = naceId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemIncludes() {
        return itemIncludes;
    }

    public void setItemIncludes(String itemIncludes) {
        this.itemIncludes = itemIncludes;
    }

    public String getItemAlsoIncludes() {
        return itemAlsoIncludes;
    }

    public void setItemAlsoIncludes(String itemAlsoIncludes) {
        this.itemAlsoIncludes = itemAlsoIncludes;
    }

    public String getRulings() {
        return rulings;
    }

    public void setRulings(String rulings) {
        this.rulings = rulings;
    }

    public String getItemExcludes() {
        return itemExcludes;
    }

    public void setItemExcludes(String itemExcludes) {
        this.itemExcludes = itemExcludes;
    }

    public String getRefToISIC() {
        return refToISIC;
    }

    public void setRefToISIC(String refToISIC) {
        this.refToISIC = refToISIC;
    }
}
