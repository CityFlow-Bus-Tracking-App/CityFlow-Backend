package com.example.demo.Service;

import com.example.demo.Model.StudentStatusRequest;
import com.example.demo.Repository.StudentStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Service
public class StudentStatusRequestService {

    @Autowired
    private StudentStatusRepository studentStatusRepository;

    public StudentStatusRequest store(MultipartFile file, String username) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Date now = new Date();
        StudentStatusRequest studentStatusRequest = new StudentStatusRequest(fileName,username, now, file.getContentType(), file.getBytes());
        return studentStatusRepository.save(studentStatusRequest);
    }
    public StudentStatusRequest getByNameAndUsername(String name, String username){
        return studentStatusRepository.findByNameAndUsername(name,username);
    }
}