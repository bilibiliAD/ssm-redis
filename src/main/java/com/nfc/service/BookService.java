package com.nfc.service;

import com.nfc.exception.CustomException;
import com.nfc.pojo.Book;
import com.nfc.util.DataPage;

/**
 * Created by nfc on 2018-06-14.
 */
public interface BookService {
    DataPage<Book> selectPage(Integer pageNum, Integer pageSize, Integer indexCount);
    Book findByPrimaryKey(Integer id) throws CustomException;
    void insert(Book book);
    void deleteByPrimaryKey(Integer id);
    void updateByPrimaryKey(Integer id, Book book);
}
