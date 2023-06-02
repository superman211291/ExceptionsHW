import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            loginIn("login_12345", "lksdc3232_", "lksdc3232_");
//            loginIn("login_12345678910111213", "lksdc3232_", "lksdc3232_");
//           loginIn("login_12345", "lksdc3232_12345678910111213", "lksdc3232_");
//            loginIn("Петя9485", "lksdc3232_", "lksdc3232_");
//            loginIn("login_12345", "32кыа", "32кыа");
//            loginIn("login_12345", "lksdc3232_", "lksdc322_");
        }catch (WrongLoginException e){
            System.out.println("Логин - введены недопустимые символы или длина > 20!");
        }catch (WrongPasswordException e){
            System.out.println("Паоль - введены недопустимые символы или длина > 20 или не поле confirmPassword не соответствует!");
        }
    }




    public static void loginIn(String login, String password, String confirmPassword){
        if(!checkSimbols(login)||checkLength(login)){
            throw new WrongLoginException();
        }
        if(!checkSimbols(password)||checkLength(password)||!confirmPassword.equals(password)){
            throw new WrongPasswordException();
        }
    }

    private static boolean checkLength(String str) {
        return str.length()>20;
    }

    private static boolean checkSimbols(String str) {
        char[] chLogin = str.toCharArray();
        for (int i = 0; i < chLogin.length; i++) {
            if (!((chLogin[i]>=65 && chLogin[i]<=122) || (chLogin[i]>=48 && chLogin[i]<=57) ||  chLogin[i]==95)){
                return false;
            }

        }
        return true;//65..122 48..57 95
    }

}

