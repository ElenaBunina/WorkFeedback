package com.model;

import com.config.annotation.Attribute;
import com.config.annotation.Name;
import com.config.annotation.ObjectType;
import com.config.annotation.Parent;

@ObjectType(3)
@Parent(1)
@Name("Company")
public class Company extends Entity {

    @Attribute(attrId = 6)
    private String address;
    @Attribute(attrId = 7)
    private String name;
    @Attribute(attrId = 8)
    private String description;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
