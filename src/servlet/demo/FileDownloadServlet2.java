/**
 * 
 */
package servlet.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 支持断点续传的文件下载 Servlet
 *
 * Created by liuchenwei on 2017/2/15.
 */
public class FileDownloadServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5803828916499815768L;
	
	private static final int BUFFER_SIZE = 1024 * 4; 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		String filename = "log.txt";
		
		File file = new File(getRealFilePath(filename));
		long size = file.length();
		if (file.exists()) {

			// 设置文件内容的类型
			resp.setContentType("application/x-download");
			resp.setCharacterEncoding("utf-8");
			resp.setHeader("Content-Disposition", "attachment;filename=" + encodeFileName(filename));
			resp.setHeader("Content-Length", size + "");
			// 设置支持断点续传
			resp.setHeader("Accept-Ranges", "bytes");

			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;

			try {
				// 使用 IO 流进行下载操作
				bis = new BufferedInputStream(new FileInputStream(file));
				bos = new BufferedOutputStream(resp.getOutputStream());

				long pos = 0;

				String range = req.getHeader("Range");// 请求头中有此属性值则意味着是断点续传
				System.out.println("range=" + range);
				if (range != null) {
					resp.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
					try {
						pos = Long.parseLong(range.replaceAll("bytes=", "").replaceAll("-", ""));
					} catch (NumberFormatException e) {
						pos = 0;
					}
				}

				String contentRange = new StringBuffer("bytes ").append(pos+"").append(
						"-").append((size - 1)+"").append("/").append(size+"").toString();
				System.out.println("contentRange="+contentRange);
				resp.setHeader("Content-Range", contentRange);

				bis.skip(pos);

				byte[] buffer = new byte[BUFFER_SIZE];
				int length;

				while ((length = bis.read(buffer)) != -1) {
					bos.write(buffer, 0, length);
					Thread.sleep(100);// 暂停 100 ms 以便浏览器可以暂停下载
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (bis != null) {
						bis.close();
					}
					if (bos != null) {
						bos.flush();
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
