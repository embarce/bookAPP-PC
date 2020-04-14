package com.xzsd.pc.menu.dao;

import com.xzsd.pc.menu.entity.MenuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface MenuDao {
    List<MenuInfo> listMenu();
    int findMenuByName(@Param("menuName")String menuName);
    int addMenu(MenuInfo menuInfo);
    int checkRole(@Param("userId")String userId);
    int deleteMenu(@Param("menuCode")String menuCode,@Param("userId") String userId);
}
