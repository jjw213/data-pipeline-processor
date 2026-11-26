package com.example.datapipeline.processor.service;

import com.example.datapipeline.processor.model.PipelineRequest;
import com.example.datapipeline.processor.model.PipelineResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataPipelineService {
    public PipelineResponse process(PipelineRequest request) {
        List<String> data = new ArrayList<>(request.getData());
        for (PipelineRequest.Transformation transformation : request.getTransformations()) {
            String type = transformation.getType();
            switch (type) {
                case "uppercase":
                    data = data.stream().map(String::toUpperCase).collect(Collectors.toList());
                    break;
                case "lowercase":
                    data = data.stream().map(String::toLowerCase).collect(Collectors.toList());
                    break;
                case "strip-html":
                    data = data.stream().map(this::stripHtml).collect(Collectors.toList());
                    break;
                case "filter-empty":
                    data = data.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
                    break;
                default:
                    break;
            }
        }

        PipelineResponse response = new PipelineResponse();
        response.setProcessedData(data);
        return response;
    }

    private String stripHtml(String html) {
        if (html == null || html.isEmpty()) {
            return html;
        }
        Document doc = Jsoup.parse(html);
        return doc.text();
    }
}