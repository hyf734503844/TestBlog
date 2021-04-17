package com.lrm.web;

import com.lrm.dao.File1Repository;
import com.lrm.dao.UserRepository;
import com.lrm.po.File1;
import com.lrm.po.User;
import com.lrm.service.File1Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

@Controller
public class FileController {
    @Autowired
    File1Service fileService;
    @Autowired
    File1Repository file1Repository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/showFiles")
    public String showFiles(Model model,Pageable pageable){
        List<File1> f1=fileService.findAll();
//        MultiValuedMap<User,File1> hashMap=new ArrayListValuedHashMap<>();
//        String s;
//        for (File1 f:f1){
//            hashMap.put(userRepository.findOne(f.getUserId()),f);
//        }

//        model.addAttribute("hUserAndFile",hashMap);
        model.addAttribute("page1",f1);
        System.out.println("1");
        return "showfiles";
    }

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    //文件上传相关代码
    @RequestMapping("/upload")
    public String upload(@RequestParam("test") MultipartFile file, HttpSession httpSession) {
        System.out.println("in");
        User user=(User)httpSession.getAttribute("user");
        if (file.isEmpty()) {
            return "redirect:/";
        }

        if(user.getId()==null) {
            return "redirect:/";
        }

        // 获取文件名
        String fileName = file.getOriginalFilename();


        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        logger.info("上传的后缀名为：" + suffixName);

        // 文件上传后的路径
        String filePath = "G:\\9.springboot论坛\\BLOGS-master\\src\\main\\webapp\\WEB-INF\\"+user.getId().toString()+"\\";
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录

        fileService.uplode(fileName,httpSession);




        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return "redirect:/";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return "redirect:/";
    }

//    @PathVariable("id") Long id,@PathVariable("filename") String filename,

    //文件下载相关代码
    @RequestMapping("/download/{id}")
    public String downloadFile(@PathVariable Long id, HttpSession httpSession, org.apache.catalina.servlet4preview.http.HttpServletRequest request, HttpServletResponse response) {
        System.out.println("下载下载:"+id);
        File1 file1=file1Repository.findOne(id);
//        //串1。 文件名传输。
        String fileName = file1.getFileName();
//
        if (fileName != null) {
            //当前是从该工程的WEB-INF//File//下获取文件(该目录可以在下面一行代码配置)然后下载到C:\\users\\downloads即本机的默认下载的目录
            User user=(User)httpSession.getAttribute("user");
//            System.out.println("userID:"+file1.getUserId());
            //串2. file_user_id传输。
            String ff="//WEB-INF//"+file1.getUserId()+"//";
            String realPath = request.getServletContext().getRealPath(
                    ff);
            File file = new File(realPath, fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

    //多文件上传
    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(HttpServletRequest request,HttpSession httpSession) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        MultipartFile file = null;

        BufferedOutputStream stream = null;

        for(int i=0;i<files.size();i++){
            if(!files.get(i).isEmpty())
                upload(files.get(i),httpSession);
        }

//        for (int i = 0; i < files.size(); ++i) {
//            file = files.get(i);
//            if (!file.isEmpty()) {
//                try {
//                    byte[] bytes = file.getBytes();
//                    stream = new BufferedOutputStream(new FileOutputStream(
//                            new File(file.getOriginalFilename())));
//                    stream.write(bytes);
//                    stream.close();
//
//                } catch (Exception e) {
//                    stream = null;
//                    return "You failed to upload " + i + " => "
//                            + e.getMessage();
//                }
//            } else {
//                return "You failed to upload " + i
//                        + " because the file was empty.";
//            }
//        }
        return "upload successful";
    }

//    public void showFiles(){
//        List<File1> file1List=fileService.findAll();
//        for (File1 file1:file1List
//             ) {
//            System.out.println(file1);
//        }
//    }


}
