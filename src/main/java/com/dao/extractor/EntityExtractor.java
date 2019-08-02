//package com.dao.extractor;
//
//
//import com.model.Entity;
//
//import com.model.User;
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.ResultSetExtractor;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class EntityExtractor implements ResultSetExtractor {
//
//
//    private Entity entity;
//
//    public EntityExtractor(Entity entity) {
//        this.entity = entity;
//    }
//
//    @Override
//    public List<? extends Entity> extractData(ResultSet rs) throws SQLException, DataAccessException {
////        List<Entity> entityList = new ArrayList<>();
////        Set<Long> refSet = new HashSet<>();
////        try {
////            if (entity == null) {
////                throw new NullPointerException();
////            }
////        } catch (NullPointerException e) {
////        }
////        Class<? extends Entity> clazz = entity.getClass();
////        Field field = null;
////        try {
////            field = clazz.getDeclaredField("phones");
////            field.setAccessible(true);
////        } catch (NoSuchFieldException e) {
////        }
//
//
//
//        while (rs.next()) {
//            //общая часть, эти значения для всех сущностей
//            entity.setObjectId(rs.getInt("object_id"));
//            entity.setParentId(rs.getInt("parent_id"));
//            entity.setObjectTypeId(rs.getInt("object_type_id"));
//            entity.setName(rs.getString("name"));
//
//            //теперь проверяем, если наша сущность User
//            if (entity instanceof User) {
//                try {
//                    if (rs.getString("param").equals("name")) {
//                        Method setNameCust = clazz.getDeclaredMethod("setNameCust", new Class[]{String.class});
//                        setNameCust.invoke(entity, rs.getString("value"));
//                    }
//                    if (rs.getString("param").equals("address")) {
//                        Method setAddress = clazz.getDeclaredMethod("setAddress", new Class[]{String.class});
//                        setAddress.invoke(entity, rs.getString("value"));
//                    }
//                    if (rs.getString("param").equals("telephone")) {
//                        Method setTelephone = clazz.getDeclaredMethod("setTelephone", new Class[]{String.class});
//                        setTelephone.invoke(entity, rs.getString("value"));
//                    }
//
//                    field.set(entity, refSet);
//                } catch (NoSuchMethodException e) {
//                } catch (IllegalAccessException e) {
//                } catch (InvocationTargetException e) {
//                }
//            }
//
//
//        }
//        entityList.add(entity);
//        return entityList;
//    }
//}