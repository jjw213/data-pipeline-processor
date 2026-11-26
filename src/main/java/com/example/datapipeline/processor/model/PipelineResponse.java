package com.example.datapipeline.processor.model;

import java.util.List;

public class PipelineResponse {
    private List<String> processedData;

    public List<String> getProcessedData() {
        return processedData;
    }

    public void setProcessedData(List<String> processedData) {
        this.processedData = processedData;
    }
}