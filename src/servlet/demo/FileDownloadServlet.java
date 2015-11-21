/**
 * 
 */
package servlet.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件下载Servlet
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年7月18日
 */
public class FileDownloadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5803828916499815768L;
	
	private static final int BUFFER_SIZE = 1024 * 4; 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		String filename = "a.txt";
		
		File file = new File(getRealFilePath(filename));
		if (file.exists()) {

			// 文件头的设置
			resp.setHeader("Content-Disposition", "attachment;filename="
					+ encodeFileName(filename));
			// 设置文件内容的类型
			resp.setContentType("application/octet-stream");

			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			try {
				// 使用IO流进行下载操作
				bis = new BufferedInputStream(new FileInputStream(file));
				bos = new BufferedOutputStream(resp.getOutputStream());

				byte[] buffer = new byte[BUFFER_SIZE];
				int length = 0;

				while ((length = bis.read(buffer)) != -1) {
					bos.write(buffer, 0, length);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (bis != null) {
						bis.close();
					}
					if (bos != null) {
						bos.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 返回文件在服务器上的真实路径
	 */
	private String getRealFilePath(String filename) {
		// 得到Web模块在服务器上的路径，从而得到文件的真实路径
		StringBuffer s = new StringBuffer(getServletContext().getRealPath("/"));
		s.append("WEB-INF/files/");
		s.append(filename);
		return s.toString();
	}
	
	/**
	 * 将文件名进行重编码以支持简体中文
	 */
	private String encodeFileName(String filename){
		// 对于纯简体中文的文件名可以使用下面的方式将 filename 字符串转化成 ISO8859-1
		// 如果中间还有繁体字的话，就需要使用其他的方法来解决中文显示的问题
		try {
			return new String(filename.getBytes("gb2312"), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException("编码失败：" + e.getMessage());
		}
	}
}
