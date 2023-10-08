package it.gend.lctes.repository;

import it.gend.lctes.entity.ExamFamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamFamilyRepository extends JpaRepository<ExamFamily,Long> {
}
