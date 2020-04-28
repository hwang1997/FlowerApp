package com.mis.flowers.dao;

import com.mis.flowers.dto.OrdersDto;
import com.mis.flowers.dto.makeOrdersDto;
import com.mis.flowers.entity.Orders;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 订单表(Orders)表数据库访问层
 *
 * @author wanghuan
 * @since 2020-04-13 11:15:41
 */
public interface OrdersDao {

    /**
     * 通过ID查询单条数据
     *
     * @param orderid 主键
     * @return 实例对象
     */
    Orders queryById(String orderid);


    List<Orders> selectByUserId(Integer userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Orders> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param orders 实例对象
     * @return 对象列表
     */
    List<Orders> queryAll(Orders orders);

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
     * @return 影响行数
     */
    int insert(makeOrdersDto dto);

    /**
     * 修改数据
     *
     * @param dto 实例对象
     * @return 影响行数
     */
    Boolean update(OrdersDto dto);

    /**
     * 通过主键删除数据
     *
     * @param orderid 主键
     * @return 影响行数
     */
    int deleteById(String orderid);

}