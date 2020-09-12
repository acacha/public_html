package org.politecnic.midlets.games;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Comments: </p>
 * <p>Date: </p>
 * @author Pep Mendez
 * @version 1.0
 */
/**
 * Parser handler class to parse the XML input stream.
 */
class MyEventHandler
    extends DefaultHandler {

  // Private members needed to parse the XML document
  private boolean parsingInProgress; // keep track of parsing

  // XML TAGS

  /**
   * Start of document processing.
   * @throws org.xml.sax.SAXException is any SAX exception,
   * possibly wrapping another exception.
   */
  public void startDocument() throws SAXException {
    parsingInProgress = true;
  }

  /**
   * End of document processing.
   * @throws org.xml.sax.SAXException is any SAX exception,
   * possibly wrapping another exception.
   */
  public void endDocument() throws SAXException {
    parsingInProgress = false;
    // We have encountered the end of the document. Do any processing that is desired,
    //   for example dump all collected element2 values.
  }

  /**
   * Process the new element.
   * @param uri is the Namespace URI, or the empty string if the element
   * has no Namespace URI or if Namespace processing is not being performed.
   * @param localName is the The local name (without prefix), or the empty
   * string if Namespace processing is not being performed.
   * @param qName is the qualified name (with prefix), or the empty string
   * if qualified names are not available.
   * @param attributes is the attributes attached to the element. If there
   * are no attributes, it shall be an empty Attributes object.
   * @throws org.xml.sax.SAXException is any SAX exception,
   * possibly wrapping another exception.
   */
  public void startElement(String uri, String localName, String qName,
                           Attributes attributes) throws SAXException {
//    System.out.println(qName);
  }

  /**
   * Process the character data for current tag.
   * @param ch are the element's characters.
   * @param start is the start position in the character array.
   * @param length is the number of characters to use from the
   * character array.
   * @throws org.xml.sax.SAXException is any SAX exception,
   * possibly wrapping another exception.
   */
  public void characters(char[] ch, int start, int length) throws SAXException {
    String qName = new String(ch, start, length);
    // Get current QName
//    System.out.println(qName);
  }

  /**
   * Process the end element tag.
   * @param uri is the Namespace URI, or the empty string if the element
   * has no Namespace URI or if Namespace processing is not being performed.
   * @param localName is the The local name (without prefix), or the empty
   * string if Namespace processing is not being performed.
   * @param qName is the qualified name (with prefix), or the empty
   * string if qualified names are not available.
   * @throws org.xml.sax.SAXException is any SAX exception,
   * possibly wrapping another exception.
   */
  public void endElement(String uri, String localName, String qName) throws
      SAXException {
    // Pop QName, since we are done with it
  }
}
