package pers.guanzf.common.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import pers.guanzf.common.constants.Constants;
import pers.guanzf.common.sys.base.model.Result;

public class FileUtil {

	@SuppressWarnings("unchecked")
	public static Result uploadFile(MultipartFile file, String path, String prefix) {
		if (!new File(path).isDirectory()) {
			new File(path).mkdirs();
		}

		String imgName = "";

		if (file.isEmpty()) {
			new Result(0, "上传文件为空。");
		} else {
			String originalName = file.getOriginalFilename();// 文件名称
			String type = originalName.split("\\.")[1];// 文件格式
			try {
				imgName = getFileName(type, prefix);
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path, imgName));
			} catch (IOException e) {
				e.printStackTrace();
				return new Result(0, "上传的图片操作异常。");
			}
		}

		StringBuffer realPath = new StringBuffer();
		realPath.append(path);
		realPath.append(File.separator);
		realPath.append(imgName);

		Result result = new Result(1, "上传文件成功。");
		result.getResultMap().put(Constants.Path.RELATIVE, realPath.toString());
		result.getResultMap().put("imgName", imgName);
		return result;
	}

	public static String getFileName(String format, String prefix) {
		StringBuffer buf = new StringBuffer();
		buf.append(prefix);
		buf.append("_");
		buf.append(getCurrentDateAsString("yyyy_MM_dd_HH_mm_ss"));
		buf.append("_");
		buf.append((int) ((Math.random()) * 100));
		buf.append(".");
		buf.append(format);
		return buf.toString();
	}

	public static String getCurrentDateAsString(String format) {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		Date curDate = Calendar.getInstance().getTime();
		return sf.format(curDate);
	}

	/**
	 * 写文件信息
	 * 
	 * @param pathname
	 *            文件路径
	 * @param context文件内容
	 */
	public static boolean saveFile(String pathname, byte[] context) throws Exception {
		if (StringUtil.isEmpty(pathname) || context == null) {
			return false;
		}
		File file = new File(pathname);
		File path = file.getParentFile();
		boolean b = true;
		if (!path.exists()) {
			b = path.mkdirs();
		}
		if (!b) {
			return b;
		}
		if (!file.exists()) {
			b = file.createNewFile();
		}
		if (b) {
			writeFile(pathname, context);
		}
		return b;
	}

	public static void writeFile(String pathname, byte[] context) throws Exception {
		File file = new File(pathname);
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file));
		output.write(context);
		output.close();
	}
}
