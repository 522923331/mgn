package com.tt.service;

import com.tt.entity.Attr;
import com.tt.mapper.attr.AttrMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dangwu
 * @since 2021/1/29 3:35 下午
 */
@Slf4j
@Service
public class ShopService {

    @Autowired
    private AttrMapper attrMapper;


    public Attr queryAttr(Long id) {

        return attrMapper.selectByPrimaryKey(id);
    }
}
