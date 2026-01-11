package com.ssvm.docker.demo.dockerdemo.service;

import com.ssvm.docker.demo.dockerdemo.entity.DockerRequest;
import com.ssvm.docker.demo.dockerdemo.repository.DockerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DockerService {

    @Autowired
    private DockerRepo dockerRepo;

    String message = null;

    public String getMessage(){
        Optional<DockerRequest> findById = dockerRepo.findById(1l);

        if(findById.isPresent()){
            message = findById.get().toString();
        }

        return message;
    }
}
