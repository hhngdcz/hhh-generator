package com.hhh.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: HHNGDCZ
 * @since: 2023/11/19/22:45
 * @description:
 */
public class StaticGenerator {
    public static void main(String[] args) {
        // 获取项目路径
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);

        String inputPath =projectPath+File.separator+"hhh-generator-demo-projects"+File.separator+"acm-template";
        String outputPath = projectPath;
//        copyFilesByHutool(inputPath,outputPath);
        copyFilesByRecursive(inputPath,outputPath);



    }
    /**
     * 拷贝文件（Hutool 实现，会将输入目录完整拷贝到输出目录下）
     * @param inputPath
     * @param outputPath
     */
   public static void copyFilesByHutool(String inputPath, String outputPath){
       FileUtil.copy(inputPath,outputPath,false);


   }

    /**
     * 递归拷贝文件
     * @param inputPath
     * @param outputPath
     */

   public static void copyFilesByRecursive(String inputPath,String outputPath){
       File inputFile =new File(inputPath);
       File outputFile =new File(outputPath);
       try{
           copyFileByRecursive(inputFile,outputFile);
       }catch (Exception e){
           System.out.println("文件复制失败");
           e.printStackTrace();
       }
   }

   private static void copyFileByRecursive(File inputFile,File outputFile) throws IOException {
        if (inputFile.isDirectory()){
            System.out.println(inputFile.getName());
            File destOutputFile = new File(outputFile,inputFile.getName());
            if (!destOutputFile.exists()){
                destOutputFile.mkdirs();
            }
            File[] files = inputFile.listFiles();
            if (ArrayUtil.isEmpty(files)){
                return;
            }
            for (File file:files){
                copyFileByRecursive(file,destOutputFile);
            }
        }else {
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
            Files.copy(inputFile.toPath(),destPath, StandardCopyOption.REPLACE_EXISTING);
        }
   }
}
