package com.example.demo.service;

import com.example.demo.DTO.DataTree;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataTreeService {


    public DataTree buildTree(List<DataTree> nodes, String rootCombineXpath, String rootDisplayName) {

        nodes.sort(Comparator.comparingInt(o -> o.getCombineXpath().split("\\\\").length));

        // 根節點
        DataTree root = new DataTree(rootCombineXpath, rootDisplayName, new ArrayList<>());

        int preLen = 0;
        List<DataTree> currentChildren = new ArrayList<>();
        List<DataTree> parentChildren = new ArrayList<>();
        parentChildren.add(root);

        // 遍歷所有節點
        for (DataTree node : nodes) {
            String displayName = node.getDisplayName();
            String combineXpath = node.getCombineXpath();
            int currentLen = combineXpath.split("\\\\").length;
            boolean flag = false;

            DataTree dataTree = new DataTree(combineXpath, displayName, new ArrayList<>());
            // 第一筆直接塞入
            if (preLen == 0) { // \config\A
                currentChildren.add(dataTree);
                root.setChildren(currentChildren);
                preLen = currentLen;
            } else {
                String parentXpath = getParentXpath(combineXpath);
                if (preLen == currentLen) {  // \config\B
                    for (DataTree child : parentChildren) {
                        if (child.getCombineXpath().equals(parentXpath)) { // 找相同父節點路徑
                            currentChildren.add(dataTree);
                            child.addChildren(dataTree);
                            flag = true;
                            break;
                        }
                    }

                    if (!flag) {
                        currentChildren.add(dataTree);
                    }

                } else {        // \config\A\B
                    parentChildren = currentChildren; // 重新設定父節點資料
                    currentChildren = new ArrayList<>(); // 清空當前節點資料
                    for (DataTree child : parentChildren) {
                        if (child.getCombineXpath().equals(parentXpath)) { // 找相同父節點路徑
                            currentChildren.add(dataTree);
                            child.addChildren(dataTree);
                            preLen = currentLen;
                            break;
                        }
                    }
                }
            }
        }

        return root;
    }

    // 獲取父節點的 combineXpath
    private static String getParentXpath(String combineXpath) {
        int lastSlashIndex = combineXpath.lastIndexOf("\\");
        return lastSlashIndex == -1 ? "" : combineXpath.substring(0, lastSlashIndex);
    }

}
