package com.example.bancong.conta.infra;

import com.example.bancong.conta.domain.Conta;
import com.example.bancong.conta.domain.IContaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryContaRepository implements IContaRepository {

    public static final Map<Long, Conta> CONTAS_DB = new ConcurrentHashMap<>();

    @Override
    public Optional<Conta> findByNumeroConta(Long numeroConta) {
        return Optional.ofNullable(CONTAS_DB.get(numeroConta))
                .map(conta -> new Conta(conta.getNumeroConta(),  conta.getSaldo()));
    }

    @Override
    public Conta save(Conta conta) {
        Conta contaSalva = new Conta(conta.getNumeroConta(), conta.getSaldo());
        CONTAS_DB.put(conta.getNumeroConta(), contaSalva);
        return contaSalva;
    }

    @Override
    public boolean existsByNumeroConta(Long numeroConta) {
        return CONTAS_DB.containsKey(numeroConta);
    }
}
