package com.hermes.testopt.modules.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 *  查询结果对象
 * </pre>
 *
 * @author tanshunlong
 * @date 2020-05-20
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ShipmentQueryVo对象", description = "查询参数")
public class ShipmentQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

private String id;

    @ApiModelProperty(value = "批次")
    private int batch;

    @ApiModelProperty(value = "总重量")
    private Double totalWeight;

}
