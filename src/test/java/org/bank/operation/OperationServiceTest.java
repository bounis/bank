package org.bank.operation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.bank.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OperationServiceTest {

    private OperationService operationService;

    @BeforeEach
    void setUp() {
        operationService = new OperationServiceImpl();
    }

    @Test
    public void demanding_account_history_should_return_operations_ordered_By_date() {
        //given
        User user = new User("firstName_1", "lastName_2");

        //when
        List<Operation> operations = operationService.accountHistoryOrderByDate(user);

        //then
        assertThat(operations.size()).isEqualTo(2);

        assertThat(operations.get(0).getType()).isEqualTo(Operation.Type.DEPOSIT);
        assertThat(operations.get(0).getBalance()).isEqualTo(3000);
        assertThat(operations.get(0).getAmount()).isEqualTo(3000);

        assertThat(operations.get(1).getType()).isEqualTo(Operation.Type.WITHDRAW);
        assertThat(operations.get(1).getBalance()).isEqualTo(2000);
        assertThat(operations.get(1).getAmount()).isEqualTo(1000);
    }
}
