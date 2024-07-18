package com.cofe.sitioNovoHorizonte.gerenciadordeFinancasSitio.utils.conversao.formatacao;

import java.text.Collator;
import java.util.Locale;


public final class FormatacaoUtils {

	public static final Locale LOCALE_BR = new Locale("pt", "BR");

	public static final Collator COLLATOR = Collator.getInstance(LOCALE_BR);
}
