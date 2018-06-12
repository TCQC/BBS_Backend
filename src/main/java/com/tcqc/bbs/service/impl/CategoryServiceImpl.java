package com.tcqc.bbs.service.impl;

import com.tcqc.bbs.dao.CategoryDao;
import com.tcqc.bbs.entity.Category;
import com.tcqc.bbs.service.CategoryService;
import com.tcqc.bbs.util.format.FormatResult;
import com.tcqc.bbs.util.format.FormatResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public FormatResult<List<Category>> findAll() {
        List<Category> categories = categoryDao.findAll();
        return FormatResultGenerator.genSuccessResult(categories);
    }

    @Override
    public FormatResult<List<Category>> findAllByBlockId(BigInteger id) {
        List<Category> categories = categoryDao.findAllByBlockId(id);
        return FormatResultGenerator.genSuccessResult(categories);
    }

    @Override
    public FormatResult<Object> addCategory(BigInteger id, String name, String description) {
        int i = categoryDao.addCategory(id, name, description);
        return FormatResultGenerator.genSuccessResult(i);
    }

    @Override
    public FormatResult<Object> delCategory(BigInteger id) {
        int i = categoryDao.delCategory(id);
        return FormatResultGenerator.genSuccessResult(i);
    }
}
