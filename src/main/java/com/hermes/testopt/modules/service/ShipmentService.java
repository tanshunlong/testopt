package com.hermes.testopt.modules.service;

import com.hermes.testopt.modules.entity.Shipment;
import com.hermes.commons.service.BaseService;
import com.hermes.testopt.modules.param.ShipmentQueryParam;
import com.hermes.testopt.modules.vo.ShipmentQueryVo;
import com.hermes.commons.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 *  服务类
 * </pre>
 *
 * @author tanshunlong
 * @since 2020-05-20
 */
public interface ShipmentService extends BaseService<Shipment> {

    /**
     * 保存
     *
     * @param shipment
     * @return
     * @throws Exception
     */
    boolean saveShipment(Shipment shipment) throws Exception;

    /**
     * 修改
     *
     * @param shipment
     * @return
     * @throws Exception
     */
    boolean updateShipment(Shipment shipment) throws Exception;

}
