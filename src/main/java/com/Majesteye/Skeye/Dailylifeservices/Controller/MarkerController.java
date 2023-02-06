package com.Majesteye.Skeye.Dailylifeservices.Controller;

import com.Majesteye.Skeye.Dailylifeservices.Entities.EntityMarker;
import com.Majesteye.Skeye.Dailylifeservices.Entities.EntityUser;
import com.Majesteye.Skeye.Dailylifeservices.Repository.MarkerRepository;
import com.Majesteye.Skeye.Dailylifeservices.Repository.UserRepository;
import com.Majesteye.Skeye.Dailylifeservices.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class MarkerController {

    private CategoryService categoryService;
    private MarkerRepository markerepo;
    @Autowired
    public MarkerController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @Autowired
    private UserRepository userRepository;

 /* @GetMapping("/marker")
    public List<EntityMarker>  markers() throws Exception{

        List<EntityMarker> categories = markerepo.findAll();

        return categories;
    }  */

    @GetMapping("/marker/{category}")
    public List<EntityMarker> getEntityMarkerByCategory(@RequestParam("category")  String category ) {
        return categoryService.getCategoriesByType(category);
    }

   /* @PostMapping("/users/{user_id}/marker")
    public EntityMarker saveMarker(@PathVariable(name = "user_id") Integer userId, @RequestBody EntityMarker marker) {

        EntityMarker entityMarker = userRepository.findById(userId).map(user -> {
            marker.setUser(user);
            return categoryService.save(marker);
        }).orElseThrow(() -> new IllegalStateException("User with id: " + userId + " not found"));

        return categoryService.save(marker);
    }*/
   /* @PutMapping("/marker/{id}")
    public EntityMarker updateProviderOrSave(@RequestBody EntityMarker marker, @PathVariable Integer id) {
        return this.categoryService.findById(id).map(
                old_marker -> {
                    old_marker.setId(marker.getId());
                    old_marker.setLocation(marker.getLocation());
                    old_marker.setName(marker.getName());
                    old_marker.setDescription(marker.getDescription());
                    old_marker.setLongitude(marker.getLongitude());
                    old_marker.setLatitude(marker.getLatitude());
                    old_marker.setCategory(marker.getCategory());
                    old_marker.setContact(marker.getContact());
                    return categoryService.save(old_marker);
                }).orElseGet(() -> {
            marker.setId(id);
            return categoryService.save(marker);
        });
    } */
    @DeleteMapping("/marker/{id}")
    void deleteProvider(@PathVariable Integer id){
        this.categoryService .deleteById(id);
    }

    @DeleteMapping("/marker")
    public void deleteAll() {
        this.categoryService.deleteAll();
    }

}













