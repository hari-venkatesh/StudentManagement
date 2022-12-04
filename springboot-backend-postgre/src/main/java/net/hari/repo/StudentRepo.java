package net.hari.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.hari.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

}
