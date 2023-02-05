package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadJson {
    public static ArrayList<diadiem> listdiadiem = new ArrayList<diadiem>();
    public static ArrayList<String> arrayTenDiaDiem = new ArrayList<String>();
    public static void main( String[] args){
        JSONParser jsonP = new JSONParser();
        try(FileReader reader = new FileReader("C:\\Users\\LENOVO\\IdeaProjects\\History_Project\\src\\diadiem.json")) {
            Object obj = jsonP.parse(reader);
            JSONArray empList = (JSONArray) obj;
            empList.forEach(emp -> parseEmpObj((JSONObject)emp));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    private static void parseEmpObj(JSONObject emp){
        String ten = (String) emp.get("Title");
        ArrayList<String> sukien = new ArrayList<String>();
        sukien = (ArrayList<String>) emp.get("Historical_Events");
        ArrayList<String> nhanvat = new ArrayList<String>();
        nhanvat = (ArrayList<String>) emp.get("Historical_Characters");
        listdiadiem.add(new diadiem(ten,sukien,nhanvat));
        arrayTenDiaDiem.add(ten);

    }
}
