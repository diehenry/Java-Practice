package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataTree implements Serializable {
    private static final long serialVersionUID = 1L;
    private String combineXpath;
    private String displayName;
    private List<DataTree> children;

    public void addChildren(DataTree children) {
        this.children.add(children);
    }
}
