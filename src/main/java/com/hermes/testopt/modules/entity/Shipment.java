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
@ApiModel(value = "Shipment对象", description = "")
public class Shipment extends BaseEntity {

    private static final long serialVersionUID = 1L;

@TableId(value = "id", type = IdType.UUID)
    private String id;

    @ApiModelProperty(value = "批次")
    private int batch;

    @ApiModelProperty(value = "总重量")
    private Double totalWeight;

}
