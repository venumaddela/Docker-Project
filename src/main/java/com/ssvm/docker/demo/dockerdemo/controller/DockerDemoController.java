package com.ssvm.docker.demo.dockerdemo.controller;

import com.ssvm.docker.demo.dockerdemo.entity.DockerRequest;
import com.ssvm.docker.demo.dockerdemo.repository.DockerRepo;
import com.ssvm.docker.demo.dockerdemo.service.DockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerDemoController {


        private final DockerRepo repository;

        public DockerDemoController(DockerRepo repository) {
            this.repository = repository;
        }

    @GetMapping("/{id}")
    public ResponseEntity<DockerRequest> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(r -> {
                    System.out.println("FOUND: " + r);
                    return ResponseEntity.ok(r);
                })
                .orElseGet(() -> {
                    System.out.println("NOT FOUND for id=" + id);
                    return ResponseEntity.notFound().build();
                });
    }

    @GetMapping("/message")
    public String message(){
            return "Hello!! Welcome to Docker Demo Application";
    }


}
