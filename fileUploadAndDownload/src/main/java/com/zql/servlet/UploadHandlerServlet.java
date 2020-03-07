package com.zql.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * 处理文件的上传
 * @author lawliet.L
 * @date 2018-10-28 下午9:28:23
 */
public class UploadHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 上传文件的保存目录
        String savePath = getServletContext().getRealPath("/WEB-INF/upload");
        // 临时文件的保存目录
        String tempPath = getServletContext().getRealPath("/WEB-INF/temp");

//        File saveFile = new File(savePath);
        File tempFile = new File(tempPath);
        if (!tempFile.exists() && !tempFile.isDirectory()) {
            System.out.println(tempFile + "临时目录不存在，正在创建。。。");
            tempFile.mkdir();
        }
        // 消息提示
        String message = "";
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(1024*100); //设置缓冲区大小为100KB，默认为10KB
            factory.setRepository(tempFile);    // 设置上传生成的临时文件的保存目录
            // 文件上传解析器
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            // 监听文件上传进度
            fileUpload.setProgressListener(new ProgressListener() {
                @Override
                public void update(long readBytes, long fileLength, int i) {
                    System.out.println("文件大小为：" + fileLength + ",当前已处理：" + readBytes);
                }
            });
            // 防止中文乱码
            fileUpload.setHeaderEncoding("UTF-8");
            // 不是MultipartContent类型，正常处理
            if (!ServletFileUpload.isMultipartContent(req)) {
                return;
            }

            fileUpload.setFileSizeMax(1024*1024);   // 设置单个文件最大值，单位B
            fileUpload.setSizeMax(1024*1024*10);    // 单次文件上传最大值，单位B
            List<FileItem> items = fileUpload.parseRequest(req);
            for (FileItem fileItem : items) {
                if (fileItem.isFormField()) {   // 如果是普通项
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");
                    System.out.println(name + "=" + value);
                }else { //是文件
                    String fileName = fileItem.getName();
                    System.out.println("文件名：" + fileName);
                    if (fileName == null || fileName.trim().equals("")) {
                        continue;
                    }
                    // 不同浏览器提交的文件名是不一样的，有的是带路径的，有的只是单纯的文件名。
                    fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                    // 获取文件扩展名
                    String fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1);
                    System.out.println("上传文件的扩展名为：" + fileExtName);
                    if (fileExtName != null && !"txt".equals(fileExtName) && !"png".equals(fileExtName)) {
                        System.out.println("文件名不合法");
                        message = "文件名不合法，上传失败。";
                        break;
                    } else {
                        InputStream inputStream = fileItem.getInputStream();
                        // 得到文件保存的名字
                        String saveFileName = makeFileName(fileName);
                        // 得到文件保存的目录
                        String realSavePath = makePath(saveFileName,savePath);

                        FileOutputStream fileOutputStream = new FileOutputStream(realSavePath + "\\" + saveFileName);
                        byte[] buffer = new byte[1024];
                        int len = 0;
                        while ((len = inputStream.read(buffer)) > 0) {
                            fileOutputStream.write(buffer,0,len);
                        }
                        // 关闭流
                        inputStream.close();
                        fileOutputStream.close();
                        // 删除临时文件
                        fileItem.delete();
                        message = "文件上传成功";
                    }
                }
            }

        }catch (FileUploadBase.FileSizeLimitExceededException e) {
            message = "单个文件超出最大值！！";
            e.printStackTrace();
        } catch (FileUploadBase.SizeLimitExceededException e) {
            message = "上传文件总大小超出最大值！！";
            e.printStackTrace();
        } catch (Exception e) {
            message = "传文件失败";
        }
        req.setAttribute("message",message);
        req.getRequestDispatcher("/message.jsp").forward(req,resp);
    }

    /**
     * 防止一个目录下太多文件
     * 使用hash算法打乱
     * @param fileName
     * @param savePath
     * @return
     */
    private String makePath(String fileName, String savePath) {
        // 得到文件名的hasCode，就是这个字符串在内存中的地址值
        int hashCode = fileName.hashCode();

        int dir1 = hashCode & 0xf;
        int dir2 = (hashCode & 0xf0) >> 4;

        // 构造新的目录
        String dir = savePath + "\\" + dir1 + "\\" + dir2;

        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
        return dir;
    }

    /**
     * 防止文件名重复被覆盖
     * 每个产生一个唯一的文件名
     * @param fileName
     * @return
     */
    private String makeFileName(String fileName) {
        return UUID.randomUUID().toString() + "_" + fileName;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
