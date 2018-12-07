package com.az.dlxj.common.util;

import com.az.dlxj.common.domain.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : az
 * @Create : 2018-12-07 19:46
 * @Desc :
 */
public class BuildTree {


    public static <T> List<Tree<T>> build(List<Tree<T>> nodes,String rootId){
        if(nodes == null){
            return null;
        }

        List<Tree<T>> rootNodes = new ArrayList<>();

        for (Tree<T> child : nodes) {
            String pid = child.getParentId();
            if(pid == null || pid.equals(rootId)){
                // 添加根节点
                rootNodes.add(child);
                continue;
            }

            for (Tree<T> parent : nodes) {
                String id = parent.getId();
                if(id != null && id.equals(pid)){
                    // 添加子节点
                    child.setHasParent(true);
                    parent.getChildren().add(child);
                    parent.setHasChildren(true);
                    continue;
                }
            }
        }

        return rootNodes;
    }


}
