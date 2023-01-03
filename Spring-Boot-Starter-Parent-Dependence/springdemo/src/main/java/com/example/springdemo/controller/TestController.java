package com.example.springdemo.controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @program:test
 * @description:test
 * @author:jonlin
 * @create:2023/1/3 22:52
 */

@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * apache poi-ooxml导出样例
     */
    @GetMapping("/exportApache")
    public void exportApache(HttpServletResponse response) throws IOException {
//        Workbook workbook = new HSSFWorkbook();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row = sheet.createRow(1);
        Cell cell = row.createCell(1);
        cell.setCellValue("1,1");

        String fileName = URLEncoder.encode("测试.xls", "utf-8");
        if (workbook instanceof XSSFWorkbook) {
            fileName = fileName + "x";
        }

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename="+ fileName);
        OutputStream out = response.getOutputStream();
        workbook.write(out);
        out.flush();
        out.close();
    }
}
