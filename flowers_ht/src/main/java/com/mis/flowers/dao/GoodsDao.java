package com.mis.flowers.dao;

import com.mis.flowers.dto.GoodsDto;
import com.mis.flowers.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 商品表(Goods)表数据库访问层
 *
 * @author wanghuan
 * @since 2020-04-12 14:45:36
 */
@Mapper
public interface GoodsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsid 主键
     * @return 实例对象
     */
    Goods queryById(Integer goodsid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Goods> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param goods 实例对象
     * @return 对象列表
     */
    List<Goods> queryAll(Goods goods);

    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<Goods> selectAll();
    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 影响行数
     */
    int insert(Goods goods);

    /**
     * 修改数据
     *
     * @param dto 实例对象
     * @return 影响行数
     */
    int update(GoodsDto dto);

    /**
     * 通过主键删除数据
     *
     * @param goodsid 主键
     * @return 影响行数
     */
    int deleteById(Integer goodsid);

}