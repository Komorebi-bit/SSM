package com.ko.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author Komorebi
 * @date 2022.07.22.13:48
 */

// @TableName("user_copy")当表名和实体类不一致时，使用此注解

// @Setter
// @Getter
// @ToString
// @NoArgsConstructor
// @AllArgsConstructor
// @EqualsAndHashCode

@Data //不包含有参构造函数
public class User {
    @TableField("id")//解决字段名不一致问题
    private Long id;
    private String name;

    @TableField(select = false)//设置字段是否参与查询
    private String password;
    private Integer age;
    private String tel;

    @TableField(exist = false)//解决编码中添加了数据库中未定义的属性
    private Integer online;

}
