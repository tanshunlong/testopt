package com.hermes.testopt.modules.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.hermes.commons.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <pre>
 *
 * </pre>
 *
 * @author tanshunlong
 * @since 2020-05-20
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ShipmentChildren对象", description = "")
public class ShipmentChildren extends BaseEntity {

    private static final long serialVersionUID = 1L;

@TableId(value = "id", type = IdType.UUID)
    private String id;

    @ApiModelProperty(value = "父ID")
    private String parentId;

    @ApiModelProperty(value = "重量")
    private Double weight;

}
