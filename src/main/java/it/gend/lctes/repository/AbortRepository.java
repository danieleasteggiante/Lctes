package it.gend.lctes.repository;

import it.gend.lctes.entity.Abort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbortRepository extends JpaRepository<Abort,Long> {
}
