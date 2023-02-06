package com.Majesteye.Skeye.Dailylifeservices.Repository;

import com.Majesteye.Skeye.Dailylifeservices.Entities.EntityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<EntityUser, Integer> {
    public EntityUser findByEmail(String email);
    public EntityUser findByUsername(String username);

}
