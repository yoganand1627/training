<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:output method="xml" indent="yes"
              doctype-public="-//Hibernate/Hibernate Mapping DTD 3.0//EN"
              doctype-system="http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd"/>

  <xsl:template
          match="/hibernate-mapping/class[@name!='gov.georgia.dhr.dfcs.sacwis.db.Event']/id[generator[@class='foreign-EVENT']]/node()">
    <xsl:copy>
      <xsl:if test="self::column">
        <xsl:apply-templates select="@*"/>
      </xsl:if>
      <xsl:if test="self::generator[@class]">
        <xsl:attribute name="class">foreign</xsl:attribute>
        <param name="property">event</param>
      </xsl:if>
    </xsl:copy>
  </xsl:template>

  <xsl:template
          match="/hibernate-mapping/class[@name!='gov.georgia.dhr.dfcs.sacwis.db.Event'][id/generator[@class='foreign-EVENT']]/node()">
    <xsl:copy>
      <xsl:apply-templates select="@*|node()"/>
    </xsl:copy>
    <xsl:if test="self::timestamp or (self::id and not(following-sibling::timestamp))">
      <one-to-one name="event" class="gov.georgia.dhr.dfcs.sacwis.db.Event" constrained="true"/>
    </xsl:if>
  </xsl:template>

  <xsl:template
          match="/hibernate-mapping/class[@name!='gov.georgia.dhr.dfcs.sacwis.db.Stage']/id[generator[@class='foreign-STAGE']]/node()">
    <xsl:copy>
      <xsl:if test="self::column">
        <xsl:apply-templates select="@*"/>
      </xsl:if>
      <xsl:if test="self::generator[@class]">
        <xsl:attribute name="class">foreign</xsl:attribute>
        <param name="property">stage</param>
      </xsl:if>
    </xsl:copy>
  </xsl:template>

  <xsl:template
          match="/hibernate-mapping/class[@name!='gov.georgia.dhr.dfcs.sacwis.db.Stage'][id/generator[@class='foreign-STAGE']]/node()">
    <xsl:copy>
      <xsl:apply-templates select="@*|node()"/>
    </xsl:copy>
    <xsl:if test="self::timestamp or (self::id and not(following-sibling::timestamp))">
      <one-to-one name="stage" class="gov.georgia.dhr.dfcs.sacwis.db.Stage" constrained="true"/>
    </xsl:if>
  </xsl:template>

  <xsl:template
          match="/hibernate-mapping/class[@name!='gov.georgia.dhr.dfcs.sacwis.db.Person']/id[generator[@class='foreign-PERSON']]/node()">
    <xsl:copy>
      <xsl:if test="self::column">
        <xsl:apply-templates select="@*"/>
      </xsl:if>
      <xsl:if test="self::generator[@class]">
        <xsl:attribute name="class">foreign</xsl:attribute>
        <param name="property">person</param>
      </xsl:if>
    </xsl:copy>
  </xsl:template>

  <xsl:template
          match="/hibernate-mapping/class[@name!='gov.georgia.dhr.dfcs.sacwis.db.Person'][id/generator[@class='foreign-PERSON']]/node()">
    <xsl:copy>
      <xsl:apply-templates select="@*|node()"/>
    </xsl:copy>
    <xsl:if test="self::timestamp or (self::id and not(following-sibling::timestamp))">
      <one-to-one name="person" class="gov.georgia.dhr.dfcs.sacwis.db.Person" constrained="true"/>
    </xsl:if>
  </xsl:template>

  <xsl:template
          match="/hibernate-mapping/class[@name!='gov.georgia.dhr.dfcs.sacwis.db.ContractCounty']/id[generator[@class='foreign-CONTRACT_COUNTY']]/node()">
    <xsl:copy>
      <xsl:if test="self::column">
        <xsl:apply-templates select="@*"/>
      </xsl:if>
      <xsl:if test="self::generator[@class]">
        <xsl:attribute name="class">foreign</xsl:attribute>
        <param name="property">contractCounty</param>
      </xsl:if>
    </xsl:copy>
  </xsl:template>

  <xsl:template
          match="/hibernate-mapping/class[@name!='gov.georgia.dhr.dfcs.sacwis.db.ContractCounty'][id/generator[@class='foreign-CONTRACT_COUNTY']]/node()">
    <xsl:copy>
      <xsl:apply-templates select="@*|node()"/>
    </xsl:copy>
    <xsl:if test="self::timestamp or (self::id and not(following-sibling::timestamp))">
      <one-to-one name="contractCounty" class="gov.georgia.dhr.dfcs.sacwis.db.ContractCounty" constrained="true"/>
    </xsl:if>
  </xsl:template>

  <xsl:variable name="columnName">
    <xsl:value-of select="string(/hibernate-mapping/class/id/column/@name)"/>
  </xsl:variable>

  <!-- This must be at the bottom or it will not do the select properly.. -->
  <xsl:template
          match="/hibernate-mapping/class[id/generator[@class[contains(.,'foreign')]]]/many-to-one[column[@name=$columnName]]"/>

  <!--
    The following template matches any node or attribute and copies it, unchanged, into the output.
  -->
  <xsl:template match="@*|node()">
    <xsl:copy>
      <xsl:apply-templates select="@*|node()"/>
    </xsl:copy>
  </xsl:template>

</xsl:stylesheet>