/*
 * Coded by David Vazquez using NetBeans.
 */
package auxiliares;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author BurnKill
 */
public class GettersAndSettersGenerator {

    public static void main(String[] args) {
        List<String> tipos = new ArrayList<String>();
        List<String> nombres = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        do {
            tipos.add(scanner.next());
            if ( ! tipos.get(tipos.size() - 1).equals("0")) {
                nombres.add(scanner.next());
            } else {
                break;
            }
        }while (true);
        tipos.remove(tipos.size() - 1);
        //ya lei
        for (int i = 0; i < nombres.size(); i ++) {
            System.out.println("public abstract " + tipos.get(i) + " get" + nombres.get(i).substring(0, 1).toUpperCase() + nombres.get(i).substring(1) + "();");
            System.out.println("public abstract void set" + nombres.get(i).substring(0, 1).toUpperCase() + nombres.get(i).substring(1) + "(" + tipos.get(i) + " x);\n");
        }
    }

}
