package ddd.microservice;


import stupid.generator.GeneratorFacade;

/**
 * @author badqiu
 * @email badqiu(a)gmail.com
 */

public class GeneratorMain {
	/**
	 * 请直接修改以下代码调用不同的方法以执行相关生成任务.
	 */
	public static void main(String[] args) throws Exception {

		// 模板地址
		String templatePath = "classpath:template";
		GeneratorFacade g = new GeneratorFacade();
		g.getGenerator().addTemplateRootDir(templatePath);
		// 删除生成器的输出目录//
		g.deleteOutRootDir();
		// 通过数据库表生成文件
		g.generateByTable("product");

		// 自动搜索数据库中的所有表并生成文件,template为模板的根目录
		// g.generateByAllTable();
		// 按table名字删除文件
		// g.deleteByTable("table_name", "template");
		//打开文件夹
		//Runtime.getRuntime().exec("cmd.exe /c start "+GeneratorProperties.getRequiredProperty("outRoot"));
	}
}
