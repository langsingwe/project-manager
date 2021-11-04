package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.aop.Log;
import org.example.enums.BusinessType;
import org.example.enums.OperatorType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className TestController
 * @date 2021.11.04
 */
@Slf4j
@RestController
@RequestMapping("/index")
public class TestController {

    @Log(title = "测试接口", businessType = BusinessType.SELECT, operatorType = OperatorType.MANAGE, isSaveRequestData = true)
    @GetMapping("/test")
    public String test() {
        return "ok";
    }
}
