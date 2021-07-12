package com.ms.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.xwork.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ms.pojo.UploadedImageFile;

/**
 * 文件上传控制器
 * @author Ms
 *
 */
//注册为控制器交付springmvc
@Controller
public class UploadController {
//	指定方法路径(映射请求)
	@RequestMapping("/uploadImage")
	public ModelAndView upload(HttpServletRequest request, UploadedImageFile file) throws IllegalStateException, IOException {
		
		String filename=file.getImage().getOriginalFilename();
		System.out.println("文件上传原名："+filename);
		String suffixName = filename.substring(filename.lastIndexOf("."));
		System.out.println("文件扩展名"+suffixName);
		
		
		String name=RandomStringUtils.randomAlphabetic(10);//随机文件名字->解决同名文件覆盖问题
		String newFileName=name+".png";//新文件名拼接
		//获取到web目录下的image目录，用于存放上传后的文件
		File newFile=new File(request.getServletContext().getRealPath("/image"),newFileName);
		newFile.getParentFile().mkdirs();//文件地址不存在就创建->自动新建image文件夹
		file.getImage().transferTo(newFile);//复制文件到服务器->上传文件
		ModelAndView mav=new ModelAndView("showUploadedFile");
		mav.addObject("imageName",newFileName);
		return mav;
		
	}
}
