package com.nfc.service;

import com.nfc.exception.CustomException;
import com.nfc.util.DataPage;
import com.nfc.pojo.Movie;

/**
 * Created by ms-zk on 2017-03-13.
 */
public interface MovieService {
    DataPage<Movie> selectPage(Integer pageNum, Integer pageSize, Integer indexCount);
    Movie findByPrimaryKey(Integer id) throws CustomException;
    void insert(Movie movie);
    void deleteByPrimaryKey(Integer id);
    void updateByPrimaryKey(Integer id,Movie movie);
}
