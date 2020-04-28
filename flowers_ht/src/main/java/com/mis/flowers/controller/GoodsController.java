package com.mis.flowers.controller;

import com.mis.flowers.dto.GoodsDto;
import com.mis.flowers.entity.Goods;
import com.mis.flowers.entity.Users;
import com.mis.flowers.service.GoodsService;
import com.mis.flowers.util.AppFileUtils;
import com.mis.flowers.util.Page;
import com.mis.flowers.util.Result;
import com.mis.flowers.util.ResultCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品表(Goods)表控制层
 *
 * @author wanghuan
 * @since 2020-04-12 14:45:36
 */
@RestController
@RequestMapping("goods")
public class GoodsController {
    /**
     * 服务对象
     */
    @Resource
    public GoodsService goodsService;

    //app显示所有数据
    @RequestMapping(value = "queryAllForApp",method = RequestMethod.GET)
    public Result<List<Goods>> queryAllForApp(){
        try {
            return Result.createSuccess(this.goodsService.selectAll());
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.Fail.code(),"失败");
        }
    }

    //分页查询
    @RequestMapping(value = "selectByPage", method = RequestMethod.GET)
    public Result<Page<Goods>> selectByPage(int page, int limit) {
        try {
            List<Goods> list = this.goodsService.queryAllByLimit((page-1)*limit,limit);
            Integer count = this.goodsService.selectAll().size();
            Page<Goods> goodsPage = new Page<Goods>(list,count);
            return Result.createSuccess(goodsPage);
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.Fail.code(),"搜索失败");
        }
    }
    /**
     * 通过goodsId查询单条数据
     * @param goodsId 主键
     * @return 单条数据
     */
    @RequestMapping(value = "goodsDoSearch", method = RequestMethod.GET)
    public Result<List<Goods>> userDoSearch(String goodsId) {
        try {
            List<Goods> goods = new ArrayList<>();
            goods.add(this.goodsService.queryById(Integer.parseInt(goodsId)));
            return Result.createSuccess(goods);
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.Fail.code(),"搜索失败！");
        }
    }
    /**
     *添加
     */
    @RequestMapping(value = "insertGoods",method = RequestMethod.POST)
    public Result<Integer> insertUsers(GoodsDto dto) {
        try {
            if (dto.getGoodsimg()!=null&&dto.getGoodsimg().endsWith("_temp")){
               String newName = AppFileUtils.renameFile(dto.getGoodsimg());
               dto.setGoodsimg(newName);
            }
            Goods goods = new Goods();
            goods.setGoodsname(dto.getGoodsname());
            goods.setGoodsprice(dto.getGoodsprice());
            goods.setGoodscount(dto.getGoodscount());
            goods.setGoodsdes(dto.getGoodsdes());
            goods.setGoodsimg(dto.getGoodsimg());
            this.goodsService.insert(goods);
            return Result.createSuccess();
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.Fail.code(),"失败");
        }
    }
    /**
     *
     *修改
     */
    @RequestMapping(value = "updateGoods",method = RequestMethod.POST)
    public Result<Boolean> updateGoods(GoodsDto dto) {
        try {
            //此时说明是默认图片
            if (!(dto.getGoodsimg()!=null&&dto.getGoodsimg().equals("images/1.png"))){
                if (dto.getGoodsimg().endsWith("_temp")){
                    String newName = AppFileUtils.renameFile(dto.getGoodsimg());
                    dto.setGoodsimg(newName);
                    //删除原先图片
                    String oldPath = this.goodsService.queryById(dto.getGoodsid()).getGoodsimg();
                    AppFileUtils.removeFileByPath(oldPath);
                }
            }
            this.goodsService.update(dto);
            return Result.createSuccess();
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.Fail.code(),"失败");
        }
    }
    @RequestMapping(value = "updateGoodsCount",method = RequestMethod.POST)
    public Result<Boolean> updateGoodsCount(GoodsDto dto) {
        try {
            this.goodsService.update(dto);
            return Result.createSuccess();
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.Fail.code(),"失败");
        }
    }
    //删除
    @RequestMapping(value = "deleteGoods", method = RequestMethod.DELETE)
    public Result<Boolean> deleteUsers(Integer goodsid, String goodsimg) {
        try {
            //删除原文件
            AppFileUtils.renameFile(goodsimg);
            this.goodsService.deleteById(goodsid);
            return Result.createSuccess();
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.Fail.code(), "删除失败!");
        }
    }
}