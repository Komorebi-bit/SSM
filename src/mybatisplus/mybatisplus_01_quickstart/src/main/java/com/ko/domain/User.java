package com.ko.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

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
    private Long id;
    private String name;
    private String password;
    private Integer age;
    private String tel;

}
