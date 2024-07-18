package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.utils.conversao.enums.service;


import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.utils.conversao.enums.interfaces.ConvertEnum;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.utils.conversao.enums.interfaces.ValorEnum;

import java.util.Objects;


public final class ConvertEnumNonNull<E extends Enum<E> & ValorEnum<T>, T> implements ConvertEnum<E, T> {

	@Override
	public T getRepresentacaoValorEnumParaBancoDeDados(E tipoEnum) {
		return tipoEnum.getValor();
	}

	@Override
	public E getEnum(E[] valoresEnum, T valorEnum) {
		if (Objects.isNull(valorEnum))
			throw new NullPointerException("O 'valorEnum' não pode "
				+ "ser convertido para o Enum '" + valoresEnum.getClass().getSimpleName().split("\\[\\]")[0]
				+ "' pois ele está nulo!");
		
		for (E valorEnumAtual : valoresEnum) 
			if (valorEnumAtual.getValor().equals(valorEnum))
				return valorEnumAtual;
		
		throw new IllegalArgumentException("O valor '" + valorEnum 
			+ "' para o Enum '" + valoresEnum.getClass().getSimpleName().split("\\[\\]")[0]
			+ "' é inválido!");
	}
}
