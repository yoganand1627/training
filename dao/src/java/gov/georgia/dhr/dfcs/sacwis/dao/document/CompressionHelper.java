package gov.georgia.dhr.dfcs.sacwis.dao.document;

import gov.georgia.dhr.dfcs.sacwis.core.exception.InformationalPrsException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.grnds.facility.log.GrndsTrace;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class CompressionHelper {
  public static ByteArrayOutputStream compressData(byte[] documentData)
          throws IOException, InformationalPrsException {
    return compressData(documentData, 0);
  }

  public static ByteArrayOutputStream compressData(byte[] documentData, int counter)
          throws IOException, InformationalPrsException {
    PerformanceTrace performanceTrace = new PerformanceTrace("CompressionHelper", "compressData");
    performanceTrace.enterScope();

    // Capture CRC check to compare after compression
    CRC32 crcPre = new CRC32();
    crcPre.update(documentData);

    // Setup output stream to compress
    ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
    GZIPOutputStream compressOut = new GZIPOutputStream(byteOut);
    ByteArrayInputStream byteIn = new ByteArrayInputStream(documentData);
    try {
      //  Transfer bytes from the input file 
      //  to the gzip output stream
      byte[] buffer = new byte[32768];
      int len;
      while ((len = byteIn.read(buffer)) > 0) {
        compressOut.write(buffer, 0, len);
      }
    }
    finally {
      //  Finish creation of gzip file
      compressOut.finish();
      compressOut.close();
    }
    // Decompress to verify no data loss
    CRC32 crcPost = new CRC32();
    crcPost.update(decompressData(byteOut.toByteArray()).toByteArray());

    // Retry loop in case compression fails.
    if (crcPre.getValue() != crcPost.getValue()) {
      if (counter < 5) {
        GrndsTrace.msg(TRACE_TAG, 7, "Compression Failure - Attempt #:" + counter);
        byteOut = compressData(documentData, ++counter);
      } else {
        GrndsTrace.msg(TRACE_TAG, 7, "Compression Failure - Attempt #:" + counter);
        throw new InformationalPrsException(MessageLookup.getMessageByNumber(Messages.ARC_DOCS_ERR_COMPRESS_SAVE));
      }
    }

    return byteOut;
  }

  public static ByteArrayOutputStream decompressData(byte[] documentData) throws IOException {
    PerformanceTrace performanceTrace = new PerformanceTrace("CompressionHelper", "decompressData");
    performanceTrace.enterScope();

    ByteArrayInputStream byteIn = new ByteArrayInputStream(documentData);
    ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
    GZIPInputStream in = new GZIPInputStream(byteIn);

    try {
      byte[] buffer = new byte[32768];
      int len;
      while ((len = in.read(buffer)) > 0) {
        byteOut.write(buffer, 0, len);
      }
    }
    finally {
      in.close();
    }
    performanceTrace.exitScope();
    return byteOut;
  }

  private static final String TRACE_TAG = "CompressionHelper";
}





