package com.example.jxls.controller;

import com.example.jxls.domain.Settlement;
import com.example.jxls.service.JxlsService;
import com.example.jxls.util.ExcelUtil;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JxlsController {

    @Autowired
    private JxlsService jxlsService;

    @RequestMapping("/export")
    public void export(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        // String templateFileName= request.getServletContext().getRealPath("/") + "templ.xlsx";
        String templateFileName = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "templ.xlsx";
        String destFileName= "下载结果.xlsx";
        destFileName = new String(destFileName.getBytes("UTF-8"), "ISO-8859-1");
        //模拟数据
        Settlement settlement = new Settlement("111", "222");
        List<Settlement> settlements = new ArrayList<>();
        settlements.add(settlement);
        Map<String, Object> beanParams = new HashMap<>(1);
        beanParams.put("list", settlements);

        XLSTransformer transformer = new XLSTransformer();
        InputStream in=null;
        OutputStream out=null;
        //设置响应
        response.setHeader("Content-Disposition", "attachment;filename=" + destFileName);
        response.setContentType("application/vnd.ms-excel");
        try {
            in=new BufferedInputStream(new FileInputStream(templateFileName));
            Workbook workbook=transformer.transformXLS(in, beanParams);
            out=response.getOutputStream();
            //将内容写入输出流并把缓存的内容全部发出去
            workbook.write(out);
            out.flush();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in!=null){try {in.close();} catch (IOException e) {}}
            if (out!=null){try {out.close();} catch (IOException e) {}}
        }
    }

    @RequestMapping("/export2")
    public ResponseEntity<byte[]> export2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //模拟数据
        Settlement settlement = new Settlement("333", "444");
        List<Settlement> settlements = new ArrayList<>();
        settlements.add(settlement);
        Map<String, Object> beanParams = new HashMap<>(1);
        beanParams.put("list", settlements);
        //下载表格
        String downloadFilename = "下载的文件files.xlsx";
        return ExcelUtil.downLoadExcel("templ.xlsx",beanParams, downloadFilename);
    }
}
