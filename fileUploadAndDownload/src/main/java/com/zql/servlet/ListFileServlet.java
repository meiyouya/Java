package com.zql.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * 列出web系统中所有的文件
 * @author lawliet.L
 * @date 2018-10-28 下午9:38:21
 */
public class ListFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取上传文件的目录
        String uploadFilePath = getServletContext().getRealPath("/WEB-INF/upload");
        // 存储要下载的文件名
        HashMap<String, String> fileNameMap = new HashMap<>();
        // 遍历上传目录下的所有文件，将文件的文件名存储到map集合
        listFile(new File(uploadFilePath),fileNameMap);
        // 将map发送到listFile.jsp进行显示
        req.setAttribute("fileNameMap",fileNameMap);
        req.getRequestDispatcher("/listFile.jsp").forward(req,resp);
    }

    /**
     * 遍历目录下所有文件
     * @param file
     * @param fileNameMap
     */
    private void listFile(File file, HashMap<String, String> fileNameMap) {
        // 如果file是目录
        if (!file.isFile()) {
            // 递归列出该目录下所有文件
            File[] files = file.listFiles();
            for (File file1 : files) {
                listFile(file1,fileNameMap);
            }
        }else {
            // 由于上传的文件名是以UUID_fileName存储的，所有要把UUID去除掉,UUID的格式是xxx-xxx-xx-xx
            String realName = file.getName().substring(file.getName().indexOf("_") + 1);
            // 用file.getName()当作key是为了保证key是唯一的，不会被后面的文件覆盖，并且可以再下载的时候直接取到文件名
            fileNameMap.put(file.getName(),realName);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
