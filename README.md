# Hello World!
## To get started with the system check module-info.java and follow these steps:
### Begin by running the Server.java class. This is the central component of the project, acting as the server that manages incoming client connections, processes messages, and facilitates communication between clients.
### After running the server, proceed to execute the Client.java class. This is the client interface, designed using JavaFX, which enables users to connect to the server, send and receive messages, and interact with the system.
### Additionally, the project includes other classes like Client1 and Server1. These classes share common methods and functions with the primary Client.java and Server.java classes. Notably, they also incorporate JavaFX elements to enhance the user experience.

#### Real-Time Communication: The system supports real-time communication, allowing clients to send and receive messages instantaneously. Messages sent by one client are promptly received and displayed on the screens of other connected clients.
#### Abstract Packet Class: The abstract class "Packet" serves as the foundation for all messages exchanged between clients and the server. By implementing the Serializable interface, it enables the messages to be easily serialized and deserialized. This approach ensures that messages can be efficiently transmitted and received over the network.
#### Socket Communication: The use of sockets facilitates the low-level communication between the clients and the server. It ensures data is efficiently transferred over the network, maintaining the integrity and reliability of the messages.
