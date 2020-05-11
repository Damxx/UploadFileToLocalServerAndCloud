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
                "cloud_name", "dzxgyzxkx",
                "api_key", "947818954546771",
                "api_secret", "zbDp_g9DVBF731lY2zJzeM2hlsU"));
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



