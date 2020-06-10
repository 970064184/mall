package com.mall.test.brand.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.test.brand.entity.TbBrand;
import com.mall.test.brand.mapper.TbBrandMapper;
import com.mall.test.brand.service.ITbBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author zb
 * @since 2020-05-21
 */
@Service
public class TbBrandServiceImpl extends ServiceImpl<TbBrandMapper, TbBrand> implements ITbBrandService {

    @Autowired
    private TbBrandMapper mapper;


}
