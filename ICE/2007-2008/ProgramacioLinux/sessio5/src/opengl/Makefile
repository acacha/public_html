MESADIR = /home/markw/Mesa-3.0

INCDIR = $(MESADIR)/include
LIBDIR = $(MESADIR)/lib

GL_LIBS = -L $(LIBDIR) -lglut -lMesaGLU -lMesaGL -lm -lX11 -lXext -lXmu -lXt -lXi

all:	orbits

orbits: orbits.c
	gcc -I $(INCDIR) -o orbits orbits.c $(GL_LIBS)

