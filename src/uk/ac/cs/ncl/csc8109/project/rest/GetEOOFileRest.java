package uk.ac.cs.ncl.csc8109.project.rest;

import javax.inject.Inject;

import uk.ac.cs.ncl.csc8109.project.data.FileStorage;

/**
 * this class is used to given a link to the client to download the EOO file
 * @author hp
 *
 */
public class GetEOOFileRest {
	@Inject
	private FileStorage filestorage;
	/**
	 * a request given a fileID and the clientID to get the EOO file
	 * 
	 */
	public void getEoo(String fileid){
		filestorage.getEOOStream(fileid);
		
		
	}

}
