// bifurcation.c
//
// Copyright Mark Watson, 1999. Open Source Software License
//
// This program implement's biologist Robert May's
// population growth model. The output graphics shows
// regimes of stability and chaos in population size.
//

#include <stdio.h>
#include <X11/Xlib.h>
#include <X11/Xutil.h>

void draw_bifurcation(Window window, GC gc, Display *display, int screen, XColor text_color);

main(int argc,char **argv) {

  Display *display;
  int screen;
  Window win;
  XColor blue;
  unsigned int width=500, height=231;
  XFontStruct *font_info;         
  GC gc;        
  Colormap cmap;
  XEvent x_event;                
  XGCValues values;

  if ( (display=XOpenDisplay(NULL)) == NULL ) {
    perror("Could not open X display");
    exit(1);
  }
    
  screen = DefaultScreen(display);


  win = XCreateSimpleWindow(display, RootWindow(display, screen),
                            0, 0, width, height, 5,
                            BlackPixel(display, screen),  // border
                            WhitePixel(display, screen)); // background

  cmap=DefaultColormap(display,screen);

  XParseColor(display,cmap,"blue",&blue);
  XAllocColor(display,cmap,&blue);

  if ((font_info = XLoadQueryFont(display,"9x15")) == NULL) {
    perror("Use fixed font\n"); 
    font_info = XLoadQueryFont(display,"fixed");
  } 

  gc = XCreateGC(display,win,(unsigned long)0,&values);

  XSetFont(display, gc, font_info->fid); 
  XSetForeground(display, gc, BlackPixel(display,screen));

  XSetStandardProperties(display, win,
			 "Robert May's population model",
			 "Bifurcation", None,
                         0, 0, NULL); 

  XSelectInput(display, win, ExposureMask | ButtonPressMask);
  XMapWindow(display, win);
  draw_bifurcation(win,gc,display,screen,blue);

  while (1) {
    XNextEvent(display, &x_event);
    switch (x_event.type) {
    case Expose:
      draw_bifurcation(win,gc,display,screen,blue);
      break;
    case ButtonPressMask:
      XCloseDisplay(display);
      exit(0);
    default:
      break;
    }
  }
}

void draw_bifurcation(Window win, GC gc, Display *display,
		 int screen, XColor font_color) {

  float lambda = 0.1;
  float x = 0.1f;
  float population = 0.0;
  int x_axis, y_axis, iter;

  XSetForeground(display, gc, font_color.pixel);
  XDrawString(display, win, gc, 236,22,
	      "Extinction", strlen("Extinction"));
  XDrawString(display, win, gc, 16, 41,
	      "Steady state", strlen("Steady state"));
  XDrawString(display, win, gc, 334, 123,
	      "Period doubled", strlen("Period doubled"));
  
  XSetForeground(display, gc, BlackPixel(display,screen));
  for (y_axis=0; y_axis<198; y_axis++) {
    lambda = 4.0f * (0.20f + (y_axis / 250.0f));
    for (iter=0; iter<198; iter++) {
      population = lambda * x * (1.0f - x);
      x_axis = (int)(population * 500.02f);
      if (x_axis > 0.0f && x_axis < 501.0f) {
        XDrawLine(display,win,gc, x_axis, y_axis, x_axis, y_axis);
      }
      x = population;
    }
  }
}
