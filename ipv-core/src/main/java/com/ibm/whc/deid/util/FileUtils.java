/*
 * (C) Copyright IBM Corp. 2016,2020
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package com.ibm.whc.deid.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {

  public static Collection<String> loadLines(String fileName) throws IOException {
    List<String> list;

    try (BufferedReader br = new BufferedReader(new FileReader(fileName));) {
      list = br.lines().collect(Collectors.toList());
    }

    return list;
  }

  public static String inputStreamToString(InputStream is) throws IOException {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    int nRead;
    byte[] data = new byte[16384];

    while ((nRead = is.read(data, 0, data.length)) != -1) {
      buffer.write(data, 0, nRead);
    }

    buffer.flush();

    return new String(buffer.toByteArray());
  }

  public static byte[] inputStreamToBytes(InputStream is) throws IOException {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    int nRead;
    byte[] data = new byte[16384];

    while ((nRead = is.read(data, 0, data.length)) != -1) {
      buffer.write(data, 0, nRead);
    }

    buffer.flush();

    return buffer.toByteArray();
  }

  /**
   * Parse double value.
   *
   * @param value
   * @return
   */
  public static Double parseDouble(String value) {
    if (value == null || value.isEmpty()) {
      return 0.0;
    }

    return Double.parseDouble(value);
  }
}
