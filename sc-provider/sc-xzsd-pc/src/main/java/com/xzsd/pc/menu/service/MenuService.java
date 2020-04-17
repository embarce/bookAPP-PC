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
            return AppResponse.repeat("菜单已存在");
        }
    }

    /**
     * 查询菜单，根据权限来查询
     * @return
     */
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
    //findMenuById
    public AppResponse findMenuById(String menuCode){
        MenuInfo menuInfo=menuDao.findMenuById(menuCode);
        if(menuInfo==null){
            return AppResponse.bizError("查询失败");
        }else {
            return AppResponse.success("查询成功",menuInfo);
        }
    }
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateMenu (MenuInfo menuInfo){
        String userId=SecurityUtils.getCurrentUserId();
        menuInfo.setLastModifiedBy(userId);
        int num=menuDao.updateMenu(menuInfo);
        if(0==num){
            return AppResponse.bizError("修改失败");
        }else {
            return AppResponse.success("修改成功");
        }
    }
}
