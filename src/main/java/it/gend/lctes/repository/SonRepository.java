package it.gend.lctes.repository;

import it.gend.lctes.entity.Abort;
import it.gend.lctes.entity.Son;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SonRepository extends JpaRepository<Son,Long> {
}
