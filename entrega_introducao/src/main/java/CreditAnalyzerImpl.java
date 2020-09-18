import br.com.safeguard.check.SafeguardCheck;
import br.com.safeguard.types.ParametroTipo;

public class CreditAnalyzerImpl implements CreditAnalyzer{

    @Override
    public Boolean validateCreditAvailable(String userDocument, Integer userScore) {
        Boolean creditAvailable = true;
        Boolean validDocument = new SafeguardCheck().elementOf(userDocument, ParametroTipo.CPF_FORMATADO)
                .validate()
                .hasError();

        if (userScore < 600) {
            creditAvailable = false;
        }

        return creditAvailable && validDocument;
    }
}
