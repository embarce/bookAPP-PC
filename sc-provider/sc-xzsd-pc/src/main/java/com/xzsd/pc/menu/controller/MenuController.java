package com.xzsd.pc.menu.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Embrace
 * @date 2020/4/14 22:47
 */
@RestController
@RequestMapping("/menus")
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
    @Resource
    private MenuService menuService;

    /**
     * 新增菜单
     * @param menuInfo
     * @return
     */
    @PostMapping("addMenu")
    public AppResponse addMenu(MenuInfo menuInfo){
        try {
            AppResponse appResponse=menuService.addMenu(menuInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("新增失败",e);
            throw e;
        }
    }

    /**
     * 查询菜单
     * @return
     */
    @RequestMapping(value="listMenu")
    public AppResponse listMenu(){
        try {
            AppResponse appResponse=menuService.listMenu();
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败",e);
            throw e;
        }
    }

    /**
     * 删除菜单
     * @param menuCode
     * @return
     */
    @PostMapping("deleteMenu")
    public AppResponse deleteMenu(String menuCode){
        try {
            AppResponse appResponse=menuService.deleteMenu(menuCode);
            return appResponse;
        }catch (Exception e){
            logger.error("删除失败",e);
            throw e;
        }
    }

    /**
     * 菜单详情
     * @param menuCode
     * @return
     */
    @PostMapping("findMenuById")
    public AppResponse findMenuById(String menuCode){
        try{
            AppResponse appResponse=menuService.findMenuById(menuCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败",e);
            throw e;
        }
    }
    /**
     * 修改菜单
     * updateMenu
     */
    @PostMapping("updateMenu")
    public AppResponse updateMenu(MenuInfo menuInfo){
        try {
            AppResponse appResponse=menuService.updateMenu(menuInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("修改失败",e);
            throw e;
        }
    }
}
