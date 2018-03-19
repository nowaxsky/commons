package org.cpm.zwl.commons.utils;

import java.util.Date;
import org.apache.commons.lang.time.DateFormatUtils;

/**
 * convert object between Date and String
 * 
 * @author Mailu
 *
 */
public class DateUtil {

  public static final String DATE_TIME_MS_FORMAT = "yyyyMMddHHmmssms";

  /**
   * return format is yyyyMMddHHmmssms length is 18
   * 
   * @param date
   * @return
   */
  public static String toDateTimeMsFormat(Date date) {
    return DateFormatUtils.format(date, DATE_TIME_MS_FORMAT);
  }

}
