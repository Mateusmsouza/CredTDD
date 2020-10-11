public interface CreditAnalyzer {
    boolean validateCreditAvailable(String userDocument, Integer userScore);
}
