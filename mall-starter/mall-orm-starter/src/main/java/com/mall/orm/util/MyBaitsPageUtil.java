package com.mall.orm.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mall.base.entity.PageResult;
import com.mall.base.entity.PageVO;

import java.util.List;
import java.util.function.Supplier;

/**
 * Description: mybatis 分页查询工具类
 *
 * @author zb
 * @date 2020/5/21 20:56
 */
public class MyBaitsPageUtil {

    /**
     * 分页查询工具类
     * @param pageVO 基本页码管理
     * @param mapper   参数示例：() -> oauthApplicationMapper.selectOauthApplicationPage(oauthApplication)
     * @param <T>
     * @return
     */
    public static <T> PageResult<T> pageResult(PageVO pageVO, Supplier<List<T>> mapper){
        PageResult<T> pageResult = new PageResult<>();
        if(null == pageVO.getPage()){
            pageVO.setPage(1);
        }
        if(null == pageVO.getPageSize()){
            pageVO.setPageSize(10);
        }
        Page<T> page = PageHelper.startPage(pageVO.getPage(), pageVO.getPageSize());
        List<T> rs = mapper.get();
        pageResult.setData(rs);
        pageResult.setTotal(page.getTotal());
        pageResult.setTotalPage(page.getPages());
        return pageResult;
    }
}
