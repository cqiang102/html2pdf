package online.cccccc.html.pdf.controller;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.layout.font.FontProvider;
import online.cccccc.html.pdf.vo.BasicOverview;
import online.cccccc.html.pdf.vo.CompanyRecordForm;
import online.cccccc.html.pdf.vo.DrillRecordList;
import online.cccccc.html.pdf.vo.EvidentiaryMaterial;
import online.cccccc.html.pdf.vo.FacilitiesCondition;
import online.cccccc.html.pdf.vo.FireKeyParts;
import online.cccccc.html.pdf.vo.PhotoRealistic;
import online.cccccc.html.pdf.vo.UnitApplicationForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * @author 你是电脑
 * @create 2019/11/8 - 14:26
 */
@RestController
@RequestMapping("pdf")
@CrossOrigin("*")
public class PdfController {
    @Resource
    private TemplateEngine templateEngine;

    @Value("${user.host}")
    private String host;

    @Value("${user.resources}")
    private String resources;
    @PostMapping(value = "Basic-overview")
    public String basicOverview(@RequestBody BasicOverview basicOverview){
        System.out.println(basicOverview);
        //往 模板中塞数据
        Context context = new Context();
        context.setVariable("e",basicOverview) ;
        String emailTemplate = templateEngine.process("Basic-overview", context);

        String pdf = pdf(emailTemplate);

        return host+"/"+pdf+".pdf";
    }
    @PostMapping(value = "Unit-application-form")
    public String unitApplicationForm(@RequestBody UnitApplicationForm unitApplicationForm){
        System.out.println(unitApplicationForm);
        //往 模板中塞数据
        Context context = new Context();
        context.setVariable("e",unitApplicationForm) ;
        String emailTemplate = templateEngine.process("Unit-application-form", context);

        String pdf = pdf(emailTemplate);

        return host+"/"+pdf+".pdf";
    }

    @PostMapping(value = "Company-record-form")
    public String companyRecordForm(@RequestBody CompanyRecordForm companyRecordForm){
        System.out.println(companyRecordForm);
        //往 模板中塞数据
        Context context = new Context();
        context.setVariable("e",companyRecordForm) ;
        String emailTemplate = templateEngine.process("Company-record-form", context);

        String pdf = pdf(emailTemplate);

        return host+"/"+pdf+".pdf";
    }
    @PostMapping(value = "Photo-realistic")
    public String photoRealistic(@RequestBody PhotoRealistic photoRealistic){
        System.out.println(photoRealistic);
        //往 模板中塞数据
        Context context = new Context();
        context.setVariable("e",photoRealistic) ;
        String emailTemplate = templateEngine.process("Photo-realistic", context);
        String pdf = pdf(emailTemplate);
        return host+"/"+pdf+".pdf";
    }
    @PostMapping(value = "Drill-record-list")
    public String drillRecordList(@RequestBody DrillRecordList drillRecordList){
        System.out.println(drillRecordList);
        //往 模板中塞数据
        Context context = new Context();
        context.setVariable("row",drillRecordList.getRow()) ;
        context.setVariable("urls",drillRecordList.getUrls()) ;
        String emailTemplate = templateEngine.process("Drill-record-list", context);
        String pdf = pdf(emailTemplate);
        return host+"/"+pdf+".pdf";
    }
    @PostMapping(value = "Evidentiary-material")
    public String evidentiaryMaterial(@RequestBody EvidentiaryMaterial evidentiaryMaterial){
        System.out.println(evidentiaryMaterial);
        //往 模板中塞数据
        Context context = new Context();
        context.setVariable("row",evidentiaryMaterial) ;
        String emailTemplate = templateEngine.process("Evidentiary-material", context);
        String pdf = pdf(emailTemplate);
        return host+"/"+pdf+".pdf";
    }
    @PostMapping(value = "Fire-key-parts")
    public String fireKeyParts(@RequestBody FireKeyParts fireKeyParts) {
        System.out.println(fireKeyParts);
        //往 模板中塞数据
        Context context = new Context();
        context.setVariable("row", fireKeyParts.getRow());
        context.setVariable("fireResource", fireKeyParts.getFireResource());
        String emailTemplate = templateEngine.process("Fire-key-parts", context);
        String pdf = pdf(emailTemplate);
        return host + "/" + pdf + ".pdf";
    }
    @PostMapping(value = "Facilities-condition")
    public String fireKeyParts(@RequestBody Map<Object,Object> facilitiesCondition) {
        System.out.println(facilitiesCondition);
        //往 模板中塞数据
        Context context = new Context();
        context.setVariable("jsonEquipInfo", facilitiesCondition);
        String emailTemplate = templateEngine.process("Facilities-condition", context);
        String pdf = pdf(emailTemplate);
        return host + "/" + pdf + ".pdf";
    }
    @PostMapping(value = "Real-name-system")
    public String realNameSystem(@RequestBody Map<Object,Object> facilitiesCondition) {
        System.out.println(facilitiesCondition);
        //往 模板中塞数据
        Context context = new Context();
//        context.setVariable("jsonEquipInfo", facilitiesCondition);
        String emailTemplate = templateEngine.process("Real-name-system", context);
        String pdf = pdf(emailTemplate);
        return host + "/" + pdf + ".pdf";
    }
    @PostMapping(value = "Information-books")
    public String informationBooks(@RequestBody Map<String,String> json ){
        System.out.println(json);
        //往 模板中塞数据
        Context context = new Context();
        context.setVariable("text",json.get("text")) ;
        String emailTemplate = templateEngine.process("Information-books", context);
        String pdf = pdf(emailTemplate);
        return host+"/"+pdf+".pdf";
    }
    @PostMapping(value = "Letter-of-commitment")
    public String letterOfCommitment(@RequestBody Map<String,String> json ){
        System.out.println(json);
        //往 模板中塞数据
        Context context = new Context();
        context.setVariable("text",json.get("text")) ;
        String emailTemplate = templateEngine.process("Letter-of-commitment", context);
        String pdf = pdf(emailTemplate);
        return host+"/"+pdf+".pdf";
    }
    @PostMapping(value = "security-system")
    public String securitySystem(@RequestBody Map<String,String> json ){
        System.out.println(json);
        //往 模板中塞数据
        Context context = new Context();
        context.setVariable("e",json) ;
        String emailTemplate = templateEngine.process("security-system", context);
        String pdf = pdf(emailTemplate);
        return host+"/"+pdf+".pdf";
    }
    /**
     * 根据渲染后的模板生成pdf文档
     * @param emailTemplate
     * @return
     */
    private String pdf(String emailTemplate){
        //取得HTML 路径
        String templates = Objects.requireNonNull(PdfController.class.getClassLoader().getResource("templates")).getPath();
        templates = templates.replaceFirst("/","");

        //生成pdf文件
        String string = UUID.randomUUID().toString()+"+++"+System.currentTimeMillis();
        File pdfDest = new File(resources+string+".pdf");

        ConverterProperties converterProperties = new ConverterProperties();
        //设置字体、资源文件
        FontProvider fp = new FontProvider();
        fp.addStandardPdfFonts();
        fp.addDirectory(templates);
        fp.addFont("templates/simsun.ttf");
        converterProperties.setFontProvider(fp);
        converterProperties.setBaseUri(templates);

        try {
//            开始生成pdf
            HtmlConverter.convertToPdf(emailTemplate,
                    new FileOutputStream(pdfDest), converterProperties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }
}
