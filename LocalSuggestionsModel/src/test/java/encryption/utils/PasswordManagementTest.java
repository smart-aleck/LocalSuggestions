package encryption.utils;

import com.fabs.encryption.utils.PasswordManagement;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordManagementTest {

    private String PASSWORD1 = "Password!1";
    private String PASSWORD2 = "Password!2";

    @Test
    public void PasswordHashAndVerify()
            throws PasswordManagement.CannotPerformOperationException, PasswordManagement.InvalidHashException
    {
        String passwordHash = PasswordManagement.createHash(PASSWORD1);
        assertTrue(PasswordManagement.verifyPassword(PASSWORD1, passwordHash));
    }

    @Test
    public void IncorrectPasswordAssert()
            throws PasswordManagement.CannotPerformOperationException, PasswordManagement.InvalidHashException
    {
        String passwordHash = PasswordManagement.createHash(PASSWORD1);
        assertFalse(PasswordManagement.verifyPassword(PASSWORD2, passwordHash));
    }

    @Test
    public void PasswordComponentsCheck()
            throws PasswordManagement.CannotPerformOperationException, PasswordManagement.InvalidHashException
    {
        assertEquals(PasswordManagement.HASH_SECTIONS, passwordHashParts(PASSWORD1).length);
    }

    @Test
    public void PasswordHashDifferentAlgorithmName()
            throws PasswordManagement.CannotPerformOperationException, PasswordManagement.InvalidHashException
    {
        String[] hashParts = passwordHashParts(PASSWORD1);
        hashParts[PasswordManagement.HASH_ALGORITHM_INDEX] = "sha2";

        String modifiedHash = String.join(PasswordManagement.PARTS_JOIN_KEY, hashParts);
        assertThrows(PasswordManagement.CannotPerformOperationException.class,
                () -> { PasswordManagement.verifyPassword(PASSWORD1, modifiedHash); });
    }

    private String[] passwordHashParts(String password)
            throws PasswordManagement.CannotPerformOperationException
    {
        String passwordHash = PasswordManagement.createHash(password);
        return passwordHash.split(PasswordManagement.PARTS_JOIN_KEY);
    }
}
