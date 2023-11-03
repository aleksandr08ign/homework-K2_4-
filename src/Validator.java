import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Validator {

    private static final String correct_code = "q,w,e,r,t,y,u,i,o,p,a,s,d,f,g,h," +
            "j,k,l,z,x,c,v,b,n,m,Q,W,E,R,T,Y,U,I,O,P,A,S,D,F,G,H,J,K,L,Z,X,C,V,B,N,M," +
            "_,0,1,2,3,4,5,6,7,8,9";
    private static final int max_lenght = 20;

    public static void validate(
            String login,
            String password,
            String confirmPassword
    )

    {
        validateLogin(login);
        validatePassword(password, confirmPassword);
    }


    private static void validateLogin(String login) {
        for (int i = 0; i < login.length(); i++) {
            if (correct_code.indexOf(login.charAt(i)) == -1) {
                throw new WrongLoginException("Логин содержит недопустимые символы");
            }

            if (login.length() > max_lenght) {
                throw new WrongLoginException("Длина логина превышает допустимое значение " + max_lenght);
            }
        }
    }

    private static void validatePassword(String password, String confirmPassword) {
        for (int i = 0; i < password.length(); i++) {
            if (correct_code.indexOf(password.charAt(i)) == -1) {
                throw new WrongPasswordException("Пароль содержит недопустимые символы");
            }
        }
        if (password.length() > max_lenght) {
            throw new WrongPasswordException("Длина пароля превышает допустимое значение " + max_lenght);
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают.");
        }
    }
}

