package com.Majesteye.Skeye.Dailylifeservices.Repository;
import com.Majesteye.Skeye.Dailylifeservices.Entities.EntityMarker;
import org.hibernate.internal.util.collections.ConcurrentReferenceHashMap;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;



@Repository
public interface MarkerRepository extends JpaRepository<EntityMarker, Integer>{

    List<EntityMarker> findByCategory(String category);
}
