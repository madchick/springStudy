package com.example.fileUploadTest.controller;

import com.example.fileUploadTest.model.FileUploadResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/test")
public class FileUploadController {

    // @Value("${spring.servlet.multipart.location}")
    // String filePath;

    @PostMapping("/upload")
    public ResponseEntity<FileUploadResponse> upload(
            @RequestParam MultipartFile[] uploadfile,
            HttpServletRequest request)
            throws IllegalStateException, IOException {
        for (MultipartFile file : uploadfile) {
            if (!file.isEmpty()) {
                String newFileName = UUID.randomUUID().toString();
                String oldFileName = file.getOriginalFilename();

                String savePath = request.getServletContext().getRealPath("images/");
                File newFile = new File(savePath + newFileName + "_" + oldFileName);

                // 전달된 내용을 실제 물리적인 파일로 저장해준다.
                file.transferTo(newFile);
            }
        }

        FileUploadResponse fileUploadResponse = new FileUploadResponse();
        fileUploadResponse.setStatus("200");
        fileUploadResponse.setError("success");

        return ResponseEntity.ok(fileUploadResponse);
    }
/*
    @GetMapping("/download")
    public ResponseEntity<Resource> download(@ModelAttribute FileDto dto) throws IOException {
        Path path = Paths.get(filePath + "/" + dto.getUuid() + "_" + dto.getFileName());
        String contentType = Files.probeContentType(path);
        // header를 통해서 다운로드 되는 파일의 정보를 설정한다.
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(ContentDisposition.builder("attachment")
                .filename(dto.getFileName(), StandardCharsets.UTF_8)
                .build());
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);

        Resource resource = new InputStreamResource(Files.newInputStream(path));
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
*/
}
