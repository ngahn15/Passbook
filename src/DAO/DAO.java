/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author ngocn
 */
public interface DAO<T, E> {

//    Lấy toàn bộ danh sách
    List<T> getAll();

    List<T> getAllByID(E e);
//    Lấy đối tượng theo ID

    public T getByID(E e);

//    Thêm mới
    int add(T t);

//    Xóa đối tượng
}
