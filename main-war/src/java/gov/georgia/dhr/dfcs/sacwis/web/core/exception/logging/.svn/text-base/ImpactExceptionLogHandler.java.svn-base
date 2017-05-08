package gov.georgia.dhr.dfcs.sacwis.web.core.exception.logging;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.zip.DeflaterOutputStream;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import oracle.sql.BLOB;

/** User: mkw Date: Sep 23, 2003 Time: 3:57:25 AM */
public class ImpactExceptionLogHandler extends Handler {
  private static final String INSERT_ERROR_RECORD_SQL =
          "INSERT INTO IMPACT_ERRORS " +
          "(ID_ERROR, ID_PERSON, TS_ERROR_OCCURRED, ID_EXCEPTION, ID_CSC_PROBLEM, " +
          "SZ_IMPACT_VERSION, SZ_ERROR_REPORT_TYPE, BL_ERROR ) " +
          "VALUES ( ?, ?, ?, ?, ?, ?, ?, empty_blob() )";

  private static final String GET_ID_ERROR_SQL = "SELECT SEQ_IMPACT_ERRORS.NEXTVAL FROM DUAL";
  private static final String GET_BLOB_SQL = "SELECT BL_ERROR FROM IMPACT_ERRORS WHERE ID_ERROR = ? FOR UPDATE";

  private boolean open = true;

  public void publish(LogRecord logRecord) {
    if (open && logRecord instanceof ImpactExceptionLogRecord) {
      ImpactExceptionLogRecord record = (ImpactExceptionLogRecord) logRecord;

      Connection connection = null;
      PreparedStatement insertStatement = null;
      PreparedStatement selectIdErrorStatement = null;
      ResultSet selectIdErrorResultSet = null;
      PreparedStatement selectBlobStatement = null;
      ResultSet selectBlobResultsSet = null;
      try {
        connection = JdbcHelper.getConnection();
        selectIdErrorStatement = connection.prepareStatement(GET_ID_ERROR_SQL);
        selectIdErrorResultSet = selectIdErrorStatement.executeQuery();
        selectIdErrorResultSet.next();
        int idError = selectIdErrorResultSet.getInt(1);

        insertStatement = connection.prepareStatement(INSERT_ERROR_RECORD_SQL);
        insertStatement.setInt(1, idError);
        UserProfile user = record.getUser();
        insertStatement.setInt(2, user != null ? user.getUserID() : 0);
        insertStatement.setTimestamp(3, new Timestamp(record.getMillis()));
        Throwable throwable = record.getThrown();
        if (throwable instanceof BasePrsException) {
          insertStatement.setLong(4, ((BasePrsException) throwable).getUniqueId());
        } else {
          insertStatement.setNull(4, Types.DECIMAL);
        }
        insertStatement.setNull(5, Types.DECIMAL); // todo: get the CSC problem ID from the user error page
        insertStatement.setString(6, "UNKNOWN_VERSION"); // todo: version impact builds
        insertStatement.setString(7, "XMLString"); // todo: figure out how this should be done
        insertStatement.executeUpdate();

        //Select the blob
        String formattedRecordString = getFormatter().format(record);
        selectBlobStatement = connection.prepareStatement(GET_BLOB_SQL);
        selectBlobStatement.setInt(1, idError);
        selectBlobResultsSet = selectBlobStatement.executeQuery();
        selectBlobResultsSet.next();
        Blob regularErrorBlob = selectBlobResultsSet.getBlob(1);
        OutputStream blobOutputStream = regularErrorBlob.setBinaryStream(0);

        // Create the byte array
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream compressedOut = new DeflaterOutputStream(byteArrayOutputStream);
        ObjectOutputStream objectOut = null;
        try {
          objectOut = new ObjectOutputStream(compressedOut);
          objectOut.writeObject(formattedRecordString);
        } finally {
          if (objectOut != null) {
            objectOut.close();
          }
        }
        byte[] blobByteArray = byteArrayOutputStream.toByteArray();

        // Write the byte array out to a file
        int chunkSize = ((BLOB) regularErrorBlob).getChunkSize();
        int i = 0;
        int inputArrayLength = blobByteArray.length;
        while (i + chunkSize < inputArrayLength) {
          blobOutputStream.write(blobByteArray, i, chunkSize);
          i += chunkSize;
        }
        //Write remaining chunk.
        int remainingChunkSize = inputArrayLength - i;
        if (remainingChunkSize > 0) {
          blobOutputStream.write(blobByteArray, i, remainingChunkSize);
        }
        // close the stream so the blob is updated
        blobOutputStream.close();

        // end the transaction
        connection.commit();

        // indicate that the error record has been written successfully
        record.setIdError(idError);
        record.setWritten(true);
      } catch (Throwable throwable) {
        // attempt rollback if something goes wrong
        try {
          if (connection != null) {
            connection.rollback();
          }
        } catch (Throwable rollbackThrowable) {
          // do nothing
        }
      } finally {
        try {
          if (selectBlobResultsSet != null) {
            selectBlobResultsSet.close();
          }
          if (selectBlobStatement != null) {
            selectBlobStatement.close();
          }
          if (selectIdErrorResultSet != null) {
            selectIdErrorResultSet.close();
          }
          if (selectIdErrorStatement != null) {
            selectIdErrorStatement.close();
          }
          if (insertStatement != null) {
            insertStatement.close();
          }
          if (connection != null && !connection.isClosed()) {
            connection.close();
          }
        } catch (SQLException e) {
          // do nothing
        }
      }
    }
  }

  public void flush() {
    // Do nothing
  }

  public void close() throws SecurityException {
    open = false;
  }
}
