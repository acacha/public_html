all:	test_client test_server

test_client:	test_client.cpp Client.o
	g++ -o test_client test_client.cpp Client.o

test_server:	test_server.cpp Server.o
	g++ -o test_server test_server.cpp Server.o

Client.o:	Client.cpp Client.hxx
	g++ -c Client.cpp

Server.o:	Server.cpp Server.hxx
	g++ -c Server.cpp

clean:
	rm -f *.o test_client test_server

