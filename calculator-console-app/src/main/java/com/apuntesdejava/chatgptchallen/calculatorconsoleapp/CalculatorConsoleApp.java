package com.apuntesdejava.chatgptchallen.calculatorconsoleapp;

import com.apuntesdejava.chatgptchallen.calculatorconsoleapp.operation.OperationFactory;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class CalculatorConsoleApp {

  List<String> VALID_OPTIONS = List.of(Constants.ADD_OPTION, Constants.SUBS_OPTION, Constants.MULTI_OPTION, Constants.DIV_OPTION, Constants.EXIT_OPTION);

  public static void main(String[] args) {
    new CalculatorConsoleApp().run();
  }

  private void run() {

    String option = null;
    do {
      try {
        showOptions();
        option = readOption();
        if (!option.equals(Constants.EXIT_OPTION)) {
          OperationFactory.getOperation(option).ifPresent(operation -> {
            operation.inputNumbers();
            operation.showResult();
          });

        }
      } catch (IllegalArgumentException ex) {
        System.err.println("Opción no válida");
      }
    } while (!Constants.EXIT_OPTION.equals(option));

  }

  private String readOption() {
    var scanner = new Scanner(System.in);
    var option = scanner.nextLine();
    if (VALID_OPTIONS.contains(option)) {
      return option;
    }
    throw new IllegalArgumentException();
  }

  private void showOptions() {
    System.out.println("Calculadora de Operaciones Básicas");
    System.out.println("1. Suma");
    System.out.println("2. Resta");
    System.out.println("3. Multiplicación");
    System.out.println("4. División");
    System.out.println("5. Salir");
    System.out.print("Seleccione una opción: ");
  }
}
