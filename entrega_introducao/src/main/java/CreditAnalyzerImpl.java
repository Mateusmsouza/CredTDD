public class CreditAnalyzerImpl implements CreditAnalyzer{


    @Override
    public Boolean validateCreditAvailable(String userDocument, Integer userScore) {
        if (userScore < 600){
            return false;
        }

        return true;
    }
}
