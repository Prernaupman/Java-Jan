package com.sapient.dao;
/* This class is to Read and Write the CSV File */
import com.sapient.entity.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;
public class CsvDao {
    public static String TYPE = "text/csv";
    static String[] HEADERS = { "Id", "Name", "Email" };

    //hasCSVFormat() is used to check the file format is CSV or not.
    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    //csvToUsers() used for reading the CSV file data.
    public static List<User> csvToUsers(InputStream in) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));

             //CSVParser Object from BufferedReader and InputStream.
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());)
        {
            List<User> users = new ArrayList<User>();
            //getRecords() returns the content present in the CSV file in the form of records.
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            //Iterating over each records.
            for (CSVRecord csvRecord : csvRecords) {
               User user = new User(
                        Long.parseLong(csvRecord.get("Id")),
                        csvRecord.get("Name"),
                        csvRecord.get("Email")
                );
                users.add(user);
            }
            return users;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
