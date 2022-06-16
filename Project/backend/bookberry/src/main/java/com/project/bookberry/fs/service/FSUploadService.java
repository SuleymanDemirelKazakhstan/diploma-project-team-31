package com.project.bookberry.fs.service;

import com.project.bookberry.fs.dto.FSUploadDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FSUploadService {
    List<FSUploadDTO> upload(List<MultipartFile> file);
}
