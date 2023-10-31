package Funcionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Funcionario.entities.funcionario;

public interface funcionarioRepository extends JpaRepository<funcionario, Long>{

}
