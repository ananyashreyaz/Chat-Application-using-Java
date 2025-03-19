CHAT APPLICATION
This project is a simple chat application implemented in Java using Swing for the GUI and Java Networking for communication between a client and a server. The application allows users to send and receive messages in real time.

Features
* Real-time messaging between client and server.
* Simple GUI implemented using Java Swing.
* Supports sending and receiving text messages.

Prerequisites
* Java Development Kit (JDK) installed.
* Java Runtime Environment (JRE) installed.
Usage
1. Start the server first. The server listens for incoming connections on port 6001.
2. Start the client. The client connects to the server at 127.0.0.1 on port 6001.
3. Use the text field in the client window to type and send messages. The server will display received messages, and any messages sent from the server will appear in the client window.



Code Structure
Server.java
* Imports: Required libraries for GUI, networking, and utilities.
* Server Class: Implements the server-side logic of the chat application.
* Components:
o JFrame for the main window.
o JPanel for the header and message area.
o JTextField for input.
o JButton for sending messages.
* Networking: Uses ServerSocket to listen for incoming connections and DataInputStream/DataOutputStream for message transmission.
Client.java
* Imports: Required libraries for GUI, networking, and utilities.
* Client Class: Implements the client-side logic of the chat application.
* Components:
o JFrame for the main window.
o JPanel for the header and message area.
o JTextField for input.
o JButton for sending messages.
* Networking: Connects to the server using a Socket and uses DataInputStream/DataOutputStream for message transmission.
Note
* Ensure that the image resources used in the application (e.g., 3.png, video.png, phone.png, 3icon.png) are available in the correct directory.
* Adjust the paths to image resources if necessary.

