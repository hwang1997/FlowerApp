package com.mis.flowers.controller;

import com.mis.flowers.dto.GoodsDto;
import com.mis.flowers.dto.OrdersDto;
import com.mis.flowers.dto.makeOrdersDto;
import com.mis.flowers.entity.Goods;
import com.mis.flowers.entity.Orders;
import com.mis.flowers.entity.Users;
import com.mis.flowers.service.GoodsService;
import com.mis.flowers.service.OrdersService;
import com.mis.flowers.service.UsersService;
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
    public UsersService usersService;
    public GoodsService goodsService;

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
            orders.add(this.ordersService.queryById(ordersId));
            return Result.createSuccess(orders);
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.Fail.code(),"搜索失败！");
        }
    }
    @RequestMapping(value = "updateOrders",method = RequestMethod.POST)
    public Result<Boolean> updateGoods(OrdersDto dto) {
        try {
            this.ordersService.update(dto);
            return Result.createSuccess();
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.Fail.code(),"失败");
        }
    }

    @RequestMapping(value = "makeOrders",method = RequestMethod.POST)
    public Result<Integer> makeOrders(makeOrdersDto dto) {
        try {
            makeOrdersDto makeOrdersDto = new makeOrdersDto();
            makeOrdersDto.setOrderid(dto.getOrderid());
            this.ordersService.insert(dto);
            return Result.createSuccess();
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.Fail.code(),"失败");
        }
    }
    /**
     * 通过userId查询单条数据
     *
     * @param userId 主键
     * @return 单条数据
     */
    @RequestMapping(value = "selectBuyUserId", method = RequestMethod.POST)
    public Result<List<Orders>> selectBuyUserId(String userId) {
        try {
            List<Orders> orders = this.ordersService.selectBuyUserId(Integer.parseInt(userId));
            return Result.createSuccess(orders);
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.INTERNAL_SERVER_ERROR.code(),"内部错误！");
        }
    }

    /**
     * 通过userId查询单条数据
     *
     * @param userId 主键
     * @return 单条数据
     */
    @RequestMapping(value = "ordersDoSearchByUserId", method = RequestMethod.GET)
    public Result<List<Orders>> ordersDoSearchByUserId(String userId) {
        try {
            List<Orders> orders = this.ordersService.selectBuyUserId(Integer.parseInt(userId));
            return Result.createSuccess(orders);
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.Fail.code(),"搜索失败！");
        }
    }
    /**
     * 通过orderId删除单条数据
     *
     * @param orderId 主键
     * @return 单条数据
     */
    @RequestMapping(value = "deleteByOrderId", method = RequestMethod.POST)
    public Result<Boolean> deleteByOrderId(String orderId){
        try {
            this.ordersService.deleteById(orderId);
            return Result.createSuccess();
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.INTERNAL_SERVER_ERROR.code(), "服务器异常");
        }
    }
    @RequestMapping(value = "updateOrdersState",method = RequestMethod.POST)
    public Result<Boolean> updateOrdersState(String orderId, String state) {
        try {
            OrdersDto dto = new OrdersDto();
            dto.setOrderid(orderId);
            dto.setState(Integer.parseInt(state));
            this.ordersService.update(dto);
            return Result.createSuccess();
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.Fail.code(),"失败");
        }
    }

}