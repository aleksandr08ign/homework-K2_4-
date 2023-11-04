import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {
    public static void main(String[] args) {

        String login = "java_skypro_go";
        String password = "D_1hWiKjjP_9";
        String confirmPassword = "D_1hWiKjjP_9";

        try {
            Validator.validate(login, password, confirmPassword);
        } catch (WrongLoginException wrongLoginException) {
            wrongLoginException.printStackTrace();
        } catch (WrongPasswordException wrongPasswordException) {
            wrongPasswordException.printStackTrace();
        }

            System.out.println("Валидация завершилась");
        }
    }
