package com.example.demo.controller;

import com.example.demo.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ResponseTestController {

    @Autowired
    private com.example.demo.service.pdfService pdfService;

    @ResponseBody
    @GetMapping("/getperson")
 public Person getPerson(){
     Person person = new Person( "33","222", 34);
     return person;
 }

    @ResponseBody
    @GetMapping("/pdf")
    public String mergePdfFiles() throws FileNotFoundException {
            // 合并后pdf存放路径
            String bothPath =  "D:\\liuyaxian\\ceshi";
            //这是需要合并的PDF文件
            List<String> files = new ArrayList<>();
                files.add("E:\\Downloads\\H2_AN202104261487858088_1.pdf");
                files.add("E:\\Downloads\\H2_AN202104211486808801_1.pdf");
                files.add("E:\\Downloads\\H2_AN202103311479199009_1.pdf");
                pdfService.mergePdfFiles(files, bothPath);
                return "success";
        }
}

