package auxiliares;

public class PRUEBA {

    public static void main(String[] args) {
        MailTools.getInstance().enviarCorreo(
                "profesorbastar@hotmail.com",
                "Pruebas 1",
                "cONTENIDO", "Estado de cuenta");
    }
}
