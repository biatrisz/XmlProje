package Funcionario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Funcionario.entities.funcionario;
import Funcionario.service.FuncionarioService;
import jakarta.validation.Valid;

@RestController

@RequestMapping("/funcionarios")

public class FuncionarioController {
	private final FuncionarioService funcionarioService;

	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<funcionario> getProductById(@PathVariable Long id) {
		funcionario funcionario = funcionarioService.getFuncionarioById(id);
		if (funcionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<funcionario>> getAllFuncionario() {
		List<funcionario> funcionario = funcionarioService.getAllFuncionario();
		return ResponseEntity.ok(funcionario);
	}
	@PostMapping("/")
	public ResponseEntity<funcionario> criarFuncionario(@RequestBody @Valid funcionario funcionario) {
		funcionario criarFuncionario = funcionarioService.salvarFuncionario(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarFuncionario);
	}
	@PutMapping("/{id}")
	public ResponseEntity<funcionario> updateFuncionario(@PathVariable Long id, @RequestBody @Valid funcionario funcionario) {
		funcionario updatedFuncionario = funcionarioService.updateFuncionario(id, funcionario);
		if (updatedFuncionario != null) {

			return ResponseEntity.ok(updatedFuncionario);

		} else {

			return ResponseEntity.notFound().build();

		}

	}
	@DeleteMapping("/{id}")

	public ResponseEntity<String> deleteFuncionario(@PathVariable Long id) {

		boolean deleted = funcionarioService.deleteFuncionario(id);

		if (deleted) {

			return ResponseEntity.ok().body("O funcionário foi excluído com sucesso.");

		} else {

			return ResponseEntity.notFound().build();

		}
	}

}

