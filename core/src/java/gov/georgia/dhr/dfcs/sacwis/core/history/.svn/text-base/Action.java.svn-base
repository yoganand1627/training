package gov.georgia.dhr.dfcs.sacwis.core.history;

/**
 * The Action class will store the command, conversation, and branch associated with the current user
 *
 * @author Phillip T. Bernard
 */
public class Action {
  /** Constructor */
  public Action() {
    this.mapping = null;
    this.command = null;
    this.conversation = null;
    this.branch = null;
    this.screenName = null;
  }

  /**
   * Set the servlet mapping from the user request
   *
   * @param mapping The servlet mapping from the user
   */
  public void setMapping(String mapping) {
    this.mapping = mapping;
  }

  /**
   * Returns the servlet mapping from the Action object
   *
   * @param Mapping field as a string
   */
  public String getMapping() {
    return this.mapping;
  }

  /**
   * Set the conversation from the user request
   *
   * @param conversation The conversation from the user request
   */
  public void setConversation(String conversation) {
    this.conversation = conversation;
  }

  /**
   * Returns the conversation from the Action object
   *
   * @return Conversation field as a string
   */
  public String getConversation() {
    return this.conversation;
  }

  /**
   * Set the command from the user request
   *
   * @param command The command from the user request
   */
  public void setCommand(String command) {
    this.command = command;
  }

  /**
   * Returns the command from the Action object
   *
   * @return Command field as a string
   */
  public String getCommand() {
    return this.command;
  }

  /**
   * Set the branch from the user request
   *
   * @param branch The branch from the user request
   */
  public void setBranch(String branch) {
    this.branch = branch;
  }

  /**
   * Returns the branch from the Action object
   *
   * @return Branch field as a string
   */
  public String getBranch() {
    return this.branch;
  }

  /**
   * Set the screen name from the user request
   *
   * @param screenName The screen name from the user request
   */
  public void setScreenName(String screenName) {
    this.screenName = screenName;
  }

  /**
   * Returns the screenName from the Action object
   *
   * @return ScreenName field as a string
   */
  public String getScreenName() {
    return this.screenName;
  }

  /**
   * Return the mapping, conversation, command, brach, and screen name together as a string
   *
   * @return Concatenation of conversation, command, and branch fields
   */
  public String getAll() {
    return mapping + "/" + conversation + "/" + command + "/" + branch + "/" + screenName;
  }

  // -- Instance Variables --
  private String mapping;
  private String command;
  private String conversation;
  private String branch;
  private String screenName;
}












