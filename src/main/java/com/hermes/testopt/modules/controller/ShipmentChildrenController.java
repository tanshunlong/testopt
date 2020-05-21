package com.hermes.testopt.modules.controller;

import com.hermes.testopt.modules.entity.ShipmentChildren;
import com.hermes.testopt.modules.service.ShipmentChildrenService;
import com.hermes.commons.api.ApiResult;
import com.hermes.commons.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

import com.hermes.commons.vo.Paging;

import java.util.List;

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
@RequestMapping("/shipmentChildren")
@Api(" API")
public class ShipmentChildrenController extends BaseController {

    @Autowired
    private ShipmentChildrenService shipmentChildrenService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加ShipmentChildren对象", notes = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addShipmentChildren(@Valid @RequestBody ShipmentChildren shipmentChildren) throws Exception {
        boolean flag = shipmentChildrenService.saveShipmentChildren(shipmentChildren);
        return ApiResult.result(flag);
    }

    /**
     * 合并
     */
    @PostMapping("/merge")
    @ApiOperation(value = "合并ShipmentChildren对象", notes = "合并", response = ApiResult.class)
    public ApiResult<Boolean> mergeShipmentChildren(@Valid @RequestBody List<ShipmentChildren> shipmentChildrens) throws Exception {
        boolean flag = shipmentChildrenService.mergeShipmentChildren(shipmentChildrens);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改ShipmentChildren对象", notes = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateShipmentChildren(@Valid @RequestBody ShipmentChildren shipmentChildren) throws Exception {
        boolean flag = shipmentChildrenService.updateShipmentChildren(shipmentChildren);
        return ApiResult.result(flag);
    }

}

