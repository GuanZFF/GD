package pers.guanzf.test;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageHandle {

	public static void main(String[] args) throws Exception {
		cutImage("C:/Users/GZFeng/Desktop/a1.png", "C:/Users/GZFeng/Desktop/a3.png", 1, 1, 700, 1000, "png", "png");
	}
	
	public static void cutImage(String sourcePath, String purposePath, int x, int y, int w, int h, String sourceType,
			String purposeType) {
		FileInputStream read = null;
		ImageInputStream image = null;
		try {
			read = new FileInputStream(new File(sourcePath));
			image = ImageIO.createImageInputStream(read);
			Iterator<ImageReader> reader = ImageIO.getImageReadersByFormatName(sourceType);
			ImageReader imageReader = reader.next();
			imageReader.setInput(image, true);
			ImageReadParam imageReadParam = imageReader.getDefaultReadParam();
			Rectangle rectangle = new Rectangle(x, y, w, h);
			imageReadParam.setSourceRegion(rectangle);
			BufferedImage bufferedImage = imageReader.read(0, imageReadParam);
			ImageIO.write(bufferedImage, purposeType, new File(purposePath));
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				image.close();
				read.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
}
