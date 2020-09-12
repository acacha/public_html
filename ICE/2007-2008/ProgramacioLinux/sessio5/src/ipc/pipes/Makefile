all:	read_pipe	write_pipe	unnamed_pipe

read_pipe:	read_pipe.c
	cc -o read_pipe read_pipe.c

write_pipe:	write_pipe.c
	cc -o write_pipe write_pipe.c

unnamed_pipe:	unnamed_pipe.c
	cc -o unnamed_pipe unnamed_pipe.c

clean:
	rm -f read_pipe write_pipe

