package com.dao;


import com.model.Entity;
import com.model.User;

import java.util.List;

public interface DAO {


    List<Entity> getAllObjects();
    <T extends Entity> void saveEntity(T obj) throws IllegalAccessException;

}
