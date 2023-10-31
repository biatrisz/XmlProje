package Funcionario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Funcionario.entities.funcionario;
import Funcionario.repository.funcionarioRepository;

@Service
public class FuncionarioService {
	private final funcionarioRepository funcionarioRepository;
	
	@Autowired
	 public FuncionarioService(funcionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<funcionario> getAllFuncionario (){
        return funcionarioRepository.findAll();
    }

    public funcionario getFuncionarioById(Long id) {
        Optional<funcionario> Funcionario = funcionarioRepository.findById(id);
        return Funcionario.orElse(null);
    }

    public funcionario salvarFuncionario(funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public funcionario updateFuncionario(Long id, funcionario updatedfuncionario) {
        Optional<funcionario> existingFuncionario = funcionarioRepository.findById(id);
        if (existingFuncionario.isPresent()) {
            updatedfuncionario.setId(id);
            return funcionarioRepository.save(updatedfuncionario);
        }
        return null;
    }

    public boolean deleteFuncionario(Long id) {
        Optional<funcionario> existingFuncionario = funcionarioRepository.findById(id);
        if (existingFuncionario.isPresent()) {
            funcionarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
