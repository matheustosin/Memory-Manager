import java.util.Scanner;

public class MenuUtils {

    static Scanner scanner = new Scanner(System.in);

    public static void showInitialMenu() {
        System.out.println("1 - Iniciar");
        System.out.println("2 - Sair");
    }

    public static void showInitialMenuMemorySize() {
        System.out.println("Informe o tamanho da memoria desejada: ");
    }

    public static void showInitialMenuAllocationPolicy() {
        System.out.println("Escolha a politica de alocacao de memoria");
        System.out.println("Digite:");
        System.out.println("1 - First Fit");
        System.out.println("2 - Best Fit");
        System.out.println("3 - Worst Fit");
        System.out.println("4 - Circular Fit");
    }

    public static int nextInt() {
        return scanner.nextInt();
    }

}