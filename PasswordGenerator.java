import java.security.SecureRandom;

/**
 * Cryptographically secure function for generating application passwords
 * such as ones for use with Wi-Fi, VPN, imap/smtp, etc.
 */
public class PasswordGenerator {
    
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
    private static final SecureRandom secureRandom = new SecureRandom();
    
    /**
     * Generates a random application password with groups separated by hyphens
     * Format: xxxx-yyyy-zzzz or xxx-yyy-zzz-www with random number of groups
     * and random number of characters in a group
     * @return Generated password string
     */
    public static String generatePassword() {
        StringBuilder randomString = new StringBuilder();
        
        // Generate number of groups: 3 or 4
        int ng = secureRandom.nextInt(2) + 3; // 3 or 4
        
        // Determine min and max group lengths based on ng
        int gmil = (ng > 3) ? 3 : 4;
        int gmal = (ng > 3) ? 4 : 6;
        
        // Generate each group
        for (int k = 0; k < ng; k++) {
            // Random group length between gmil and gmal (inclusive)
            int gl = secureRandom.nextInt(gmal - gmil + 1) + gmil;
            
            // Generate characters for this group
            for (int i = 0; i < gl; i++) {
                int index = secureRandom.nextInt(CHARACTERS.length());
                randomString.append(CHARACTERS.charAt(index));
            }
            
            // Add separator (will remove last one later)
            randomString.append('-');
        }
        
        // Remove trailing hyphen
        randomString.setLength(randomString.length() - 1);
        
        // Check if we need to add one more character for shortest lengths
        int currentLength = randomString.length();
        if ((currentLength == 14 && ng == 3) || (currentLength == 15 && ng == 4)) {
            // Split by hyphen to get groups
            String[] groups = randomString.toString().split("-");
            
            // Select random group to add character to
            int ming = secureRandom.nextInt(ng);
            
            // Add random character to selected group
            int index = secureRandom.nextInt(CHARACTERS.length());
            groups[ming] = groups[ming] + CHARACTERS.charAt(index);
            
            // Rebuild the string
            randomString = new StringBuilder();
            for (int i = 0; i < groups.length; i++) {
                randomString.append(groups[i]);
                if (i < groups.length - 1) {
                    randomString.append('-');
                }
            }
        }
        
        return randomString.toString();
    }
}
