package com.imooc.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.AbstractDocument.BranchElement;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.imooc.dao.AdminDao;
import com.imooc.dao.ArticleDao;
import com.imooc.dto.MultiFileUploadForm;
import com.imooc.dto.Result;
import com.imooc.entity.Admin;
import com.imooc.entity.Article;
import com.imooc.enums.BlogEnum;
import com.imooc.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	private static final Logger log = Logger.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public Result<String> dologin(Admin admin) {
		// TODO Auto-generated method stub
		
		if(admin==null)
			return new Result<String>(BlogEnum.FAIL,"0");
		String name = admin.getUsername();
		String password = admin.getPassword();
		if(name==null||password==null)
			return new Result<String>(BlogEnum.ADMINERROR,"0");
		String checkpw = adminDao.queryByName(name);
		if(checkpw == null)
			return new Result<String>(BlogEnum.ADMINERROR,"0");
		if(checkpw.equals(password))
			return new Result<String>(BlogEnum.SUCCESS,"1");
		return new Result<String>(BlogEnum.ADMINERROR,"0");
	}
	
	@Override
	public Result<String> modify(Admin admin) {
		// TODO Auto-generated method stub
		
		if(admin==null)
			return new Result<String>(BlogEnum.FAIL,"0");
		
		String name = admin.getUsername();
		String password = admin.getPassword();
		if(name==null||password==null)
			return new Result<String>(BlogEnum.MFERROR,"0");
		int mId = adminDao.modify(admin);
		if(mId == 0)
			return new Result<String>(BlogEnum.MFERROR,"0");
		
		return  new Result<String>(BlogEnum.SUCCESS,"1");
	}
	
	
	
	@Override
	public Result<String> deleteByIdArticle(String id) {
		// TODO Auto-generated method stub
		log.info("----------start delete--------------------");
		if(id==null||id.equals(""))
			return new Result<String>(BlogEnum.IDERROR,"0");
		try{
			int aId = Integer.parseInt(id);
			log.info("id:"+aId);
			int dId = articleDao.deleteById(aId);
			log.info("dId:"+dId);
			if(dId==0){
				log.info("没有删除");
				return new Result<String>(BlogEnum.IDERROR,"0");
			}
		}catch(Exception e){
			log.error("error:"+e.getMessage());
			return new Result<String>(BlogEnum.IDERROR,"0");
		}
		return new Result<String>(BlogEnum.SUCCESS,"1");
	}

	@Override
	public Result<String> updateArticle(Article article) {
		// TODO Auto-generated method stub
		if(article ==null){
			return new Result<String>(BlogEnum.ARERROR,"0");
		}
		article.setDate(new Date());
		int mId = articleDao.modifyArticle(article);
		log.info("mId:"+mId);
		if(mId == 0)
			return new Result<String>(BlogEnum.ARERROR,"0");
		return new Result<String>(BlogEnum.SUCCESS,"1");
	}

	@Override
	public Result<String> addArticle(Article article) {
		// TODO Auto-generated method stub
		
		if(article ==null){
			return new Result<String>(BlogEnum.ARERROR,"0");
		}
		
		article.setGraded(3.0);
		article.setDate(new Date());
		article.setGradedCount(1);
		article.setVisitCount(1);
		log.info("content:"+article);
		
		int aId = articleDao.addArticle(article);
		if(aId == 0)
			return new Result<String>(BlogEnum.ARERROR,"0");
		return new Result<String>(BlogEnum.SUCCESS,"1");
	}

	
	
	@Override
	public Result<String> addParseHtml(MultiFileUploadForm multiFileUploadForm) {
		// TODO Auto-generated method stub
		
		//判断是否为空
		if(multiFileUploadForm == null){
			return new Result<String>(BlogEnum.FAIL,"传入错误");
		}
		
		//解析文章
		MultipartFile file = multiFileUploadForm.getMultiUploadFile();
		if(file == null||file.getSize()<0){
			return new Result<String>(BlogEnum.FAIL,"文章内容为空");
		}
		String content = null;
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line =null;
			while((line = br.readLine())!=null){
				sb.append(line).append(System.getProperty("line.separator"));
			}
			PegDownProcessor pdp = new PegDownProcessor(Integer.MAX_VALUE);
			content = pdp.markdownToHtml(sb.toString());
		}catch(Exception e){
			return new Result<String>(BlogEnum.FAIL,"传入错误");
			
		}
		
		String title = multiFileUploadForm.getTitle();
		String tag = multiFileUploadForm.getTag();
		String summary = multiFileUploadForm.getSummary();
		String classification = multiFileUploadForm.getClassification();
		if(judge(title)||judge(tag)	||judge(summary)
				||judge(classification)||judge(content)){
			return new Result<String>(BlogEnum.FAIL,"传入错误");
		}
		System.out.println("--------------content---------------------");
		System.out.println(content.length());
		Article artitle = new Article(title,summary,content,tag,classification);
		
		return addArticle(artitle);
	}	
	
	
	private boolean judge(String text){
		if(text == null||text.equals("")){
			return true;
		}
		return false;
	}

	
	
	@Override
	public Result<String> uploadPicture(MultipartFile picture,HttpServletRequest request) {
		// TODO Auto-generated method stub
		//判断是否传上图片
		if(picture ==null)
			return new Result<String>(BlogEnum.FAIL,"上传失败");
		String filename ;
		try {
			request.setCharacterEncoding("utf-8");
			String rootPath = request.getSession().getServletContext().getRealPath("/images");
			File file = new File(rootPath);
			
			if(!file.exists())
				file.mkdirs();
			filename = picture.getOriginalFilename();
			filename = System.currentTimeMillis()+filename.substring(filename.lastIndexOf("."), filename.length());
			file = new File(rootPath+File.separator+filename);
			FileUtils.copyInputStreamToFile(picture.getInputStream(), file);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new Result<String>(BlogEnum.FAIL,"上传失败");
		}
		if(filename==null||filename.equals(""))
			return new Result<String>(BlogEnum.FAIL,"上传失败");
		return new Result<String>(BlogEnum.SUCCESS,"images/"+filename);
	}
}
