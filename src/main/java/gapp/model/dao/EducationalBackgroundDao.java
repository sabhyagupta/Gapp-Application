package gapp.model.dao;

import java.util.List;

import gapp.model.EducationBckgd;


public interface EducationalBackgroundDao  {
    List<EducationBckgd> getEducationalDetails(Integer eid);
    List<EducationBckgd> getEducationalByaid(Integer aid);

    EducationBckgd getSaveAcademic(Integer eid);
    EducationBckgd saveEducationBckgd(EducationBckgd EducationBckgd);
   
	void Remove( Integer eid);


}
