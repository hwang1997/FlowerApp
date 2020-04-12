package com.mis.flowers.service;

import com.mis.flowers.dto.GoodsDto;
import com.mis.flowers.entity.Goods;
import java.util.List;

/**
 * 商品表(Goods)表服务接口
 *
 * @author wanghuan
 * @since 2020-04-12 14:45:36
 */
public interface GoodsService {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsid 主键
     * @return 实例对象
     */
    Goods queryById(Integer goodsid);

    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<Goods> selectAll();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Goods> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    Goods insert(Goods goods);

    /**
     * 修改数据
     *
     * @param dto 实例对象
     * @return 实例对象
     */
    Goods update(GoodsDto dto);

    /**
     * 通过主键删除数据
     *
     * @param goodsid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer goodsid);

}