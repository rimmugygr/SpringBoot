package car.servis.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/file")
public class FileController {
    Logger logger = LoggerFactory.getLogger(FileController.class);

    @GetMapping("/download")
    @ResponseBody
    public void downloadFile(HttpServletResponse response) throws IOException {
        File file = new File("src/main/resources/xxx.jpg");
        logger.info("file loaded");
        InputStream inputStream = new FileInputStream(file);
        response.setContentType("image/jpg");
        response.setContentLengthLong(file.length());
        response.setHeader("Content-Disposition", "attachment; fileName=abc.jpg");
        FileCopyUtils.copy(inputStream,response.getOutputStream());
        logger.info("file stream");
    }
}
