package online.cccccc.html.pdf.vo;

import lombok.Data;

/**
 * @author 你是电脑
 * @create 2019/11/12 - 9:11
 */
@Data
public class FireKeyParts {
    private Row row;
    private String fireResource;
    @Data
    private class Row{
        private String buildArea;
        private String disableFlag;
        private String exits;
        private String location;
        private String fireCase;
        private String fireDangers;
        private String fullpathName;
        private String keypartName;
        private String structureType;
        private String useFunction;
        private String starits;
        private String height;
        private String refireLevel;
        private String equip;
        private String reason;
        private String refireFlag;
        private String tipsFlag;
        private String respPerson;
        private String mgrMeasures;
    }

}
