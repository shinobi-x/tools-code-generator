package cn.uc.codegenerator.util;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import cn.uc.codegenerator.module.Database;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class TemplateUtil {
    
    protected static Configuration getConfiguration(String projectType) throws Exception {
        String templateDir = "template_" + projectType;
        Configuration cfg = new Configuration();
        File file = new File(templateDir);
        if (!file.exists()) {
            file = new File(ClassLoader.getSystemResource(templateDir).toURI());
        }
        cfg.setDirectoryForTemplateLoading(file);
        cfg.setObjectWrapper(new DefaultObjectWrapper());
        return cfg;
    }

    public static String getText(String projectType, String templateFile, Object params) throws Exception {
        Template template = getConfiguration(projectType).getTemplate(templateFile);

        Writer out = new StringWriter();

        template.process(params, out);

        return out.toString();
    }
    
    public static Map<String, String> getFileToPath(Database dbInfo, String objectName)
    {
      Map<String, String> fileToPath = new HashMap<String, String>();

      String domainPath = transferDomainToPath(dbInfo.getDomain());
      String model = dbInfo.getModel();
      fileToPath.put("/model/model.ftl", "app/" + domainPath +"/" + model + "/model/" + objectName + ".java");
      fileToPath.put("/dto/dto.ftl", "app/" + domainPath +"/" + model + "/dto/" + objectName + "Dto.java");
      fileToPath.put("/dto/queryDto.ftl", "app/" + domainPath +"/" + model + "/dto/" + objectName + "QueryDto.java");
      fileToPath.put("/dao/mapper/mapper.ftl", "conf/" + domainPath +"/" + model + "/dao/mapper/" + objectName + "Mapper.xml");
      fileToPath.put("/dao/mapper.ftl", "app/" + domainPath +"/" + model + "/dao/" + objectName + "Mapper.java");
      fileToPath.put("/service/impl/serviceImpl.ftl", "app/" + domainPath +"/" + model + "/service/impl/" + objectName + "ServiceImpl.java");
      fileToPath.put("/service/service.ftl", "app/" + domainPath +"/" + model + "/service/" + objectName + "Service.java");

      return fileToPath;
    }
    
    private static String transferDomainToPath(String domain){
        return domain.replaceAll("\\.", "\\/");
    }
}
