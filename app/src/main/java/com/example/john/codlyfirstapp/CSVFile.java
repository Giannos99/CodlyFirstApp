package com.example.john.codlyfirstapp;

/**
 * Created by john on 2/6/2015.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVFile {

    InputStream inputStream;

    public CSVFile(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public List<PicTuple> read(){
        List<PicTuple> resultList = new ArrayList<PicTuple>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {

                PicTuple tuple = new PicTuple("",0);

                String[] row = csvLine.split(",");
                for(int j=0;j<row.length-1;j++){
                    tuple.setPic(row[j].replace(".png",""));
                    tuple.setTime(Integer.parseInt(row[j+1]));
                    resultList.add(tuple);
                }
                //resultList.add(row);
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: "+ex);
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: "+e);
            }
        }
        return resultList;
    }

}
