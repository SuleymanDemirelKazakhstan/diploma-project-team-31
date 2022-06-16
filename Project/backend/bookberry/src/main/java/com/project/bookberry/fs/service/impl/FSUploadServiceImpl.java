package com.project.bookberry.fs.service.impl;

import com.project.bookberry.fs.dto.CdnDTO;
import com.project.bookberry.fs.dto.FSUploadDTO;
import com.project.bookberry.fs.service.FSUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class FSUploadServiceImpl implements FSUploadService {

    @Value("${fs.cdn.url}")
    private String URL;

    @Value("${fs.cdn.preset}")
    private String PRESET;

    @Override
    public List<FSUploadDTO> upload(List<MultipartFile> files) {
        RestTemplate restTemplate = new RestTemplate();
        List<FSUploadDTO> result = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        for (MultipartFile file : files) {
            body.add("file", file.getResource());
            body.add("upload_preset", PRESET);

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
            ResponseEntity<CdnDTO> response = restTemplate.exchange(
                    String.join("/", URL, "upload"),
                    HttpMethod.POST,
                    requestEntity,
                    CdnDTO.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                FSUploadDTO fsUploadDTO = new FSUploadDTO();
                fsUploadDTO.setUrl(response.getBody().getUrl());
                fsUploadDTO.setFilename(file.getOriginalFilename());
                result.add(fsUploadDTO);
            }
        }
        return result;
    }
}
