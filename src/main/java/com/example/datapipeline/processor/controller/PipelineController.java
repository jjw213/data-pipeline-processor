package com.example.datapipeline.processor.controller;

import com.example.datapipeline.processor.model.PipelineRequest;
import com.example.datapipeline.processor.model.PipelineResponse;
import com.example.datapipeline.processor.service.DataPipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PipelineController {
    @Autowired
    private DataPipelineService dataPipelineService;

    @PostMapping("/process")
    public PipelineResponse process(@RequestBody PipelineRequest request) {
        return dataPipelineService.process(request);
    }
}