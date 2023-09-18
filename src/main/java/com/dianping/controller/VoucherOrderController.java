package com.dianping.controller;

import com.dianping.dto.Result;
import com.dianping.service.IVoucherOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 前端控制器
 */
@Controller
@RequestMapping("/voucher-order")
public class VoucherOrderController {

    @Resource
    private IVoucherOrderService voucherOrderService;

    @PostMapping("/seckill/{id}")
    public Result seckillVoucher(Long voucherId) {
        return voucherOrderService.seckillVoucher(voucherId);
    }
}
