package com.codenotfound.services;

import java.util.List;

import javax.inject.Named;

import com.codenotfound.model.Academic;
import com.codenotfound.model.factory.DAOFactory;
import com.codenotfound.model.factory.AcademicDaoFactory;


@Named
public class AcademicService {
	
	private AcademicDaoFactory academicDaoFactory ;
	
	
	public AcademicService() {
		this.academicDaoFactory = (AcademicDaoFactory)DAOFactory.getDAOFactory(DAOFactory.ACADEMIC_REPOSITORY);
	}
	

    public List<Academic> getAcademicList() {
        return this.academicDaoFactory.getAcademicDao().findAll();
    }
    

}