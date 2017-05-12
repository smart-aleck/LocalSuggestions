package encryption.utils;

import com.fabs.encryption.utils.PasswordManagement;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test(expected=PasswordManagement.CannotPerformOperationException.class)
    public void PasswordHashDifferentAlgorithmName()
            throws PasswordManagement.CannotPerformOperationException, PasswordManagement.InvalidHashException
    {
        String[] hashParts = passwordHashParts(PASSWORD1);
        hashParts[PasswordManagement.HASH_ALGORITHM_INDEX] = "sha2";

        String modifiedHash = String.join(PasswordManagement.PARTS_JOIN_KEY, hashParts);
        PasswordManagement.verifyPassword(PASSWORD1, modifiedHash);
    }

    private String[] passwordHashParts(String password)
            throws PasswordManagement.CannotPerformOperationException
    {
        String passwordHash = PasswordManagement.createHash(password);
        return passwordHash.split(PasswordManagement.PARTS_JOIN_KEY);
    }
}
