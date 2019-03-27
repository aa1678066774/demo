package com.example.demo.test.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.FileInfo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/file")
public class FileController {
	private String path = "E:\\file\\fcsfile";
	
	@Autowired
	private IFileManage fileManage;

    @PostMapping
    public FileInfo upload(MultipartFile file) throws Exception {

        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        File localFile = new File(path, file.getOriginalFilename());

        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
        try (InputStream inputStream = new FileInputStream(new File(path, id + ".jpg"));
                OutputStream outputStream = response.getOutputStream();) {

            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=" + id + ".jpg");

            IOUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @ApiOperation("大文件分片上传")
    @PostMapping("/chunkUpload")
    public void fileChunkUpload(MultipartFileParam param, HttpServletResponse response, HttpServletRequest request){
        /**
         * 判断前端Form表单格式是否支持文件上传
         */
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(!isMultipart){
            //这里是我向前端发送数据的代码，可理解为 return 数据; 具体的就不贴了
//            resultData = ResultData.buildFailureResult("不支持的表单格式", ResultCodeEnum.NOTFILE.getCode());
//            printJSONObject(resultData,response);
            return;
        }
        System.out.println("上传文件 start...");
        try {
            String taskId = fileManage.chunkUploadByMappedByteBuffer(param);
        } catch (IOException e) {
            System.out.println("文件上传失败。{}");
        }
        System.out.println("上传文件结束");
    }
    
}
