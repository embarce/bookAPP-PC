package com.xzsd.pc.goods.dao;


import com.xzsd.pc.goods.entity.classifVO;
import com.xzsd.pc.goods.entity.goodsInfo;
import com.xzsd.pc.goods.entity.goodsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @ClassName GoodsDao
 * @Description goods
 * @author 72937
 * @Date 2020-03-24
 */
public interface GoodsDao {
    /**
     * 查看是否存在商品
     * @param bookId 商品信息
     * @return
     */
    int countgoodsBybookId(@Param("bookId") String bookId);
    /**
     * 新增商品
     * @param  goodsInfo
     * @return
     */
    int addGoods(goodsInfo goodsInfo);
    /**
     * 查询商品列表
     * @Param goodsInfo 商品信息
     * @return 商品信息列表
     */
    List<goodsVO> listGoodsByPage(goodsInfo goodsInfo);

    /**
     *删除商品信息
     * @param listCode
     * @param userId
     * @return
     */
    int deleteGoods(@Param("listCode") List<String> listCode, @Param("goodId") String userId);

    /**
     * 修改商品信息
     * @author 7293747
     * @Date 2020-3-25
     * @param goodsInfo
     * @return
     */
    int updateGoods(goodsInfo goodsInfo);

    /**
     * 查询商品详情
     * @Date 2020-3-26
     * @param goodsId
     * @return
     */
    goodsInfo getGoodsByGoodsId(@Param("goodsId") String goodsId);
    /**
     * 上架商品
     * @author 7293747
     * @Date 2020-3-25
     * @param listCode,userId
     * @return
     */
    int updateGoodsUpper(@Param("listCode") List<String> listCode, @Param("goodId") String userId);
    /**
     * 下架商品
     * @author 7293747
     * @Date 2020-3-25
     * @param listCode,userId
     * @return
     */
    int updateGoodsLower(@Param("listCode") List<String> listCode, @Param("goodId") String userId);
    List<classifVO> listGoodsClassify();
    List<classifVO> listGoodsClassifyByPid(@Param("classifyId") String classifyId);
}
