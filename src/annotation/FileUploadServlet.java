/**
 * 
 */
package annotation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * 文件上传Servlet
 * <p>
 * @MultipartConfig 指定该Servlet将会负责处理multipart/form-data类型的请求，主要用于文件上传。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年7月18日
 */
@WebServlet(name = "upload", urlPatterns = "/fileupload", loadOnStartup = 1)
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5803828916499815768L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		/* HttpServletRequest增加了对文件上传的支持。 */
		// 获取文件上传域
		Part filePart = request.getPart("file");
		String fileName = getFileName(filePart);// 文件名
		String fileType = filePart.getContentType();// 文件类型
		long fileSize = filePart.getSize();// 文件大小，以byte为单位
		
		String newPath = "D:/"+fileName;
		
		OutputStream output = null;
		InputStream input = null;
		
		final PrintWriter writer = response.getWriter();
		writer.println("file type：" + fileType + "</br>");
		writer.println("file size：" + fileSize/ 1024 + " KB</br>");
		try {
			output = new FileOutputStream(new File(newPath));
			input = filePart.getInputStream();// 获取上传文件的读入流
			int read = 0;
			final byte[] buffer = new byte[1024];
			while ((read = input.read(buffer)) != -1) {
				output.write(buffer, 0, read);
			}
			writer.println("New file " + fileName + " created at " + newPath);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (output != null) {
				output.close();
			}
			if (input != null) {
				input.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
	}
	
	private String getFileName(Part filePart){
		String header = filePart.getHeader("content-disposition");
		String[] headerValues = header.split(";");
		for (String value : headerValues) {
			String trim = value.trim();
			if(trim.startsWith("filename")){
				return trim.substring(trim.indexOf("=")+1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
