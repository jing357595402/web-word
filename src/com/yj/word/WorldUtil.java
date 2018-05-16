package com.yj.word;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author YJ
 * @描述 word生成工具类
 */
public class WorldUtil {
	/**
	 * @param data
	 *            需要动态改变的数据
	 * @param templateName
	 *            模板名称，test.ftl
	 * @param filePath
	 *            文件生成后保存路径
	 * @param fileName
	 *            文件保存名称
	 * @throws IOException
	 * @throws TemplateException 
	 */
	public static void createWord(Map data, String templateName, String filePath, String fileName) throws IOException, TemplateException {
		// 1、创建配置实例
		Configuration configuration = new Configuration();
		// 设置编码
		configuration.setDefaultEncoding("utf-8");
		// 设置模板路径
		configuration.setClassForTemplateLoading(WorldUtil.class, "/com/yj/template/");
		// 获取模板
		Template template = configuration.getTemplate(templateName);
		File file = new File(fileName + File.separator + fileName);
		// 如果目录不存在就创建
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		// 将模板和数据模型合并生成文件
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
		// 生成文件
		template.process(data, out);
		// 关闭流
		out.flush();
		out.close();
	}
}
