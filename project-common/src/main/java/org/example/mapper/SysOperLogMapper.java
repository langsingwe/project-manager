package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.entity.SysOperLog;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className SysOperLogMapper
 * @date 2021.11.04
 */
@Mapper
public interface SysOperLogMapper extends BaseMapper<SysOperLog> {
}
