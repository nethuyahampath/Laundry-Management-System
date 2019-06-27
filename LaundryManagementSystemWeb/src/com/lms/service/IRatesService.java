package com.lms.service;

import java.util.ArrayList;
import com.lms.model.WashFoldRates;
import com.lms.model.DryCleanRates;

public interface IRatesService {

	public ArrayList<WashFoldRates> getWashFoldRates();
	public ArrayList<DryCleanRates> getDryCleanRates();
	
	//admin and staff
	public void addWashFoldRates( WashFoldRates wfR );
	public void addDryCleanRates(DryCleanRates dcR);
	
	public void updateWashFoldRates(String rateID, WashFoldRates wfR); 
	public void updateDryCleanRates(String rateID, DryCleanRates dcR);
	
	
	public void deleteWFRates(String rateID);
	public void deleteDCRates(String rateID);
	

}
