package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.AtividadeSitio.domain.entities.enums;

import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.utils.conversao.enums.interfaces.ConvertEnum;
import com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.utils.conversao.enums.service.ConvertEnumMaybeNull;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoProdutorEnumConverter implements AttributeConverter<TipoProdutorEnum, String> {

    private ConvertEnum<TipoProdutorEnum, String> convertEnum = new ConvertEnumMaybeNull<>();

    @Override
    public String convertToDatabaseColumn(TipoProdutorEnum locomocao) {
        return convertEnum.getRepresentacaoValorEnumParaBancoDeDados(locomocao);
    }

    @Override
    public TipoProdutorEnum convertToEntityAttribute(String dbData){
        return convertEnum.getEnum(TipoProdutorEnum.values(), dbData);
    }
}
