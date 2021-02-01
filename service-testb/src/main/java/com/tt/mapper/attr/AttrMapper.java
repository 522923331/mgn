package com.tt.mapper.attr;

import com.tt.entity.Attr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AttrMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Attr record);

    /**
     * 非空插入
     * @param record 属性实体
     * @return 影响行数
     */
    int insertSelective(Attr record);

    /**
     * 根据id查询属性
     * @param id 属性主键
     * @return 属性实体
     */
    Attr selectByPrimaryKey(Long id);

    /**
     * 根据条件修改
     * @param record 属性实体
     * @return 影响行数
     */
    int updateByPrimaryKeySelective(Attr record);

    int updateByPrimaryKey(Attr record);

    /**
     * 查询所有属性信息
     * @return 属性集合
     */
    List<Attr> findAllList();

    /**
     * 通过属性分类id查询属性列表信息
     * @param attrCateId 属性分类id
     * @return 属性集合
     */
    List<Attr> listAttrByAttrCateId(@Param("attrCateId") Long attrCateId);
}