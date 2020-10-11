import br.com.caelum.stella.validation.InvalidStateException;
import br.com.safeguard.check.SafeguardCheck;
import br.com.safeguard.types.ParametroTipo;

public class CreditAnalyzerImpl implements CreditAnalyzer{
    @Override
    public boolean validateCreditAvailable(String userDocument, Integer userScore) {
        Boolean hasError = false;

        try {
            hasError = new SafeguardCheck().elementOf(userDocument, ParametroTipo.CPF)
                    .validate()
                    .hasError();
        } catch (Exception e) {
            hasError = true;
            System.out.println("Invalid document... skipping.");
        }

        if (userScore < 600 || userScore > 1000 || userScore < 1) {
            return false;
        }

        System.out.println(hasError);
        return true && !hasError;
    }
}
