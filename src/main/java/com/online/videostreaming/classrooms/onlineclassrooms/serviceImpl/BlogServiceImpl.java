package com.online.videostreaming.classrooms.onlineclassrooms.serviceImpl;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.videostreaming.classrooms.onlineclassrooms.dao.BlogDao;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.BlogUploadEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.VideoUploadEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.services.BlogService;
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
	private BlogDao blogDao;

    
    @Autowired
    ServletContext context;
    
	@Override
	public int uploadBlogFile(BlogUploadEntity blogUploadEntity) throws Exception {
		
		
		return blogDao.uploadBlogFile(blogUploadEntity);
		
		
	}

	@Override
	public List<BlogUploadEntity> getAllUploadedBlogs() throws Exception {
		
		
		return blogDao.getAllUploadedBlogs();
	}
	
	@Override
	public List<BlogUploadEntity> getAllUploadedBlogsByLimit() throws Exception {
		
		
		return blogDao.getAllUploadedBlogsByLimit();
	}

	@Override
	public String deleteFolderAndBlogsById(Integer idToDelete) throws Exception {
		boolean isDeleted=false;
		try
		{
			
			BlogUploadEntity obj =  blogDao.getBlogDetailsById(idToDelete);
			if(obj!=null) {
				
				boolean check = blogDao.deleteBlogById(idToDelete);
				if(check)
				{
					
					isDeleted=true;
					if(obj.getOriginalFileName()!=null )
					{
						File thumbfile = new File(context.getRealPath(obj.getOriginalPath())+obj.getOriginalFileName());
						File thumbfile600 = new File(context.getRealPath(obj.getOriginalPath())+obj.getOriginalFileName600());
						File thumbfile800 = new File(context.getRealPath(obj.getOriginalPath())+obj.getOriginalFileName800());
						
						
						
						if(thumbfile.exists())
						{
							thumbfile.delete();
							FileUtils.deleteDirectory(thumbfile);
						}
						if(thumbfile600.exists())
						{
							thumbfile600.delete();
							FileUtils.deleteDirectory(thumbfile600);
						}
						if(thumbfile800.exists())
						{
							thumbfile800.delete();
							FileUtils.deleteDirectory(thumbfile800);
						}
					}
				}
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
		
		return isDeleted==true?"Record deleted Successfully":"Record not deleted Successfully";
	}
	
}
