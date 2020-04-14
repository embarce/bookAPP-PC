package com.xzsd.pc.menu.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.menu.dao.MenuDao;
import com.xzsd.pc.menu.entity.MenuInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Embrace
 * @date 2020/4/14 22:48
 */
@Service
public class MenuService {
    @Resource
    private MenuDao menuDao;
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addMenu(MenuInfo menuInfo){
        int count=menuDao.findMenuByName(menuInfo.getMenuName());
        if(0==count){
            menuInfo.setMenuCode(StringUtil.getCommonCode(2));
            int num=menuDao.addMenu(menuInfo);
            if(0!=num){
                return AppResponse.success("新增成功");
            }else {
                return AppResponse.bizError("新增失败");
            }
        }else {
            return AppResponse.success("菜单已存在");
        }
    }
    public AppResponse listMenu(){
        List<MenuInfo> menuInfos=menuDao.listMenu();
        int role=menuDao.checkRole(SecurityUtils.getCurrentUserId());
        List<MenuInfo> list=new ArrayList<>();
        for (MenuInfo menuInfo : menuInfos) {
            if(menuInfo.getLevel()>=role){
                list.add(menuInfo);
            }
        }
        return AppResponse.success("查询菜单成功",list);
    }

    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteMenu(String menuCode){
        String userId=SecurityUtils.getCurrentUserId();
        int num=menuDao.deleteMenu(menuCode,userId);
        if(0==num){
            return AppResponse.bizError("删除失败");
        }else {
            return AppResponse.success("删除成功");
        }
    }
}
