package org.bank.util;


import java.time.LocalDateTime;
import java.time.Month;
import org.assertj.core.api.Assertions;
import org.bank.domain.Operation;
import org.junit.jupiter.api.Test;

public class OperationDateComparatorTest {

    @Test
    public void operation_date_comparator_should_work_as_expected() {

        //given
        LocalDateTime localDateTime_1 =
            LocalDateTime.of(2020, Month.JANUARY, 2, 10, 10);

        LocalDateTime localDateTime_2 =
            LocalDateTime.of(2020, Month.FEBRUARY, 2, 10, 10);

        LocalDateTime localDateTime_3 =
            LocalDateTime.of(2020, Month.FEBRUARY, 2, 10, 10);

        Operation operation_1 = new Operation();
        operation_1.setDate(localDateTime_1);

        Operation operation_2 = new Operation();
        operation_2.setDate(localDateTime_2);

        Operation operation_3 = new Operation();
        operation_3.setDate(localDateTime_3);

        OperationDateComparator operationDateComparator = new OperationDateComparator();

        //when
        int compare_1 = operationDateComparator.compare(operation_1, operation_2);
        int compare_2 = operationDateComparator.compare(operation_2, operation_1);
        int compare_3 = operationDateComparator.compare(operation_2, operation_3);

        //then
        Assertions.assertThat(compare_1).isEqualTo(-1);
        Assertions.assertThat(compare_2).isEqualTo(1);
        Assertions.assertThat(compare_3).isEqualTo(0);
    }
}