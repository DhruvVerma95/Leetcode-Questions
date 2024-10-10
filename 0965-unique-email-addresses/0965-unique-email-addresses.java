import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        
        for (String email : emails) {
            String[] parts = email.split("@");
            String localName = parts[0];
            String domainName = parts[1];
            
            if (localName.contains("+")) {
                localName = localName.substring(0, localName.indexOf('+'));
            }
            
            localName = localName.replace(".", "");
            uniqueEmails.add(localName + "@" + domainName);
        }
        
        return uniqueEmails.size();
    }
}
