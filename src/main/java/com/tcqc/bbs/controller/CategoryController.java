package com.tcqc.bbs.controller;

import com.tcqc.bbs.dao.CategoryDao;
import com.tcqc.bbs.entity.Category;
import com.tcqc.bbs.util.format.FormatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "category")
public class CategoryController {
    private CategoryDao  categoryDao;
    @Autowired
    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    /**
     * 查看category的详细信息，右侧信息
     * @param id
     * @return
     */
    @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
    public FormatResult<Category> getCategoryInfo(@PathVariable(value = "id")BigInteger id){
        return null;
    }
}
