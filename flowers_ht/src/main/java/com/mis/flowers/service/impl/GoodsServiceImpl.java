package com.mis.flowers.service.impl;

import com.mis.flowers.dto.GoodsDto;
import com.mis.flowers.entity.Goods;
import com.mis.flowers.dao.GoodsDao;
import com.mis.flowers.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品表(Goods)表服务实现类
 *
 * @author wanghuan
 * @since 2020-04-12 14:45:36
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    @Override
    public List<Goods> selectAll() {
        return this.goodsDao.selectAll();
    }
    /**
     * 通过ID查询单条数据
     *
     * @param goodsid 主键
     * @return 实例对象
     */
    @Override
    public Goods queryById(Integer goodsid) {
        return this.goodsDao.queryById(goodsid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Goods> queryAllByLimit(int offset, int limit) {
        return this.goodsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Goods insert(Goods goods) {
        this.goodsDao.insert(goods);
        return goods;
    }

    /**
     * 修改数据
     *
     * @param dto 实例对象
     * @return 实例对象
     */
    @Override
    public Goods update(GoodsDto dto) {
        this.goodsDao.update(dto);
        return this.queryById(dto.getGoodsid());
    }

    /**
     * 通过主键删除数据
     *
     * @param goodsid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer goodsid) {
        return this.goodsDao.deleteById(goodsid) > 0;
    }
}