package com.ko.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author Komorebi
 * @date 2022.07.22.13:48
 */

// @TableName("user_copy")当表名和实体类不一致时，使用此注解
@Data //不包含有参构造函数
public class User {
    @TableField("id")//解决字段名不一致问题
    // @TableId(type = IdType.ASSIGN_ID)//雪花算法生成id  也可以进行全局配置，见.yml
    private Long id;
    private String name;

    @TableField(select = false)//设置字段是否参与查询
    private String password;
    private Integer age;
    private String tel;

    @TableField(exist = false)//解决编码中添加了数据库中未定义的属性
    private Integer online;

    //逻辑删除字段，标记当前记录是否被删除 也可以进行全局配置，见.yml
    // @TableLogic(value = "0",delval = "1")
    private int deleted;

    //加乐观锁 需要添加mp拦截器
    @Version
    private Integer version;

}
