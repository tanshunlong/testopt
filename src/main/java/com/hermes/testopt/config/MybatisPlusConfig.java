package com.hermes.testopt.config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.hermes.commons.config.MybatisPlusConfigurationAdapter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.hermes.testopt.*.mapper", "com.hermes.testopt.repository"}, markerInterface = BaseMapper.class)
@ConditionalOnClass(value = {PaginationInterceptor.class})
public class MybatisPlusConfig extends MybatisPlusConfigurationAdapter {
}
