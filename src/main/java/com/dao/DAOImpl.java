package com.dao;


import com.config.annotation.Attribute;
import com.config.annotation.Name;
import com.config.annotation.ObjectType;
import com.config.annotation.Parent;
import com.dao.mapper.EntityMapper;
import com.model.Entity;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.appengine.labs.repackaged.org.json.XMLTokener.entity;

//отключение предупреждений, связанных с устареванием и  синтаксис sql
@SuppressWarnings({"SqlDialectInspection", "deprecation"})
public class DAOImpl implements DAO {

    private JdbcTemplate jdbcTemplate;

    private JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public DAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Entity> getAllObjects() {
        String sql = "select * from objects order by name";
        Entity  entity = new Entity();
        List<Entity> listUserInfo =  getJdbcTemplate().query(sql,new EntityMapper(entity));
        return listUserInfo;

    }

    long generatorId() {
        long id = 0;
        long number = getJdbcTemplate().queryForLong("SELECT max(object_id) FROM objects");
        long a = Math.round(Math.random() * 1000);
        if (a != number && a != 0) {
            id = a;
        }
        return id;
    }
    private static List<Field> getInheritedFields(Class<?> type) {

        List<Field> fields = new ArrayList<>();
        for (Class<?> c = type; c != null; c = c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
        }
        return fields;
    }

    @Override
    public <T extends Entity> void saveEntity(T obj) throws IllegalAccessException {
        long id = generatorId();
        Class clazz = obj.getClass();
        List<Field> fieldClass = getInheritedFields(obj.getClass());
        obj.setObjectId(id);
        if (clazz.isAnnotationPresent(ObjectType.class) && clazz.isAnnotationPresent(Parent.class)) {
            ObjectType objectType = (ObjectType) clazz.getAnnotation(ObjectType.class);
            Parent parent = (Parent) clazz.getAnnotation(Parent.class);
            Name name = (Name) clazz.getAnnotation(Name.class);
            String updateObject = "INSERT INTO objects (object_id, parent_id, object_type_id, name) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(updateObject, obj.getObjectId(), parent.value(), objectType.value(), name.value());
            for (Field field : fieldClass) {
                if (field.isAnnotationPresent(Attribute.class)) {
                    field.setAccessible(true);
                    Attribute attribute = field.getAnnotation(Attribute.class);
                        Object objectValue = null;
                        objectValue = field.get(obj);
                        if (objectValue == null) continue;
                        String updateParams = "INSERT INTO params (attribute_id, object_id, value) VALUES (?, ?, ?)";
                        jdbcTemplate.update(updateParams, attribute.attrId(), obj.getObjectId(), field.get(obj).toString());
                }
            }
        }
    }
}
