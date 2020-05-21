package com.hermes.testopt.modules.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hermes.testopt.modules.entity.Shipment;
import com.hermes.testopt.modules.entity.ShipmentChildren;
import com.hermes.testopt.modules.mapper.ShipmentChildrenMapper;
import com.hermes.testopt.modules.mapper.ShipmentMapper;
import com.hermes.testopt.modules.service.ShipmentChildrenService;
import com.hermes.testopt.modules.service.ShipmentService;
import com.hermes.testopt.modules.param.ShipmentQueryParam;
import com.hermes.testopt.modules.vo.ShipmentQueryVo;
import com.hermes.commons.service.impl.BaseServiceImpl;
import com.hermes.commons.vo.Paging;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
public class ShipmentServiceImpl extends BaseServiceImpl<ShipmentMapper, Shipment> implements ShipmentService {

    @Autowired
    private ShipmentMapper shipmentMapper;
    @Autowired
    private ShipmentChildrenService shipmentChildrenService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveShipment(Shipment shipment) throws Exception {
        int batch = shipment.getBatch();
        double weight = shipment.getTotalWeight()/batch;
        super.save(shipment);
        boolean flag = false;
        for(int i=0;i<batch;i++){
            ShipmentChildren children = new ShipmentChildren();
            children.setParentId(shipment.getId());
            children.setWeight(weight);
            shipmentChildrenService.save(children);
            flag = true;
        }
        return flag;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateShipment(Shipment shipment) throws Exception {
        double totalWeight = shipment.getTotalWeight();
        int batch = shipment.getBatch();
        double Weight = totalWeight/batch;
        List<ShipmentChildren> list = this.getList(shipment);
        for(ShipmentChildren children:list){
            children.setWeight(Weight);
            shipmentChildrenService.updateShipmentChildren(children);
        }
        return super.updateById(shipment);
    }

    public List<ShipmentChildren> getList(Shipment shipment) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(StringUtils.isNotBlank(shipment.getId())){
            queryWrapper.eq("parent_id",shipment.getId());
        }
        return shipmentChildrenService.list(queryWrapper);

    }

}
