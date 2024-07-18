package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.enums;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.utils.conversao.enums.interfaces.ConvertEnum;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.utils.conversao.enums.service.ConvertEnumMaybeNull;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoCafeEnumConverter implements AttributeConverter<TipoCafeEnum, String> {

    private ConvertEnum<TipoCafeEnum, String> convertEnum = new ConvertEnumMaybeNull<>();

    @Override
    public String convertToDatabaseColumn(TipoCafeEnum locomocao) {
        return convertEnum.getRepresentacaoValorEnumParaBancoDeDados(locomocao);
    }

    @Override
    public TipoCafeEnum convertToEntityAttribute(String dbData){
        return convertEnum.getEnum(TipoCafeEnum.values(), dbData);
    }
}