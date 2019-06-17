package com.springcloud.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springcloud.common.UploadUtils;
import com.springcloud.vo.ResultValue;

@RestController
public class FileUploadController {
	
	//从application.properties文件中获得指定键的值，并赋给相应的成员变量
	@Value("${web.user-path}")
	private String userPath;
	
	@Value("${web.goods-path}")
	private String goodsPath;
	
	/**
	 * 上传用户头像
	 * 
	 * @param file  上传用户头像图片
	 * @return
	 */
	@RequestMapping(value = "/userUpload")
	public ResultValue userUpload(@RequestParam("userImage")MultipartFile file) {
		ResultValue rv = new ResultValue();
		//上传文件		
		try {
			Map<String, Object> map = this.fileUpload(file, userPath);
		    if(map !=null && map.size() > 0 ) {
		    	rv.setCode(0);
			    rv.setDataMap(map);		
			    return rv;
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("用户头像上传失败！！！");
		return rv;
		
	}
	
	/**
	 * 上传商品图片
	 * 
	 * @param file  上传商品图片
	 * @return
	 */
	@RequestMapping(value = "/goodsUpload")
	public ResultValue goodsUpload(@RequestParam("goodsImage")MultipartFile file) {
		ResultValue rv = new ResultValue();
		//上传文件		
		try {
			Map<String, Object> map = this.fileUpload(file, goodsPath);
		    if(map !=null && map.size() > 0 ) {
		    	rv.setCode(0);
			    rv.setDataMap(map);		
			    return rv;
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("商品图片上传失败！！！");
		return rv;
		
	}
	/**
	 * 删除商品图片
	 * @param goodsImg
	 * @return
	 */
	@RequestMapping(value = "/deleteGoodsImg")
	public ResultValue deleteGoodsImg(@RequestParam("goodsImg") String goodsImg) {
		ResultValue rv = new ResultValue();
		
		try {
			//从URL中获得商品图片的名字
			int indexOf = goodsImg.lastIndexOf("/");
			if(indexOf !=-1) {
				//声明一个Sting类型的变量去截取图片
				String fileName = goodsImg.substring(indexOf + 1);
				//System.out.println(fileName);
				File file = new File(this.goodsPath + fileName);
				//判断文件或目录是否存在
						file.delete();					
						rv.setCode(0);
						return rv;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}
	/**
	 * 删除商品图片
	 * @param goodsImg
	 * @return
	 */
	@RequestMapping(value = "/deleteUserImg")
	public ResultValue deleteUserImg(@RequestParam("userImg") String userImg) {
		ResultValue rv = new ResultValue();
		
		try {
			//从URL中获得用户图片的名字
			int indexOf = userImg.lastIndexOf("/");
			if(indexOf !=-1) {
				//声明一个Sting类型的变量去截取图片
				String fileName = userImg.substring(indexOf + 1);
				//System.out.println(fileName);
				File file = new File(this.userPath + fileName);
				//判断文件或目录是否存在
						file.delete();					
						rv.setCode(0);
						return rv;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}
			
	/**
	 * 上传文件
	 * 
	 * @param file   需要上传的文件
	 * @param path   上传文件的路径
	 * @return 成功返回java.util.Map类型的实例，否则返回null
	 * @throws IOException 
	 */
	private Map<String, Object>fileUpload(MultipartFile file,String path) throws IOException{
		Map<String, Object> map = null;
		
		//获得新的文件名
		String fileName = UploadUtils.getFileName();
		//根据上传文件的文件名获得文件的扩展名
		String extendedName = UploadUtils.getExendedName(file.getOriginalFilename());
		
		//上传文件	
		//1、将文件转换为字节类型的数组
		byte[] bytes = file.getBytes();
		//2、创建File类的对象,并设置文件名上传路径及文件名
		File saveFile = new File(path + fileName + extendedName);
		//3、上传文件
		FileCopyUtils.copy(bytes, saveFile);
		
		map = new HashMap<>();
		map.put("fileName", fileName);
		map.put("extendedName",  extendedName);
		
		return map;
		
	}

}
