package com.Majesteye.Skeye.Dailylifeservices.Repository;

import com.Majesteye.Skeye.Dailylifeservices.Entities.EntityFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<EntityFeedback , Integer> {
}
