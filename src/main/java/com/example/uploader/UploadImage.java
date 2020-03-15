package com.example.uploader;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Component
public class UploadImage {
    private Cloudinary cloudinary;

    public UploadImage() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "ddxgnvjm9",
                "api_key", "186442611393335",
                "api_secret", "wM35sunU9-XERdLtTE2oKoO8IG4"));
    }

    public String getFileUrl(MultipartFile multipartFile) {
        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(),ObjectUtils.emptyMap());

        }catch (IOException e) {
            e.printStackTrace();
        }
        return uploadResult.get("url").toString();
    }


}



