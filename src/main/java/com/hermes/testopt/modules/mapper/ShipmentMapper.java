package com.hermes.testopt.modules.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hermes.testopt.modules.entity.Shipment;
import com.hermes.testopt.modules.param.ShipmentQueryParam;
import com.hermes.testopt.modules.vo.ShipmentQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 *  Mapper 接口
 * </pre>
 *
 * @author tanshunlong
 * @since 2020-05-20
 */
@Repository
public interface ShipmentMapper extends BaseMapper<Shipment> {

}
