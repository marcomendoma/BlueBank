package com.operations.bluebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operations.bluebank.model.Conta;
import com.operations.bluebank.repository.IrepositoryContas;

@Service
public class IContaServiceImpl implements IContaServices {

	@Autowired
	private IrepositoryContas repository;
	
	public void setRepository(IrepositoryContas repository) {
		this.repository = repository;
	}

	@Override
	public Iterable<Conta> listAllcontas() {
		return repository.findAll();
	}

	@Override
	public Conta getContaById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Conta saveConta(Conta conta) {
		return repository.save(conta);
	}
}
