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
 * �ļ��ϴ�������
 * @author Ms
 *
 */
//ע��Ϊ����������springmvc
@Controller
public class UploadController {
//	ָ������·��(ӳ������)
	@RequestMapping("/uploadImage")
	public ModelAndView upload(HttpServletRequest request, UploadedImageFile file) throws IllegalStateException, IOException {
		
		String filename=file.getImage().getOriginalFilename();
		System.out.println("�ļ��ϴ�ԭ����"+filename);
		String suffixName = filename.substring(filename.lastIndexOf("."));
		System.out.println("�ļ���չ��"+suffixName);
		
		
		String name=RandomStringUtils.randomAlphabetic(10);//����ļ�����->���ͬ���ļ���������
		String newFileName=name+".png";//���ļ���ƴ��
		//��ȡ��webĿ¼�µ�imageĿ¼�����ڴ���ϴ�����ļ�
		File newFile=new File(request.getServletContext().getRealPath("/image"),newFileName);
		newFile.getParentFile().mkdirs();//�ļ���ַ�����ھʹ���->�Զ��½�image�ļ���
		file.getImage().transferTo(newFile);//�����ļ���������->�ϴ��ļ�
		ModelAndView mav=new ModelAndView("showUploadedFile");
		mav.addObject("imageName",newFileName);
		return mav;
		
	}
}
