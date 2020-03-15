package org.bank;

import org.bank.util.BankStoreDataGenerator;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    public void baseSetUp() {
        BankStoreDataGenerator.generateBankData();
    }
}
