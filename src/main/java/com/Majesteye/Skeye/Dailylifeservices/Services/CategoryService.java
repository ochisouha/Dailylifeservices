package com.Majesteye.Skeye.Dailylifeservices.Services;

import com.Majesteye.Skeye.Dailylifeservices.Entities.EntityMarker;
import com.Majesteye.Skeye.Dailylifeservices.Repository.MarkerRepository;
import net.bytebuddy.jar.asm.commons.Remapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private MarkerRepository markerRepo;

    @Autowired
    public CategoryService(MarkerRepository markerRepo) {
        this.markerRepo = markerRepo;
    }
    public List<EntityMarker> getCategoriesByType(String category) {
        return markerRepo.findByCategory(category);
    }



    public void deleteById(Integer id) {
    }

    public void deleteAll() {
    }

    public Remapper findById(Integer id) {
        return null;
    }

}
