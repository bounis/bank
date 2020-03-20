package org.bank.operation;

import java.util.List;
import org.bank.user.User;

public interface OperationService {

    List<Operation> accountHistoryOrderByDate(User user);
}
