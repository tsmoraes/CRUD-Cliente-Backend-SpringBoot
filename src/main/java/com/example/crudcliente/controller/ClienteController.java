package com.example.crudcliente.controller;

/**
 * @author Thiago da Silva Moraes
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudcliente.exception.ResourceNotFoundException;
import com.example.crudcliente.model.Cliente;
import com.example.crudcliente.repository.ClienteRepository;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ClienteController {

	private String inesistente = "Não existe cliente com o id :";

	@Autowired
	private ClienteRepository clienteRepository;

	// get all employees
	@GetMapping("/clientes")
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

	// create employee rest api
	@PostMapping("/clientes")
	@PreAuthorize("hasRole('ADMIN')")
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	// get employee by id rest api
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(inesistente + id));
		return ResponseEntity.ok(cliente);
	}

	// update employee rest api

	@PutMapping("/clientes/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(inesistente + id));

		cliente.setNome(clienteDetails.getNome());
		cliente.setCpf(clienteDetails.getCpf());
		cliente.setCep(clienteDetails.getCep());
		cliente.setLogradouro(clienteDetails.getLogradouro());
		cliente.setBairro(clienteDetails.getBairro());
		cliente.setCidade(clienteDetails.getCidade());
		cliente.setUf(clienteDetails.getUf());
		cliente.setComplemento(clienteDetails.getComplemento());
		cliente.setTelefone(clienteDetails.getTelefone());
		cliente.setTipoTel(clienteDetails.getTipoTel());
		cliente.setEmail(clienteDetails.getEmail());
		cliente.setTelResidencial(clienteDetails.getTelResidencial());
		cliente.setTelComercial(clienteDetails.getTelComercial());
		cliente.setTelCelular(clienteDetails.getTelCelular());
		cliente.setEmails(clienteDetails.getEmails());

		Cliente updatedCliente = clienteRepository.save(cliente);
		return ResponseEntity.ok(updatedCliente);
	}

	// delete employee rest api
	@DeleteMapping("/clientes/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Map<String, Boolean>> deleteCliente(@PathVariable Long id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(inesistente + id));

		clienteRepository.delete(cliente);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
