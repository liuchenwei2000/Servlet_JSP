/**
 * 
 */
package servlet.demo;

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
 * Servlet3.0开始支持文件上传，完成文件上传再也不需要第三方工具了。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年7月18日
 */
@WebServlet(name = "fileUploadServlet", urlPatterns = "/upload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5803828916499815768L;

	private static final int BUFFER_SIZE = 1024 * 4; 
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		Part filePart = request.getPart("file");
		
		String fileName = getFileName(filePart);
		
		if(fileName != null) {
			// 上传文件在服务器的真实路径
			String newPath = getServletContext().getRealPath("/WEB-INF/uploads") + "\\" + fileName;
			
			OutputStream os = null;
			InputStream is = null;
			
			PrintWriter writer = response.getWriter();
			try {
				os = new FileOutputStream(new File(newPath));
				is = filePart.getInputStream();
				
				int read = 0;
				final byte[] buffer = new byte[BUFFER_SIZE];
				while ((read = is.read(buffer)) != -1) {
					os.write(buffer, 0, read);
				}
				
				writer.println("New file " + fileName + " created at " + newPath);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (os != null) {
					os.close();
				}
				if (is != null) {
					is.close();
				}
				if (writer != null) {
					writer.close();
				}
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
