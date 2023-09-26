package com.apuntesdejava.chatgptchallen.calculatorconsoleapp.operation;

import static com.apuntesdejava.chatgptchallen.calculatorconsoleapp.Constants.ADD_OPTION;
import static com.apuntesdejava.chatgptchallen.calculatorconsoleapp.Constants.DIV_OPTION;
import static com.apuntesdejava.chatgptchallen.calculatorconsoleapp.Constants.MULTI_OPTION;
import static com.apuntesdejava.chatgptchallen.calculatorconsoleapp.Constants.SUBS_OPTION;
import java.util.Optional;

/**
 *
 * @author diego
 */
public class OperationFactory {

  public static Optional<Operation> getOperation(String option) {
    switch (option) {
      case ADD_OPTION -> {
        return Optional.of(new AddOperation());
      }
      case SUBS_OPTION -> {
        return Optional.of(new SubtractionOperation());
      }
      case MULTI_OPTION -> {
        return Optional.of(new MultiplicationOperation());
      }
      case DIV_OPTION -> {
        return Optional.of(new DivisionOperation());
      }
    }
    return Optional.empty();
  }
}
