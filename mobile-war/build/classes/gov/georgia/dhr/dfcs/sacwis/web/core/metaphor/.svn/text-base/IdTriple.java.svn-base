package gov.georgia.dhr.dfcs.sacwis.web.core.metaphor;

import java.io.Serializable;

public class IdTriple implements Serializable {
  public final String id1;
  public final String id2;
  public final String id3;
  private final int hashCode;

  public IdTriple(String id1, String id2, String id3) {
    this.id1 = id1;
    this.id2 = id2;
    this.id3 = id3;
    this.hashCode = (id1 == null ? 0 : id1.hashCode()) +
                    (id2 == null ? 0 : id2.hashCode() * 8675309) +
                    (id3 == null ? 0 : id3.hashCode() * 16661);
  }

  public int hashCode() {
    return this.hashCode;
  }

  public boolean equals(Object other) {
    if (other != null && other.getClass() == IdTriple.class) {
      IdTriple otherTriple = (IdTriple) other;
      return ((id1 == null ? otherTriple.id1 == null : id1.equals(otherTriple.id1)) &&
              (id2 == null ? otherTriple.id2 == null : id2.equals(otherTriple.id2)) &&
              (id3 == null ? otherTriple.id3 == null : id3.equals(otherTriple.id3)));
    } else {
      return false;
    }
  }
}
