# Encryption and Decryption Application
This simple JavaFx application is meant to allow the user to provide data in the form of plain text and encrypt the data so that it can be transmitted or stored securely. Data that is encrypted using this application can then be decrypted in the same way. 

## Applications
Encrypting plain text data can have many applications such as protecting passwords, seed phrases (cryptocurrency), and other sensitive data and information in the case that they are accessed by unatuhroized parties. 

## How it works
The data is encrypted by parsing through the given text and converting each character to its defined equivalent. Then, a pattern of characters (extremely unlikely to occur in the text itself) are inserted at a randomized interval throughout the text.

To decrypt the data, the pattern is removed wherever it appears, and the characters are switched back to the orginal.

## How to use it
To launch the application, download or clone the repository and open the project. Navigate to the AppView class and Run the main method. The application UI should launch. 

To encrypt data, either enter data straight into the text field or select a .txt file. Once data has been provided, press "Encrypt". The encrypted data will show up in the text area at the bottom. 

To decrypt data, follow the same steps as to ecnrypt, however, the data provided for decryption must be data that has been previously ecnrypted using the same algortihm. 

## Known bugs
None at the moment.

## Future improvements

 - Addition of a key to be entered in order to encrypt and then decrypt the data (to have fully implemented symmetric ecnryption).
 - Option to download encrypted/decrypted data as a .txt file.
 - Convert to fully functional/downloadable desktop application.
