package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.utils.conversao.enums.interfaces;




public interface ConvertEnum<E extends Enum<? extends ValorEnum<T>>, T> {


	T getRepresentacaoValorEnumParaBancoDeDados(E tipoEnum);

	E getEnum(E[] valoresEnum, T valorEnum);
}
