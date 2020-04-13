package com.mis.flowers.controller;

import com.mis.flowers.entity.Orders;
import com.mis.flowers.service.OrdersService;
import com.mis.flowers.util.Page;
import com.mis.flowers.util.Result;
import com.mis.flowers.util.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单表(Orders)表控制层
 *
 * @author wanghuan
 * @since 2020-04-13 11:15:41
 */
@RestController
@RequestMapping("orders")
public class OrdersController {
    /**
     * 服务对象
     */
    @Resource
    private OrdersService ordersService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Orders selectOne(Integer id) {
        return this.ordersService.queryById(id);
    }

    //分页查询
    @RequestMapping(value = "selectByPage", method = RequestMethod.GET)
    public Result<Page<Orders>> selectByPage(int page, int limit) {
      try {
          List<Orders> list = this.ordersService.queryAllByLimit((page-1)*limit,limit);

          Integer count = this.ordersService.selectAll().size();
          Page<Orders> goodsPage = new Page<Orders>(list,count);
          return Result.createSuccess(goodsPage);
      }catch (Exception e){
          e.printStackTrace();
          return Result.createFailUre(ResultCode.Fail.code(),"失败");
      }
    }

    /**
     * 通过userId查询单条数据
     *
     * @param ordersId 主键
     * @return 单条数据
     */
    @RequestMapping(value = "ordersDoSearch", method = RequestMethod.GET)
    public Result<List<Orders>> userDoSearch(String ordersId) {
        try {
            List<Orders> orders = new ArrayList<>();
            orders.add(this.ordersService.queryById(Integer.parseInt(ordersId)));
            return Result.createSuccess(orders);
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.Fail.code(),"搜索失败！");
        }
    }

}