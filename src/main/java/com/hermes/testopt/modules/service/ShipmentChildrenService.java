package com.hermes.testopt.modules.service;

import com.hermes.testopt.modules.entity.ShipmentChildren;
import com.hermes.commons.service.BaseService;
import com.hermes.commons.vo.Paging;
import com.hermes.testopt.modules.param.ShipmentChildrenQueryParam;
import com.hermes.testopt.modules.vo.ShipmentChildrenQueryVo;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 *  服务类
 * </pre>
 *
 * @author tanshunlong
 * @since 2020-05-20
 */
public interface ShipmentChildrenService extends BaseService<ShipmentChildren> {

    /**
     * 保存
     *
     * @param shipmentChildren
     * @return
     * @throws Exception
     */
    boolean saveShipmentChildren(ShipmentChildren shipmentChildren) throws Exception;

    /**
     * 合并
     *
     * @param shipmentChildren
     * @return
     * @throws Exception
     */
    boolean mergeShipmentChildren(List<ShipmentChildren> shipmentChildren) throws Exception;

    /**
     * 修改
     *
     * @param shipmentChildren
     * @return
     * @throws Exception
     */
    boolean updateShipmentChildren(ShipmentChildren shipmentChildren) throws Exception;

}
