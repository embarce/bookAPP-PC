package com.xzsd.pc.hotGoods.dao;

import com.xzsd.pc.hotGoods.entity.ChoseHotsGoodsVO;
import com.xzsd.pc.hotGoods.entity.HotGoodsDO;
import com.xzsd.pc.hotGoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotGoods.entity.HotGoodsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotGoodsDao {
    /**
     * 根据商品id查个数
     * @param goodsId
     * @return
     */
    int countHotGoods(String goodsId);
    int findNumByNum(int num);

    /**
     * 新增热门位
     * @param hotGoodsInfo
     * @return
     */
    int addHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 选择商品列表接口
     * @param choseHotsGoodsVO
     * @return
     */
    List<ChoseHotsGoodsVO> choseGoods(ChoseHotsGoodsVO choseHotsGoodsVO);

    /**
     * 修改展示数量
     * @param num
     * @return
     */
    int changeShowNum(@Param("num") String num,@Param("userId") String userId);

    /**
     * 删除接口
     * @param hotGoodsId
     * @param userId
     * @return
     */
    int deleteHotGoods(@Param("hotGoodsId") List<String> hotGoodsId,@Param("userId") String userId);
    int updateHotGoodsById(HotGoodsDO hotGoodsDO);
    List<HotGoodsVO> listHotGoodsByPage(@Param("goodsId") String goodsId,@Param("goodsName") String goodsName);
}
