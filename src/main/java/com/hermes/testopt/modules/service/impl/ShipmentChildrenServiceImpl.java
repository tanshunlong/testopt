package com.hermes.testopt.modules.service.impl;

import com.hermes.testopt.modules.entity.Shipment;
import com.hermes.testopt.modules.entity.ShipmentChildren;
import com.hermes.testopt.modules.mapper.ShipmentChildrenMapper;
import com.hermes.testopt.modules.param.ShipmentChildrenQueryParam;
import com.hermes.testopt.modules.service.ShipmentChildrenService;
import com.hermes.commons.service.impl.BaseServiceImpl;
import com.hermes.commons.vo.Paging;
import com.hermes.testopt.modules.service.ShipmentService;
import com.hermes.testopt.modules.vo.ShipmentChildrenQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.util.List;


/**
 * <pre>
 *  服务实现类
 * </pre>
 *
 * @author tanshunlong
 * @since 2020-05-20
 */
@Slf4j
@Service
public class ShipmentChildrenServiceImpl extends BaseServiceImpl<ShipmentChildrenMapper, ShipmentChildren> implements ShipmentChildrenService {

    @Autowired
    private ShipmentChildrenMapper shipmentChildrenMapper;

    @Autowired
    private ShipmentService shipmentService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveShipmentChildren(ShipmentChildren shipmentChildren) throws Exception {
        return super.save(shipmentChildren);
    }

    @Override
    public boolean mergeShipmentChildren(List<ShipmentChildren> shipmentChildrens) throws Exception {
        Shipment shipment = new Shipment();
        int batch = shipmentChildrens.size();
        double totalWeight = 0;
        for(ShipmentChildren children:shipmentChildrens){
            totalWeight =totalWeight+children.getWeight();
        }
        shipment.setBatch(batch);
        shipment.setTotalWeight(totalWeight);
        return shipmentService.saveShipment(shipment);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateShipmentChildren(ShipmentChildren shipmentChildren) throws Exception {
        return super.updateById(shipmentChildren);
    }


}
