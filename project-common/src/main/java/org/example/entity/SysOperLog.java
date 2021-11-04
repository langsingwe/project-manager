package org.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className TbSysOperLog
 * @date 2021.10.11
 */
@Data
@TableName("tb_sys_oper_log")
public class SysOperLog {
    private String id;
    private String title;
    private int businessType;
    private String method;
    private String requestMethod;
    private int operatorType;
    private String operName;
    private String operId;
    private String deptName;
    private String deptId;
    private String operIp;
    private String operUrl;
    private String operLocation;
    private String operParam;
    private String jsonResult;
    private int status;
    private String errorMsg;
    private Date operTime;
}
