package com.traini8.trainingcenter.service;

import com.traini8.trainingcenter.model.TrainingCenter;
import com.traini8.trainingcenter.repository.TrainingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingCenterService {

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    // Method to create and save a new Training Center
    public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) {
        return trainingCenterRepository.save(trainingCenter); // Saves training center to the database
    }

    // Method to fetch all Training Centers
    public List<TrainingCenter> getAllTrainingCenters() {
        return trainingCenterRepository.findAll();
    }

    // Method to fetch a Training Center by ID
    public Optional<TrainingCenter> getTrainingCenterById(Long id) {
        return trainingCenterRepository.findById(id);
    }

    // Method to delete a Training Center by ID
    public void deleteTrainingCenter(Long id) {
        trainingCenterRepository.deleteById(id);
    }
}
