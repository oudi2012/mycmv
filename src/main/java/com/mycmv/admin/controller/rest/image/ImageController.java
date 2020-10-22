package com.mycmv.admin.controller.rest.image;


import com.mycmv.server.constants.LogConstants;
import com.mycmv.server.model.ResponseObject;
import com.mycmv.server.model.AbstractUser;
import com.mycmv.server.service.image.ImageService;
import com.mycmv.server.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/***
 * image
 * @author a
 */
@RestController
@RequestMapping("image")
public class ImageController {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.ADM_LOG);

    @Resource
    private ImageService imageService;

    @ResponseBody
    @PostMapping("upload")
    public ResponseObject pageList(AbstractUser user, @RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        logger.info("文件上传操作人: " + user.getUserName());
        ResponseObject responseObject = new ResponseObject();
        String fileName = multipartFile.getOriginalFilename();
        logger.info("文件上传名称: " + fileName);
        String path = request.getServletContext().getRealPath(File.separator);
        logger.info("文件保存路径: " + fileName);
        if(!new File(path).exists()){
            new File(path).mkdir();
        }
        File upLoadFile = new File(path + File.separator + fileName);
        multipartFile.transferTo(upLoadFile);
        String imageUrl = imageService.uploadImage(upLoadFile);
        logger.info("文件远程保存路径: " + imageUrl);
        CommonUtils.executeSuccess(responseObject, imageUrl);
        return responseObject;
    }

}
