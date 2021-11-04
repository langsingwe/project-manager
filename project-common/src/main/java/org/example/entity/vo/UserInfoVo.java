package org.example.entity.vo;

import lombok.Data;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className UserInfoVo
 * @date 2021.11.04
 */
@Data
public class UserInfoVo {

    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 证件号码
     */
    private String cardNo;


}
