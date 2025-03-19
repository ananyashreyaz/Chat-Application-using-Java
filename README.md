Chat Application
This project is a simple chat application implemented in Java using Swing for the GUI and Java Networking for communication between a client and a server. The application allows users to send and receive messages in real time.

Features
Real-time messaging between client and server
Simple and interactive GUI built with Java Swing
Supports sending and receiving text messages
Prerequisites
Before running the application, ensure the following are installed on your system:

Java Development Kit (JDK)
Java Runtime Environment (JRE)
Usage
Start the Server:

Run Server.java.
The server listens for incoming connections on port 6001.
Start the Client:

Run Client.java.
The client connects to the server at 127.0.0.1 on port 6001.
Send Messages:

Use the text field in the client window to type and send messages.
The server displays received messages.
Messages sent from the server appear in the client window.
Code Structure
Server.java
Imports: Required libraries for GUI, networking, and utilities.
Server Class: Implements the server-side logic of the chat application.
Components:
JFrame for the main window
JPanel for the header and message area
JTextField for input
JButton for sending messages
Networking:
Uses ServerSocket to listen for incoming connections.
Uses DataInputStream and DataOutputStream for message transmission.
Client.java
Imports: Required libraries for GUI, networking, and utilities.
Client Class: Implements the client-side logic of the chat application.
Components:
JFrame for the main window
JPanel for the header and message area
JTextField for input
JButton for sending messages
Networking:
Connects to the server using a Socket.
Uses DataInputStream and DataOutputStream for message transmission.
Notes
Ensure that the following image resources are available in the correct directory:

3.png
video.png
phone.png
3icon.png
If the images are missing or stored elsewhere, adjust the file paths accordingly.
