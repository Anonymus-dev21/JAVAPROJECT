package com.ProjectoJavaSpring.jpa.JAVASPRING.Repository;

import org.apache.el.stream.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.ProjectoJavaSpring.jpa.JAVASPRING.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

}
