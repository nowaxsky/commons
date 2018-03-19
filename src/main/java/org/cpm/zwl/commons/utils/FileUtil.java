package org.cpm.zwl.commons.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;


/**
 * File IO
 * 
 * @author Mailu
 *
 */
public class FileUtil {

  /**
   * 
   * @param directory
   * @param fileName
   * @param rowDate
   * @return
   * @throws IOException
   */
  public static boolean createFile(String directory, String fileName, List<String> rowDate)
      throws IOException {
    Path dirPath = Paths.get(directory);
    Path filePath = Paths.get(directory + fileName);

    Files.createDirectories(dirPath);
    Files.createFile(filePath);

    Charset cs = Charset.forName("UTF-8");
    Files.write(filePath, rowDate, cs, StandardOpenOption.CREATE,
        StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
    return true;
  }

  /**
   * 由物件List產生csv格式字串List
   * 
   * @param objects
   * @return
   */
  public static List<String> convertObjectsToCsvFormat(List<? extends Object> objects) {
    List<Map<String, Object>> maps = ParseUtil.convertObjectToMap(objects);
    List<String> csv = ParseUtil.convertObjectMapToCsvFormat(maps);
    return csv;
  }
}
