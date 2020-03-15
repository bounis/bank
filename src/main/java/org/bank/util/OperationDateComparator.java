package org.bank.util;

import java.util.Comparator;
import org.bank.domain.Operation;

public class OperationDateComparator implements Comparator<Operation> {

    @Override
    public int compare(Operation o1, Operation o2) {
        if (o1.getDate().isAfter(o2.getDate())) {
            return 1;
        } else if (o1.getDate().isBefore(o2.getDate())) {
            return -1;
        } else {
            return 0;
        }

    }
}
