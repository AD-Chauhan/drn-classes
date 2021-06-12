package com.online.videostreaming.classrooms.onlineclassrooms.captcha;

import java.awt.image.BufferedImage;

public class ImgCaptchaCode extends CaptchaCode {

	private static final long serialVersionUID = 1L;
	private  BufferedImage bufferedImage;

    public ImgCaptchaCode(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public ImgCaptchaCode(String key, String value, Long createTime, BufferedImage bufferedImage) {
        super(key, value, createTime);
        this.bufferedImage = bufferedImage;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
}
