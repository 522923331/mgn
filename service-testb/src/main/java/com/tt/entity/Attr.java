package com.tt.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * t_attr
 * 
 * @author ttjianbao
 * @date 2020-12-30
 */
@Data
@NoArgsConstructor
public class Attr implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 属性分类id
     */
    private Long attrCateId;

    /**
     * 属性名称
     */
    private String attrName;

    /**
     * 属性值(如果是多个，逗号分隔)
     */
    private String attrValue;

    /**
     * 属性值类型（0单选项、1自定义、2枚举值、3单选项+自定义、4复选项 ）
     */
    private Integer attrValueType;

    /**
     * 是否必填（0否1是）
     */
    private Integer attrRequired;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 更新人
     */
    private Long updateUser;

    /**
     * 删除标识0否1是
     */
    private Integer deleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}