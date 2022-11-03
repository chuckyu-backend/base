package com.chuck.base.utils.excel;

/**
 * @author Chuck
 * @since 6/19/2021
 * @version 0.0.1
 * @apiNote
 */
public abstract class PoiUtils {
  /**
   * 生成Excel文件
   *
   * @param workbook
   * @param fileName
   * @return
   */
  //  public static File createExcelFile(Workbook workbook, String fileName) {
  //    OutputStream stream = null;
  //    File file = null;
  //    try {
  //      file = File.createTempFile(fileName, ".xlsx");
  //      stream = new FileOutputStream(file.getAbsoluteFile());
  //      workbook.write(stream);
  //    } catch (FileNotFoundException e) {
  //      e.printStackTrace();
  //    } catch (IOException e) {
  //      e.printStackTrace();
  //    } finally {
  //      IOUtils.closeQuietly(workbook);
  //      IOUtils.closeQuietly(stream);
  //    }
  //    return file;
  //  }
}
