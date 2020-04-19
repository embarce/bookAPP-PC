package com.xzsd.app.clientShopCart.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.app.clientShopCart.dao.ShopCartDao;
import com.xzsd.app.clientShopCart.entity.ShopCartInfo;
import com.xzsd.app.clientShopCart.entity.ShopCartVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Embrace
 * @date 2020/4/19 21:18
 */
@Service
public class ShopCartService {
    @Resource
    private ShopCartDao shopCartDao;

    /**
     * 加入购物车
     * @param shopCartInfo
     * @return
     */
    public AppResponse addShopCart(ShopCartInfo shopCartInfo){
        int count=shopCartDao.countByGoodsId(shopCartInfo.getGoodsId());
        if(0==count){
            shopCartInfo.setShoppingCartCode(StringUtil.getCommonCode(2));
            shopCartInfo.setUserCode(SecurityUtils.getCurrentUserId());
            int num=shopCartDao.addShopCart(shopCartInfo);
            if(0!=num){
                return AppResponse.success("购物车新增成功");
            }else {
                return AppResponse.bizError("新增失败");
            }
        }else {
            return AppResponse.repeat("商品已存在");
        }
    }

    /**
     * 查询购物车列表
     * @return
     */
    public AppResponse listShoppingCarts(){
        List<ShopCartVO> list=shopCartDao.listShoppingCarts(SecurityUtils.getCurrentUserId());
        if(null!=list){
            return AppResponse.success("查询成功",list);
        }else {
            return AppResponse.bizError("查询失败");
        }
    }
}
