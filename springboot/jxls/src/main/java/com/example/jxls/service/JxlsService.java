package com.example.jxls.service;

import com.example.jxls.domain.Settlement;
import com.example.jxls.util.JxlsUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class JxlsService {

    public Map<String, Object> export() {

        Settlement settlement = new Settlement("123", "456");
        List<Settlement> settlements = new ArrayList<>();
        settlements.add(settlement);
        String templateFileName = "templ.xlsx";
        String resultFileName = "结算数据" + ".xlsx";
        Map<String, Object> excel = new JxlsUtils().createExcel(templateFileName, settlements, resultFileName);
        return excel;
    }

    public void export1() {

        Settlement settlement = new Settlement("123", "456");
        List<Settlement> settlements = new ArrayList<>();
        settlements.add(settlement);
        String templateFileName = "templ.xlsx";
        String resultFileName = "结算数据" + ".xlsx";
        new JxlsUtils().createExcel(templateFileName, settlements, resultFileName);
    }



}
