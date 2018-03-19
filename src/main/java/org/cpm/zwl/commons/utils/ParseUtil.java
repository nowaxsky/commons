package org.cpm.zwl.commons.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * parse input to String
 * 
 * @author Mailu
 *
 */
public class ParseUtil {

  /**
   * read csv file by InputStream
   * 
   * @param inputStream
   * @return
   * @throws UnsupportedEncodingException
   * @throws IOException
   */
  public static List<String> readCsv(InputStream inputStream)
      throws UnsupportedEncodingException, IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
      List<String> words =
          reader.lines().flatMap(line -> Stream.of(line.split(","))).collect(Collectors.toList());
      return words;
    }
  }

  /**
   * 將物件List各欄位轉換為Map對應格式
   * 
   * @param objects
   * @return
   */
  public static List<Map<String, Object>> convertObjectToMap(List<? extends Object> objects) {
    ObjectMapper objectMapper = new ObjectMapper();

    List<Map<String, Object>> maps = objects.stream()
        .map(k -> objectMapper.convertValue(k, Map.class)).collect(Collectors.toList());
    return maps;
  }

  /**
   * 將物件Map格式轉換為csv字串List格式
   * 
   * @param maps
   * @return
   */
  public static List<String> convertObjectMapToCsvFormat(List<Map<String, Object>> maps) {
    List<String> csv = new ArrayList<>();
    final String DEFAULT_SEPARATOR = ",";

    String title = maps.get(0).keySet().stream().collect(Collectors.joining(DEFAULT_SEPARATOR));
    List<String> content =
        maps.stream().map(m -> m.keySet().stream().map(k -> String.valueOf(m.get(k)))
            .collect(Collectors.joining(","))).collect(Collectors.toList());

    csv.add(title);
    csv.addAll(content);
    return csv;

  }
}
