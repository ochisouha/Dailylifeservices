package com.Majesteye.Skeye.Dailylifeservices.Controller;

import com.Majesteye.Skeye.Dailylifeservices.Entities.EntityFeedback;
import com.Majesteye.Skeye.Dailylifeservices.Repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class FeedbackController {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @GetMapping("/feedback")
    public List<EntityFeedback> findAll() {
        return this.feedbackRepository.findAll();
    }

    @PostMapping("/feedback")
    public EntityFeedback saveFeedback(@RequestBody EntityFeedback feedback) {
        return this.feedbackRepository.save(feedback);
    }
}