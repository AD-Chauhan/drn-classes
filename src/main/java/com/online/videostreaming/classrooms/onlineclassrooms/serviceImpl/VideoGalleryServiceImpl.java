package com.online.videostreaming.classrooms.onlineclassrooms.serviceImpl;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.videostreaming.classrooms.onlineclassrooms.dao.VideoGalleryDao;
import com.online.videostreaming.classrooms.onlineclassrooms.entity.VideoUploadEntity;
import com.online.videostreaming.classrooms.onlineclassrooms.services.VideoGalleryService;
@Service
public class VideoGalleryServiceImpl implements VideoGalleryService {

	@Autowired
	private VideoGalleryDao VideoGalleryDao;
	
	@Autowired
    ServletContext context;
	@Transactional
	@Override
	public int uploadFile(VideoUploadEntity videoUploadEntity) throws Exception {
		
		
		
		return VideoGalleryDao.uploadFile(videoUploadEntity);
	}
	@Override
	public List<VideoUploadEntity> getAllUploadedVideos() throws Exception {
		return VideoGalleryDao.getAllUploadedVideos();
	}
	@Override
	public boolean updateVideoDetails(VideoUploadEntity videoUploadEntity) throws Exception {
		return VideoGalleryDao.updateVideoDetails(videoUploadEntity);
	}

	@Override
	public String deleteFolderAndVideoById(Integer idToDelete) throws Exception {
		boolean isDeleted=false;
		try
		{
			
			VideoUploadEntity obj =  VideoGalleryDao.getVideoDetailsById(idToDelete);
			boolean check = VideoGalleryDao.deleteVideoById(idToDelete);
			if(check)
			{
				
				isDeleted=true;
				if(obj.getOriginalFileName()!=null && obj.getThumbnailFileName()!=null)
				{
					File videofile = new File(context.getRealPath(obj.getOriginalPath())+obj.getOriginalFileName());
					File thumbfile = new File(context.getRealPath(obj.getThumbnailPath())+obj.getThumbnailFileName());
					File dir = new File(context.getRealPath("/resources/VideosUploads/"+obj.getFolderId()+"/Videos/"));
					File dir2 = new File(context.getRealPath("/resources/VideosUploads/"+obj.getFolderId()+"/Thumbnail/"));
					
					if(videofile.exists())
					{
						videofile.delete();
					}
					
					if(thumbfile.exists())
					{
						thumbfile.delete();
					}
					FileUtils.deleteDirectory(dir);
					FileUtils.deleteDirectory(dir2);
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
	@Override
	public VideoUploadEntity getVideoDetailsByFolderId(String Id) throws Exception {
		return VideoGalleryDao.getVideoDetailsByFolderId( Id);
	}

}
