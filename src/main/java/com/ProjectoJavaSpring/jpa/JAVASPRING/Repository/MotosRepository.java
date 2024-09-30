package com.ProjectoJavaSpring.jpa.JAVASPRING.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ProjectoJavaSpring.jpa.JAVASPRING.model.Motos;

public interface MotosRepository extends JpaRepository<Motos, Integer> {
@Query("SELECT m FROM Motos m WHERE m.cilindraje=:cilindrada")
List<Motos> findByCilindrada(int cilindrada);
}
