package gapp.model.dao;

import java.util.List;

import gapp.model.Contestant;
import gapp.model.EducationBckgd;
import gapp.model.OtherRequirementValue;

public interface OtherRequirementValueDao {
	  List<OtherRequirementValue> getOtherRequirementValue(Integer id);
	  OtherRequirementValue getOtherRequirementValueedition(Integer ftid);
	  OtherRequirementValue saveOtherRequirementValue(OtherRequirementValue OtherRequirementValue);
	  void updateOtherRequirementValue(Integer id,String txtvalue);
	  String getOldFileName(Integer aid);


}
