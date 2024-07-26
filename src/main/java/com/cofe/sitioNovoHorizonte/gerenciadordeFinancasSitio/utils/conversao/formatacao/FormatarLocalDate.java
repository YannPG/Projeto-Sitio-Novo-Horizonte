package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.utils.conversao.formatacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatarLocalDate {

    public static String formatLocalDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }
}
