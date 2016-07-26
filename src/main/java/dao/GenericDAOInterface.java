/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Sonja
 * @param <T>
 * @param <PK>
 */

public interface GenericDAOInterface<T, PK extends Serializable> {
    
        public void save(T entity);
        public Object findById(PK id);
        public void delete(T entity);
        public List<T> findAll();
        public void update(T entity);

}
