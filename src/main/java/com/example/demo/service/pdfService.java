package com.example.demo.service;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/***
 * pdf 文件合并
 */
@Service
public class pdfService {
//    public static void main(String[] args) throws FileNotFoundException {
//        // 合并后pdf存放路径
//        String bothPath =  "D:\\liuyaxian\\ceshi";
//
//        //这是需要合并的PDF文件
//        List<String> files = new ArrayList<>();
//        files.add("http://pdf.dfcfw.com/pdf/H2_AN202104261487858088_1.pdf");
//        files.add("http://pdf.dfcfw.com/pdf/H2_AN202104211486808801_1.pdf");
//        files.add("http://pdf.dfcfw.com/pdf/H2_AN202103311479199009_1.pdf");
//        files.add("http://pdf.dfcfw.com/pdf/H2_AN202012311445616982_1.pdf");
//        mergePdfFiles(files, bothPath);
//    }


    public   void mergePdfFiles(List<String> files, String bothPath) throws FileNotFoundException {
        //pdf合并工具类
        PDFMergerUtility mergePdf = new PDFMergerUtility();
        //合并pdf生成的文件名
        String destinationFileName = System.currentTimeMillis()+".pdf";


        File file3 = new File(bothPath);
        try{
            if(!file3.exists()){
                file3.mkdirs();
            }
        }catch(Exception e1){
            e1.printStackTrace();
        }
        for (String file : files) {
            mergePdf.addSource(file);
        }
        //设置合并生成pdf文件名称
        mergePdf.setDestinationFileName(bothPath + File.separator + destinationFileName);
        //合并pdf
        try {
            try {
                mergePdf.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("pdf文件合并成功");
    }
}
