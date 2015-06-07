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
 * �ļ��ϴ�Servlet
 * <p>
 * @MultipartConfig ָ����Servlet���Ḻ����multipart/form-data���͵�������Ҫ�����ļ��ϴ���
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��7��18��
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
		
		/* HttpServletRequest�����˶��ļ��ϴ���֧�֡� */
		// ��ȡ�ļ��ϴ���
		Part filePart = request.getPart("file");
		String fileName = getFileName(filePart);// �ļ���
		String fileType = filePart.getContentType();// �ļ�����
		long fileSize = filePart.getSize();// �ļ���С����byteΪ��λ
		
		String newPath = "D:/"+fileName;
		
		OutputStream output = null;
		InputStream input = null;
		
		final PrintWriter writer = response.getWriter();
		writer.println("file type��" + fileType + "</br>");
		writer.println("file size��" + fileSize/ 1024 + " KB</br>");
		try {
			output = new FileOutputStream(new File(newPath));
			input = filePart.getInputStream();// ��ȡ�ϴ��ļ��Ķ�����
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
