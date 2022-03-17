package com.sapient.service;

import com.sapient.entity.User;
import com.sapient.dao.CsvDao;
import com.sapient.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CsvService {
    @Autowired
    UserRepository repository;

    //To save the CSV file to databse
    public void save(MultipartFile file) {
        try {
            List<User> tutorials = CsvDao.csvToUsers(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
