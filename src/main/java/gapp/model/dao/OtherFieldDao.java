package gapp.model.dao;

import java.util.List;

import gapp.model.OtherRequirement;
import gapp.model.Programs;

public interface OtherFieldDao {
  List<OtherRequirement> getOtherRequirement(String dptname);
  OtherRequirement saveOtherRequirement(OtherRequirement other);
  void  OtherRequirementRemove(Integer id);
  List<OtherRequirement> getOtherRequirementdetails();
  OtherRequirement getOtherRequirement(Integer id);
}
