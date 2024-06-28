package com.donggw.core.utils;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class Excel2Sql {

    private static final Logger log = LoggerFactory.getLogger(Excel2Sql.class);

    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("D:\\OARcvFiles\\新支付平台（第三批次）二代支付上线生产参数检查表V1.1.xlsx")) {
            readExcelData(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readExcelData(FileInputStream excelFile) {
        try {
            Workbook workbook = WorkbookFactory.create(excelFile);
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);
                if ("系统参数表".equals(sheet.getSheetName())) {

                    DataFormatter dataFormatter = new DataFormatter();
                    for (Row row : sheet) {
                        StringBuilder insertSql = new StringBuilder();
                        insertSql.append("INSERT INTO ").append("PT_REF_CODE").append(" (");

                        // 构建列名
                        boolean isFirstColumn = true;
                        for (Cell cell : row) {
                            String column = dataFormatter.formatCellValue(cell);
                            if (!column.isEmpty() && isEnglish(column)) {
                                if (!isFirstColumn) {
                                    insertSql.append(", ");
                                }
                                insertSql.append(dataFormatter.formatCellValue(cell));
                                isFirstColumn = false;
                            }
                        }
                        insertSql.append(") VALUES (");

                        if (row.getRowNum() == 0 || row.getRowNum() == 1) {
                            continue;
                        }
                        // 构建value部分
                        isFirstColumn = true;
                        for (Cell cell : row) {

                            if (cell != null && !dataFormatter.formatCellValue(cell).isEmpty()) {
                                if (!isFirstColumn) {
                                    insertSql.append(", ");
                                }
                                insertSql.append("'").append(dataFormatter.formatCellValue(cell)).append("'");
                                isFirstColumn = false;
                            } else {
                                insertSql.append("NULL ");
                            }
                        }
                        insertSql.append(");\n");

                        System.out.println(insertSql);
                    }
                }
            }
        } catch (Exception e) {
            log.error("文件读取异常",e);
        }
    }

    private static String generateInsertSql(StringBuilder insertSql, String tableName) {

        insertSql.append("INSERT INTO").append(tableName).append(" (");

        return insertSql.toString();
    }

    private static boolean isEnglish(String str) {
        for (char c : str.toCharArray()) {
            if (c > '\u007F') {
                return false;
            }
        }
        return true;
    }
}
