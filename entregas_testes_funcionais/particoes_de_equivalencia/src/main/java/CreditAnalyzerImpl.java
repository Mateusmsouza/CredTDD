import br.com.caelum.stella.validation.InvalidStateException;
import br.com.safeguard.check.SafeguardCheck;
import br.com.safeguard.types.ParametroTipo;

public class CreditAnalyzerImpl implements CreditAnalyzer{
    @Override
    public boolean validateCreditAvailable(String userDocument, Integer userScore) {
        Boolean hasError;
        Boolean validScore = true;

        hasError = validateDocument(userDocument);

        if (userScore < 600 || userScore > 1000 || userScore < 1) {
            validScore = false;
        }

        return validScore && !hasError;
    }

    private Boolean validateDocument(String userDocument) {
        Boolean hasError;
        try {
            hasError = new SafeguardCheck().elementOf(userDocument, ParametroTipo.CPF)
                    .validate()
                    .hasError();
        } catch (Exception e) {
            hasError = true;
            System.out.println("Invalid document... skipping.");
        }

        return hasError;
    }
}
