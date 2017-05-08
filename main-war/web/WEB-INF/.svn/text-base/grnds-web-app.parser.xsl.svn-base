<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:j2ee="http://java.sun.com/xml/ns/j2ee">
  <!-- This parameter can be used to let this stylesheet run the grnds-web-app template on ALL the xconf files
       found in web.xml; it is not used, as we need to use ServletContext.getResourceAsStream() to guarantee
       that we will get the xconf files when we are in a web app (i.e. no absolute path is avaialble).
  <xsl:param name="docroot"/>
  -->
  <xsl:output method="text"/>
  <xsl:template match="grnds-web-app">
    <xsl:for-each select="servlet">
      <xsl:sort select="."/>
      <xsl:for-each select="conversations/conversation">
        <xsl:sort select="."/>
        <xsl:for-each select="commands/command">
          <xsl:sort select="."/>
          <xsl:choose>
            <xsl:when test="count(presentation) = 0">/<xsl:value-of select="../../../../@mapping"/>/<xsl:value-of select="../../conversation-name"/>/<xsl:value-of select="command-name"/>/
            </xsl:when>
            <xsl:otherwise>
              <xsl:for-each select="presentation">
                <xsl:sort select="."/>
                /<xsl:value-of select="../../../../../@mapping"/>/<xsl:value-of select="../../../conversation-name"/>/<xsl:value-of select="../command-name"/>/<xsl:value-of select="@branch"/>
              </xsl:for-each>
            </xsl:otherwise>
          </xsl:choose>
        </xsl:for-each>
      </xsl:for-each>
    </xsl:for-each>
  </xsl:template>
  <xsl:template match="j2ee:web-app">
    <xsl:for-each select="j2ee:servlet/j2ee:init-param[j2ee:param-name='grnds.web.app.map']/j2ee:param-value">
      <xsl:sort select="."/>
      <!-- This tag can be used to let this stylesheet run the grnds-web-app template on ALL the xconf files
           found in web.xml; it is not used, as we need to use ServletContext.getResourceAsStream() to guarantee
           that we will get the xconf files when we are in a web app (i.e. no absolute path is avaialble).
      <xsl:apply-templates select="document(concat($docroot,.))"/>
      -->
      <xsl:value-of select="."/>
      ,
    </xsl:for-each>
  </xsl:template>
</xsl:stylesheet><!-- Stylus Studio meta-information - (c) 2004-2007. Progress Software Corporation. All rights reserved.

<metaInformation>
	<scenarios>
		<scenario default="yes" name="Scenario1" userelativepaths="yes" externalpreview="no" url="grnds-web-app.admin.xconf" htmlbaseurl="" outputurl="" processortype="saxon8" useresolver="yes" profilemode="0" profiledepth="" profilelength=""
		          urlprofilexml="" commandline="" additionalpath="" additionalclasspath="" postprocessortype="none" postprocesscommandline="" postprocessadditionalpath="" postprocessgeneratedext="" validateoutput="no" validator="internal"
		          customvalidator="">
			<advancedProp name="sInitialMode" value=""/>
			<advancedProp name="bXsltOneIsOkay" value="true"/>
			<advancedProp name="bSchemaAware" value="true"/>
			<advancedProp name="bXml11" value="false"/>
			<advancedProp name="iValidation" value="0"/>
			<advancedProp name="bExtensions" value="true"/>
			<advancedProp name="iWhitespace" value="0"/>
			<advancedProp name="sInitialTemplate" value=""/>
			<advancedProp name="bTinyTree" value="true"/>
			<advancedProp name="bWarnings" value="true"/>
			<advancedProp name="bUseDTD" value="false"/>
			<advancedProp name="iErrorHandling" value="fatal"/>
		</scenario>
	</scenarios>
	<MapperMetaTag>
		<MapperInfo srcSchemaPathIsRelative="yes" srcSchemaInterpretAsXML="no" destSchemaPath="" destSchemaRoot="" destSchemaPathIsRelative="yes" destSchemaInterpretAsXML="no"/>
		<MapperBlockPosition></MapperBlockPosition>
		<TemplateContext></TemplateContext>
		<MapperFilter side="source"></MapperFilter>
	</MapperMetaTag>
</metaInformation>
-->