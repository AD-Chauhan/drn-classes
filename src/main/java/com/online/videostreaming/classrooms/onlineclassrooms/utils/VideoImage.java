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
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;
 
/**
 * Get video thumbnails
 * @author liuyazhuang
 *
 */
public class VideoImage {
 
	private static final String IMAGEMAT = "png";
	private static final String ROTATE = "rotate";
	
	/**
	  * The middle frame of the default captured video is the cover
	 */
	public static final int MOD = 2;
	
	/**
	  * Get video thumbnails
	  * @param filePath: video path
	  * @param mod: video length / mod gets the few frames
	 * @throws Exception
	 */
	public static void randomGrabberFFmpegImage(String filePath, int mod,String targetFilePath) throws Exception {
		FFmpegFrameGrabber ff = FFmpegFrameGrabber.createDefault(filePath);
		//ff.setImageHeight(imageHeight);
		//ff.setImageWidth(imageWidth);
		ff.start();
		String rotate = ff.getVideoMetadata(ROTATE);
		int ffLength = ff.getLengthInFrames();
		Frame f;
		int i = 0;
		int index = ffLength / mod;
		while (i < ffLength) {
			f = ff.grabImage();
			if(i == index){
				if (null != rotate && rotate.length() > 1) {
					OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
					IplImage src = converter.convert(f);
					f = converter.convert(rotate(src, Integer.valueOf(rotate)));
				}
				doExecuteFrame(f, targetFilePath);
				break;
			}
			i++;
		}
		ff.stop();
	}
	
	
	/**
	  * Rotate the picture
	 * @param src
	 * @param angle
	 * @return
	 */
	public static IplImage rotate(IplImage src, int angle) {
		IplImage img = IplImage.create(src.height(), src.width(), src.depth(), src.nChannels());
		opencv_core.cvTranspose(src, img);
		opencv_core.cvFlip(img, img, angle);
		return img;
	}
 
	/**
	  * Capture thumbnails
	 * @param f
	  * @param targerFilePath: cover image
	 */
	public static void doExecuteFrame(Frame f, String targerFilePath) {
		if (null == f || null == f.image) {
			return;
		}
		Java2DFrameConverter converter = new Java2DFrameConverter();
		BufferedImage bi = converter.getBufferedImage(f);
		File output = new File(targerFilePath);
		try {
			ImageIO.write(bi, IMAGEMAT, output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
	/**
	  * Randomly generate random number sets based on video length
	  * @param baseNum: the base number, here is the video length
	  * @param length: random number set length
	  * @return: a collection of random numbers
	 */
	public static List<Integer> random(int baseNum, int length) {
		List<Integer> list = new ArrayList<Integer>(length);
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
