package com.example.bancong.conta.domain;

import java.util.Optional;

public interface IContaRepository {

    Optional<Conta> findByNumeroConta(Long numeroConta);
    Conta save(Conta conta);
    boolean existsByNumeroConta(Long numeroConta);

}
