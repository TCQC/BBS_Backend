package com.tcqc.bbs.controller;

import com.tcqc.bbs.entity.Category;
import com.tcqc.bbs.service.CategoryService;
import com.tcqc.bbs.util.format.FormatResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }



    /**
     * 查询某版块下的所有cateogry
     * @param id
     * @return
     */
    @RequestMapping(value = "block/{id}", method = RequestMethod.GET)
    public FormatResult<List<Category>> findCategoriesByBlockId(@PathVariable(value = "id")BigInteger id){
        return categoryService.findAllByBlockId(id);
    }

    /**
     * 查询所有分类列表
     * @return
     */
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public FormatResult<Map<String, Object>> getCategory(@PathVariable(value = "id")BigInteger id){
        return categoryService.getCategoryById(id);
    }

    /**
     * 查询所有分类列表
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public FormatResult<List<Category>> findAllCategories(){
        return categoryService.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public FormatResult<Object> addCategory(@RequestParam(value = "blockId")BigInteger id, @RequestParam(value = "name")String name, @Param(value = "description")String description){
        return categoryService.addCategory(id, name, description);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public FormatResult<Object> delCategory(@PathVariable(value = "id")BigInteger id){
        return categoryService.delCategory(id);
    }

}
