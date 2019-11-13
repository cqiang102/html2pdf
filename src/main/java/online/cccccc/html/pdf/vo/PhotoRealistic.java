package online.cccccc.html.pdf.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author 你是电脑
 * @create 2019/11/11 - 15:53
 */
@Data
public class PhotoRealistic {

    private String text;

    private List<Image> images;

    @Data
    @AllArgsConstructor
    private static class Image{
        private String src;
        private String title;

    }
}
