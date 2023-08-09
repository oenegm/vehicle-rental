package com.project.vehiclerental.service;

import com.project.vehiclerental.advice.exception.FileDownloadException;
import com.project.vehiclerental.advice.exception.FileUploadException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    String uploadFile(MultipartFile multipartFile) throws FileUploadException, IOException;

    Object downloadFile(String filename) throws FileDownloadException, IOException;

    boolean delete(String fileName);
}
