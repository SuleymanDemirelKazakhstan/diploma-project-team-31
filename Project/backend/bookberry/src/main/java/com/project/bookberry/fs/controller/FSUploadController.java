package com.project.bookberry.fs.controller;

import com.project.bookberry.fs.dto.FSUploadDTO;
import com.project.bookberry.fs.service.FSUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/fs")
public class FSUploadController {

    @Autowired
    private FSUploadService fsUploadService;

    @PostMapping("/upload")
    public ResponseEntity<List<FSUploadDTO>> upload(@RequestParam(value = "file") List<MultipartFile> files) {
        return ResponseEntity.ok(fsUploadService.upload(files));
    }
}
