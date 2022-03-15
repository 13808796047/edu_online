package com.summer.service.edu.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 讲师
 * </p>
 *
 * @author Summer
 * @since 2022-03-16
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("edu_teacher")
@ApiModel(value = "Teacher对象", description = "讲师")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("讲师ID")
      private String id;

    @ApiModelProperty("讲师姓名")
    private String name;

    @ApiModelProperty("讲师简介")
    private String intro;

    @ApiModelProperty("讲师资历,一句话说明讲师")
    private String career;

    @ApiModelProperty("头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty("讲师头像")
    private String avatar;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    private Boolean isDeleted;

    @ApiModelProperty("创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty("更新时间")
    private LocalDateTime gmtModified;


}
