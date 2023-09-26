package com.apuntesdejava.chatgptchallen.calculatorconsoleapp.operation;

import java.util.Scanner;

/**
 *
 * @author diego
 */
public abstract class Operation {

  protected float firstNumber;
  protected float secondNumber;

  public void inputNumbers() {
    try (var scanner = new Scanner(System.in)) {
      System.out.print("Ingrese el primer número:");
      firstNumber = scanner.nextFloat();
      System.out.print("Ingrese el segundo número:");
      secondNumber = scanner.nextFloat();
    }
  }

  protected abstract float getResult();

  protected abstract String getSymbol();

  public void showResult() {
    System.out.printf("Resultado: %s %s %s = %s\n", firstNumber, getSymbol(), secondNumber, getResult());
  }
}
