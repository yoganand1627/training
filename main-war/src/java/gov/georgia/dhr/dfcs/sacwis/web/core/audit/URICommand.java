package gov.georgia.dhr.dfcs.sacwis.web.core.audit;

import java.io.Serializable;

/** User: mkw Date: Jun 20, 2003 Time: 10:37:22 AM */
public class URICommand implements Comparable<URICommand>, Serializable {
  public static final URICommand UNKNOWN_URI = new URICommand("UNKNOWN", "UNKNOWN", "UNKNOWN", "UNKNOWN");

  private int id = 0;
  private final String servlet;
  private final String conversation;
  private final String command;
  private final String branch;

  public static boolean isJSP(String uri) {
    return uri != null && isJSP(uri.length(), uri);
  }

  public static boolean isJSP(int length, String uri) {
    return uri.charAt(length - 4) == '.' &&
           uri.charAt(length - 3) == 'j' &&
           uri.charAt(length - 2) == 's' &&
           uri.charAt(length - 1) == 'p';
  }

  public static URICommand parseURI(String uri) {
    URICommand uriCommand = null;
    if (uri != null) {
      int uriLength = uri.length();
      // need at least 3 characters for a chance of being a meaningful uri
      if (uriLength >= 3) {
        int begin = 0;
        int end = 0;
        // get the servlet
        while (++end < uriLength && uri.charAt(end) != '/') {
        }
        String servlet = begin + 1 == end ? null : uri.substring(begin + 1, end);
        begin = end;
        // get the conversation
        while (++end < uriLength && uri.charAt(end) != '/') {
        }
        String conversation = begin + 1 == end ? null : uri.substring(begin + 1, end);
        // get the command
        begin = end;
        while (++end < uriLength && uri.charAt(end) != '/' && uri.charAt(end) != '?') {
        }
        String command = begin + 1 == end ? null : uri.substring(begin + 1, end);
        // if we have one, get the presentation branch
        begin = end;
        String branch = null;
        if (begin < uriLength && uri.charAt(begin) != '?') {
          // get the presentation branch
          while (++end < uriLength && uri.charAt(end) != '/' && uri.charAt(end) != '?') {
          }
          if (begin < end - 1) {
            branch = uri.substring(begin + 1, end);
          }
        }
        uriCommand = new URICommand(servlet, conversation, command, branch);
      }
    }
    return uriCommand;
  }

  public URICommand(String servlet, String conversation, String command, String branch) {
    this(0, servlet, conversation, command, branch);
  }

  public URICommand(int id, String servlet, String conversation, String command, String branch) {
    this.id = id;
    this.servlet = servlet != null ? servlet : "default";
    this.conversation = conversation != null ? conversation : "default";
    this.command = command != null ? command : "default";
    this.branch = branch != null ? branch : "default";
  }

  public int getId() {
    return id;
  }

  public String getServlet() {
    return servlet;
  }

  public String getConversation() {
    return conversation;
  }

  public String getCommand() {
    return command;
  }

  public String getBranch() {
    return branch;
  }

  public String toString() {
    return "/" + this.servlet + "/" + this.conversation + "/" + this.command + "/" + this.branch;
  }

  public int hashCode() {
    return this.servlet.hashCode() ^ this.conversation.hashCode() ^ this.command.hashCode() ^ this.branch.hashCode();
  }

  public boolean equals(Object obj) {
    if (obj instanceof URICommand) {
      URICommand other = (URICommand) obj;
      return this.servlet.equals(other.servlet) &&
             this.conversation.equals(other.conversation) &&
             this.command.equals(other.command) &&
             this.branch.equals(other.branch);
    } else {
      return false;
    }
  }

  public int compareTo(URICommand other) {
    int result = 0;
    int servletCompare = this.servlet.compareTo(other.servlet);
    if (servletCompare != 0) {
      result = servletCompare;
    } else {
      int conversationCompare = this.conversation.compareTo(other.conversation);
      if (conversationCompare != 0) {
        result = conversationCompare;
      } else {
        int commandCompare = this.command.compareTo(other.command);
        if (commandCompare != 0) {
          result = commandCompare;
        } else {
          int branchCompare = this.branch.compareTo(other.branch);
          if (branchCompare != 0) {
            result = branchCompare;
          }
        }
      }
    }
    return result;
  }
}
