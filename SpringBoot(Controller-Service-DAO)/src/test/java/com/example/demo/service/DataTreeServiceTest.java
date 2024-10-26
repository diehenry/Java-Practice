package com.example.demo.service;

import com.example.demo.DTO.DataTree;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class DataTreeServiceTest {

    @Autowired
    private DataTreeService dataTreeService;

    @Test
    public void buildTree() throws Exception{
        List<DataTree> dataTrees = Arrays.asList(
                new DataTree("\\config\\A", "A", new ArrayList<>()),
                new DataTree("\\config\\A\\A", "A\\A", new ArrayList<>()),
                new DataTree("\\config\\A\\B", "A\\B", new ArrayList<>()),
                new DataTree("\\config\\A\\C", "A\\C", new ArrayList<>()),
                new DataTree("\\config\\A\\A\\pay", "A\\A\\pay", new ArrayList<>()),
                new DataTree("\\config\\A\\B\\play", "A\\B\\play", new ArrayList<>()),
                new DataTree("\\config\\A\\C\\play", "A\\C\\play", new ArrayList<>()),
                new DataTree("\\config\\B", "B", new ArrayList<>()),
                new DataTree("\\config\\B\\A", "B\\A", new ArrayList<>()),
                new DataTree("\\config\\C\\A", "C\\A", new ArrayList<>()),
                new DataTree("\\config\\C", "C", new ArrayList<>())
        );


        DataTree d = dataTreeService.buildTree(dataTrees, "Auto", "Auto");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(d);
        System.out.println(json);
    }
}