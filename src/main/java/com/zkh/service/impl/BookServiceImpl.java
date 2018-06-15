package com.zkh.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zkh.dao.BookMapper;
import com.zkh.exception.CustomException;
import com.zkh.pojo.Book;
import com.zkh.service.BookService;
import com.zkh.util.DataPage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by nfc  on 2018-06-14.
 */
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book findByPrimaryKey(Integer id) throws CustomException {

        Book book = bookMapper.selectByPrimaryKey(id);
        if(book==null){
            throw new CustomException("记录不存在！");
        }
        return book;
    }

    @Override
    public void insert(Book book) {
    bookMapper.insert(book);
    }


    @Override
    public void deleteByPrimaryKey(Integer id) {
        bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateByPrimaryKey(Integer id, Book book) {
        book.setId(id);
        bookMapper.updateByPrimaryKey(book);
    }

    @Override
    public DataPage<Book> selectPage(Integer pageNum, Integer pageSize, Integer indexCount) {
        PageHelper.startPage(pageNum,pageSize);
        List<Book> books = bookMapper.selectByExample(null);

        Integer pageCount = ((Page) books).getPages();
        pageNum = pageNum > pageCount ? pageCount : pageNum;

        DataPage<Book> page = new DataPage<Book>();
        page.setData(books);
        page.setIndexCount(indexCount);
        page.setPageCount(pageCount);
        page.setPageSize(pageSize);
        page.setPageNum(pageNum);

        return page;
    }

}
