package com.mis.flowers.service.impl;

import com.mis.flowers.dto.OrdersDto;
import com.mis.flowers.dto.makeOrdersDto;
import com.mis.flowers.entity.Orders;
import com.mis.flowers.dao.OrdersDao;
import com.mis.flowers.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单表(Orders)表服务实现类
 *
 * @author wanghuan
 * @since 2020-04-13 11:15:41
 */
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersDao ordersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param orderid 主键
     * @return 实例对象
     */
    @Override
    public Orders queryById(String orderid) {
        return this.ordersDao.queryById(orderid);
    }


    public List<Orders> selectByUserId(Integer userId) {
        return this.ordersDao.selectByUserId(userId);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    @Override
    public List<Orders> selectAll() {
        return this.ordersDao.selectAll();
    }
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Orders> queryAllByLimit(int offset, int limit) {
        return this.ordersDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dto 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean insert(makeOrdersDto dto) {
        return this.ordersDao.insert(dto) > 0;
    }

    /**
     * 修改数据
     *
     * @param dto 实例对象
     * @return 实例对象
     */
    @Override
    public Orders update(OrdersDto dto) {
        this.ordersDao.update(dto);
        return this.queryById(dto.getOrderid());
    }

    /**
     * 通过主键删除数据
     *
     * @param orderid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String orderid) {
        return this.ordersDao.deleteById(orderid) > 0;
    }
}