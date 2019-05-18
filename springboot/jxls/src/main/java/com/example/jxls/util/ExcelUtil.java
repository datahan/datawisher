package com.example.jxls.util;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author
 * @date
 *
 */
public class ExcelUtil {

    /**
     * 下载excel
     *
     * @author HJ
     * @date 2019年1月1日
     * @param sourcePath	模板路径
     * @param beanParams	excel内容
     * @param downloadFileName 下载的文件名
     * @return
     * @throws ParsePropertyException
     * @throws IOException
     */
    public static ResponseEntity<byte[]> downLoadExcel(String sourcePath, Map<String, Object> beanParams, String downloadFileName)
            throws ParsePropertyException, InvalidFormatException, IOException {

        ByteArrayOutputStream os = new ByteArrayOutputStream();

        //读取模板
        InputStream is = ExcelUtil.class.getClassLoader().getResourceAsStream(sourcePath);
        XLSTransformer transformer = new XLSTransformer();

        //向模板中写入内容
        Workbook workbook = transformer.transformXLS(is, beanParams);

        //写入成功后转化为输出流
        workbook.write(os);

        //配置Response信息
        HttpHeaders headers = new HttpHeaders();

        //防止中文名乱码
        downloadFileName = new String(downloadFileName.getBytes("UTF-8"), "ISO-8859-1");

        headers.setContentDispositionFormData("attachment", downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //返回
        return new ResponseEntity<byte[]>(os.toByteArray(), headers, HttpStatus.CREATED);
    }
}
