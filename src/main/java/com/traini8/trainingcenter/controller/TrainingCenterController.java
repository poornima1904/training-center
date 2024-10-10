package com.traini8.trainingcenter.controller;

import com.traini8.trainingcenter.model.TrainingCenter;
import com.traini8.trainingcenter.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService;

    // POST request to create a new Training Center
    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(
            @Valid @RequestBody TrainingCenter trainingCenter) {
        TrainingCenter savedCenter = trainingCenterService.createTrainingCenter(trainingCenter);
        return ResponseEntity.ok(savedCenter);
    }

    // GET request to fetch all Training Centers
    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        List<TrainingCenter> centers = trainingCenterService.getAllTrainingCenters();
        return ResponseEntity.ok(centers);
    }

    // GET request to fetch a specific Training Center by ID
    @GetMapping("/{id}")
    public ResponseEntity<TrainingCenter> getTrainingCenterById(@PathVariable Long id) {
        return trainingCenterService.getTrainingCenterById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE request to remove a Training Center by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainingCenter(@PathVariable Long id) {
        trainingCenterService.deleteTrainingCenter(id);
        return ResponseEntity.noContent().build();
    }
}
