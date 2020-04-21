package com.xzsd.app.clientShopCart.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.app.clientShopCart.dao.ShopCartDao;
import com.xzsd.app.clientShopCart.entity.ShopCartInfo;
import com.xzsd.app.clientShopCart.entity.ShopCartVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
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
     *
     * @param shopCartInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addShopCart(ShopCartInfo shopCartInfo) {
        int count = shopCartDao.countByGoodsId(shopCartInfo.getGoodsId());
        if (0 == count) {
            shopCartInfo.setShoppingCartCode(StringUtil.getCommonCode(2));
            shopCartInfo.setUserCode(SecurityUtils.getCurrentUserId());
            shopCartInfo.setPrice(shopCartDao.getPrice(shopCartInfo.getGoodsId()));
            int num = shopCartDao.addShopCart(shopCartInfo);
            if (0 != num) {
                return AppResponse.success("购物车新增成功");
            } else {
                return AppResponse.bizError("新增失败");
            }
        } else {
            return AppResponse.repeat("商品已存在");
        }
    }

    /**
     * 查询购物车列表
     *
     * @return
     */
    public AppResponse listShoppingCarts() {
        List<ShopCartVO> list = shopCartDao.listShoppingCarts(SecurityUtils.getCurrentUserId());
        if (null != list) {
            return AppResponse.success("查询成功", list);
        } else {
            return AppResponse.bizError("查询失败");
        }
    }

    /**
     * 修改购物车
     *
     * @param shopCartInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateShoppingCart(ShopCartInfo shopCartInfo) {
        shopCartInfo.setChangeName(SecurityUtils.getCurrentUserId());
        int num = shopCartDao.updateShoppingCart(shopCartInfo);
        if (0 == num) {
            return AppResponse.bizError("修改失败");
        } else {
            return AppResponse.success("修改成功");
        }
    }

    /**
     * 删除购物车
     *
     * @param listCode
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteShoppingCart(String listCode) {
        List<String> shoppingList = Arrays.asList(listCode.split(","));
        String userCode = SecurityUtils.getCurrentUserId();
        int num = shopCartDao.deleteShoppingCart(shoppingList, userCode);
        if (0 == num) {
            return AppResponse.bizError("删除失败");
        } else {
            return AppResponse.success("删除成功");
        }
    }
}
