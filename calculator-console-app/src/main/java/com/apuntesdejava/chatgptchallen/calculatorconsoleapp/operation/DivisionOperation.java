package com.apuntesdejava.chatgptchallen.calculatorconsoleapp.operation;

/**
 *
 * @author diego
 */
public class DivisionOperation extends Operation {

  @Override
  protected float getResult() {
    return firstNumber / secondNumber;
  }

  @Override
  protected String getSymbol() {
    return "/";
  }

}
