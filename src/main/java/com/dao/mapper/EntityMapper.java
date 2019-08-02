package com.dao.mapper;


import com.config.annotation.ObjectType;
import com.model.Company;
import com.model.Entity;
import com.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EntityMapper implements RowMapper<Entity> {

    Entity entity;

    public EntityMapper(Entity entity) {
        this.entity = entity;
    }

    @Override
    public Entity mapRow(ResultSet rs, int rowNum) throws SQLException {
        Entity entity = new Entity();
        Class<? extends Entity> clazz = entity.getClass();
        if (clazz.isAnnotationPresent(ObjectType.class)) {
            ObjectType objectType = clazz.getAnnotation(ObjectType.class);
            if (objectType.value() == 2) {
                entity = new User();
            }else if (objectType.value() == 3) {
                entity = new Company();
            }
        }
        entity.setObjectId(rs.getLong("object_id"));
        entity.setParentId(rs.getLong("parent_id"));
        entity.setObjectTypeId(rs.getLong("object_type_id"));
        entity.setName(rs.getString("name"));
        return entity;



    }
}
