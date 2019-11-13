package online.cccccc.html.pdf.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 你是电脑
 * @create 2019/11/11 - 16:27
 */
@Data
public class DrillRecordList {
    private Row row;
    private String[] urls;
    @Data
    private class Row{
        @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
        private String date;
        private String department;
        private String address;
        private String principal;
        private String content;
        private String scheme;
        private String implementation;
        private String summarize;
        private String suggest;
        private String recordPeople;
        private String fireCustodian;
    }
}
