package com.codenotfound.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.codenotfound.model.Academic;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("repositoryB")
public class AcademicDaoImpl implements AcademicDao {

    @Override
    public List findAll() {
        List<Academic> list = new ArrayList<Academic>();
        Academic academic = null;
        String data = this.readFile();
        for (String nombreAcademic : data.split(";")) {
            academic = new Academic();
            academic.setNombre(nombreAcademic.trim());
            list.add(academic);
        }
        return list;
    }

    private String readFile()  {
        String data = "";
        try {
            FileInputStream fis = new FileInputStream("data/academics.txt");
            data = IOUtils.toString(fis, "UTF-8");
            System.out.println(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    
}