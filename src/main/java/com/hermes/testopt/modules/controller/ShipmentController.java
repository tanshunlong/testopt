package com.hermes.testopt.modules.controller;

import com.hermes.testopt.modules.entity.Shipment;
import com.hermes.testopt.modules.service.ShipmentService;
import com.hermes.testopt.modules.param.ShipmentQueryParam;
import com.hermes.testopt.modules.vo.ShipmentQueryVo;
import com.hermes.commons.api.ApiResult;
import com.hermes.commons.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

import com.hermes.commons.vo.Paging;

/**
 * <pre>
 *  前端控制器
 * </pre>
 *
 * @author tanshunlong
 * @since 2020-05-20
 */
@Slf4j
@RestController
@RequestMapping("/shipment")
@Api(" API")
public class ShipmentController extends BaseController {

    @Autowired
    private ShipmentService shipmentService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加Shipment对象", notes = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addShipment(@Valid @RequestBody Shipment shipment) throws Exception {
        boolean flag = shipmentService.saveShipment(shipment);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改Shipment对象", notes = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateShipment(@Valid @RequestBody Shipment shipment) throws Exception {
        boolean flag = shipmentService.updateShipment(shipment);
        return ApiResult.result(flag);
    }


}

