/*
 * package com.online.videostreaming.classrooms.onlineclassrooms.utils;
 * 
 * import java.awt.Graphics2D; import java.awt.image.BufferedImage; import
 * java.io.File; import java.io.IOException;
 * 
 * import javax.imageio.ImageIO;
 * 
 * import com.xuggle.mediatool.IMediaReader; import
 * com.xuggle.mediatool.MediaListenerAdapter; import
 * com.xuggle.mediatool.ToolFactory; import
 * com.xuggle.mediatool.event.IVideoPictureEvent; import
 * com.xuggle.xuggler.Global;
 * 
 *//**
	 *
	 * Generates Thumbnails for the given Video
	 *
	 *//*
		 * public class Thumbnail { public static final double SECONDS_BETWEEN_FRAMES =
		 * 10;
		 * 
		 * private static String inputFilename = null; private static String
		 * outputFilePrefix = null; private static int mVideoStreamIndex = -1; private
		 * static long mLastPtsWrite = Global.NO_PTS; private static String
		 * outputFilename = null; public static final long MICRO_SECONDS_BETWEEN_FRAMES
		 * = (long) (Global.DEFAULT_PTS_PER_SECOND * SECONDS_BETWEEN_FRAMES);
		 * 
		 * public static void generateThumbnail(String videoLocation,String
		 * thumbLocation, String Filename) { mVideoStreamIndex = -1; mLastPtsWrite =
		 * Global.NO_PTS;
		 * 
		 * inputFilename = videoLocation + Filename; outputFilePrefix = thumbLocation;
		 * IMediaReader mediaReader = ToolFactory.makeReader(inputFilename); try {
		 * mediaReader .setBufferedImageTypeToGenerate(BufferedImage.TYPE_3BYTE_BGR);
		 * ImageSnapListener isListener = new ImageSnapListener();
		 * mediaReader.addListener(isListener); while (!isListener.isImageGrabbed()) {
		 * mediaReader.readPacket(); } } catch(Exception ex) { ex.printStackTrace(); }
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * private static BufferedImage resizeImage(BufferedImage originalImage, int
		 * type, int width, int height){
		 * 
		 * BufferedImage resizedImage = new BufferedImage(width, height, type);
		 * Graphics2D g = resizedImage.createGraphics(); g.drawImage(originalImage, 0,
		 * 0, width, height, null); g.dispose();
		 * 
		 * return resizedImage; }
		 * 
		 * private static class ImageSnapListener extends MediaListenerAdapter { public
		 * boolean imageGrabbed = false; public void onVideoPicture(IVideoPictureEvent
		 * event) { if (event.getStreamIndex() != mVideoStreamIndex) { if
		 * (mVideoStreamIndex == -1) mVideoStreamIndex = event.getStreamIndex(); else
		 * return; } if (mLastPtsWrite == Global.NO_PTS) mLastPtsWrite =
		 * event.getTimeStamp() - MICRO_SECONDS_BETWEEN_FRAMES; if (event.getTimeStamp()
		 * - mLastPtsWrite >= MICRO_SECONDS_BETWEEN_FRAMES) { outputFilename =
		 * dumpImageToFile(event.getImage()); this.imageGrabbed = true; //set this var
		 * to true once an image is grabbed out of the movie. double seconds = ((double)
		 * event.getTimeStamp()) / Global.DEFAULT_PTS_PER_SECOND; mLastPtsWrite +=
		 * MICRO_SECONDS_BETWEEN_FRAMES; } }
		 * 
		 * private String dumpImageToFile(BufferedImage originalImage) { int type =
		 * originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB :
		 * originalImage.getType();
		 * 
		 * BufferedImage resizeImageJpg = resizeImage(originalImage, type, 614, 400);
		 * 
		 * try { String outputFilename = outputFilePrefix + System.currentTimeMillis() +
		 * ".jpg"; File file = new File(outputFilename); ImageIO.write(resizeImageJpg,
		 * "jpg", file); return outputFilename; } catch (IOException e) {
		 * e.printStackTrace(); return null; } }
		 * 
		 * public boolean isImageGrabbed() { return imageGrabbed; } } }
		 */