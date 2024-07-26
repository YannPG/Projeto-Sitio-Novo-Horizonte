package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.utils.conversao.formatacao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatarLocalDateTime {

    public static String formatLocalDateTime(LocalDateTime date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return date.format(formatter);
    }
}
