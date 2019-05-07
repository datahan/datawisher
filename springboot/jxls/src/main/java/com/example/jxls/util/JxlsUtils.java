package com.example.jxls.util;

import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Excel生成类.
 */
public class JxlsUtils {

    /**
     * 根据模板生成Excel文件.
     * @param templateFileName 模板文件.
     * @param list 模板中存放的数据.
     * @param resultFileName 生成的文件.
     */
    public Map<String, Object> createExcel(String templateFileName, List<?> list, String resultFileName){
        final Logger logger = LoggerFactory.getLogger(JxlsUtils.class);

        //创建XLSTransformer对象
        XLSTransformer transformer = new XLSTransformer();
        //获取java项目编译后根路径
        URL url = this.getClass().getClassLoader().getResource("");
        //得到模板文件路径
        assert url != null;
        String srcFilePath = url.getPath() + templateFileName;
        Map<String,Object> beanParams = new HashMap<>();
        beanParams.put("list", list);
        String destFilePath = resultFileName;

        //生成Excel文件
        try {
            transformer.transformXLS(srcFilePath, beanParams, destFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("destFilePath", destFilePath);
        return map;
    }

}
