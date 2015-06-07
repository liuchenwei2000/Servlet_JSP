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
 * �ļ�����Servlet
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��7��18��
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

			// �ļ�ͷ������
			resp.setHeader("Content-Disposition", "attachment;filename="
					+ encodeFileName(filename));
			// �����ļ����ݵ�����
			resp.setContentType("application/octet-stream");

			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			try {
				// ʹ��IO���������ز���
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
	 * �����ļ��ڷ������ϵ���ʵ·��
	 */
	private String getRealFilePath(String filename) {
		// �õ�Webģ���ڷ������ϵ�·�����Ӷ��õ��ļ�����ʵ·��
		StringBuffer s = new StringBuffer(getServletContext().getRealPath("/"));
		s.append("WEB-INF/files/");
		s.append(filename);
		return s.toString();
	}
	
	/**
	 * ���ļ��������ر�����֧�ּ�������
	 */
	private String encodeFileName(String filename){
		// ���ڴ��������ĵ��ļ�������ʹ������ķ�ʽ�� filename �ַ���ת���� ISO8859-1
		// ����м仹�з����ֵĻ�������Ҫʹ�������ķ��������������ʾ������
		try {
			return new String(filename.getBytes("gb2312"), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException("����ʧ�ܣ�" + e.getMessage());
		}
	}
}
