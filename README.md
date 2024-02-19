# Socket Communication Project

This project demonstrates simple socket-based communication between a client and a server. The client sends messages to the server, which writes them to a file. The server sends back a confirmation message after receiving each message from the client.

## Components

### Client

The client program (`ClientSide.java`) establishes a socket connection with the server and prompts the user to input a message. It sends the message to the server and displays the response from the server. The client terminates when the user inputs "exit".

### Server

The server program (`ServerSide.java`) listens for incoming connections from clients on port 8080. It receives messages from clients, writes them to a file (`logs.txt`), and sends a confirmation message back to the client. The server terminates when it receives "turn of server" from the client.

## Usage

1. **Compile the Code**: Compile both `ClientSide.java` and `ServerSide.java` using any Java compiler.

2. **Run the Server**: Execute the `ServerSide` program. It will start listening for client connections.

3. **Run the Client**: Execute the `ClientSide` program. It will establish a connection with the server and prompt you to input messages. Type your message and press Enter. The server will respond with a confirmation message. Type "exit" to terminate the client.

## File Structure

- `ClientSide.java`: Client-side program.
- `ServerSide.java`: Server-side program.
- `logs.txt`: File where messages received by the server are logged.

## Dependencies

This project has no external dependencies beyond the Java standard library.

## Notes

- This project is a simple demonstration of socket-based communication and may not be suitable for production use without further enhancements (e.g., error handling, security considerations).

- Make sure the server program is running before starting the client program.
