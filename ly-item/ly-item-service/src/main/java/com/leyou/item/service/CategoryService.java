package com.leyou.item.service;

import com.leyou.common.Exception.LyException;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryListByPid(Long pid){
        Example example = new Example(Category.class);
        example.createCriteria().andEqualTo("parentId",pid);
        List<Category> list = this.categoryMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new LyException(ExceptionEnum.GATEGORY_NOT_FIND);
        }
        return list;
    }
}
