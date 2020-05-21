package com.hermes.testopt.modules.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.hermes.commons.param.OrderQueryParam;

/**
 * <pre>
 *  查询参数对象
 * </pre>
 *
 * @author tanshunlong
 * @date 2020-05-20
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ShipmentChildrenQueryParam对象", description = "查询参数")
public class ShipmentChildrenQueryParam extends OrderQueryParam {
    private static final long serialVersionUID = 1L;
}
