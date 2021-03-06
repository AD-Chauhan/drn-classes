package com.online.videostreaming.classrooms.onlineclassrooms.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;

public abstract class VideoImageFrame {
 
	
	
	public static String randomGrabberFFmpegImage(String filePath, String targerFilePath, String targetFileName, int randomSize, String random) throws Exception {
		String filename=null;
		FFmpegFrameGrabber ff = FFmpegFrameGrabber.createDefault(filePath);
		ff.setImageWidth(370);
		ff.setImageHeight(187);
		ff.setImageMode(FrameGrabber.ImageMode.COLOR);
		ff.start();
		String rotate = ff.getVideoMetadata("rotate");
		int ffLength = ff.getLengthInFrames();
		List<Integer> randomGrab = random(ffLength, randomSize);
		int maxRandomGrab = randomGrab.get(randomGrab.size() - 1);
		Frame f;
		int i = 0;
		while (i < ffLength) {
			f = ff.grabImage();
			if (randomGrab.contains(i)) {
				if (null != rotate && rotate.length() > 1) {
					OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
					IplImage src = converter.convert(f);
					f = converter.convert(rotate(src, Integer.valueOf(rotate)));
				}
				 filename=doExecuteFrame(f, targerFilePath, targetFileName, i, random);
			}
			if (i >= maxRandomGrab) {
				break;
			}
			i++;
		}
		ff.stop();
		return filename;
	}
 
	public static IplImage rotate(IplImage src, int angle) {
		IplImage img = IplImage.create(400, 614, src.depth(), src.nChannels());
		opencv_core.cvTranspose(src, img);
		opencv_core.cvFlip(img, img, angle);
		return img;
	}
 
	public static String  doExecuteFrame(Frame f, String targerFilePath, String targetFileName, int index,String random) {
		if (null == f || null == f.image) {
			return null;
		}
		Java2DFrameConverter converter = new Java2DFrameConverter();
		String imageMat = "png";
		String FileName = targerFilePath  + targetFileName + "_" + random + "." + imageMat;
		String fileNameUploaded = targetFileName + "_" + random + "." + imageMat;
		BufferedImage bi = converter.getBufferedImage(f);
		File output = new File(FileName);
		try {
			ImageIO.write(bi, imageMat, output);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileNameUploaded;
		
	}
 
	public static List<Integer> random(int baseNum, int length) {
		List<Integer> list = new ArrayList<>(length);
		while (list.size() < length) {
			Integer next = (int) (Math.random() * baseNum);
			if (list.contains(next)) {
				continue;
			}
			list.add(next);
		}
		Collections.sort(list);
		return list;
	}
 
}