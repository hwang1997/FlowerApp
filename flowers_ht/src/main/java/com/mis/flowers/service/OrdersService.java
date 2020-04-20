package com.mis.flowers.service;

import com.mis.flowers.dto.OrdersDto;
import com.mis.flowers.dto.makeOrdersDto;
import com.mis.flowers.entity.Orders;
import java.util.List;

/**
 * 订单表(Orders)表服务接口
 *
 * @author wanghuan
 * @since 2020-04-13 11:15:41
 */
public interface OrdersService {

    /**
     * 通过ID查询单条数据
     *
     * @param orderid 主键
     * @return 实例对象
     */
    Orders queryById(String orderid);


    List<Orders> selectBuyUserId(Integer userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Orders> queryAllByLimit(int offset, int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<Orders> selectAll();

    /**
     * 新增数据
     *
     * @param dto 实例对象
     * @return 实例对象
     */
    Boolean insert(makeOrdersDto dto);

    /**
     * 修改数据
     *
     * @param dto 实例对象
     * @return 实例对象
     */
    Orders update(OrdersDto dto);

    /**
     * 通过主键删除数据
     *
     * @param orderid 主键
     * @return 是否成功
     */
    boolean deleteById(String orderid);

}