import org.junit.jupiter.api.Assertions;
import ru.netology.PasswordChecker;


public class MainTest {
        //позитивный тест: все параметры удовлетворяют условиям
        @org.junit.jupiter.api.Test
        public void test_valid_password() {
            // given:
            int leght = 1;
            int repeatSymbol = 2;
            PasswordChecker passwordChecker = new PasswordChecker(leght, repeatSymbol);
            //passwordChecker.verify("Hello");
            // then:
            Assertions.assertTrue(passwordChecker.verify("Hello"));
        }
//входной пароль не удовлетворяют минимальной длине пароля
    @org.junit.jupiter.api.Test
    public void test_valid_leght_password() {
        // given:
        int leght = 6;
        int repeatSymbol = 2;
        PasswordChecker passwordChecker = new PasswordChecker(leght, repeatSymbol);
        // then:
        Assertions.assertFalse(passwordChecker.verify("Hello"));
    }
    //входные условия удовлетворяют по количеству повторений символов в пароле, тестируемый нет
    @org.junit.jupiter.api.Test
    public void test_valid_repeat_password() {
        // given:
        int leght = 4;
        int repeatSymbol = 2;
        PasswordChecker passwordChecker = new PasswordChecker(leght, repeatSymbol);
        passwordChecker.verify("Hello");

        // when:
        int leght_2 = 4;
        int repeatSymbol_2 = 1;
        PasswordChecker newPasswordChecker = new PasswordChecker(leght_2, repeatSymbol_2);
        newPasswordChecker.verify("Hello");
        // then:
        Assertions.assertEquals(passwordChecker.verify("Hello"), newPasswordChecker.verify("Hello"));
    }

}
