package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.utils.conversao.enums.service;



import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.utils.conversao.enums.interfaces.ConvertEnum;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.utils.conversao.enums.interfaces.ValorEnum;

import java.util.Objects;

public class ConvertEnumMaybeNull<E extends Enum<E> & ValorEnum<T>, T> implements ConvertEnum<E, T> {

	@Override
	public T getRepresentacaoValorEnumParaBancoDeDados(E tipoEnum) {
		return Objects.nonNull(tipoEnum) ? tipoEnum.getValor() : null;
	}

	@Override
	public E getEnum(E[] valoresEnum, T valorEnum) {
		if (Objects.isNull(valorEnum))
			return null;
		
		for (E valorEnumAtual : valoresEnum) 
			if (valorEnumAtual.getValor().equals(valorEnum))
				return valorEnumAtual;
		
		throw new IllegalArgumentException("O valor '" + valorEnum 
				+ "' para o Enum '" + valoresEnum.getClass().getSimpleName().split("\\[\\]")[0]
				+ "' é inválido!");
	}
}