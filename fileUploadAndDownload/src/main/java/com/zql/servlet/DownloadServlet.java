package com.zql.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 处理下载
 * @author lawliet.L
 */
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 得到下载的文件名
        String fileName = request.getParameter("fileName");
        fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
        // 文件存储目录
        String fileRootPath = getServletContext().getRealPath("/WEB-INF/upload");
        // 通过文件名找到文件所在目录
        String path = findFilePathByFileName(fileName,fileRootPath);
        // 得到要下载的文件
        File file = new File(path + "\\" + fileName);
        if (!file.exists()) {   // 文件不存在
            request.setAttribute("message","您下载的资源已被删除");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
            return;
        }
        // 处理文件名
        String realName = fileName.substring(fileName.indexOf("_") + 1);
        // 设置响应头，控制浏览器下载该文件
        if (request.getHeader("USER-AGENT").toLowerCase().indexOf("firefox") > 0) { // 火狐浏览器
            response.setHeader("content-disposition","attachment;filename=" + new String(realName.getBytes("GB2312"),"ISO-8859-1"));
        } else {
            response.setHeader("content-disposition","attachment;filename=" + URLEncoder.encode(realName,"UTF-8"));
        }
        // 读取要下载的文件，保存到文件输入流
        FileInputStream fileInputStream = new FileInputStream(path + "\\" + fileName);
        // 输出流
        ServletOutputStream outputStream = response.getOutputStream();

        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(buffer)) > 0) {
            outputStream.write(buffer,0,len);
        }

        // 关闭流
        fileInputStream.close();
        outputStream.close();
    }

    /**
     * 通过文件名和存储文件的根目录找出要下载的文件
     * 主要是计算出hashCode去对应文件名
     * @param fileName
     * @param fileRootPath
     * @return
     */
    private String findFilePathByFileName(String fileName, String fileRootPath) {
        int hashCode = fileName.hashCode();
        int dir1 = hashCode & 0xf;
        int dir2 = (hashCode & 0xf0) >> 4;
        String dir = fileRootPath + "\\" + dir1 + "\\" + dir2;
        return dir;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
