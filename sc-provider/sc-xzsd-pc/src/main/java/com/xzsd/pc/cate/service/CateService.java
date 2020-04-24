package com.xzsd.pc.cate.service;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.cate.dao.CateDao;
import com.xzsd.pc.cate.entity.CateInfo;
import com.xzsd.pc.cate.entity.Tree;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Embrace
 * @date 2020/3/27 16:33
 */
@Service
public class CateService {
    @Resource
    private CateDao cateDao;
//    @Resource
//    private ProducerController producerController;

    /**
     * 新增分类
     * @param cateInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addCate(CateInfo cateInfo){
        cateInfo.setCateId(StringUtil.getCommonCode(2));
        cateInfo.setIsDeleted(0);
        cateInfo.setCreateBy(SecurityUtils.getCurrentUserId());
        int num=cateDao.countCateByName(cateInfo.getCateName());
//        producerController.sendQueue(cateInfo);
        //新增
        if(num==0){
            int count=cateDao.addCate(cateInfo);
            if(0==count){
                return AppResponse.bizError("新增失败，请重试");
            }
            return AppResponse.success("新增成功");
        }
        else {
            return AppResponse.repeat("分类已存在");
        }
    }
    /**
     * 查询分类列表
     * 重写
     * @return
     */
//    public AppResponse getCate(){
//        List<CateInfo> infos=cateDao.getCate();
//        for (CateInfo cateP : infos) {
//           List<cateParentInfo> cateInfoList=cateDao.findCateById(cateP.getCateId());
//           cateP.setCi(cateInfoList);
//        }
//
//        return AppResponse.success("get",infos);
//    }
    public Map<String,Object> listCate(String rootId) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 查询全部菜单
        List<CateInfo> cateInfoList = cateDao.listMenus();
        Tree rootTree = new Tree();
        // 格式化菜单成树结构
        initTree(rootTree, cateInfoList, rootId);
        map.put("cateTree",rootTree.getChildren());
        return map;
    }
    private void initTree(Tree rootTree, List<CateInfo> cateInfoList, String selfCode){
        Iterator<CateInfo> menuIterator = cateInfoList.iterator();
        while(menuIterator.hasNext()){
            CateInfo temp = menuIterator.next();
            //初始化自身节点
            if(temp.getCateId().equals(selfCode)){
                cateToTree(temp,rootTree);
            }else if(temp.getCateIdParent().equals(selfCode)){
                //初始化子节点
                Tree children = new Tree();
                cateToTree(temp,children);
                rootTree.getChildren().add(children);
                //递归
                initTree(children,cateInfoList,temp.getCateId());
            }
        }
    }
    private void cateToTree(CateInfo cateInfo, Tree tree){
        tree.setId(cateInfo.getCateId());
        tree.setVersion(cateInfo.getVersion());
        tree.setPid(cateInfo.getCateIdParent());
        tree.setLabel(cateInfo.getCateName());
        tree.setAttributes(cateInfo);
    }
    /**
     * 删除分类
     * @param cateId
     * @return
     */
    public AppResponse delectCateById(String cateId){
        int count=cateDao.chekChiById(cateId);
        String lastModifiedBy=SecurityUtils.getCurrentUserId();
        if(count==0){
            int num=cateDao.delectCateById(cateId,lastModifiedBy);
            if(num>0){
                return AppResponse.success("删除成功");
            }
            else {
                return AppResponse.bizError("删除失败");
            }
        }else {
            return AppResponse.bizError("存在子类，删除失败");
        }
    }

    /**
     * 修改分类
     * @param cateInfo
     * @return
     */
    public AppResponse updateCateById(CateInfo cateInfo){
        String lastModifiedBy=SecurityUtils.getCurrentUserId();
        cateInfo.setLastModifiedBy(lastModifiedBy);
        int count=cateDao.updateCateById(cateInfo);
        if(count==0){
            return AppResponse.bizError("修改失败");
        }
        else {
            return AppResponse.success("修改成功");
        }
    }

    /**
     * 查询商品分类详情
     * @param cateId
     * @return
     */
    public AppResponse findCateById(String cateId){
        CateInfo cateInfo=cateDao.getCateById(cateId);
        if(cateInfo==null){
            return AppResponse.bizError("查询失败");
        }else {
            return AppResponse.success("查询成功",cateInfo);
        }
    }
}
