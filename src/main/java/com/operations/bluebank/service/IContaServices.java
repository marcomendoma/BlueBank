package com.operations.bluebank.service;

import com.operations.bluebank.model.Conta;

public interface IContaServices {
	Iterable<Conta> listAllcontas();
    Conta getContaById(Long id);
    Conta saveConta(Conta conta);
}
