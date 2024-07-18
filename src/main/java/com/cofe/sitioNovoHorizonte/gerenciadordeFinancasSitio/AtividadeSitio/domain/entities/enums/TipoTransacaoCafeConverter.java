package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.enums;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.utils.conversao.enums.interfaces.ConvertEnum;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.utils.conversao.enums.service.ConvertEnumMaybeNull;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoTransacaoCafeConverter implements AttributeConverter<TipoTransacaoCafeEnum, String> {

    private ConvertEnum<TipoTransacaoCafeEnum, String> convertEnum = new ConvertEnumMaybeNull<>();

    @Override
    public String convertToDatabaseColumn(TipoTransacaoCafeEnum locomocao) {
        return convertEnum.getRepresentacaoValorEnumParaBancoDeDados(locomocao);
    }

    @Override
    public TipoTransacaoCafeEnum convertToEntityAttribute(String dbData){
        return convertEnum.getEnum(TipoTransacaoCafeEnum.values(), dbData);
    }
}