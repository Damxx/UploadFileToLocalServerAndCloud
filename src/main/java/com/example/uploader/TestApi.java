package com.example.uploader;

import com.example.uploader.entity.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class TestApi {


    @Autowired
    UploadImage uploadImage;

    @GetMapping("/test1")
    public String test1(Model theModel){
        theModel.addAttribute("newPath", new Path());
        return "homeUser";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute() Path path){
        System.out.println(path.getPath());
       //uploadImage.getFileUrl("\\\\abell1\\Home\\Home\\dpadzik\\Desktop\\widokPrzycisk.png");
        return "redirect:/test1";
    }

    @RequestMapping("/showFormUpload")
    public String uploadPage(Model theModel){
        return "upload";
    }
    @RequestMapping("/upload")
    public String upload(@RequestParam("files") MultipartFile file,
                         RedirectAttributes redirectAttributes){
        if (file.isEmpty()) {
            System.out.println("Nie ma Pliku");
            return "redirect:uploadStatus";
        }
        try {
            byte[] bytes = file.getBytes();
            java.nio.file.Path path = Paths.get("\\\\abell1\\Home\\Home\\dpadzik\\Desktop\\Stankiewicz\\" + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            uploadImage.getFileUrl(file);
        }
        return "redirect:/uploadStatus";
    }
    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }


    @GetMapping("/test2")
    public String test2(){
        return "test2";
    }
    @GetMapping("/test3")
    public String test3(){
        return "test3";
    }


}
