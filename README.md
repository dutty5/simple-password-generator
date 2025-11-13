# simple-password-generator

Cryptographically secure password generator for human-readable application passwords.

## Overview

A lightweight Java password generator that creates secure, memorable passwords in hyphen-separated format. Perfect for application-specific passwords in OAuth 2.0 environments, IMAP/SMTP authentication, or any scenario requiring user-friendly credentials.

**Example outputs**: `abcd-efgh-ijkl`, `abc-def-ghi-jklm`, `qwerty-asdf-zxcv`

## Features

- **Cryptographically secure**: Uses Java's `SecureRandom` for true randomness
- **Human-readable**: Hyphen-separated lowercase letters (easy to type and communicate)
- **Strong security**: 68-90 bits of entropy, exceeding NIST recommendations (64+ bits)
- **Flexible format**: 3-4 groups with 3-6 characters each
- **Consistent length**: 15-20 total characters including hyphens

## Technical Specifications

| Property | Value |
|----------|-------|
| Character set | Lowercase a-z (26 chars) |
| Groups | 3 or 4 (random) |
| Characters per group | 3-4 (4 groups) or 4-6 (3 groups) |
| Total length | 15-20 characters (including hyphens) |
| Character count | 13-18 letters |
| Entropy | 68-90 bits |

## Security

- **Minimum entropy**: 68 bits (13 characters)
- **Maximum entropy**: 90 bits (18 characters)
- **Brute force resistance**: ~9.4 million years at 1 billion attempts/second (minimum case)
- **Quantum-resistant**: 45 bits effective security against Grover's algorithm

The hyphen-separated format sacrifices ~10 bits of potential entropy for significant usability benefits while maintaining excellent security for application passwords.

## Use Cases

- Application-specific passwords for OAuth 2.0 environments
- IMAP/SMTP, Wi-Fi, VPN authentication credentials
- API access tokens in human-readable format
- Temporary access codes
- Service account passwords

## Usage

### Standalone

Add the JAR to your classpath (e.g., `~/java-x86_64_sdk/jre/lib/ext/`):
```java
import PasswordGenerator;

...
String password = PasswordGenerator.generatePassword();
System.out.println(password); // abc-defg-hijk-lmn
...
```

### Download Pre-compiled JAR

Download the latest `simple-password-generator.jar` from [Releases](https://github.com/dutty5/simple-password-generator/releases).

### Command Line
```bash
# Generate a single password (using -jar)
java -jar simple-password-generator.jar

# Generate 5 passwords
java -jar simple-password-generator.jar 5

# Alternative: using -cp
java -cp simple-password-generator.jar PasswordGenerator 5
```

## Building from Source

```bash
# Clone the repository
git clone https://github.com/dutty5/simple-password-generator.git
cd simple-password-generator

# Build manually
javac PasswordGenerator.java
jar cfe simple-password-generator.jar PasswordGenerator PasswordGenerator.class

# Test
java -jar simple-password-generator.jar
```  

## License

MIT License - see LICENSE file for details
